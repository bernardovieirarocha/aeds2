#include <stdio.h>
#include <stdlib.h>

int main(void) {

    int qtdDeEntradas = 0;

    scanf("%d", &qtdDeEntradas);
    getchar();

    for (int i = 0; i < qtdDeEntradas; i++) {
        int qtdDeNumeros = 0;
        scanf("%d", &qtdDeNumeros);
        getchar();

        int *numeros = (int *) malloc(qtdDeNumeros * sizeof(int));
        for (int i = 0; i < qtdDeNumeros; i++) {
            scanf("%d", &numeros[i]);
        }
        getchar();

        // Implementar o SelectionSOrt para descobrir o numero minimo de trocas para ordenar os numeros

        int trocas = 0;
        for (int i = 0; i < qtdDeNumeros; i++) {
            int min = i;
            for (int j = i + 1; j < qtdDeNumeros; j++) {
                if (numeros[j] < numeros[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int aux = numeros[i];
                numeros[i] = numeros[min];
                numeros[min] = aux;
                trocas++;
            }
        }
        printf("%d\n", trocas);
    }

}