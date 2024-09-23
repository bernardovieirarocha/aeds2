package exercicios.beecrowd.MenorPilha;

import java.util.Stack;
import java.util.Scanner;

public class MenorPilhaRapido {
    public static void main(String[] args) {
        Stack<Integer> pilha = new Stack<>();
        Stack<Integer> minPilha = new Stack<>();

        Scanner sc = new Scanner(System.in);
        int qtdOperacoes = sc.nextInt();
        sc.nextLine();
        for (int i = 0 ; i < qtdOperacoes; i++){
            String operation = sc.next();
            if (operation.equals("PUSH")){
                int valor = sc.nextInt();
                pilha.push(valor);

                if (minPilha.isEmpty() || valor <= minPilha.peek()){
                    minPilha.push(valor);
                } else {
                    minPilha.push(minPilha.peek());
                }

            } else if (operation.equals("POP")) {
                if (!pilha.isEmpty()) {
                    pilha.pop();
                    minPilha.pop();
                }
            } else if (operation.equals("MIN")) {
                if (!minPilha.isEmpty()) {
                    System.out.println(minPilha.peek());
                } else {
                    System.out.println("EMPTY");
                }
            }
        }
        sc.nextLine();
        sc.close();
    }
}
