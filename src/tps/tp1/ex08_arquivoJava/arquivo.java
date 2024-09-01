/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q08 - Arquivo (ArquivoJava)
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * Classe que ensina o uso do RandomAccessFile que eh uma forma de ler e escrever arquivos de forma nao sequencial com suporte a ponteiros e maior flexibilidade.
*  */
@SuppressWarnings("WrongPackageStatement")
public class arquivo {
    /*
    * Funcao que escreve (n) vezes varios doubles no arquivo.txt (bit a bit)
     * @param n - Quantidade de doubles
     * @param filename - Nome do Arquivo
     * @param sc - Scanner para leitura
    * */
    public static void writeFile(int n, String filename, Scanner sc){
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            for (int i = 0; i < n; i++) {
                double inputN = sc.nextDouble();
                file.writeDouble(inputN);
            }
            file.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    /*
     * Funcao que le de tras para frente os bits que formavam os doubles originais transformando e mostrando os novos resultados
     * @param n - Quantidade de doubles
     * @param filename - Nome do Arquivo
     * */
    public static void readReverse(int n, String filename) {
        try {
            RandomAccessFile file = new RandomAccessFile(filename, "rw");
            long doubleSize = 8; // Um double tem 8 bytes (Ler de tras para frente)
            for (int i = n - 1; i >= 0; i--) {
                file.seek(i * doubleSize); // Posicionar o ponteiro corretamente
                double number = file.readDouble();
                if (number == (int) number ){
                    System.out.println((int) number);
                } else {
                    System.out.println(number);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String filename = "arquivo.txt";
        writeFile(n, filename, sc);
        sc.close();
        readReverse(n, filename);
    }
}
