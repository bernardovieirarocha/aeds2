/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q11 - Palindromo Recursivo (palindromoRecursivoC)
*/

// TODO: Porque o codigo ideal pensando no primeiro caso nao funciona mais?

#include <stdio.h>
#include <string.h>
#include <stdbool.h>

/**
 * Funcao que verifica se uma palavra eh palindromo
 * @param palavra Palavra a ser verificada
 * @param direita Indice da direita
 * @param esquerda Indice da esquerda
 * @return true se a palavra eh palindromo, false caso contrario
 */
bool palindromo(char palavra[], int direita, int esquerda) {
    if (direita >= esquerda) {
        return true;
    } else if (palavra[direita] != palavra[esquerda]) {
        return false;
    } else {
        return palindromo(palavra, direita + 1, esquerda - 1);
    }
}

int main() {
    char palavra[1000];

    while (true) {
        // Le a palavra ate a quebra de linha 
        scanf(" %[^\n]", palavra);

        // Checa se o input eh FIM
        if (strcmp(palavra, "FIM") == 0) {
            break;
        } else {
            int len = strlen(palavra);
            if (palindromo(palavra, 0, len - 1)) {
                printf("SIM\n");
            } else {
                printf("NAO\n");
            }
        }
    }
    return 0;
}