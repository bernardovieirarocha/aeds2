#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Aluno {
    int matricula;
    char nome[100];
    float n1, n2, n3;
} typedef Aluno;


struct TabelaHash {
    Aluno **alunos;
    int tamanho;
} typedef TabelaHash;

TabelaHash * criarTabelaHash(int tamanho) {
    TabelaHash *tabela = (TabelaHash *) malloc(sizeof(TabelaHash));
    tabela->tamanho = tamanho;
    tabela->alunos = (Aluno **) malloc(tamanho * sizeof(Aluno *));
    for (int i = 0; i < tamanho; i++) {
        tabela->alunos[i] = NULL;
    }
    return tabela;
}

void liberarTabelaHash(TabelaHash *tabela) {
    for (int i = 0; i < tabela->tamanho; i++) {
        if (tabela->alunos[i] != NULL) {
            free(tabela->alunos[i]);
        }
    }
    free(tabela->alunos);
    free(tabela);
}

