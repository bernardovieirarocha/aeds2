/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB03_01 - Balanco Parenteses (BalancoParanteses)
 */

import java.util.Stack;

@SuppressWarnings("WrongPackageStatement")
public class balancoParenteses
{
    /**
     * Funcao que empilha a cada '(' abertura e desempilha-os a medida que encontra fechamentos ')',
     * verificando se os parenteses estao definidos de forma correta.
     * @param s - String de entrada trimmed(sem espacos)
    * */
    public static boolean findOpenParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            }
            else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String entrada = "";

        while (true) {
            entrada = MyIO.readLine();
            entrada = entrada.trim();
            if (entrada.equals("FIM")) break;

            System.out.println(findOpenParentheses(entrada) ? "correto": "incorreto");
        }


    }

}
