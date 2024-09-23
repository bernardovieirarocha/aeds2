package exercicios.beecrowd.MenorPilha;

import java.util.Scanner;
import java.util.Stack;

public class MenorPilha {

    public static void findPrintMin(Stack<Integer> pilha) {
        int min = Integer.MAX_VALUE;
        for (Integer integer : pilha) {
            if (integer < min) {
                min = integer;
            }
        }
        System.out.println(min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> pilha = new Stack<>();


        int qtdOperacoes = sc.nextInt();

        for (int i = 0; i < qtdOperacoes; i++) {
            String operacao = sc.next();

            if (operacao.equals("PUSH")) {
                pilha.push(sc.nextInt());
            }
            if (operacao.equals("POP")) {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                }
            }
            if (operacao.equals("MIN")) {
                if (!pilha.isEmpty()) {
                    findPrintMin(pilha);
                } else {
                    System.out.println("EMPTY");
                }
            }
            sc.nextLine();
        }


    }
}
