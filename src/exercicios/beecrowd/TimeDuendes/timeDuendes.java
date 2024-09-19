package exercicios.beecrowd.TimeDuendes;

import java.util.ArrayList;
import java.util.Scanner;

class Duende {
    public String nome;
    public int idade;

    public Duende(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

}


public class timeDuendes {

    public static void lerDuendes(ArrayList<Duende> duendes, int qtd, Scanner sc) {
        for (int i = 0; i < qtd; i++) {
            String nome = sc.next();
            int idade = sc.nextInt();
            sc.nextLine();
            Duende duende = new Duende(nome,idade);
            duendes.add(duende);
        }
        sc.close();
    }

    public static void ordenarDuendesIdade(ArrayList<Duende> duendes) {
        for (int i = 0; i < duendes.size() - 1; ++i) {
            for (int j = 0; j < duendes.size() - i - 1; ++j) {
                // Ordenar de maneira decrescente de idade
                if (duendes.get(j).idade < duendes.get(j + 1).idade  ) {
                    Duende temp = duendes.get(j);
                    duendes.set(j, duendes.get(j + 1));
                    duendes.set(j + 1, temp);
                }
                if (duendes.get(j).idade == duendes.get(j + 1).idade && duendes.get(j).nome.compareTo(duendes.get(j + 1).nome) > 0) {
                    Duende temp = duendes.get(j);
                    duendes.set(j, duendes.get(j + 1));
                    duendes.set(j + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdDuendes = sc.nextInt();

        int qtdTimes = qtdDuendes / 3;
        ArrayList<Duende> duendes = new ArrayList<Duende>();
        lerDuendes(duendes, qtdDuendes, sc);
        ordenarDuendesIdade(duendes);

        ArrayList<Duende>[] times = new ArrayList[qtdTimes];
        for (int i = 0; i < qtdTimes; i++) {
            times[i] = new ArrayList<Duende>();
        }

        // Se há 6 duendes na lista, haverá dois times, onde o duende mais velho é líder do time 1, e
        // o segundo mais velho é líder do time 2.
        // O terceiro mais velho é entregador do time 1 e
        // o quarto mais velho é entregador do time 2.
        // O quinto é piloto de trenó do time 1 e o último é piloto do time 2;
        for (int i = 0; i < qtdTimes; i++) {
            times[i].add(duendes.get(i));
            times[i].add(duendes.get(i+qtdTimes));
            times[i].add(duendes.get(i+qtdTimes*2));
        }

        for (int i = 0; i < qtdTimes; i++) {
            System.out.println("Time " + (i+1));
            for (int j = 0; j < 3; j++) {
                System.out.println(times[i].get(j).nome + " " + times[i].get(j).idade);

            }
            System.out.println();
        }

    }

}
