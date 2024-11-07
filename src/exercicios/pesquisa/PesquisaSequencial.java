package exercicios.pesquisa;

import java.util.Arrays;

public class PesquisaSequencial {

        public static void pesquisaSequencial(int[] vet, int valorProcurado){
            for (int i = 0; i < vet.length; i++){
                if (vet[i] == valorProcurado){
                    System.out.println("Valor (" + valorProcurado + ") encontrado na posição: " + i);
                    return;
                }
            }
            System.out.println("Valor não encontrado");
        }

        public static void showArray(int[] vet){
            System.out.println(Arrays.toString(vet));
        }

        public static void main(String[] args) {
            int [] vetor = {5,9,12,3,4,8};

            int valorProcurado = 12;

            showArray(vetor);
            pesquisaSequencial(vetor, valorProcurado);
        }
}
