package exercicios.estruturas.arvoreBinaria;


import java.util.Scanner;

public class BalanceamentoAB {
    private No raiz;

    public BalanceamentoAB() {
        raiz = null;
    }

    // Método para inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerda = inserirRecursivo(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserirRecursivo(no.direita, valor);
        }
        return no;
    }

    // Método para ler três números inteiros e inseri-los na árvore
    public void inserirTresNumeros(Scanner scanner) {
        System.out.println("Digite três números inteiros:");
        for (int i = 0; i < 3; i++) {
            int valor = scanner.nextInt();
            inserir(valor);
        }

        // Verifica a estrutura da árvore para determinar qual rotação aplicar
        verificarERotacionar();
    }

    private void verificarERotacionar() {
        if (raiz != null) {
            // Caso LL: raiz -> esquerdo -> esquerdo
            if (raiz.esquerda != null && raiz.esquerda.esquerda != null) {
                System.out.println("Caso LL detectado. Aplicando rotação simples à direita.");
                raiz = rotacaoDireita(raiz);
            }
            // Caso LR: raiz -> esquerdo -> direito
            else if (raiz.esquerda != null && raiz.esquerda.direita != null) {
                System.out.println("Caso LR detectado. Aplicando rotação dupla esquerda-direita.");
                raiz = rotacaoEsquerdaDireita(raiz);
            }
            // Caso RR: raiz -> direito -> direito
            else if (raiz.direita != null && raiz.direita.direita != null) {
                System.out.println("Caso RR detectado. Aplicando rotação simples à esquerda.");
                raiz = rotacaoEsquerda(raiz);
            }
            // Caso RL: raiz -> direito -> esquerdo
            else if (raiz.direita != null && raiz.direita.esquerda != null) {
                System.out.println("Caso RL detectado. Aplicando rotação dupla direita-esquerda.");
                raiz = rotacaoDireitaEsquerda(raiz);
            } else {
                System.out.println("A árvore está equilibrada. Nenhuma rotação necessária.");
            }
        }
    }

    // Rotação simples à direita
    private No rotacaoDireita(No y) {
        No x = y.esquerda;
        No T2 = x.direita;

        // Realiza a rotação
        x.direita = y;
        y.esquerda = T2;

        // Retorna a nova raiz
        return x;
    }

    // Rotação simples à esquerda
    private No rotacaoEsquerda(No x) {
        No y = x.direita;
        No T2 = y.esquerda;

        // Realiza a rotação
        y.esquerda = x;
        x.direita = T2;

        // Retorna a nova raiz
        return y;
    }

    // Rotação dupla esquerda-direita
    private No rotacaoEsquerdaDireita(No no) {
        no.esquerda = rotacaoEsquerda(no.esquerda);
        return rotacaoDireita(no);
    }

    // Rotação dupla direita-esquerda
    private No rotacaoDireitaEsquerda(No no) {
        no.direita = rotacaoDireita(no.direita);
        return rotacaoEsquerda(no);
    }

    // Método para exibir a árvore em ordem
    public void exibirEmOrdem() {
        exibirEmOrdemRecursivo(raiz);
        System.out.println();
    }

    private void exibirEmOrdemRecursivo(No no) {
        if (no != null) {
            exibirEmOrdemRecursivo(no.esquerda);
            System.out.print(no.valor + " ");
            exibirEmOrdemRecursivo(no.direita);
        }
    }
}

