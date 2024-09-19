package exercicios.beecrowd.ListaCriancasPapaiNoel;
import java.util.Scanner;

class Crianca {
    public String nome;
    public Crianca(String nome ){
        this.nome = nome;
    }
}

public class ListaCriancasPapaiNoel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdCriancas = sc.nextInt();
        Crianca[] criancas = new Crianca[qtdCriancas];


        int qtdBom = 0;
        int qtdMal = 0;

        for (int i = 0; i < qtdCriancas; i++){
            String comportamento = sc.next();
            if (comportamento.contains("+")){
                criancas[i] = new Crianca(sc.next());
                qtdBom++;
            } else {
                criancas[i] = new Crianca(sc.next());
                qtdMal++;
            }
        }
        for (int i = 0; i < qtdCriancas - 1; ++i) {
            for (int j = 0; j < qtdCriancas - 1 - i; j++) {
                if (criancas[j].nome.compareTo(criancas[j + 1].nome) > 0) {
                    Crianca temp = criancas[j];
                    criancas[j] = criancas[j + 1];
                    criancas[j + 1] = temp;
                }
            }
        }

        for (Crianca crianca : criancas){
            System.out.println(crianca.nome);
        }

        System.out.println("Se comportaram: " + qtdBom + " | Nao se comportaram: " + qtdMal);
    }
}
