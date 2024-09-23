#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {

  while (true) {
    int horarioDormir[2];
    int horarioAcordar[2];

    for (int i = 0; i < 2; i++) {
      scanf("%d", &horarioDormir[i]);
    }

    for (int i = 0; i < 2; i++) {
      scanf("%d", &horarioAcordar[i]);
    }

    int horaDormir = (horarioDormir[0] == 0) ? 24 : horarioDormir[0];
    int minutoDormir = horarioDormir[1];
    int horaAcordar = (horarioAcordar[0] == 0) ? 24 : horarioAcordar[0];
    int minutoAcordar = horarioAcordar[1];

    if (horaDormir == 24 && minutoDormir == 0 && horaAcordar == 24 &&
        minutoAcordar == 0) {
      break;
    }

    int minutosDormir = horaDormir * 60 + minutoDormir;
    int minutosAcordar = horaAcordar * 60 + minutoAcordar;
    int minutosDormidos = minutosAcordar - minutosDormir;

    if (minutosDormidos < 0) {
      minutosDormidos += 24 * 60;
    }

    printf("%d\n", minutosDormidos);

  }
}