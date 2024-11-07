package exercicios.pesquisa;

import java.util.Arrays;

public class PesquisaBinaria {

    public static void ordenarArray(int[] vet){
        boolean swapped = true;
        for (int i = 0 ; i < vet.length - 1 && swapped; i++){
            swapped = false;
            for (int j = 0; j < vet.length - i - 1; j++){
                if (vet[j] > vet[j+1]) {
                    int temp =  vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void showArray(int[] vet){
        System.out.println(Arrays.toString(vet));
    }

    public static void pesquisaBinariaRecursiva(int[] vet, int valorProcurado, int esq, int dir){
        if (esq > dir){
            System.out.println("Valor não encontrado");
            return;
        }
        int meio = (esq + dir) / 2;
        if (vet[meio] == valorProcurado){
            System.out.println("Valor encontrado na posição: " + meio);
            return;
        } else if (vet[meio] < valorProcurado){
            pesquisaBinariaRecursiva(vet, valorProcurado, meio + 1, dir);
        } else {
            pesquisaBinariaRecursiva(vet, valorProcurado, esq, meio - 1);
        }
    }

    public static void main(String[] args) {
        int [] vetor = {5,9,12,3,4,8};

        ordenarArray(vetor);
        showArray(vetor);

        int meio;
        int dir = vetor.length - 1;
        int esq = 0;
        int valorProcurado = 12;

        while (esq <= dir) {
            meio = (esq + dir) / 2;
            if (vetor[meio] == valorProcurado) {
                System.out.println("Valor encontrado na posição: " + meio);
                break;
            } else if (vetor[meio] < valorProcurado) {
                esq = meio + 1;
            } else {
                dir = meio - 1;
            }
        }
    }
}
