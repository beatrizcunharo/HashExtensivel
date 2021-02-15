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
    
    Diretorio(int tamanhoGlobal){
        diretorio = new ArrayList<>();
        this.tamanhoGlobal = tamanhoGlobal;
    }
    
    public String buscaChave (int chave){
        for (Balde balde : diretorio) {
            if(balde.getPseudoChaves().equals(chave))
                return balde.getPseudoChaves();
        }
        return null;
    }
    
    public int hash (String chave){
        String substring = chave.substring(0,tamanhoGlobal);  
        int index = Integer.parseInt(substring, 2);
        return index;
    }
    
    public void inserirItem (Item item){
        int index = hash(item.getChave());
        diretorio.get(index).inserirItem(item);
    }
    
    public void dividirBaldes(int tamanho){
        
    }
    

    /**
     * @return the tamanhoGlobal
     */
    public int getTamanhoGlobal() {
        return tamanhoGlobal;
    }

    /**
     * @param tamanhoGlobal the tamanhoGlobal to set
     */
    public void setTamanhoGlobal(int tamanhoGlobal) {
        this.tamanhoGlobal = tamanhoGlobal;
    }
    
}
