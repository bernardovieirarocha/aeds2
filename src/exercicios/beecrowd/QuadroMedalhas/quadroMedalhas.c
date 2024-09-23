#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


struct pais {
    char nome[100];
    int ouro;
    int prata;
    int bronze;
} typedef Pais;

struct quadro {
    Pais paises[100];
    int n;
} typedef Quadro;

void inicializaQuadro(Quadro *q) {
    q->n = 0;
}

void swap(Pais *a, Pais *b) {
    Pais aux = *a;
    *a = *b;
    *b = aux;
}

void adicionaPais(Quadro *q, char nome[], int ouro, int prata, int bronze) {
    strcpy(q->paises[q->n].nome, nome);
    q->paises[q->n].ouro = ouro;
    q->paises[q->n].prata = prata;
    q->paises[q->n].bronze = bronze;
    q->n++;
}

void ordenarQuadro(Quadro *q) {
    for (int i = 0; i < q->n; i++) {
        for ( int j = 0; j < q->n - i -1; j++){
            if (q->paises[j].ouro < q->paises[j+1].ouro) {
                swap(&q->paises[j], &q->paises[j+1]);
            } else if (q->paises[j].ouro == q->paises[j+1].ouro) {
                if (q->paises[j].prata < q->paises[j+1].prata) {
                    swap(&q->paises[j], &q->paises[j+1]);
                } else if (q->paises[j].prata == q->paises[j+1].prata) {
                    if (q->paises[j].bronze < q->paises[j+1].bronze) {
                        swap(&q->paises[j], &q->paises[j+1]);
                    } else if (q->paises[j].bronze == q->paises[j+1].bronze) {
                        if (strcmp(q->paises[j].nome, q->paises[j+1].nome) > 0) {
                            swap(&q->paises[j], &q->paises[j+1]);
                        }
                    }
                }
            }
        }
    }
}

int main(void) {
    Quadro q;
    inicializaQuadro(&q);

    while(!feof(stdin)) {
        char nome[100];
        int ouro, prata, bronze;
        scanf("%s %d %d %d", nome, &ouro, &prata, &bronze);
        adicionaPais(&q, nome, ouro, prata, bronze);
    }

    ordenarQuadro(&q);

    for (int i = 0; i < q.n; i++) {
        printf("%s %d %d %d\n", q.paises[i].nome, q.paises[i].ouro, q.paises[i].prata, q.paises[i].bronze);
    }

    return 0;
}