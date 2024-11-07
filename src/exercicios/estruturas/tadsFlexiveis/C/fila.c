#include <stdlib.h>
#include <stdio.h>

struct Celula
{
    int elemento;
    struct Celula * prox;
} typedef Celula ;

struct Fila
{
    Celula * primeiro;
    Celula * ultimo;
} typedef Fila;

Fila* criarFila(void) {
    Fila * fila = malloc(sizeof(Fila));
    fila->primeiro = (Celula*) malloc(sizeof(Celula));
    fila->ultimo = fila->primeiro;
    return fila;
}

void inserir(Fila * fila) {
    fila->ultimo->prox = malloc(sizeof(Celula));
    fila->ultimo = fila->ultimo->prox;
}

void remover(Fila *fila){
    if (fila->primeiro == fila->ultimo) {
        return ;
    }
    Celula * tmp = fila->primeiro->prox;
    int elemento = tmp->elemento;
    fila->primeiro->prox = tmp->prox;
    if (fila->ultimo == tmp){
        fila->ultimo = fila->primeiro;
    }
    free(tmp);
    tmp = NULL;
}

int main(void) {
    Fila * fila = criarFila();
    

    return 0;
}