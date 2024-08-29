/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q15 - Is Recursivo (IsRecursivo)
 */

/**
 * Classe que verifica se uma string de entrada contém apenas vogais, apenas
 * consoantes, pode ser convertida para um inteiro ou para um número de ponto
 * flutuante.
 */
@SuppressWarnings("WrongPackageStatement")
public class isRecursivo {

    /**
     * Verifica se a string de entrada contém apenas vogais de maneira RECURSIVA.
     * @param input a string a ser verificada
     * @param count - Contador
     * @return true se a entrada contém apenas vogais, false caso contrário
     */
    public static boolean hasVogal(String input, int count) {
        if (input.length() == count) return true;

        if (input.charAt(count) != 'a' && input.charAt(count) != 'e' &&
                input.charAt(count) != 'i' && input.charAt(count) != 'o' &&
                input.charAt(count) != 'u' ) {
            return false;
        }
        return hasVogal(input, count + 1);
    }

    /**
     * Verifica se a string de entrada contém apenas consoantes de maneira RECURSIVA.
     * @param input a string a ser verificada
     * @param count - Contador
     * @return true se a entrada contém apenas consoantes, false caso contrário
     */
    public static boolean hasConsoante(String input, int count) {
        if (input.length() == count) return true;

        if (!Character.isLetter(input.charAt(count)) || input.charAt(count) == 'a' ||
                input.charAt(count) == 'e' || input.charAt(count) == 'i' ||
                input.charAt(count) == 'o' || input.charAt(count) == 'u') {
            return false;
        }
        return hasConsoante(input, count + 1);
    }
    /**
     * Verifica se a string de entrada pode ser convertida para um inteiro de maneira RECURSIVA.
     * @param input a string a ser verificada
     * @return true se a entrada pode ser convertida para um inteiro, false caso
     *     contrário
     */
    public static boolean isInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Verifica se a string de entrada pode ser convertida para um número de ponto
     * flutuante.
     *
     * @param input a string a ser verificada
     * @return true se a entrada pode ser convertida para um número de ponto
     *     flutuante, false caso contrário
     */
    public static boolean isFloat(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Método principal que lê strings de entrada e verifica se contêm vogais,
     * consoantes, inteiros e números de ponto flutuante.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        String entrada = "";
        while (true) {
            entrada = MyIO.readLine();
            if (entrada.equals("FIM") || entrada.isEmpty()) {
                break;
            }

            // Tratamento de Dados
            entrada = entrada.toLowerCase();
            entrada = entrada.replace(",", ".");

            System.out.printf("%s %s %s %s%n", hasVogal(entrada, 0) ? "SIM" : "NAO",
                    hasConsoante(entrada, 0) ? "SIM" : "NAO",
                    isInt(entrada) ? "SIM" : "NAO",
                    isFloat(entrada) ? "SIM" : "NAO");
        }
    }
}
