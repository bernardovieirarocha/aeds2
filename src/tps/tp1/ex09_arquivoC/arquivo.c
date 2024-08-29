/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * TP01_Q09- Arquivo (arquivoC)
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdlib.h>

/**
 * Lê um número especificado de valores double do usuário e os escreve em um arquivo.
 *
 * @param n O número de valores double a serem lidos.
 * @param filename O nome do arquivo para onde os valores double serão escritos.
 */
void lerDoubles(int n, const char *filename) {
    FILE *arquivo = fopen(filename, "wb");

    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }

    double inputN;
    for (int i = 0; i < n; i++) {
        scanf("%lf", &inputN);  // Lê um valor double do usuário
        fwrite(&inputN, sizeof(double), 1, arquivo);  // Escreve o double no arquivo
    }

    fclose(arquivo);  // Fecha o arquivo
}

/**
 * Lê um número especificado de valores double de um arquivo em ordem reversa e os imprime.
 *
 * @param n O número de valores double a serem lidos.
 * @param filename O nome do arquivo de onde os valores double serão lidos.
 */
void readReverse(int n, const char *filename) {
    FILE *file = fopen(filename, "rb");  // Abre o arquivo em modo de leitura binária
    if (file == NULL) {
        perror("Erro ao abrir o arquivo");
        return;
    }

    long doubleSize = sizeof(double);  // O tamanho de um double é 8 bytes
    double number;

    for (int i = n - 1; i >= 0; i--) {
        fseek(file, i * doubleSize, SEEK_SET);  // Move o ponteiro do arquivo
        fread(&number, doubleSize, 1, file);    // Lê o double

        if (number == (int)number) {
            printf("%d\n", (int)number);  // Imprime como um inteiro
        } else {
            printf("%g\n", number);  // Imprime como um double
        }
    }

    fclose(file);  // Fecha o arquivo
}

int main() {

    const char *filename = "arquivo.txt";

    int n;
    scanf("%d", &n);

    lerDoubles(n, filename);
    readReverse(n, filename);

}
