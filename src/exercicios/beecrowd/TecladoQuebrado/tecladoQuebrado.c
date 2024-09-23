#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>
#include <string.h>

int main(void) 
{
    while(!feof(stdin)) {
        char frase[1000];
        fgets(frase, 1000, stdin);
        char resultado[1000];

        for (int i = 0; i < strlen(frase); ++i){
            if (frase[i] == '['){
                int j = i +1 ;
                int contador = 0;
                while (j < strlen(frase) && frase[j] != ']' ) {
                    resultado[contador] = frase[j];
                    contador++;
                    j++;
                }
                i = j;
            } else if (frase[i] == ']'){
                int j = i -1 ;
                while (j >= 0 && frase[j] != '[' ) {
                    resultado[j] = frase[j];
                    j--;
                }
                i = j;
            } else {
                resultado[i] = frase[i];
            }
        }

        printf("%s", resultado);

    }


}