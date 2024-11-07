#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <ctype.h>

int main(void){
    int qtdVitorias = 0;
    int qtdPerdas = 0;
    for (int i = 0; i < 6; i++){
        char c;
        scanf("%c", &c);
        if (c == 'V') {
            qtdVitorias++;
        } else {
            qtdPerdas++;
        }
        getchar(); // consumir newline char
    }

    if (qtdVitorias == 6 || qtdVitorias ==5 ) {
        printf("1");
    } 
    if (qtdVitorias == 3 || qtdVitorias == 4 ) {
        printf("2");
    }

    if (qtdVitorias == 1 || qtdVitorias == 2 ) {
        printf("3");
    }

    if (qtdVitorias == 0) {
        printf("-1");
    }


}
