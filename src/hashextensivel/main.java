package hashextensivel;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Beatriz Cunha Rodrigues - 201776038
 * 
 */
public class main {
       
    private static String gerarBinariosAleatorios(int bits, Random random){
        String binarioAleatorio = "";
	for(int i=0; i< bits; i++){
            boolean bit = random.nextBoolean();
            if(bit)
                binarioAleatorio = binarioAleatorio.concat("1");
            else
                binarioAleatorio = binarioAleatorio.concat("0");
        }
        System.out.println(binarioAleatorio);
        return binarioAleatorio;
    }
    
    private static String gerarBinariosComPadrao(int bits, Random random, String padrao){
        String binarioAleatorio = padrao;
	for(int i=0; i< bits - padrao.length(); i++){
            boolean bit = random.nextBoolean();
            if(bit)
                binarioAleatorio = binarioAleatorio.concat("1");
            else
                binarioAleatorio = binarioAleatorio.concat("0");
        }
        System.out.println(binarioAleatorio);
        return binarioAleatorio;
    }
    
    private static void processamento(){
        Scanner input = new Scanner(System.in);
        System.out.println("Entre com o tamanho a ser usado pelos baldes: ");
        int tamanho = input.nextInt();
        System.out.println("Entre com o número de bits a serem usados nas pseudo-chaves: ");
        int bits = input.nextInt();
        System.out.println("1 - Inserções de N pseudo-chaves aleatórias: \n"
                + "2 - Inserções de N pseudo-chaves iniciadas com um mesmo padrão de bits\n"
                + "3 - Sair");
        int op = input.nextInt();
        Random gerar = new Random(16);
        switch (op){
            case 1:
                for(int i=0; i < 10; i++){
                    String bitsAleatorios = gerarBinariosAleatorios(bits, gerar);
                    Diretorio diretorio = new Diretorio(tamanho, bits);
                    diretorio.inserirItem(bitsAleatorios);
                }
                break;
            case 2:
                System.out.println("Passe um padrão de bits: ");
                String padrao = input.next();
                for(int i=0; i < 10; i++){
                    String bitsAleatorios = gerarBinariosComPadrao(bits, gerar, padrao);
                    Diretorio diretorio = new Diretorio(tamanho, bits);
                    diretorio.inserirItem(bitsAleatorios);
                }
                break;
            default:
                System.exit(0);
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
    public static void main(String[] args){
        cabecalho();
        processamento();
       
    }
    
}
