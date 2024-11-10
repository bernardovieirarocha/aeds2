package exercicios.estruturas.tadsFlexiveis;

class CelulaDupla {
    public int elemento;
    public CelulaDupla prox;
    public CelulaDupla ant;

    public CelulaDupla() {
        this(0);
    }
    public CelulaDupla(int elemento) {
        this.elemento = elemento;
        this.prox = this.ant = null;
    }
}

public class ListaDuplamenteEncadeada {
    private CelulaDupla primeiro, ultimo;

    public ListaDuplamenteEncadeada() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public void inserirInicio (int x) {
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            // Caso nao tenha nenhum elemento na lista
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    public void inserirFim(int x) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo = ultimo.prox;
    }

    public int removerInicio() throws IllegalAccessException {
        if (primeiro == ultimo) {
            throw new IllegalAccessException("Lista Vazia");
        }
        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        int elemento = primeiro.elemento;
        tmp.prox = null;
        tmp.ant = null;
        tmp = null;
        return  elemento;
    }

    public int removerInicio2() throws IllegalAccessException {
        if (primeiro == ultimo) {
            throw new IllegalAccessException("Lista Vazia");
        }
        CelulaDupla tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = tmp.prox;
        if (tmp.prox != null) {
            primeiro.prox.ant = primeiro;
        }
        tmp.prox = null;
        tmp.ant = null;
        tmp = null;
        return elemento;
    }

    public int removerFim() throws IllegalAccessException {
        if (primeiro == ultimo) {
            throw  new IllegalAccessException("Lista Vazia");
        }
        CelulaDupla temp = ultimo;
        ultimo = ultimo.ant;
        temp.ant.prox = temp.prox;
        int elemento = temp.elemento;
        temp.ant = null;
        temp.prox = null;
        temp=null;
        return elemento;
    }

    public int getSize() {
        if (primeiro == ultimo) {
            return 0;
        }
        int contador = 0;
        CelulaDupla tmp = primeiro.prox;
        while (tmp !=null) {
            tmp = tmp.prox;
            contador++;
        }
        return  contador;
    }

    public void inserir(int x, int pos) {
        int tam = getSize();
        if (pos < 0 || pos > tam) {
            throw  new IllegalArgumentException("Pos invalida");
        } else if (pos == 0) {
            inserirInicio(x);
            return;
        } else if (pos == tam) {
            inserirFim(x);
            return;
        }
        CelulaDupla i = primeiro;
        for (int j = 0; j <  pos - 1; j++, i = i.prox) ;
        CelulaDupla tmp = new CelulaDupla(x);
        tmp.prox = i.prox;
        tmp.ant = i;
        if (i.prox != null) {
            tmp.prox.ant = tmp;
        }
        i.prox = tmp;
    }

    public int remover(int pos) throws IllegalAccessException {
        int tam = getSize();
        if (primeiro == ultimo || pos < 0 || pos >= tam) {
            throw new IllegalArgumentException("Erro");
        } else if (pos == 0) {
            return removerInicio();
        } else if (pos == tam - 1) {
            return removerFim();
        }
        CelulaDupla i = primeiro.prox;
        for (int j = 0; j < pos - 1; j++, i = i.prox) ;
        i.ant.prox = i.prox;
        i.prox.ant = i.ant;
        int elemento = i.elemento;
        i.prox = null;
        i.ant = null;
        i = null;
        return elemento;
    }

    public void inverte() {
        CelulaDupla i = primeiro;
        CelulaDupla j = ultimo;
        while (i != j && i.ant != j) {
            int tmp = i.elemento;
            i.elemento = j.elemento;
            j.elemento = tmp;
            i = i.prox;
            j = j.ant;
        }
    }

    public void mostrar() {
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
    }

    public void quicksort(CelulaDupla esq, CelulaDupla dir) {
        CelulaDupla i = esq;
        CelulaDupla j = dir;
        CelulaDupla pivo = esq;
        while (i != j) {
            while (i != j && j.elemento >= pivo.elemento) {
                j = j.ant;
            }
            while (i != j && i.elemento <= pivo.elemento) {
                i = i.prox;
            }
            if (i != j) {
                int tmp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = tmp;
            }
        }
        int tmp = pivo.elemento;
        pivo.elemento = j.elemento;
        j.elemento = tmp;
        if (j != esq) {
            quicksort(esq, j.ant);
        }
        if (j != dir) {
            quicksort(j.prox, dir);
        }
    }

    public void quicksort () {
        quicksort(primeiro.prox, ultimo);
    }



}
