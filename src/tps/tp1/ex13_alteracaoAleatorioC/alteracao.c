/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q13 - Alteracao Aleatoria Recursiva (alteracaoC)
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int isFIM(char *s) { return strcmp(s, "FIM") == 0; }

void alteracao(char palavra[], char s1, char s2, int i, int tam) {
  if (i >= tam) {
    return;
  }
  if (palavra[i] == s1) {
    palavra[i] = s2;
  }
  return alteracao(palavra, s1, s2, i + 1, tam);
}

int main(void) {
  srand(time(NULL));

  char palavra[1000];

  while (1) {
    scanf(" %[^\n]", palavra);
    if (isFIM(palavra)) {
      break;
    } else {
      char letra = (char) 'a' + rand() % 26;
      char substituto = (char) 'a' + rand() % 26;

      int tam = strlen(palavra);
      alteracao(palavra, letra, substituto, 0, tam);
      printf("%s\n", palavra);
    }
  }

  return 0;
}