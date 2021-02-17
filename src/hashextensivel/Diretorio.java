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
    
    Diretorio(int profundidadeGlobal){
        diretorio = new ArrayList<>();
        this.profundidadeGlobal = profundidadeGlobal;
        this.tamanhoGlobal = 2 ^ profundidadeGlobal;
    }
    
    Diretorio(){
        // Apenas para construir um diretório
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
    
    public void duplicarBalde (){
        Balde baldes = new Balde();
    }
    
    public int hash (String chave){
        String substring = chave.substring(0,profundidadeGlobal);  
        int index = Integer.parseInt(substring, 2);
        return index;
    }
    
    public void inserirItem (Item item){
        int index = hash(item.getChave());
        //diretorio.get(index).inserirItem(item);
        // verificar espaço do balde
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
}
