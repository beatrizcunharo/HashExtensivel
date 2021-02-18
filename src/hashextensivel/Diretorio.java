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
    private int tamanhoBalde;
    int tamanhoBits;
    private int profundidadeGlobal;
    
    Diretorio(int tamanho, int bits){
        diretorio = new ArrayList<>();
        this.profundidadeGlobal = 2;
        this.tamanhoGlobal = (int) Math.pow(2, profundidadeGlobal);
        this.tamanhoBalde = tamanho;
        this.tamanhoBits = bits;
    }
    
    Diretorio (){
        // CONSTRUTOR VAZIO
    } 
    
    public int buscaChave (String chave){
        int index = hash(chave);
        for(int i=0; i < diretorio.get(index).balde.size(); i++){
            if(diretorio.get(index).balde.get(i).equals(chave))
                return i;
        }
        return -1;
    }
    
    
    public void duplicarDiretorio(){
        /*this.tamanhoGlobal = this.tamanhoGlobal * 2;
        this.profundidadeGlobal = this.profundidadeGlobal + 1;
        String chave;
        Balde baldes = new Balde();
        for(int i=0; i< tamanhoGlobal / 2; i++){
            chave = baldes.getBalde().get(i).getChave();
            this.diretorio.get(i).setPseudoChaves("0".concat(chave));
        } 
        for(int i = tamanhoGlobal/2; i < tamanhoGlobal; i++){
            chave = baldes.getBalde().get(i).getChave();
            this.diretorio.get(i).setPseudoChaves("1".concat(chave));
        }*/
    }
        
    public int hash (String chave){
        int index;
        String substring = chave.substring(0,this.profundidadeGlobal);  
        index = Integer.parseInt(substring, 2);
        
        return index;
    }
    
    public void duplicarBalde(int index, String chave){
        diretorio.get(index).incrementaProfundidade();
        Balde baldeNovo = new Balde(this.tamanhoBalde, diretorio.get(index).getProfundidadeLocal());
        String substring = chave.substring(0, diretorio.get(index).getProfundidadeLocal());
        ArrayList<String> chavesBaldeAntigo = new ArrayList<>();
        for(int i=0;i < diretorio.get(index).balde.size(); i++){
            chavesBaldeAntigo.add(diretorio.get(index).balde.get(i));
        }
        
        
        for(int i=0; i < diretorio.get(index).balde.size(); i++){
            
        }
        
    }
    
    public String getPseudoChave(String chave){
        String substring = chave.substring(0,this.profundidadeGlobal);  
        return substring;
    }
    
    public void inserirItem (String chave){
        int index = hash(chave);
        boolean baldeCheio = false;
        if(diretorio.get(index).balde.isEmpty())
            baldeCheio = diretorio.get(index).isBaldeCheio();
        
        if(baldeCheio){
            if(diretorio.get(index).getProfundidadeLocal() == this.profundidadeGlobal){
                this.duplicarDiretorio();
            }
        }else{
            Balde balde = new Balde(this.tamanhoBalde, this.tamanhoBits);
            diretorio.add(balde);
            diretorio.get(index).inserirChave(chave);
        }
    }    

    public void incrementaProfundidadeGlobal(){
        this.profundidadeGlobal = this.profundidadeGlobal + 1;
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
     * @return the tamanhoBalde
     */
    public int getTamanhoBalde() {
        return tamanhoBalde;
    }

    /**
     * @param tamanhoBalde the tamanhoBalde to set
     */
    public void setTamanhoBalde(int tamanhoBalde) {
        this.tamanhoBalde = tamanhoBalde;
    }
}
