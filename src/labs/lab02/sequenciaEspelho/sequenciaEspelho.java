/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB02_01 - Sequencia Espelho (sequenciaEspelho)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("WrongPackageStatement")
public class sequenciaEspelho {

    /**
     * Imprime de maneira invertida os numeros da lista.
     *
     * @param numeros A lista de numeros inteiros.
     * @return Uma string com os numeros invertidos e concatenados.
     */
    public static void espelhar(List<Integer> numeros) {
        // Percorre a lista de numeros em ordem inversa
        for (int i = numeros.size() - 1; i >= 0; i--) {
            String to_string = Integer.toString(numeros.get(i));
            String invertido = new StringBuilder(to_string).reverse().toString();
            System.out.print(invertido);
        }

    }

    public  static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int inicio = sc.nextInt();
            int fim = sc.nextInt();

            List<Integer> numeros = new ArrayList<>();

            // Criar a lista com os numeros na ordem crescente comum
            for (int i = inicio; i <= fim; i++) {
                System.out.print(i);
                numeros.add(i);
            }


            espelhar(numeros);
            System.out.println();
        }
        sc.close();

    }
}
