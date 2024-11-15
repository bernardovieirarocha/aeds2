#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>


struct Matriz
{
    Celula *inicio;
    int linha;
    int colunas;
} typedef Matriz;


struct Celula {
    int elemento;
    struct Celula *inf;
    struct Celula *sup;
    struct Celula *esq;
    struct Celula *dir;
} typedef Celula;


Celula *newCelula(int elemento) {
    Celula *nova = (Celula *) malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->inf = NULL;
    nova->sup = NULL;
    nova->esq = NULL;
    nova->dir = NULL;
    return nova;
}

Matriz * criarMatriz(int linhas, int colunas) {
    Matriz * mat = (Matriz * ) malloc(sizeof(Matriz));
    if (mat == NULL) {
        printf("Erro ao alocar matriz");
        exit(1);
    }
    mat->linha = linhas;
    mat->colunas = colunas;
    mat->inicio = newCelula(0);
    return mat;
}

Matriz * inicializarMatriz(Matriz *matriz) {
    Celula *aux = matriz->inicio;
    for (int i = 0; i < matriz->linha; i++) {
        for (int j = 0; j < matriz->colunas; j++) {
            aux->dir = newCelula(0);
            aux->dir->esq = aux;
            aux = aux->dir;
        }
        aux = matriz->inicio;
        aux->inf = newCelula(0);
        aux->inf->sup = aux;
        aux = aux->inf;
    }
    return matriz;
}

void inserirMatriz (Matriz * mat, int linha, int coluna, int x) {
    Celula *aux = mat->inicio;
    for (int i = 0; i < linha; i++) {
        aux = aux->inf;
    }
    for (int i = 0; i < coluna; i++) {
        aux = aux->dir;
    }
    aux->elemento = x;
}

Celula *getPos(Matriz *matriz,int i, int j) {
    Celula *aux = matriz->inicio;
    for (int k = 0; k < i; k++) {
        aux = aux->inf;
    }
    for (int k = 0; k < j; k++) {
        aux = aux->dir;
    }
    return aux;
}

void setPos(Matriz *matriz, int i, int j, int x) {
    Celula *aux = getPos(matriz, i, j);
    aux->elemento = x;
}

Matriz * soma (Matriz *matrizA, Matriz *matrizB) {
    if (matrizA->linha != matrizB->linha || matrizA->colunas != matrizB->colunas) {
        printf("Matrizes de tamanhos diferentes");
        exit(1);
    }
    Matriz *matrizC = criarMatriz(matrizA->linha, matrizA->colunas);
    inicializarMatriz(matrizC);
    for (int i = 0; i < matrizA->linha; i++) {
        for (int j = 0; j < matrizA->colunas; j++) {
            int soma = getPos(matrizA, i, j)->elemento + getPos(matrizB, i, j)->elemento;
            setPos(matrizC, i, j, soma);
        }
    }
}

int * getDiagPrincipal(Matriz * matriz) {
    int *vetor = (int *) malloc(matriz->linha * sizeof(int));
    Celula *aux = matriz->inicio;
    for
}