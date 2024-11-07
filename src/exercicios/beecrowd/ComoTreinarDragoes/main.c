#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int dias;
    int multa;
    double prioridade;
} Dragao;

Dragao newDragao(int dias, int multa);

Dragao newDragao(int dias, int multa) {
    Dragao dragao;
    dragao.dias = dias;
    dragao.multa = multa;
    dragao.prioridade = (double)multa / dias;
    return dragao;
}

// Insertion sort to sort dragons by priority (descending order)
void insertionSort(Dragao *dragoes, int n) {
    for (int i = 1; i < n; i++) {
        Dragao key = dragoes[i];
        int j = i - 1;

        // Move elements that are less than key's priority to the right
        while (j >= 0 && dragoes[j].prioridade < key.prioridade) {
            dragoes[j + 1] = dragoes[j];
            j--;
        }
        dragoes[j + 1] = key;
    }
}

int main() {
    Dragao *dragoes = malloc(sizeof(Dragao) * 100000);
    int n = 0;
    int tempo, multa;

    // Reading input until EOF
    while (scanf("%d %d", &tempo, &multa) == 2) {
        dragoes[n++] = newDragao(tempo, multa);
    }

    // Sort dragons by priority in descending order
    insertionSort(dragoes, n);

    double multadia = 0.0;
    double multatotal = 0.0;
    int diasrestantes = 0;
    int treinando = 0;

    for (int i = 0; i < n; i++) {
        multadia += dragoes[i].multa;

        if (!treinando || diasrestantes == 0) {
            multadia -= dragoes[i].multa;
            diasrestantes = dragoes[i].dias;
            multatotal += multadia;
            treinando = 1;
        } else {
            multatotal += multadia;
        }
        diasrestantes--;
    }

    // Adjust for remaining training time
    if (treinando) {
        multatotal += diasrestantes * multadia;
    }

    printf("%.0lf\n", multatotal);

    free(dragoes);  // Free the allocated memory
    return 0;
}
