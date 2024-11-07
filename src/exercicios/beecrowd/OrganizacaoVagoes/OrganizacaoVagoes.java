package exercicios.beecrowd.OrganizacaoVagoes;

import java.util.ArrayList;
import java.util.Scanner;

public class OrganizacaoVagoes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int qdeTestes = sc.nextInt();
        for (int k =0 ; k < qdeTestes; k++) {
            int qdeVagoes = sc.nextInt();
            sc.nextLine();
            ArrayList<Integer> vagoes = new ArrayList<>();
            for (int j = 0; j < qdeVagoes; j++) {
                vagoes.add(sc.nextInt());
            }
            sc.nextLine();
            int qdeTrocas = 0;
            // Implementar bubblesort
            for (int i = 0 ; i < vagoes.size() -1 ; i++){
                for (int j = 0 ; j < vagoes.size() - i -1 ;j++) {
                    if (vagoes.get(j) > vagoes.get(j+1)) {
                        int aux = vagoes.get(j);
                        vagoes.set(j, vagoes.get(j+1));
                        vagoes.set(j+1, aux);
                        qdeTrocas++;
                    }
                }
            }
            System.out.printf("Optimal train swapping takes %d swaps.\n", qdeTrocas);
        }
    }
}
