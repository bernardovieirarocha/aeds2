package exercicios.beecrowd.JogandoCartasFora;

import java.util.LinkedList;
import java.util.Scanner;

public class jogandoCartasFora {

    public static void inserirCartasIniciais(int n, LinkedList<Integer> cartas) {
        for (int i = 1; i <= n; i++) {
            cartas.add(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;

            LinkedList<Integer> cartas = new LinkedList<>();
            LinkedList<Integer> descartadas = new LinkedList<>();
            inserirCartasIniciais(n, cartas);

            while (cartas.size() > 1) {
                descartadas.add(cartas.removeFirst());
                cartas.addLast(cartas.removeFirst());
            }

            System.out.print("Discarded cards: ");
            for (int i = 0; i < descartadas.size(); i++) {
                if (i > 0) {
                    System.out.print(", ");
                }
                System.out.print(descartadas.get(i));
            }
            System.out.println();
            System.out.println("Remaining card: " + cartas.getFirst());
        }

        sc.close();
    }
}
