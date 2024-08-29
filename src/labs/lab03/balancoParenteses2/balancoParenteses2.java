/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB03_01 - Balanco Parenteses (BalancoParanteses)
 */

@SuppressWarnings("WrongPackageStatement")
public class balancoParenteses2 {

    /**
     * Verifica se a string dada possui parênteses balanceados.
     *
     * @param s A string a ser verificada.
     * @return Retorna true se a string possuir parênteses balanceados, caso contrário, false.
     */
    public static boolean checkBalance(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '(') {
                balance++;
            }
            if (s.charAt(i) == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        String entrada = "" ;

        while (true) {
            entrada = MyIO.readLine();
            entrada = entrada.trim();
            if (entrada.equals("FIM")) break;
            System.out.println(checkBalance(entrada) ? "correto": "incorreto");

        }

    }

}
