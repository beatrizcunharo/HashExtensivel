package hashextensivel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beatriz
 */
public class Balde {
    private int profundidadeLocal; // profundidade dos dados
    private int tamanho;// tamanho da lista
    private int bits; // bits de entrada
    List<String> balde;
    
    Balde(int tamanho, int bits){
        this.profundidadeLocal = 1;
        this.tamanho = tamanho;
        this.bits = bits;
        balde = new ArrayList<>();
    }
    
    Balde (){
        // CONSTRUTOR VAZIO
    }
    
    public boolean isBaldeCheio(){
        if(balde.size() == tamanho)
            return true;
        return false;
    }
    
    public void inserirChave(String chave){
        this.balde.add(chave);
    }    
    
    public void incrementaProfundidade(){
        this.profundidadeLocal = this.profundidadeLocal + 1;
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

    /**
     * @return the bits
     */
    public int getBits() {
        return bits;
    }

    /**
     * @param bits the bits to set
     */
    public void setBits(int bits) {
        this.bits = bits;
    }
    
}
