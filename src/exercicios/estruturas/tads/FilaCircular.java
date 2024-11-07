package exercicios.estruturas.tads;

public class FilaCircular {
    // A fila circular é uma estrutura de dados que permite a inserção de elementos
    // em uma extremidade e a remoção de elementos na outra extremidade.

    // Usando o operador módulo, a fila circular permite que os elementos sejam
    // inseridos e removidos de forma cíclica, ou seja, quando o último elemento
    // é removido, o próximo elemento a ser removido é o primeiro elemento da fila.

    public int[] array;
    public int primeiro, ultimo;

    public FilaCircular(int tam) {
        // Construtor da fila circular
        this.array = new int[tam + 1];
        // O tamanho do array é tam + 1 para alocar um espaço extra para o controle da fila circular
        this.primeiro = ultimo = 0;
    }

    public boolean isEmpty() {
        // Verifica se a fila está vazia
        return primeiro == ultimo;
    }

    public boolean isFull() {
        // Verifica se a fila está cheia (sem espaço para inserir mais elementos)
        // (ultimo + 1) % array.length verifica o próximo índice do array se for igual ao primeiro índice, a fila está cheia
        return (ultimo + 1) % array.length == primeiro;
    }

    public void inserir(int valor ) {
        if (isFull()) {
            System.out.println("Fila cheia!");
            return;
        }
        array[ultimo] = valor;
        // Atualiza o índice do último elemento
        ultimo = (ultimo + 1) % array.length;
    }

    public int remover() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return -1;
        }
        int resp = array[primeiro];
        primeiro = (primeiro + 1) % array.length;
        return resp;
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
            return;
        }
        int i = primeiro;
        while (i != ultimo) {
            System.out.print(array[i] + " ");
            i = (i + 1) % array.length;
        }
        System.out.println();
    }
}
