package exercicios.beecrowd.EstacionamentoLinear;

import java.util.Scanner;
import java.util.Stack;

public class EstacionamentoLinear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdMotoristas;
        int qtdVagas;

        while (true) {
            qtdMotoristas = sc.nextInt();
            qtdVagas = sc.nextInt();
            sc.nextLine();  // Consumir o \n

            if (qtdMotoristas == 0 && qtdVagas == 0) {
                break;
            }

            boolean possivel = true;
            Stack<Integer> estacionamento = new Stack<>();

            for (int i = 0; i < qtdMotoristas && possivel; i++) {
                String[] motorista = sc.nextLine().split(" ");
                int H_entrada = Integer.parseInt(motorista[0]);
                int H_saida = Integer.parseInt(motorista[1]);

                // Remover carros que devem sair antes do horário de entrada atual
                while (!estacionamento.isEmpty() && estacionamento.peek() <= H_entrada) {
                    estacionamento.pop();
                }

                // Adicionar o carro atual se houver espaço e garantir a ordem de saída
                if (estacionamento.size() < qtdVagas) {
                    if (!estacionamento.isEmpty() && estacionamento.peek() < H_saida) {
                        // Se o próximo carro na pilha tiver que sair antes do H_saida atual, é impossível
                        possivel = false;
                    } else {
                        estacionamento.push(H_saida);
                    }
                } else {
                    // Caso o estacionamento esteja cheio, a operação é impossível
                    possivel = false;
                }
            }

            // Imprimir o resultado para o caso de teste atual
            if (possivel) {
                System.out.println("Sim");
            } else {
                System.out.println("Nao");
            }
        }

        sc.close();
    }
}
