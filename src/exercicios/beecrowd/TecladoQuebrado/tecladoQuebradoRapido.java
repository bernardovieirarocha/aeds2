package exercicios.beecrowd.TecladoQuebrado;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class tecladoQuebradoRapido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String frase = scanner.nextLine();
            Deque<Character> resultado = new LinkedList<>();
            boolean addToFront = false;
            Deque<Character> temp = new LinkedList<>();

            for (char ch : frase.toCharArray()) {
                if (ch == '[') {
                    while (!temp.isEmpty()) {
                        resultado.addFirst(temp.removeLast());
                    }
                    addToFront = true;
                } else if (ch == ']') {
                    while (!temp.isEmpty()) {
                        resultado.addFirst(temp.removeLast());
                    }
                    addToFront = false;
                } else {
                    if (addToFront) {
                        temp.addLast(ch);
                    } else {
                        resultado.addLast(ch);
                    }
                }
            }

            while (!temp.isEmpty()) {
                resultado.addFirst(temp.removeLast());
            }

            StringBuilder finalResult = new StringBuilder();
            for (char ch : resultado) {
                finalResult.append(ch);
            }

            System.out.println(finalResult);
        }

        scanner.close();
    }
}