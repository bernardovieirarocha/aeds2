package exercicios.estruturas.tadsFlexiveis;


public class FilaSemNoCabeca {
    private Celula primeiro, ultimo;

    public FilaSemNoCabeca() {
        primeiro = null;
        ultimo = null;
    }

    public void inserir(int x) {
        Celula nova = new Celula(x);
        if (isEmpty()) {
            primeiro = nova;
            ultimo = nova;
        } else {
            ultimo.prox = nova;
            ultimo = nova;
        }
    }

    public int remover() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        int elemento = primeiro.elemento;
        primeiro = primeiro.prox;
        if (primeiro == null) {
            ultimo = null; // Se a fila ficou vazia, atualiza `ultimo` também
        }
        return elemento;
    }

    public void mostrar() {
        for (Celula i = primeiro; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
    }

    public int maiorElemento() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        int maior = primeiro.elemento;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento > maior) {
                maior = i.elemento;
            }
        }
        return maior;
    }

    public int thirdElement() {
        if (isEmpty() || primeiro.prox == null || primeiro.prox.prox == null) {
            throw new RuntimeException("Fila não possui terceiro elemento");
        }
        return primeiro.prox.prox.elemento;
    }

    public int soma() {
        int soma = 0;
        for (Celula i = primeiro; i != null; i = i.prox) {
            soma += i.elemento;
        }
        return soma;
    }

    public void inverter() {
        if (isEmpty() || primeiro == ultimo) {
            return;
        }

        Celula anterior = null;
        Celula atual = primeiro;
        Celula proximo;
        ultimo = primeiro;

        while (atual != null) {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        }
        primeiro = anterior;
    }

    public int contarParesMultiplos5() {
        return contarParesMultiplos5(primeiro);
    }

    private int contarParesMultiplos5(Celula i) {
        if (i == null) {
            return 0;
        }
        int count = (i.elemento % 2 == 0 && i.elemento % 5 == 0) ? 1 : 0;
        return count + contarParesMultiplos5(i.prox);
    }

    public boolean isEmpty() {
        return primeiro == null;
    }

    public static void main(String[] args) {
        Fila fila = new Fila();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);
        fila.inserir(40);

        fila.mostrar();
        System.out.println("\nMaior elemento: " + fila.maiorElemento());
        System.out.println("Terceiro elemento: " + fila.thirdElement());
        System.out.println("Soma dos elementos: " + fila.soma());
        System.out.println("Pares múltiplos de 5: " + fila.contarParesMultiplos5());

        fila.inverter();
        System.out.print("Fila invertida: ");
        fila.mostrar();
    }
}
