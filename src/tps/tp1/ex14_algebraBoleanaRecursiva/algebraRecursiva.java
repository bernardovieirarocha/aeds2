/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q14 - Algebra Booleana Recursiva (Algebra Recursiva)
 */
@SuppressWarnings("WrongPackageStatement")
public class algebraRecursiva {


    /**
     * Processa a string de entrada para substituir operadores lógicos e variáveis
     * pelos seus valores correspondentes de forma RECURSIVA.
     *
     * @param input A string de entrada contendo o número de operações, valores
     *     das variáveis e a expressão lógica.
     * @return A expressão processada com variáveis substituídas pelos seus
     *     valores e operadores lógicos simplificados.
     */
    public static String inputTreatment(String input) {
        int qtdOperacoes = Character.getNumericValue(input.charAt(0));
        String expressao = input.replace(" ", ""); // Remove espaços

        // Helper method to handle recursion for replacing operators and variables
        return processExpression(expressao, qtdOperacoes, 0);
    }

    /**
     * Substitui recursivamente as variáveis na expressão pelos seus valores
     * correspondentes.
     *
     * @param expressao A expressão lógica a ser processada.
     * @param qtdOperacoes O número de operações a serem realizadas.
     * @param index O índice atual para substituição da variável.
     * @return A expressão com as variáveis substituídas pelos seus valores.
     */
    private static String processExpression(String expressao, int qtdOperacoes, int index) {
        if (index == qtdOperacoes) {
            return simplifyOperators(expressao.substring(qtdOperacoes + 1));
        }

        char letra = (char)('A' + index);
        char valorCorrespondente = expressao.charAt(index + 1);
        expressao = expressao.replace(letra, valorCorrespondente);

        return processExpression(expressao, qtdOperacoes, index + 1);
    }

    /**
     * Substitui recursivamente os operadores lógicos na expressão pelos seus
     * caracteres únicos correspondentes.
     *
     * @param expressao A expressão lógica a ser simplificada.
     * @return A expressão com os operadores lógicos simplificados.
     */
    private static String simplifyOperators(String expressao) {
        if (!expressao.contains("and") && !expressao.contains("or") && !expressao.contains("not")) {
            return expressao;
        }

        if (expressao.contains("and")) {
            expressao = expressao.replace("and", "a");
        }
        if (expressao.contains("or")) {
            expressao = expressao.replace("or", "o");
        }
        if (expressao.contains("not")) {
            expressao = expressao.replace("not", "n");
        }

        return simplifyOperators(expressao);
    }

    /**
     * Avalia recursivamente a expressão lógica com base na entrada fornecida.
     *
     * @param inputT A expressão lógica processada.
     * @return O resultado da avaliação lógica como uma string ("1" para
     *     verdadeiro, "0" para falso).
     */
    public static String evalExpression(String inputT) {
        char operacao = inputT.charAt(0);

        return switch (operacao) {
            case 'a' -> evalAndExpression(inputT, 2);
            case 'o' -> evalOrExpression(inputT, 2);
            case 'n' -> inputT.charAt(2) == '0' ? "1" : "0";
            default -> "";
        };
    }

    private static String evalAndExpression(String inputT, int index) {
        if (index >= inputT.length()) {
            return "1"; // Todos os operandos eram "1"
        }
        if (inputT.charAt(index) == '0') {
            return "0"; // Qualquer operando "0" resulta em "0"
        }
        return evalAndExpression(inputT, index + 1);
    }

    private static String evalOrExpression(String inputT, int index) {
        if (index >= inputT.length()) {
            return "0"; // Nenhum operando era "1"
        }
        if (inputT.charAt(index) == '1') {
            return "1"; // Qualquer operando "1" resulta em "1"
        }
        return evalOrExpression(inputT, index + 1);
    }

    /**
     * Resolve recursivamente as equações lógicas fornecidas na entrada.
     * @param input A string de entrada.
     * @return O resultado da avaliação lógica como um booleano (true e false)
     */
    public static boolean solveEquations(String input) {
        String expressao = inputTreatment(input);
        return solveRecursive(expressao).equals("1");
    }

    private static String solveRecursive(String expressao) {
        if (!expressao.contains("(")) {
            return expressao;
        }

        int inicio = expressao.lastIndexOf("(");
        int fim = expressao.indexOf(")", inicio);

        String subExp = expressao.substring(inicio - 1, fim + 1);
        String resSubExp = evalExpression(subExp);

        String novaExpressao = expressao.substring(0, inicio - 1) + resSubExp +
                expressao.substring(fim + 1);

        return solveRecursive(novaExpressao);
    }


    public static void main( String[] args )
    {
        String entrada;

        do
        {
            entrada = MyIO.readLine();
            if( !entrada.equals("0") )
            {
                if( solveEquations( entrada ) )
                {
                    MyIO.println( "1" );
                }
                else
                {
                    MyIO.println( "0" );
                } // end if
            } // end if
        } while ( !entrada.equals( "0" ) ); // end do while


    }
}