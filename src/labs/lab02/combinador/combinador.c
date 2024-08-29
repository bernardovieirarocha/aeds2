/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB02_02 - Combinador (CombinadorC)
*/

#include <stdio.h>
#include <string.h>

int main(void) {
    char str1[100], str2[100];

    while (1) {
        scanf("%s %s", str1, str2);

        // Checar se o usuario enviou valores invalidos ou vazios.
        if (strlen(str1) == 0 && strlen(str2) == 0) {
            break;
        }
        // Checar se chegou num EOF de redirecionamento de entrada.
        if (feof(stdin)) {
            break;
        }

        int i = 0, j = 0;
        // Loops que alternam entre impressao de char da  primeira ou da segunda string.
        while (str1[i] != '\0' || str2[j] != '\0') {
            // Se nao chegou no final da string, imprime o caractere.
            if (str1[i] != '\0') {
                printf("%c", str1[i]);
                i++;
            }
            // Se nao chegou no final da string, imprime o caractere.
            if (str2[j] != '\0') {
                printf("%c", str2[j]);
                j++;
            }
        }
        printf("\n");
    }

    return 0;
}