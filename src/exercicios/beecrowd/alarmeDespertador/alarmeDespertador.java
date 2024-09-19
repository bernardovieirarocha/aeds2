package exercicios.beecrowd.alarmeDespertador;

import java.util.Scanner;

public class alarmeDespertador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        while (true) {
            int[] horarioDormir = new int[2];
            int[] horarioAcordar = new int[2];

            for (int i = 0; i < 2; i++) {
                horarioDormir[i] = sc.nextInt();
            }
            for (int i = 0; i < 2; i++) {
                horarioAcordar[i] = sc.nextInt();
            }

            int horaDormir = (horarioDormir[0] == 0) ? 24 : horarioDormir[0];
            int minutoDormir = horarioDormir[1];
            int horaAcordar = (horarioAcordar[0] == 0) ? 24 : horarioAcordar[0];
            int minutoAcordar = horarioAcordar[1];

            // Se todos forem zero sair do loop
            if (horaDormir == 24 && minutoDormir == 0 && horaAcordar == 24 && minutoAcordar == 0) {
                break;
            }

            int dormirMIN = horaDormir * 60 + minutoDormir;
            int acordarMIN = horaAcordar * 60 + minutoAcordar;
           int minutosDormidos = acordarMIN - dormirMIN;

           if (minutosDormidos < 0) {
               minutosDormidos += 24 * 60;
           }

           System.out.println(minutosDormidos);

        }

        sc.close();
    }
}
