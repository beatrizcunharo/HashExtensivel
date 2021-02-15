package hashextensivel;

/**
 *
 * @author Beatriz
 */
public class Item {
    private String chave;
    private String dados;
    
    Item(String chave, String dados){
        this.chave = chave;
        this.dados = dados;
    }

    /**
     * @return the chave
     */
    public String getChave() {
        return chave;
    }

    /**
     * @param chave the chave to set
     */
    public void setChave(String chave) {
        this.chave = chave;
    }

    /**
     * @return the dados
     */
    public String getDados() {
        return dados;
    }

    /**
     * @param dados the dados to set
     */
    public void setDados(String dados) {
        this.dados = dados;
    }
}