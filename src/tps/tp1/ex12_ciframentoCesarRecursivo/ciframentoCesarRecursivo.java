/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q12 - Ciframento de Cesar Recursivo (ciframentoRecursivoJava)
 */

// TODO: Porque esse código no meu MAC acusa que esta dando errado mas no verde funciona ? Eh um problema de enconding no diff ?
@SuppressWarnings("WrongPackageStatement")
public class ciframentoCesarRecursivo {

    /*
     * Metodo que cifra uma mensagem de forma RECURSIVA, deslocando cada caractere 3 posições no ASCII
     * @param message - A mensagem a ser cifrada.
     * @param count - Contador
     * @return A mensagem cifrada.
     */
    public static String cifrar(String message, int count) {
        if (count == message.length()) {
            return "";
        }
        int ascii = (int) message.charAt(count);
        char cifrado = (char) (ascii + 3);
        return cifrado + cifrar(message, count + 1);
    }

    /*
     * Metodo que verifica se a string é "FIM".
     *
     * @param s A string a ser verificada.
     * @return true se a string for "FIM", false caso contrário.
     */
    public static boolean isFIM(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' &&
                s.charAt(2) == 'M');
    }
    public static void main(String[] args) {
        String[] entradas = new String[1000];
        int numEntradas = 0;

        do {
           entradas[numEntradas] = MyIO.readLine();
        } while (!isFIM(entradas[numEntradas++]));
        numEntradas--;

        for (int x = 0; x < numEntradas; x = x + 1) {
            MyIO.println(cifrar(entradas[x], 0));
        }

    }
}


