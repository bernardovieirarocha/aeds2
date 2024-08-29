/*
  Bernardo Vieira Rocha - 853733
  Ciencia da Computacao PUC-MINAS
  TP01_Q04 - Alteracao Aleatoria (alteracao)
*/

import java.util.Random;

@SuppressWarnings("WrongPackageStatement")
public class alteracao {
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
   * Método que substitui todas as ocorrências de um caractere por outro em uma
   * string.
   *
   * @param s A string na qual as substituições serão feitas.
   * @param a O caractere a ser substituído.
   * @param b O caractere substituto.
   * @return A nova string com as substituições feitas.
   */
  public static String mudar(String s, char a, char b) {
    // Cria um array de caracteres com o mesmo tamanho da string original
    char[] resultado = new char[s.length()];

    // Itera sobre cada caractere da string original
    for (int i = 0; i < s.length(); i++) {
      // Se o caractere atual for igual a 'a', substitui por 'b'
      if (s.charAt(i) == a) {
        resultado[i] = b;
      } else {
        // Caso contrário, mantém o caractere original
        resultado[i] = s.charAt(i);
      }
    }

    // Constrói a nova string a partir do array de caracteres
    String novaString = "";
    for (int i = 0; i < resultado.length; i++) {
      novaString += resultado[i];
    }

    // Retorna a nova string construída
    return novaString;
  }

  public static void main(String[] args) {
    Random gerador = new Random();
    gerador.setSeed(4);

    String[] entradas = new String[1000];
    int numEntrada = 0;

    do {
      entradas[numEntrada] = MyIO.readLine();
    } while (!isFIM(entradas[numEntrada++]));
    numEntrada--;

    for (int i = 0; i < numEntrada; ++i) {
      char a = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
      char b = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
      MyIO.println(mudar(entradas[i], a, b));
    }
  }
}
