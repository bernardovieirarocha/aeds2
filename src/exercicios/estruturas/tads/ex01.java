package exercicios.estruturas.tads;

public class ex01 {

    private int[] list;
    private int n;

    public ex01(int tamanho) {
        list = new int[tamanho];
        n = 0;
    }

    public void inserir(int x) {
        if (x > 0) {
            inserirOrdenadoPositivo(x);
        } else {
            inserirFim(x);
        }
    }

    // Metodo para inserir elementos positivos em ordem crescente
    private void inserirOrdenadoPositivo(int x) {
        if (n >= list.length) {
            throw new IndexOutOfBoundsException("Lista cheia");
        }
        int pos = 0;
        while (pos < n && list[pos] > 0 && list[pos] < x) {
            pos++;
        }
        for (int i = n; i > pos; i--) {
            list[i] = list[i - 1];
        }
        list[pos] = x;
        n++;
    }

    // Metodo para inserir elementos negativos no fim
    private void inserirFim(int x) {
        if (n >= list.length) {
            throw new IndexOutOfBoundsException("Lista cheia");
        }
        list[n] = x;
        n++;
    }

    public void imprimir() {
        for (int i = 0; i < n; i++) {
            System.out.print(list[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ex01 lista = new ex01(10); // Cria uma lista de tamanho 10

        lista.inserir(1);
        lista.inserir(-2);
        lista.inserir(1);
        lista.inserir(43);
        lista.inserir(-1);
        lista.inserir(57);
        lista.inserir(63);
        lista.inserir(-3);
        lista.inserir(23);

        lista.imprimir(); // Imprime a lista para verificar o resultado
    }
}
