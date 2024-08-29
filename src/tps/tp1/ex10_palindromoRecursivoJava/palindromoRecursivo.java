/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q10- Palindromo RECURSIVO (palindromoRecursivoJava)
 */

/*
 * Classe que verifica se uma string é um palindromo de forma recursiva.
 */
@SuppressWarnings("WrongPackageStatement")
public class palindromoRecursivo {

    /*
     * Metodo auxiliar que inicializa a verificacao do palindromo.
     * @param input - String a ser verificada
     * @return boolean - Resposta da verificação
     */
    public static boolean isPalindromo(String input) {
        return isPalindromo(input, 0);
    }

    /*
    *  Verifica de maneira recursiva se a string eh palindroma
     * @param input - String a ser verificada
     * @param count - Contador de posicoes da string
     * @return boolen - Resposta da verificacao
    * */
    public static boolean isPalindromo(String input, int count) {
        if (count >= input.length() / 2) {
            return true;
        }
        if (input.charAt(count) != input.charAt(input.length() - count - 1)) {
            return false;
        }
        return isPalindromo(input, count + 1);
    }

    /*
     * Funcao que checa se a string eh igual a FIM
     * @param input - String a ser verificada
     * @return true se a string for igual e false caso contrario
    * */
    public static boolean isFIM(String input){
        return (input.length() == 3 && input.charAt(0) == 'F' && input.charAt(1) == 'I' && input.charAt(2) == 'M');
    }

    public static void main(String[] args) {
        String s;
        MyIO.setCharset("UTF-8");
        while (!isFIM((s = MyIO.readLine())) ){
            System.out.println(isPalindromo(s, 0) ? "SIM" : "NAO");
        }
    }
}
