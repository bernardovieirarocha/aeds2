package exercicios.beecrowd.SequenciaSecreta;

import java.util.Scanner;

public class SequenciaSecreta {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        int contador = 1;
        for (int i = 0; i < n -1; i++) {
            if (seq[i] != seq[i+1]) {
                contador++;
            }
        }

        System.out.println(contador);

        sc.close();
    }
}
