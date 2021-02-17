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

                linha = leitura.readLine(); 
                listaDeEntrada.add(linha);
            }
            leitura.close();
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo: "+ e.getMessage());
        }
        return listaDeEntrada;
    }
    
    private static void processamento(){
        Balde balde;
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com o tamanho a ser usado pelos baldes: ");
        int tamanhoGlobal = input.nextInt();
        System.out.println("Entre com o número de bits a serem usados nas pseudo-chaves: ");
        int bits = input.nextInt();
        balde = new Balde(bits, tamanhoGlobal);
        
        
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
        
    }
    
}
