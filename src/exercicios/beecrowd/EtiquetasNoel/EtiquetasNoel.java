package exercicios.beecrowd.EtiquetasNoel;

import java.util.Scanner;

class FelizNatalTraducoes {
    public String nome;
    public String traducao;
}

class Etiqueta {
    public String nome;
    public String mensagem;
}

public class EtiquetasNoel {

    public static String traduzirMensagem(String lingua, FelizNatalTraducoes[] traducoes) {
        for (FelizNatalTraducoes idioma : traducoes) {
            if (idioma.nome.equals(lingua)) {
                return idioma.traducao;
            }
        }
        return "Not found";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdTraducoes = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        FelizNatalTraducoes[] traducoes = new FelizNatalTraducoes[qtdTraducoes];

        for (int i = 0; i < qtdTraducoes; i++) {
            traducoes[i] = new FelizNatalTraducoes();
            traducoes[i].nome = sc.nextLine();
            traducoes[i].traducao = sc.nextLine();
        }

        int qtdCriancas = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < qtdCriancas; i++) {
            Etiqueta etiqueta = new Etiqueta();
            etiqueta.nome = sc.nextLine();
            String lingua = sc.nextLine();

            etiqueta.mensagem = traduzirMensagem(lingua, traducoes);

            System.out.println(etiqueta.nome);
            System.out.println(etiqueta.mensagem);
            System.out.println();
        }

        sc.close();
    }
}