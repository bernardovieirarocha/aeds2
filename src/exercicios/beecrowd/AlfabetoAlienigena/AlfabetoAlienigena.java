package exercicios.beecrowd.AlfabetoAlienigena;

import java.util.Scanner;

public class AlfabetoAlienigena {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalCaracteresAlfabeto = sc.nextInt();
        int numeroCaracteresEnviados = sc.nextInt();
        sc.nextLine();

        String alfabetoAlien = sc.nextLine();
        String caracteresEnviados = sc.nextLine();

        boolean alfabetoValido = true;
        for (int i = 0 ; i < numeroCaracteresEnviados; i++) {
            char caracter = caracteresEnviados.charAt(i);
            if (!alfabetoAlien.contains(String.valueOf(caracter))) {
                alfabetoValido = false;
                break;
            }
        }

        System.out.println(alfabetoValido ? "S" : "N");

        sc.close();

    }
}
