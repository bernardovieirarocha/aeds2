/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q02 - Palindromo (palindromoC)
*/

#include <locale.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <wchar.h>
#include <wctype.h>

int main() {
  setlocale(LC_ALL, "");

#define N 100
  wchar_t message[N];

  while (1) {
    wint_t ch;
    int len = 0;

    // Ler wide char por vez ate a quebra de linha
    while ((ch = getwchar()) != '\n') {
      if (len < N) {
        message[len++] = ch;
      }
    }

    message[len] = L'\0'; // Termina a string com o codigo de finalizacao

    // Checa se o input eh FIM
    if (wcscmp(message, L"FIM") == 0) {
      break;
    }

    // Checa se eh palindromo:
    int is_palindrome = 1;
    for (int i = 0; i < len / 2; i++) {
      if (message[i] != message[len - i - 1]) {
        is_palindrome = 0;
        break;
      }
    }

    if (is_palindrome) {
      wprintf(L"SIM\n");
    } else {
      wprintf(L"NAO\n");
    }
  }

  return 0;
}
