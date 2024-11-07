package exercicios.beecrowd.Van;

import java.util.ArrayList;
import java.util.Scanner;

class Aluno {
    String nome;
    String regiao;
    int custoDistancia;

    public Aluno(String nome, String regiao, int custoDistancia) {
        this.nome = nome;
        this.regiao = regiao;
        this.custoDistancia = custoDistancia;
    }
}

public class Van {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {  // EOF (fim de arquivo) para vários casos de teste
            int qtdAlunos = sc.nextInt();
            sc.nextLine();  // Consome o \n após a quantidade de alunos

            ArrayList<Aluno> alunos = new ArrayList<>();

            // Lê e adiciona os alunos na lista
            for (int i = 0; i < qtdAlunos; i++) {
                String[] entrada = sc.nextLine().split(" ");
                String nomeAluno = entrada[0];
                String regiaoAluno = entrada[1];
                int custoDistancia = Integer.parseInt(entrada[2]);
                alunos.add(new Aluno(nomeAluno, regiaoAluno, custoDistancia));
            }

            // Ordenação usando Bubble Sort conforme os critérios (distância, região, nome)
            for (int i = 0; i < alunos.size(); i++) {
                for (int j = 0; j < alunos.size() - i - 1; j++) {
                    if (alunos.get(j).custoDistancia > alunos.get(j + 1).custoDistancia) {
                        Aluno aux = alunos.get(j);
                        alunos.set(j, alunos.get(j + 1));
                        alunos.set(j + 1, aux);
                    } else if (alunos.get(j).custoDistancia == alunos.get(j + 1).custoDistancia) {
                        if (alunos.get(j).regiao.compareTo(alunos.get(j + 1).regiao) > 0) {
                            Aluno aux = alunos.get(j);
                            alunos.set(j, alunos.get(j + 1));
                            alunos.set(j + 1, aux);
                        } else if (alunos.get(j).regiao.compareTo(alunos.get(j + 1).regiao) == 0) {
                            if (alunos.get(j).nome.compareTo(alunos.get(j + 1).nome) > 0) {
                                Aluno aux = alunos.get(j);
                                alunos.set(j, alunos.get(j + 1));
                                alunos.set(j + 1, aux);
                            }
                        }
                    }
                }
            }

            // Imprime a ordem de entrega
            for (Aluno aluno : alunos) {
                System.out.println(aluno.nome);
            }
        }

        sc.close();  // Fecha o Scanner
    }
}
