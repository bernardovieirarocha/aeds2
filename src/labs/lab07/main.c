#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int numero;
    int largada;
    int chegada;
} Competidor;

void lerGrid(Competidor grid[], int qtdCompetidores) {
    for (int i = 0; i < qtdCompetidores; i++) {
        scanf("%d", &grid[i].numero);
        grid[i].largada = i;
    }
}

void lerGridChegada(Competidor grid[], int qtdCompetidores) {
    for (int i = 0; i < qtdCompetidores; i++) {
        int numero;
        scanf("%d", &numero);
        for (int j = 0; j < qtdCompetidores; j++) {
            if (grid[j].numero == numero) {
                grid[j].chegada = i;
                break;
            }
        }
    }
}

int main() {
    int qtdCompetidores;

    while (scanf("%d", &qtdCompetidores) != EOF && qtdCompetidores != 0) {
        Competidor grid[qtdCompetidores];

        lerGrid(grid, qtdCompetidores);
        lerGridChegada(grid, qtdCompetidores);

        // Conta o número de ultrapassagens
        int qtdUltrapassagens = 0;
        for (int i = 0; i < qtdCompetidores; i++) {
            for (int j = i + 1; j < qtdCompetidores; j++) {
                if (grid[i].chegada > grid[j].chegada) {
                    qtdUltrapassagens++;
                }
            }
        }

        printf("%d\n", qtdUltrapassagens);
    }

    return 0;
}