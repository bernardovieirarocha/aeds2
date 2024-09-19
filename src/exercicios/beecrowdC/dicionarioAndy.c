#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

#define MAX_WORDS 5000
#define MAX_WORD_LEN 201

// Função para comparar strings usada na ordenação
int compare(const void *a, const void *b) {
    return strcmp(*(const char **)a, *(const char **)b);
}

// Função para verificar se a palavra já está no dicionário
int is_unique(char *word, char *dictionary[], int count) {
    for (int i = 0; i < count; i++) {
        if (strcmp(word, dictionary[i]) == 0) {
            return 0;
        }
    }
    return 1;
}

int main() {
    char *dictionary[MAX_WORDS];
    int word_count = 0;
    char line[MAX_WORD_LEN];
    
    // Processar cada linha de entrada até EOF
    while (fgets(line, sizeof(line), stdin)) {
        int len = strlen(line);
        char word[MAX_WORD_LEN];
        int word_len = 0;

        for (int i = 0; i <= len; i++) {
            // Verifica se o caractere é uma letra
            if (isalpha(line[i])) {
                word[word_len++] = tolower(line[i]);
            } else {
                // Quando encontramos um separador ou fim de linha, processa a palavra
                if (word_len > 0) {
                    word[word_len] = '\0';  // Termina a string da palavra
                    if (is_unique(word, dictionary, word_count)) {
                        dictionary[word_count] = strdup(word);  // Adiciona ao dicionário
                        word_count++;
                    }
                    word_len = 0;  // Reseta o comprimento da palavra
                }
            }
        }
    }

    // Ordenar as palavras em ordem alfabética
    qsort(dictionary, word_count, sizeof(char *), compare);

    // Imprimir as palavras em ordem
    for (int i = 0; i < word_count; i++) {
        printf("%s\n", dictionary[i]);
        free(dictionary[i]);  // Libera a memória alocada
    }

    return 0;
}
