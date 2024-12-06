package exercicios.estruturas.arvoreBinaria;


class No2 {
    String valor;
    No2 esquerda;
    No2 direita;

    public No2(String valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }
}
public class ExercicioExemploBalanceamento {
    private No2 raiz;

    public ExercicioExemploBalanceamento() {
        raiz = null;
    }

    // Método para criar a árvore conforme a estrutura da imagem
    public void criarArvoreDesbalanceada() {
        raiz = new No2("Avô");
        raiz.esquerda = new No2("Pai");
        raiz.direita = new No2("D");
        raiz.esquerda.esquerda = new No2("Filho");
        raiz.esquerda.esquerda.esquerda = new No2("A");
        raiz.esquerda.esquerda.direita = new No2("B");
        raiz.esquerda.direita = new No2("C");
    }

    // Método para exibir o percurso pré-ordem
    public void preOrdem() {
        System.out.print("Pré-ordem: ");
        preOrdemRecursivo(raiz);
        System.out.println();
    }

    private void preOrdemRecursivo(No2 No2) {
        if (No2 != null) {
            System.out.print(No2.valor + " ");
            preOrdemRecursivo(No2.esquerda);
            preOrdemRecursivo(No2.direita);
        }
    }

    // Método para aplicar a rotação simples à direita
    public void rotacaoDireita() {
        if (raiz != null) {
            raiz = rotacaoDireitaRecursivo(raiz);
        }
    }

    private No2 rotacaoDireitaRecursivo(No2 y) {
        No2 x = y.esquerda;
        No2 T2 = x.direita;

        // Realiza a rotação
        x.direita = y;
        y.esquerda = T2;

        // Retorna a No2va raiz
        return x;
    }

    public static void main(String[] args) {
        ExercicioExemploBalanceamento arvore = new ExercicioExemploBalanceamento();

        // Criar a árvore desbalanceada
        arvore.criarArvoreDesbalanceada();

        System.out.println("Antes da rotação:");
        arvore.preOrdem();

        // Aplicar a rotação à direita
        arvore.rotacaoDireita();

        System.out.println("Após a rotação:");
        arvore.preOrdem();
    }
}


