
/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q05 - Algebra Boleana (Alg-Bool)
*/

@SuppressWarnings("WrongPackageStatement")
public class algbool {

  /**
   * Processa a string de entrada para substituir operadores lógicos e variáveis
   * pelos seus valores correspondentes.
   *
   * @param input A string de entrada contendo o número de operações, valores
   *     das variáveis e a expressão lógica.
   * @return A expressão processada com variáveis substituídas pelos seus
   *     valores e operadores lógicos simplificados.
   */
  public static String inputTreatment(String input) {
    String expressao = "";
    int qtdOperacoes = Character.getNumericValue(input.charAt(0));
    expressao = input.replace(" ", ""); // Remove espaços

    // Substitui operadores lógicos por caracteres únicos
    expressao = expressao.replace("and", "a");
    expressao = expressao.replace("or", "o");
    expressao = expressao.replace("not", "n");

    // Substitui variáveis pelos seus valores correspondentes
    for (int i = 0; i < qtdOperacoes; i++) {
      char letra = (char)('A' + i);
      char valorCorrespondente = expressao.charAt(i + 1);
      expressao = expressao.replace(letra, valorCorrespondente);
    }
    return expressao.substring(qtdOperacoes + 1, expressao.length());
  }

  /**
   * Avalia a expressão lógica com base na entrada fornecida.
   *
   * @param inputT A expressão lógica processada.
   * @return O resultado da avaliação lógica como uma string ("1" para
   *     verdadeiro, "0" para falso).
   */
  public static String evalExpression(String inputT) {
    int tamInput = inputT.length();
    char operacao = inputT.charAt(0);
    boolean stopFlag = true;

    switch (operacao) {
    case 'a':
      stopFlag = true;
      for (int i = 2; i < tamInput && stopFlag; i++) {
        // Retorna "0" se qualquer operando for "0"
        if (inputT.charAt(i) == '0') {
          stopFlag = false;
          return "0";
        }
      }
      return "1";
    case 'o':
      stopFlag = false;
      for (int i = 2; i < tamInput && !stopFlag; i++) {
        // Retorna "1" se qualquer operando for "1"
        if (inputT.charAt(i) == '1') {
          stopFlag = true;
          return "1";
        }
      }
      return "0";
    case 'n':
      if (inputT.charAt(2) == '0') {
        return "1";
      } else {
        return "0";
      }
    default:
      return "";
    }
  }

  /**
   * Resolve as equações lógicas fornecidas na entrada.
   * @param input A string de entrada.
   * @return O resultado da avaliação lógica como um booleano (true e false)
   */
  public static boolean solveEquations(String input) {
    String expressao = inputTreatment(input);
    boolean res = false;
    while (expressao.contains("(")) {
      int inicio = expressao.lastIndexOf("(");
      int fim = expressao.indexOf(")", inicio);

      String subExp = expressao.substring(inicio - 1, fim + 1);
      String resSubExp = evalExpression(subExp);

      expressao = expressao.substring(0, inicio - 1) + resSubExp +
                  expressao.substring(fim + 1, expressao.length());
    }
    res = expressao.equals("1");
    return res;
  }

  public static void main( String[] args )
    {
        String entrada = "";

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