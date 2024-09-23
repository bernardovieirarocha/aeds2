#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct sentencas {
    char sentencas[100][100];
    int n;
} typedef Sentencas;

void inicializaSentencas(Sentencas *s) {
    s->n = 0;
}

void adicionarSentenca(Sentencas *s, char sentenca[]) {
    strcpy(s->sentencas[s->n], sentenca);
    s->n++;
}


int compare(const void *a, const void *b) {
    return strlen(*(const char **)b) - strlen(*(const char **)a);
}

void quebrarSentencasPalavras(Sentencas *s) {
    for (int i = 0; i < s->n; i++) {
        char *palavras[100];
        int count = 0;

        char *token = strtok(s->sentencas[i], " ");
        while (token != NULL) {
            palavras[count++] = token;
            token = strtok(NULL, " ");
        }

        // Ordenar as palavras usando bubble sort
        for (int j = 0; j < count; j++) {
            for (int k = 0; k < count - j - 1; k++) {
                if (strlen(palavras[k]) < strlen(palavras[k+1])) {
                    char *temp = palavras[k];
                    palavras[k] = palavras[k+1];
                    palavras[k+1] = temp;
                }
            }
        }

        for (int j = 0; j < count; j++) {
            printf("%s ", palavras[j]);
        }
        printf("\n");
    }
}

int main(void) {
    Sentencas s;
    inicializaSentencas(&s);

    int qtdSentencas;
    scanf("%d", &qtdSentencas);
    getchar(); // Consume the newline character left by scanf

    for (int i = 0; i < qtdSentencas; i++) {
        char sentenca[1000];
        fgets(sentenca, 1000, stdin);
        sentenca[strcspn(sentenca, "\n")] = '\0'; // Remove the newline character
        adicionarSentenca(&s, sentenca);
    }

    quebrarSentencasPalavras(&s);

    return 0;
}