#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

typedef struct Pilha {
    int maxTam;
    int tam;
    int *arr;
} Pilha;

void iniciarPilha(Pilha *Pilha, int tam) {
    Pilha->maxTam = tam;
    Pilha->tam = 0;
    Pilha->arr = (int *) malloc(tam * sizeof(int));
}

void empilhar(Pilha * pilha, int valor) {
    if (pilha->tam == pilha->maxTam) {
        return;
    }
    pilha->arr[pilha->tam] = valor;
    pilha->tam++;
}

int desempilhar(Pilha * pilha) {
    if (pilha->tam == 0) {
        return;
    }
    int resp = pilha->arr[pilha->tam - 1];
    pilha->tam--;
    return resp;
}

int main(void) {
    Pilha pilha;
    iniciarPilha(&pilha, 50);
    int qtdOperacoes;
    scanf("%d", &qtdOperacoes);

    for (int i = 0; i < qtdOperacoes; i++) {
        char *operacao = (char *) malloc(100* sizeof(char));
        fgets(operacao, 100, stdin);

        if (strcmp(operacao, "PUSH\n") == 0) {
            int valor;
            scanf("%d", &valor);
            empilhar(&pilha, valor);
        } else if (strcmp(operacao, "POP\n") == 0) {
            desempilhar(&pilha);
        } else if (strcmp(operacao, "MIN\n") == 0) {
            int menor = pilha.arr[0];
            for (int j = 0; j < pilha.tam; j++) {
                if (pilha.arr[j] < menor) {
                    menor = pilha.arr[j];
                }
            }
            printf("%d\n", menor);
        }
    }
}