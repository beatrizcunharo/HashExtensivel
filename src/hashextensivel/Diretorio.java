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
        List<Balde> diretorioAuxiliar = new ArrayList<>();
        this.tamanhoGlobal = (int) Math.pow(2, this.profundidadeGlobal);
        for (int i = 0; i < Math.pow(2, this.profundidadeGlobal); i++) {
            this.diretorio.add(new Balde(this.tamanhoBalde, this.tamanhoBits));
            diretorioAuxiliar.add(new Balde(this.tamanhoBalde, this.tamanhoBits));
        }
        this.incrementaProfundidadeGlobal();
        int index;
        String chave;
        for(int i=0; i < this.tamanhoGlobal; i++){
            for(int j = 0; j < this.diretorio.get(i).balde.size();){
                chave = this.diretorio.get(i).balde.get(j);
                index = this.hash(chave);
                
                if(index != i){
                    diretorioAuxiliar.get(i).inserirChave(chave);
                    this.diretorio.get(i).balde.remove(j);
                }else{
                    j++;
                }
            }
        }
        
        for (int i = 0; i < this.diretorio.size(); i++) {
            if (diretorioAuxiliar.get(i).balde.size() > 0) {
                this.diretorio.get(i).balde.addAll(diretorioAuxiliar.get(i).balde);
                diretorioAuxiliar.get(i).balde.clear();
            }
        }
    }
        
    
    public int hash (String chave){
        int index;
        String substring = chave.substring(0,this.profundidadeGlobal);  
        index = Integer.parseInt(substring, 2);
        
        return index;
    }
    
   
    public String getPseudoChave(String chave){
        String substring = chave.substring(0,this.profundidadeGlobal);  
        return substring;
    }
    
    public void inserirItem (String chave){
        boolean baldeCheio;
        if(diretorio.isEmpty()){
            Balde balde = new Balde(this.tamanhoBalde, this.tamanhoBits);
            diretorio.add(balde);
            diretorio.get(0).inserirChave(chave);
        }else{
            int index = hash(chave);
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
        System.out.println("Inseriu");
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
