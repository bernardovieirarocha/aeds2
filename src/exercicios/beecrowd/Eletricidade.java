package exercicios.beecrowd;

import java.util.Scanner;

public class Eletricidade {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int N = sc.nextInt();
            if (N == 0) break;

            int[] dia = new int[N];
            int[] mes = new int[N];
            int[] ano = new int[N];
            int[] consumo = new int[N];

            for (int i = 0; i < N; i++) {
                dia[i] = sc.nextInt();
                mes[i] = sc.nextInt();
                ano[i] = sc.nextInt();
                consumo[i] = sc.nextInt();
            }

            int totalDiasConsecutivos = 0;
            int totalConsumo = 0;

            for (int i = 1; i < N; i++) {
                if (isConsecutivo(dia[i - 1], mes[i - 1], ano[i - 1], dia[i], mes[i], ano[i])) {
                    totalDiasConsecutivos++;
                    totalConsumo += (consumo[i] - consumo[i - 1]);
                }
            }

            System.out.println(totalDiasConsecutivos + " " + totalConsumo);
        }

        sc.close();
    }

    public static boolean isConsecutivo(int d1, int m1, int y1, int d2, int m2, int y2) {
        // Avançar um dia
        d1++;

        // Número de dias no mês atual
        int[] diasNoMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Ajustar para ano bissexto
        if (m1 == 2 && isBissexto(y1)) {
            diasNoMes[1] = 29;
        }

        // Verificar se precisa avançar para o próximo mês
        if (d1 > diasNoMes[m1 - 1]) {
            d1 = 1;
            m1++;
        }

        // Verificar se precisa avançar para o próximo ano
        if (m1 > 12) {
            m1 = 1;
            y1++;
        }

        // Comparar se as datas resultantes são iguais
        return (d1 == d2 && m1 == m2 && y1 == y2);
    }

    public static boolean isBissexto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}
