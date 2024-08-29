/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q01 - Palindromo (palindromoJava)
 */

package tps.tp1.ex01_palindromoJava;

import java.util.Scanner;

/*
 * Classe que verifica se uma string é um palindromo.
 */
public class palindromoJava_ex01 {

    /*
    * Verifica se uma string e palindromo.
    * @param s String a ser verificada.
    * @return true se a string e palindromo, false caso contrario.
    *  */
    public static boolean isPalindromo(String input ) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    /*
     * Metodo principal que le strings da entrada e verifica se sao palindromos.
     * Imprime "SIM" se a string e palindromo, "NAO" caso contrario.
     */
    public static void main(String[] args) {
        // Read from input
        String s;
        Scanner scanner = new Scanner(System.in);
        while (!(s = scanner.nextLine()).equals("FIM")) {
            System.out.println(isPalindromo(s) ? "SIM" : "NAO");
        }

        scanner.close();
    }
}
