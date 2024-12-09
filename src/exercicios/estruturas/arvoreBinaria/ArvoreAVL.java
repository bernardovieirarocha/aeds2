package exercicios.estruturas.arvoreBinaria;

class NoAVL {
    int valor;
    NoAVL esquerdo, direito;
    int altura;

    NoAVL(int valor) {
        this.valor = valor;
        this.altura = 1; // Cada nó começa com altura 1
    }
}

public class ArvoreAVL {
    NoAVL raiz;

    // Método para obter a altura de um nó
    int altura(NoAVL no) {
        return no == null ? 0 : no.altura;
    }

    // Método para calcular o fator de balanceamento de um nó
    int fatorBalanceamento(NoAVL no) {
        return no == null ? 0 : altura(no.direito) - altura(no.esquerdo);
    }

    // Rotação simples à direita
    NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerdo;
        NoAVL T2 = x.direito;

        // Rotação
        x.direito = y;
        y.esquerdo = T2;

        // Atualizar alturas
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        return x;
    }

    // Rotação simples à esquerda
    NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direito;
        NoAVL T2 = y.esquerdo;

        // Rotação
        y.esquerdo = x;
        x.direito = T2;

        // Atualizar alturas
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        return y;
    }

    // Método para inserir um nó na AVL
    NoAVL inserir(NoAVL no, int valor) {
        // Passo 1: Inserção normal em uma árvore binária
        if (no == null) {
            return new NoAVL(valor);
        }

        if (valor < no.valor) {
            no.esquerdo = inserir(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserir(no.direito, valor);
        } else {
            // Não permite valores duplicados
            return no;
        }

        // Passo 2: Atualizar a altura do nó atual
        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));

        // Passo 3: Verificar o fator de balanceamento e ajustar se necessário
        int balanceamento = fatorBalanceamento(no);

        // Caso 1: Rotação simples à direita (desbalanceamento à esquerda)
        if (balanceamento < -1 && valor < no.esquerdo.valor) {
            return rotacaoDireita(no);
        }

        // Caso 2: Rotação simples à esquerda (desbalanceamento à direita)
        if (balanceamento > 1 && valor > no.direito.valor) {
            return rotacaoEsquerda(no);
        }

        // Caso 3: Rotação dupla Esquerda-Direita (RED)
        if (balanceamento < -1 && valor > no.esquerdo.valor) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }

        // Caso 4: Rotação dupla Direita-Esquerda (RDE)
        if (balanceamento > 1 && valor < no.direito.valor) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    // Método público para inserir um valor na AVL
    void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    // Caminhamento em ordem para visualizar a árvore
    void emOrdem(NoAVL no) {
        if (no != null) {
            emOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            emOrdem(no.direito);
        }
    }

    // Método público para exibir a árvore
    void mostrar() {
        emOrdem(raiz);
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        ArvoreAVL avl = new ArvoreAVL();

        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30); // Necessita de rotação simples à esquerda
        avl.inserir(40);
        avl.inserir(50); // Necessita de rotação dupla Direita-Esquerda (RDE)
        avl.inserir(25);

        avl.mostrar(); // Saída em ordem: 10 20 25 30 40 50
    }
}