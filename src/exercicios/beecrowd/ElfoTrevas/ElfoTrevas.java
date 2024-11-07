package exercicios.beecrowd.ElfoTrevas;

import java.util.ArrayList;
import java.util.Scanner;

class Renas {
    String nome;
    int idade;
    int peso;
    double altura;

    public Renas(String nome, int idade, int peso, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }
}

// Renas Pesadas Primeiro
// Renas Mais novas Primeiro
// Renas mais baixas Primeiro
// Renas com nomes em ordem alfabética
public class ElfoTrevas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qtdTestes = Integer.parseInt(scanner.nextLine());

        for (int i = 0 ; i < qtdTestes; i++){
            int qtdRenasTotal = scanner.nextInt();
            int qtdRenasSelecionadas = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Renas> renas = new ArrayList<>();
            for (int j = 0; j < qtdRenasTotal; j++){
                String nome = scanner.next();
                int peso = scanner.nextInt();
                int idade = scanner.nextInt();
                double altura = scanner.nextDouble();
                renas.add(new Renas(nome, idade, peso, altura));
            }

            // Fazer o sorting usando bubble sort
            for (int j = 0; j < renas.size() - 1; j++) {
                for (int k = 0; k < renas.size() - j - 1; k++) {
                    if (renas.get(k).peso < renas.get(k + 1).peso) {
                        Renas temp = renas.get(k);
                        renas.set(k, renas.get(k + 1));
                        renas.set(k + 1, temp);
                    } else if (renas.get(k).peso == renas.get(k + 1).peso) {
                        if (renas.get(k).idade > renas.get(k + 1).idade) {
                            Renas temp = renas.get(k);
                            renas.set(k, renas.get(k + 1));
                            renas.set(k + 1, temp);
                        } else if (renas.get(k).idade == renas.get(k + 1).idade) {
                            if (renas.get(k).altura > renas.get(k + 1).altura) {
                                Renas temp = renas.get(k);
                                renas.set(k, renas.get(k + 1));
                                renas.set(k + 1, temp);
                            } else if (renas.get(k).altura == renas.get(k + 1).altura) {
                                if (renas.get(k).nome.compareTo(renas.get(k + 1).nome) > 0) {
                                    Renas temp = renas.get(k);
                                    renas.set(k, renas.get(k + 1));
                                    renas.set(k + 1, temp);
                                }
                            }
                        }
                    }
                }
            }

            System.out.println("CENARIO {" + (i + 1) + "}");
            for (int j = 0; j < qtdRenasSelecionadas; j++){
                System.out.println((j + 1) + " - " + renas.get(j).nome );
            }
        }

    }
}
