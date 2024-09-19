package exercicios.beecrowd.TecladoQuebrado;
import java.util.Scanner;

public class tecladoQuebrado {

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       while(scanner.hasNext()) {
           String frase = scanner.nextLine();
           StringBuilder resultado = new StringBuilder();

            for (int i = 0; i < frase.length(); i++) {
               if (frase.charAt(i) == '[') {
                   int j = i + 1;
                   int contador = 0;
                   while (j < frase.length() && frase.charAt(j) != ']') {
                       resultado.insert(contador, frase.charAt(j));
                       j++;
                       contador++;
                   }
                   i = j;
               } else if( frase.charAt(i) == ']' ) {
                   int j = i - 1;
                   while (j >= 0 && frase.charAt(j) != '[') {
                       resultado.append(frase.charAt(j));
                       j--;
                   }
                   i = j;
               }
               else {
                   resultado.append(frase.charAt(i));
               }
           }
        System.out.println(resultado);
       }

       scanner.close();

    }

}
