#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>

struct crianca {
    char nome[20];
} typedef crianca;


int main(void) {
    int comportou = 0;
    int Ncomportou = 0;
    int qtd = 0;
    scanf("%d", &qtd);
    getchar(); // Limpar buffer
    printf("%d\n", qtd);
    crianca *criancas = (crianca *) malloc(qtd * sizeof(crianca));

    for (int i = 0 ; i < qtd ; i++) {
        char comportamento ;
        scanf("%c", &comportamento);
        printf("%c\n", comportamento);
        if (comportamento == '+') {
            scanf("%s", criancas[i].nome);
            comportou++;
        } else {
            scanf("%s", criancas[i].nome);
            Ncomportou++;
        }
        getchar(); // Limpar buffer
    }

    // Ordenar Lexicograficamente (USING BUBBLE SORT)
    for (int i = 0 ; i < qtd - 1; ++i ){
        for (int j = 0 ; j < qtd - 1 - i; ++j){
            if (strcmp(criancas[j].nome, criancas[j+1].nome) > 0){
                crianca temp = criancas[j];
                criancas[j] = criancas[j+1];
                criancas[j+1] = temp;
            }
        }
    }

    for (int i = 0 ; i < qtd;i++){
        printf("%s\n", criancas[i].nome);
    }


    printf("Se comportaram: %d | Nao se comportaram: %d\n", comportou, Ncomportou);

    free(criancas);

    return 0;
}