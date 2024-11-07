package exercicios.estruturas.tads;

import java.util.Arrays;

public class Fila {
    public int tamanho;
    public int[] elementos;

    public Fila(int tamanho) {
        this.tamanho = 0;
        this.elementos = new int[tamanho];
    }

    public void inserirFim(int elemento) {
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    public int removerInicio() {
        // Caso a fila esteja vazia
        if (this.tamanho == 0) {
            throw new RuntimeException("Fila vazia");
        }

        int elemento = this.elementos[0];
        for (int i = 0; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
        return elemento;
    }

    public static void desenharFila(Fila fila) {
        for (int i = 0; i < fila.tamanho; i++) {
            System.out.println("| " + fila.elementos[i] + " |");
        }
        System.out.println("-----");
    }

    public static void main(String[] args) {
        // A fila é uma estrutura de dados que segue o princípio FIFO (First In, First Out)
        // ou seja, o primeiro elemento a ser inserido é o primeiro a ser removido

        // Essa implementacao de fila é feita eh ineficiente, pois ao remover um elemento da fila é necessário mover todos os elementos restantes
        // para a posição anterior, o que tem complexidade O(n)

        // Tanto para IF e RI quanto para II e RF, a complexidade é O(n)

        // Para melhorar a eficiência da fila, é possível implementar uma fila circular, onde ao remover um elemento, o ponteiro de início é
        // incrementado, evitando a necessidade de mover todos os elementos

        // Exemplo de uso da fila
        Fila fila = new Fila(5);
        fila.inserirFim(1);
        fila.inserirFim(2);
        fila.inserirFim(3);
        fila.inserirFim(4);
        fila.inserirFim(5);
        desenharFila(fila);
        fila.removerInicio();
        fila.removerInicio();
        System.out.println("Removidos 2 elementos");
        desenharFila(fila);
    }
}
