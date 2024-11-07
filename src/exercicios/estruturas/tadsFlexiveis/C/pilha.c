#include <stdio.h>
#include <stdlib.h>

struct Celula {
  int dado;
  struct Celula *prox;
} typedef Celula;

struct pilha {
  Celula *topo;
} typedef Pilha;

Pilha *criarPilha(void) {
  Pilha *pilha = malloc(sizeof(Pilha));
  pilha->topo = NULL;
  return pilha;
}

void empilhar(int x, Pilha *pilha) {
  Celula *tmp = (Celula *)malloc(sizeof(Celula));
  tmp->dado = x;
  tmp->prox = pilha->topo;
  pilha->topo = tmp;
  tmp = NULL;
}

int desempilhar(Pilha *pilha) {
  Celula *temp = pilha->topo;
  int elemento = temp->dado;
  pilha->topo = temp->prox;
  temp->prox = NULL;
  free(temp);
  return elemento;
}

void mostrar(Pilha *pilha) {
  for (Celula *i = pilha->topo; i != NULL; i = i->prox) {
    printf("%d ", i->dado);
  }
}

void somar(Celula * topo) {
  int soma = 0;
  for (Celula *i = topo; i != NULL; i = i->prox) {
    soma += i->dado;
  }
}

int main(void) {
  Pilha *pilha = criarPilha();
  empilhar(3, pilha);
  empilhar(5, pilha);
  empilhar(7, pilha);
  mostrar(pilha);
  return 0;
}
