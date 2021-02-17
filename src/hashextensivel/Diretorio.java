package hashextensivel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Diretorio {
    List<Balde> diretorio;
    private int tamanhoGlobal;
    private int profundidadeGlobal;
    private double fatorDeCargaReferencia = 0.75;
    private double fatorDeCargaAtual;
    
    Diretorio(int profundidadeGlobal){
        diretorio = new ArrayList<>();
        this.profundidadeGlobal = profundidadeGlobal;
        this.tamanhoGlobal = 2 ^ profundidadeGlobal;
        this.fatorDeCargaAtual = 0;
    }
    
    Diretorio(){
        // Apenas para construir um diretório
    }
    
    public void fatorDeCarga(){
        this.setFatorDeCargaAtual(diretorio.size() / this.tamanhoGlobal);

        if(this.getFatorDeCargaAtual() >= this.getFatorDeCargaReferencia())
            this.duplicarDiretorio();
    }
    
    public String buscaChave (int chave){
        for (Balde balde : diretorio) {
            if(balde.getPseudoChaves().equals(chave))
                return balde.getPseudoChaves();
        }
        return null;
    }
    
    public void duplicarDiretorio(){
        this.tamanhoGlobal = this.tamanhoGlobal * 2;
        this.profundidadeGlobal = this.profundidadeGlobal + 1;
        String chave;
        Balde baldes = new Balde();
        for(int i=0; i< tamanhoGlobal / 2; i++){
            chave = baldes.balde.get(i).getChave();
            this.diretorio.get(i).setPseudoChaves("0".concat(chave));
        }
        for(int i = tamanhoGlobal/2; i < tamanhoGlobal; i++){
            chave = baldes.balde.get(i).getChave();
            this.diretorio.get(i).setPseudoChaves("1".concat(chave));
        }
    }
    
    public int hash (String chave){
        String substring = chave.substring(0,profundidadeGlobal);  
        int index = Integer.parseInt(substring, 2);
        return index;
    }
    
    public void inserirItem (Item item){
        Balde baldes = new Balde();
        int index = hash(item.getChave());
        fatorDeCarga();
        if(baldes.balde.size() == baldes.getTamanho()){
            baldes.duplicarBalde();
            int indexAtual = hash(item.getChave());
            diretorio.get(indexAtual).inserirItem(item);
        }else
            diretorio.get(index).inserirItem(item);
    }    

    /**
     * @return the tamanhoGlobal
     */
    public int getTamanhoGlobal() {
        return tamanhoGlobal;
    }

    /**
     * @return the profundidadeGlobal
     */
    public int getProfundidadeGlobal() {
        return profundidadeGlobal;
    }

    /**
     * @param profundidadeGlobal the profundidadeGlobal to set
     */
    public void setProfundidadeGlobal(int profundidadeGlobal) {
        this.profundidadeGlobal = profundidadeGlobal;
    }

    /**
     * @return the fatorDeCargaReferencia
     */
    public double getFatorDeCargaReferencia() {
        return fatorDeCargaReferencia;
    }

    /**
     * @param fatorDeCargaReferencia the fatorDeCargaReferencia to set
     */
    public void setFatorDeCargaReferencia(double fatorDeCargaReferencia) {
        this.fatorDeCargaReferencia = fatorDeCargaReferencia;
    }

    /**
     * @return the fatorDeCargaAtual
     */
    public double getFatorDeCargaAtual() {
        return fatorDeCargaAtual;
    }

    /**
     * @param fatorDeCargaAtual the fatorDeCargaAtual to set
     */
    public void setFatorDeCargaAtual(double fatorDeCargaAtual) {
        this.fatorDeCargaAtual = fatorDeCargaAtual;
    }
}
