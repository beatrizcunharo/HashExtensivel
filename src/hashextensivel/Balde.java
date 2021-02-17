package hashextensivel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Balde {
    private String pseudoChaves; // representação das pseudo-chaves 
    private int profundidadeLocal; // profundidade dos dados
    private int tamanho;// tamanho da lista
    List<Item> balde;
    
    Balde(int profundidadeLocal, int tamanho){
        this.profundidadeLocal = profundidadeLocal;
        this.tamanho = tamanho;
        balde = new ArrayList<>();
    }
   
    Balde(){
        // CONSTRUTOR VAZIO
    }
    
    /*public void inserirItem(Item item){
        Diretorio diretorio = new Diretorio();
        diretorio.fatorDeCarga();
        double fatorDeCarga = diretorio.getFatorDeCargaAtual();
        double fatorDeCargaReferencia = diretorio.getFatorDeCargaReferencia();
       
        
        if(balde.size() < tamanho)
            balde.add(item);
       
    }    
    
    public Item buscaItem(String chave){
        for (Item item : balde) {
            if(item.getChave().equals(chave))
                return item;
        }
        return null;
    }*/
    
    /**
     * @return the pseudoChaves
     */
    public String getPseudoChaves() {
        return pseudoChaves;
    }

    /**
     * @param pseudoChaves the pseudoChaves to set
     */
    public void setPseudoChaves(String pseudoChaves) {
        this.pseudoChaves = pseudoChaves;
    }
    /**
     * @return the profundidadeLocal
     */
    public int getProfundidadeLocal() {
        return profundidadeLocal;
    }

    /**
     * @param profundidadeLocal the profundidade to set
     */
    public void setProfundidadeLocal(int profundidadeLocal) {
        this.profundidadeLocal = profundidadeLocal;
    }    

    /**
     * @return the tamanho
     */
    public int getTamanho() {
        return tamanho;
    }

    /**
     * @param tamanho the tamanho to set
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    
}
