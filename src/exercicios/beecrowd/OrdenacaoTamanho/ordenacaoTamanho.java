package exercicios.beecrowd.OrdenacaoTamanho;

import java.util.Scanner;

public class ordenacaoTamanho {

    public static void lerSentencas(String[] sentencas, int qtd) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < qtd; i++) {
            sentencas[i] = sc.nextLine();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtd;
        qtd = sc.nextInt();
        String[] sentencas = new String[qtd];
        lerSentencas(sentencas, qtd);

        for (String sentenca : sentencas) {
            String[] palavras = sentenca.split(" ");
            // Ordenar as palavras por tamanho decrescente
//            Arrays.sort(palavras, (a, b) -> b.length() - a.length());
            // Ordenar usando bubble sort
            for (int i = 0 ; i < palavras.length -1; ++i) {
                for (int j = 0; j < palavras.length - i - 1; ++j) {
                    if (palavras[j].length() < palavras[j+1].length()) {
                        String temp = palavras[j];
                        palavras[j] = palavras[j+1];
                        palavras[j+1] = temp;
                    }
                }
            }
            // Imprimir as palavras
            for (String palavra : palavras) {
                System.out.print(palavra + " ");
            }
            System.out.println();
        }

    }

}
