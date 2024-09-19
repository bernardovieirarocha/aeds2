package exercicios.tads;

public class Lista {
    public int[] lista;
    public int n;

    public Lista(int qtd) {
        lista = new int[qtd];
        n = 0;
    }

    public void inserirInicio(int valor) {
        if (this.n >= this.lista.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        for (int i = this.n; i > 0; i--) {
            this.lista[i] = this.lista[i - 1];
        }
        this.lista[0] = valor;
        this.n++;
    }

    public void inserirFim(int valor) {
        if (this.n >= this.lista.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        this.lista[this.n] = valor;
        this.n++;
    }

    public void inserir(int valor , int pos) {
        if (this.n >= this.lista.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        if (pos < 0 || pos > this.n) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }
        for (int i = this.n; i > pos; i--) {
            this.lista[i] = this.lista[i - 1];
        }
        this.lista[pos] = valor;
        this.n++;
    }

    public int removerInicio() {
        if ( n ==0  ) {
            throw new ArrayStoreException("Lista Vazia");
        }

        int resp = this.lista[0];
        for (int i = 0 ; i < n; ++i) {
            lista[i] = lista[i+1];
        }
        return resp;
    }

    public int removerFim() {
        if (n == 0 ) {
            throw new ArrayStoreException("Lista Vazia");
        }
        this.n--;
        return this.lista[n];
    }
    public int remover(int pos) {
        if (n == 0) { throw new ArrayStoreException("Lista Vazia");}
        int resp = lista[pos];
        for (int i = pos; i < n; ++i){
            lista[i] = lista[i+1];
        }
        return resp;
    }

}
