/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q06 - Verificação de strings (Is)
*/

/*
 * Classe que verifica se uma string de entrada contém apenas vogais, apenas
 * consoantes, pode ser convertida para um inteiro ou para um número de ponto
 * flutuante.
 */
@SuppressWarnings("WrongPackageStatement")
public class Is {

  /*
   * Verifica se a string de entrada contém apenas vogais.
   * @param input a string a ser verificada
   * @return true se a entrada contém apenas vogais, false caso contrário
   */
  public static boolean hasVogal(String input) {
    input = input.toLowerCase();
    for (int i = 0; i < input.length(); ++i) {
      if (input.charAt(i) != 'a' && input.charAt(i) != 'e' &&
          input.charAt(i) != 'i' && input.charAt(i) != 'o' &&
          input.charAt(i) != 'u') {
        return false;
      }
    }
    return true;
  }

  /*
   * Verifica se a string de entrada contém apenas consoantes.
   * @param input a string a ser verificada
   * @return true se a entrada contém apenas consoantes, false caso contrário
   */
  public static boolean hasConsoante(String input) {
    input = input.toLowerCase();
    for (int i = 0; i < input.length(); ++i) {
      if (!Character.isLetter(input.charAt(i)) || input.charAt(i) == 'a' ||
          input.charAt(i) == 'e' || input.charAt(i) == 'i' ||
          input.charAt(i) == 'o' || input.charAt(i) == 'u') {
        return false;
      }
    }
    return true;
  }
  /*
   * Verifica se a string de entrada pode ser convertida para um inteiro.
   *
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

  /*
   * Verifica se a string de entrada pode ser convertida para um número de ponto
   * flutuante.
   *
   * @param input a string a ser verificada
   * @return true se a entrada pode ser convertida para um número de ponto
   *     flutuante, false caso contrário
   */
  public static boolean isFloat(String input) {
    input = input.replace(",", ".");
    try {
      Double.parseDouble(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /*
   * Metodo principal que lê strings de entrada e verifica se contêm vogais,
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
      System.out.printf("%s %s %s %s%n", hasVogal(entrada) ? "SIM" : "NAO",
                        hasConsoante(entrada) ? "SIM" : "NAO",
                        isInt(entrada) ? "SIM" : "NAO",
                        isFloat(entrada) ? "SIM" : "NAO");
    }
  }
}
