package hashextensivel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Beatriz Cunha Rodrigues - 201776038
 * 
 */
public class main {
    
    private static ArrayList<String> leitura() throws FileNotFoundException, IOException{
        ArrayList<String> listaDeEntrada = new ArrayList<>();
        try {
            BufferedReader leitura = new BufferedReader(new FileReader("entrada.txt"));

            String linha = leitura.readLine(); 
            while (linha != null) {
                System.out.println("\n"+linha); 
                listaDeEntrada.add(linha);
                linha = leitura.readLine();
            }
            leitura.close();
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo: "+ e.getMessage());
        }
        return listaDeEntrada;
    }
    
    private static void processamento() throws IOException{
        Item item;
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com o tamanho a ser usado pelos baldes: ");
        int tamanho = input.nextInt();
        System.out.println("Entre com o número de bits a serem usados nas pseudo-chaves: ");
        int bits = input.nextInt();
        List<String> dados = leitura();
        Diretorio diretorios = new Diretorio(bits+1);
        for(int i=0; i< dados.size(); i++){
            String[] chave = dados.get(i).split(";");
            item = new Item(chave[0], chave[1]);
            diretorios.diretorio.get(i).setPseudoChaves(chave[0]);
            diretorios.inserirItem(item, bits, tamanho);
        }
    }
    
    
    private static void cabecalho(){
        System.out.println("ALUNA: BEATRIZ CUNHA RODRIGUES \n"
        + "MATRÍCULA: 201776038 \n"
        + "Trabalho de implementação hash extensível.");        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        cabecalho();
        processamento();
        
    }
    
}
