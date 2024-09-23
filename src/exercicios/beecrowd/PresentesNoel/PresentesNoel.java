package exercicios.beecrowd.PresentesNoel;

import java.util.Scanner;

public class PresentesNoel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int qtdCriancas = scanner.nextInt();
        scanner.nextLine();
        int[] boasAcoes = new int[qtdCriancas];
        int[] presentes = new int[qtdCriancas];

        for (int i = 0; i < qtdCriancas; i++) {
            boasAcoes[i] = scanner.nextInt();
            presentes[i] = 1;
        }
        scanner.nextLine();

        for (int i = 1 ; i < qtdCriancas; i++) {
            if (boasAcoes[i] > boasAcoes[i-1]) {
                presentes[i] = presentes[i-1] + 1;
            }
        }


        // Passada da direita para a esquerda
        for (int i = qtdCriancas - 2; i >= 0; i--) {
            if (boasAcoes[i] > boasAcoes[i + 1]) {
                presentes[i] = Math.max(presentes[i], presentes[i + 1] + 1);
            }
        }

        int totalPresentes = 0;
        for (int i = 0; i < qtdCriancas; i++) {
            totalPresentes += presentes[i];
        }
        System.out.println(totalPresentes);
        scanner.close();
    }
}
