#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct traducao {
  char nome[100];
  char traduzida[100];
} typedef traducao;

struct etiqueta {
  char nome[100];
  char mensagem[100];
} typedef etiqueta;

int main (void) {

    int qtdTraducoes;
    scanf("%d", &qtdTraducoes);
    getchar();  // Clear newline character left by scanf

    traducao traducoes[qtdTraducoes];

    for (int i = 0; i < qtdTraducoes; i++){
        fgets(traducoes[i].nome, 100, stdin);
        traducoes[i].nome[strcspn(traducoes[i].nome, "\n")] = '\0';  // Remove newline
        fgets(traducoes[i].traduzida, 100, stdin);
        traducoes[i].traduzida[strcspn(traducoes[i].traduzida, "\n")] = '\0';  // Remove newline
    }

    int qtdCriancas;
    scanf("%d", &qtdCriancas);
    getchar();  // Clear newline character left by scanf

    for (int i = 0; i < qtdCriancas; i++) {
        etiqueta crianca;
        fgets(crianca.nome, 100, stdin);
        crianca.nome[strcspn(crianca.nome, "\n")] = '\0';  // Remove newline
        char lingua[100];
        scanf("%s", lingua);

        for (int j = 0 ; j < qtdTraducoes; j++) {
            if (strcmp(lingua, traducoes[j].nome) == 0) {
                strcpy(crianca.mensagem, traducoes[j].traduzida);
                break;
            }
        }

        printf("%s\n", crianca.nome);
        printf("%s\n", crianca.mensagem);
    }

    return 0;
}
