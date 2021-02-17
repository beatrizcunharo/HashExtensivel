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
    
    public void duplicarBalde(Item item, int index){
        Diretorio diretorios = new Diretorio();
        Balde baldeNovo = new Balde(this.profundidadeLocal + 1, this.tamanho);
        diretorios.diretorio.add(index, baldeNovo);
        diretorios.diretorio.get(index).setProfundidadeLocal(profundidadeLocal + 1);
        diretorios.diretorio.get(index).inserirItem(item);
    }
    
    public void inserirItem(Item item){
        balde.add(item);
    }    
    
    public Item buscaItem(String chave){
        for (Item item : balde) {
            if(item.getChave().equals(chave))
                return item;
        }
        return null;
    }
    
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
