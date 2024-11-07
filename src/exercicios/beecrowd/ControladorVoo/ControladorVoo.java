package exercicios.beecrowd.ControladorVoo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ControladorVoo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> filaOeste = new LinkedList<>();
        Queue<String> filaNorte = new LinkedList<>();
        Queue<String> filaSul = new LinkedList<>();
        Queue<String> filaLeste = new LinkedList<>();

        Queue<String> filaAtual = null;

        while (sc.hasNextLine()) {
            String input = sc.nextLine().trim();
            switch (input) {
                case "-1":
                    filaAtual = filaOeste;
                    break;
                case "-2":
                    filaAtual = filaSul;
                    break;
                case "-3":
                    filaAtual = filaNorte;
                    break;
                case "-4":
                    filaAtual = filaLeste;
                    break;
                case "0":
                    sc.close();
                    printQueue(filaOeste, filaNorte, filaSul, filaLeste);
                    return;
                default:
                    if (filaAtual != null && input.startsWith("A")) {
                        filaAtual.add(input);
                    }
                    break;
            }
        }
        sc.close();
    }

    private static void printQueue(Queue<String> filaOeste, Queue<String> filaNorte, Queue<String> filaSul, Queue<String> filaLeste) {
        StringBuilder result = new StringBuilder();

        while (!filaOeste.isEmpty() || !filaNorte.isEmpty() || !filaSul.isEmpty() || !filaLeste.isEmpty()) {
            if (!filaOeste.isEmpty()) {
                result.append(filaOeste.poll()).append(" ");
            }
            if (!filaNorte.isEmpty()) {
                result.append(filaNorte.poll()).append(" ");
            }
            if (!filaSul.isEmpty()) {
                result.append(filaSul.poll()).append(" ");
            }
            if (!filaLeste.isEmpty()) {
                result.append(filaLeste.poll()).append(" ");
            }
        }
        // Remove o último espaço
        System.out.println(result.toString().trim());

    }
}