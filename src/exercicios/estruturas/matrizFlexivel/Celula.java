package exercicios.estruturas.matrizFlexivel;

public class Celula {
    public int elemento;
    public Celula inf, sup, esq, dir;

    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        this.inf = sup = esq = dir = null;
    }


}
