package exercicios.beecrowd.TrilhosNovamente;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TrilhosNovamenteTracandoMovimentos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int qtdVagoes = Integer.parseInt(sc.nextLine());
            if (qtdVagoes == 0) {
                break;
            }

            String[] entrada = sc.nextLine().split(" ");
            String[] saidaDesejada = sc.nextLine().split(" ");

            Stack<Character> pilha = new Stack<>();
            ArrayList<String> operacoes = new ArrayList<>();
            boolean ehPossivel = true;
            int iSaida = 0;

            for (String vagao : entrada) {
                // Empilha o vagão e registra a operação "I"
                pilha.push(vagao.charAt(0));
                operacoes.add("I");
                // Enquanto o topo da pilha coincide com o próximo vagão desejado, desempilha e registra "R"
                while (!pilha.isEmpty() && pilha.peek() == saidaDesejada[iSaida].charAt(0)) {
                    pilha.pop();
                    operacoes.add("R");
                    iSaida++;
                }

                if (iSaida == qtdVagoes) {
                    break;
                }
            }

            if (iSaida < qtdVagoes) {
                operacoes.add(" Impossible");
                ehPossivel = false;
            }

            for (String op : operacoes) {
                System.out.print(op);
            }
            System.out.println();
        }
    }

}
