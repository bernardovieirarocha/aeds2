/*
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q07 - Leitura HTML (leituraHtml)
 */
import java.io.*;
import java.net.*;

@SuppressWarnings("WrongPackageStatement")
public class leituraHtml {
  // Array que armazena as vogais e suas respectivas quantidades.
  static int[] vogais;

  // Array que armazena o valor do char de cada uma das vogais especiais.
  static final char[] vogalEspecial = {
      225, // á 0
      233, // é 1
      237, // í 2
      243, // ó 3
      250, // ú 4
      224, // à 5
      232, // è 6
      236, // ì 7
      242, // ò 8
      249, // ù 9
      227, // ã 10
      245, // õ 11
      226, // â 12
      234, // ê 13
      238, // î 14
      244, // ô 15
      251  // û 16
  };

  // ------- Funcao Fornecida pelo Professor:

  public static void printVariaveis() {
    System.out.printf("a(%s) ", vogais[0]);
    System.out.printf("e(%s) ", vogais[1]);
    System.out.printf("i(%s) ", vogais[2]);
    System.out.printf("o(%s) ", vogais[3]);
    System.out.printf("u(%s) ", vogais[4]);
    System.out.printf("%c(%s) ", vogalEspecial[0], vogais[5]);
    System.out.printf("%c(%s) ", vogalEspecial[1], vogais[6]);
    System.out.printf("%c(%s) ", vogalEspecial[2], vogais[7]);
    System.out.printf("%c(%s) ", vogalEspecial[3], vogais[8]);
    System.out.printf("%c(%s) ", vogalEspecial[4], vogais[9]);
    System.out.printf("%c(%s) ", vogalEspecial[5], vogais[10]);
    System.out.printf("%c(%s) ", vogalEspecial[6], vogais[11]);
    System.out.printf("%c(%s) ", vogalEspecial[7], vogais[12]);
    System.out.printf("%c(%s) ", vogalEspecial[8], vogais[13]);
    System.out.printf("%c(%s) ", vogalEspecial[9], vogais[14]);
    System.out.printf("%c(%s) ", vogalEspecial[10], vogais[15]);
    System.out.printf("%c(%s) ", vogalEspecial[11], vogais[16]);
    System.out.printf("%c(%s) ", vogalEspecial[12], vogais[17]);
    System.out.printf("%c(%s) ", vogalEspecial[13], vogais[18]);
    System.out.printf("%c(%s) ", vogalEspecial[14], vogais[19]);
    System.out.printf("%c(%s) ", vogalEspecial[15], vogais[20]);
    System.out.printf("%c(%s) ", vogalEspecial[16], vogais[21]);
  }

  public static boolean isEspecialVogal(char letra) {
    for (int i = 0; i < vogalEspecial.length; i++) {
      if (letra == vogalEspecial[i]) {
        return true;
      }
    }
    return false;
  }

  public static void countVogais(String html) {
    vogais = new int[23]; // aeiou + caracters especiais
    for (int i = 0; i < html.length(); ++i) {
      char letra = html.charAt(i);
      if (letra == 'a')
        vogais[0]++;
      else if (letra == 'e')
        vogais[1]++;
      else if (letra == 'i')
        vogais[2]++;
      else if (letra == 'o')
        vogais[3]++;
      else if (letra == 'u')
        vogais[4]++;
      else if (isEspecialVogal(letra)) {
        for (int j = 0; j < vogalEspecial.length; ++j) {
          if (letra == vogalEspecial[j]) {
            // Mais 5 porque as 5 primeiras posicoes do array vogais armazenam
            // as vogais normais.
            vogais[j + 5]++;
            break;
          }
        }
      }
    }
  }

  public static int countConsoantes(String html) {
    int result = 0;
    String consoantes = "bcdfghjklmnpqrstvwxyz";
    for (int i = 0; i < consoantes.length(); ++i) {
      char letraC = consoantes.charAt(i);
      for (int y = 0; y < html.length(); y++) {
        char htmlLetra = html.charAt(y);
        if (htmlLetra == letraC) {
          result++;
        }
      }
    }
    return result;
  }

  public static int countBR(String html) {
    int result = 0;
    for (int i = 0; i < html.length(); i++) {
      if (html.substring(i, i + 4).equals("<br>")) {
        result++;
      }
    }
    return result;
  }

  public static int countTable(String html) {
    int result = 0;
    for (int x = 0; x < html.length() - 7; x = x + 1) {
      if (html.substring(x, x + 7).equals("<table>")) {
        result++;
      } // end if
    } // end for
    return (result);
  } // end countTable ( )

  public static void main(String[] args) {
//    MyIO.setCharset("UTF-8");
    String nome;
    String endereco;
    String html = "";

    int qtd_consoantes = 0, qtd_br = 0, qtd_table = 0;

    do {
       nome = MyIO.readLine();
      if (!nome.equals("FIM")) {
         endereco = MyIO.readLine();
        html = getHtml(endereco);

         countVogais(html);
         qtd_consoantes = countConsoantes(html);
         qtd_br = countBR(html);
         qtd_table = countTable(html);

         vogais[0] -= qtd_table; // descontar o 'a' da palavra "table"
         vogais[1] -= qtd_table; // descontar o 'e' da palavra "table"
         qtd_consoantes -=
             (2 * qtd_br + 3 * qtd_table); // descontar as consoantes das
                                           // palavras "br" e "table"

         printVariaveis();
         System.out.printf("consoante(%s) ", qtd_consoantes);
         System.out.printf("<br>(%s) ", qtd_br);
         System.out.printf("<table>(%s) ", qtd_table);
         System.out.printf("%s\n", nome);
      }

    } while (!nome.equals("FIM"));
  }

  public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
}
