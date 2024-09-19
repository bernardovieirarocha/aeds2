#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <ctype.h>


int main(void) {
    int totalCaracteresAlfabeto = 0;
    int totalCaracteresEnviados = 0;

    scanf("%d %d", &totalCaracteresAlfabeto, &totalCaracteresEnviados);

    char alfabeto[totalCaracteresAlfabeto];
    char caracteresEnviados[totalCaracteresEnviados];

    scanf("%s", alfabeto);
    scanf("%s", caracteresEnviados);

    if (strstr(alfabeto, caracteresEnviados) != NULL){
        printf("SIM\n");
    } else {
        printf("NAO\n");
    }

    printf("Outro metodo:");

    bool alfabetoValido = true;
    for (int i = 0; i < totalCaracteresEnviados; ++i){
        if (strchr(alfabeto, caracteresEnviados[i]) == NULL ){
            alfabetoValido = false;
            break;
        }
    }
    printf("%s\n", alfabetoValido ? "SIM" : "NAO");
}