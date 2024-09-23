#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct duende {
    char nome[100];
    int idade;
} typedef Duende;

struct timeDuendes
{
    Duende duendes[3];
    int n;
} typedef TimeDuendes;

void inicializaTimeDuendes(struct timeDuendes *t){
    t->n = 0;
}

void adicionarDuende(struct timeDuendes *t, Duende d){
    t->duendes[t->n] = d;
    t->n++;
}


int main(void) {
    int qtdDuendes;
    scanf("%d", &qtdDuendes);
    
    int qtdTimes = qtdDuendes / 3;

    Duende *duendes = (Duende *)malloc(qtdDuendes * sizeof(Duende));

    // Ler os duendes
    for (int i = 0; i < qtdDuendes; i++) {
        scanf("%s %d", duendes[i].nome, &duendes[i].idade);
    }

    // Bubble sort Ordenar os duendes por idade e, em caso de empate, por ordem alfabética
    for (int i = 0; i < qtdDuendes - 1 ; i++){
        for (int j = 0 ; j < qtdDuendes - i - 1; ++j){
            if (duendes[j].idade < duendes[j+1].idade){
                Duende temp = duendes[j];
                duendes[j] = duendes[j+1];
                duendes[j+1] = temp;
            }
            if (duendes[j].idade == duendes[j+1].idade){
                if (strcmp(duendes[j].nome, duendes[j+1].nome) > 0){
                    Duende temp = duendes[j];
                    duendes[j] = duendes[j+1];
                    duendes[j+1] = temp;
                }
            }
        }
    }

    // Definir os times:
    TimeDuendes *times = (TimeDuendes *)malloc(qtdTimes * sizeof(TimeDuendes));

    for (int i = 0; i < qtdTimes; i++){
        inicializaTimeDuendes(&times[i]);
    }

    for (int i = 0; i < qtdDuendes; i++){
        adicionarDuende(&times[i], duendes[i]);
        adicionarDuende(&times[i], duendes[i+qtdTimes]);
        adicionarDuende(&times[i], duendes[i+qtdTimes*2]);
    }

    printf("\n");
    for (int i = 0 ; i < qtdTimes; ++i ) {
        printf("Time %d:\n", i+1);
        for (int j = 0; j < 3; j++){
            printf("%s %d\n", times[i].duendes[j].nome, times[i].duendes[j].idade);
        }
    }

    free(duendes);

    return 0;
}