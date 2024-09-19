package exercicios.beecrowd.QuadroMedalhas;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Pais {
    public String nome;
    public int ouro;
    public int prata;
    public int bronze;

    public Pais(String nome, int ouro, int prata, int bronze) {
        this.nome = nome;
        this.ouro = ouro;
        this.prata = prata;
        this.bronze = bronze;
    }
}


public class QuadroMedalhas {

    public static void swap(List<Pais> paises, int i, int j) {
        Pais temp = paises.get(i);
        paises.set(i, paises.get(j));
        paises.set(j, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qtdPaises = sc.nextInt();

        List<Pais> paises = new ArrayList<>();

        for (int i = 0 ; i < qtdPaises; i++) {
            String nome = sc.next();
            int ouro = sc.nextInt();
            int prata = sc.nextInt();
            int bronze = sc.nextInt();
            paises.add(new Pais(nome, ouro, prata, bronze));
        }

        for (int i = 0; i < qtdPaises - 1; ++i) {
            for (int j = 0; j < qtdPaises - i - 1; j++) {
                if (paises.get(j).ouro < paises.get(j + 1).ouro) {
                    swap(paises, j, j + 1);
                } else if (paises.get(j).ouro == paises.get(j + 1).ouro) {
                    if (paises.get(j).prata < paises.get(j + 1).prata) {
                        swap(paises, j, j + 1);
                    } else if (paises.get(j).prata == paises.get(j + 1).prata) {
                        if (paises.get(j).bronze < paises.get(j + 1).bronze) {
                            swap(paises, j, j + 1);
                        } else if (paises.get(j).bronze == paises.get(j + 1).bronze) {
                            if (paises.get(j).nome.compareTo(paises.get(j + 1).nome) > 0) {
                                swap(paises, j, j + 1);
                            }
                        }
                    }
                }
            }
        }

        for (Pais pais : paises) {
            System.out.println(pais.nome + " " + pais.ouro + " " + pais.prata + " " + pais.bronze);
        }

        sc.close();
    }


}
