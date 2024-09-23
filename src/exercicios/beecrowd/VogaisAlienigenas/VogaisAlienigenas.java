package exercicios.beecrowd.VogaisAlienigenas;

import java.util.Scanner;

public class VogaisAlienigenas {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       while (sc.hasNext()) {
           String vogais = sc.nextLine();
           String frase = sc.nextLine();

           int qtdVogais = 0;
           for (int i = 0; i < frase.length(); i++) {
               if (vogais.contains(frase.substring(i, i+1))) {
                   qtdVogais++;
               }
           }

           System.out.println(qtdVogais);

       }
        sc.close();
    }
}
