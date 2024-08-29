/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q03 - Ciframento de Cesar (ciframento)
 */


/**
 * Classe que implementa um ciframento simples de uma mensagem.
 */
@SuppressWarnings("WrongPackageStatement")
public class ciframento {

    /**
     * Método que cifra uma mensagem, deslocando cada caractere 3 posições no
     * código ASCII.
     *
     * @param message A mensagem a ser cifrada.
     * @return A mensagem cifrada.
     */
    public static String cifrar(String message) {
        String resultadoCifrado = "";
        int ascii = 0;
        for (int i = 0; i < message.length(); ++i) {
            ascii = (int)message.charAt(i);
            resultadoCifrado += (char)(ascii + 3);
        }
        return resultadoCifrado;
    }

    /**
     * Método que verifica se a string é "FIM".
     *
     * @param s A string a ser verificada.
     * @return true se a string for "FIM", false caso contrário.
     */
    public static boolean isFIM(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' &&
                s.charAt(2) == 'M');
    }

    /**
     * Método principal que lê entradas, cifra as mensagens e imprime os
     * resultados. Utiliza MyIO.readLine() para leitura das entradas.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {

        String[] entrada = new String[1000];
        int numEntrada = 0;

        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFIM(entrada[numEntrada++]) == false); // end do while
        numEntrada--;

        for (int x = 0; x < numEntrada; x = x + 1) {
            MyIO.println(cifrar(entrada[x]));
        }
    }
}
