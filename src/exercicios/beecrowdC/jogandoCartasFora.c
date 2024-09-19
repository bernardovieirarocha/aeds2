#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct Lista
{
    int maxTam;
    int tam;
    int *arr;
} Lista;


void iniciarLista(Lista *Lista, int tam) {
    Lista->maxTam = tam;
    Lista->tam = 0;
    Lista->arr = (int *) malloc(tam * sizeof(int));
}

void preencherLista(Lista * lista, int tam ) {
    lista->tam = tam;
    for (int i = 0; i < lista->tam; i++) {
        lista->arr[i] = i + 1;
    }
}

int removerInicio(Lista * lista) {
    if (lista->tam == 0) {
        return;
    }
    int resp = lista->arr[0];
    lista->tam--;
    for (int i = 0; i < lista->tam; i++) {
        lista->arr[i] = lista->arr[i + 1];
    }
    return resp;
}

void inserirFim(Lista * lista, int valor) {
    if (lista->tam == lista->maxTam) {
        return;
    }
    lista->arr[lista->tam] = valor;
    lista->tam++;
}

void imprimirLista(Lista * lista) {
    for (int i =0; i < lista->tam;i++) {
        printf("%d ", lista->arr[i]);
        if(i < lista->tam - 1) printf(", ");
    }
    printf("\n");
}

int main(void) {
    int tam;
    scanf("%d", &tam);
    while (tam!=0) {
        Lista lista;
        Lista descarte;

        iniciarLista(&lista, tam);
        preencherLista(&lista, tam);

        while(lista.tam > 1) {
            inserirFim(&descarte, removerInicio(&lista));
            inserirFim(&lista, removerInicio(&lista));
        }

        printf("Discarded cards: ");
        imprimirLista(&descarte);
        printf("Remaining card: %d\n", lista.arr[0]);

        free(lista.arr);
        free(descarte.arr);

        scanf("%d", &tam);

    }
    return 0;
}