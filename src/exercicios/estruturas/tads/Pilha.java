package exercicios.estruturas.tads;

public class Pilha {
    public int[] pilha;
    public int n;

    public Pilha(int qtd) {
        pilha = new int[qtd];
        n = 0;
    }

    public void empilhar(int valor) {
        // Se a pilha estiver cheia, lança uma exceção
        if (this.n >= this.pilha.length) {
            throw new ArrayStoreException("Pilha cheia");
        }
        // Adiciona o valor na pilha no topo, isto é, na posição FIM
        this.pilha[this.n] = valor;
        // Incrementa o contador de elementos da pilha
        this.n++;
    }

    public int desempilhar() {
        // Se a pilha estiver vazia, lança uma exceção
        if (this.n == 0) {
            throw new ArrayStoreException("Pilha vazia");
        }
        // Decrementa o contador de elementos da pilha
        this.n--;
        // Retorna o valor que estava no topo da pilha
        return this.pilha[this.n];
    }

    public int topo() {
        if (this.n == 0) {
            throw new ArrayStoreException("Pilha vazia");
        }
        return this.pilha[this.n - 1];
    }

    public static void desenharPilha(Pilha p) {
        for (int i = p.n - 1; i >= 0; i--) {
            System.out.println("| " + p.pilha[i] + " |");
        }
        System.out.println("-----");
    }
    public static void main(String[] args) {
        Pilha p = new Pilha(5);
        p.empilhar(1);
        p.empilhar(2);
        p.empilhar(3);
        p.empilhar(4);
        p.empilhar(5);

        desenharPilha(p);

        System.out.println();
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Topo: " + p.topo());
        System.out.println();


        System.out.println("Pilha após desempilhar:");
        desenharPilha(p);
    }
}
