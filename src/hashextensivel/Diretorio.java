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
    private double fatorDeCargaReferencia;
    private double fatorDeCargaAtual; 
    private int profundidadeGlobal;
    
    Diretorio(int profundidadeGlobal){
        diretorio = new ArrayList<>();
        this.profundidadeGlobal = profundidadeGlobal;
        this.tamanhoGlobal = 2 ^ profundidadeGlobal;
        this.fatorDeCargaReferencia = 0.75;
        this.fatorDeCargaAtual = 0;
    }
    
    public String buscaChave (int chave){
        for (Balde balde : diretorio) {
            if(balde.getPseudoChaves().equals(chave))
                return balde.getPseudoChaves();
        }
        return null;
    }
    
    public void fatorDeCarga(){
        this.setFatorDeCargaAtual(diretorio.size() / this.tamanhoGlobal);
        
        if(this.getFatorDeCargaAtual() >= this.getFatorDeCargaReferencia())
            this.duplicarDiretorio();
    }    
    
    public void duplicarDiretorio(){
        this.tamanhoGlobal = this.tamanhoGlobal * 2;
        // FAZER
        
    }
    
    public void duplicarBalde (){
        // FAZER
    }
    
    public int hash (String chave){
        String substring = chave.substring(0,tamanhoGlobal);  
        int index = Integer.parseInt(substring, 2);
        return index;
    }
    
    public void inserirItem (Item item){
        int index = hash(item.getChave());
        diretorio.get(index).inserirItem(item);
        // verificar espaço do balde
    }    

    /**
     * @return the tamanhoGlobal
     */
    public int getTamanhoGlobal() {
        return tamanhoGlobal;
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
}
