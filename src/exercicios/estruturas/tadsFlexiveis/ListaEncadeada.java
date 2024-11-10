package exercicios.estruturas.tadsFlexiveis;


public class ListaEncadeada {
    private Celula primeiro;
    private Celula ultimo;

    public int quantidadeElementos = 0;

    public ListaEncadeada() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public int getSize() {
        Celula i = primeiro;
        int contador = 0;
        while (i != null) {
            i = i.prox;
            contador++;
        }
        return contador;
    }

    public void inserirFIM(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
        quantidadeElementos++;
    }

    public void inserirInicio(int x ){
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
        quantidadeElementos++;
    }

    public void inserirInicioCriandoNoCabeca(int x) {
        Celula novoCabeca = new Celula();
        novoCabeca.prox = primeiro;
        primeiro.elemento = x;
        primeiro = novoCabeca;
        quantidadeElementos++;
    }

    public int removerFIM(int x) {
        if (primeiro == ultimo) {
            throw new IllegalArgumentException("Fila Cheia");
        }
        Celula temp = primeiro;
        while (temp.prox != null && temp.prox != ultimo) {
            temp = temp.prox;
        }
        int elemento = ultimo.elemento;
        temp.prox = null;
        ultimo = temp;
        ultimo.prox = null;
        quantidadeElementos--;
        return elemento;
    }

    public void inserir(int x, int pos) {
        int tam = getSize();
        if ( pos < 0 || pos > tam){
            throw new IllegalArgumentException("Posicao Invalida");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tam) {
            inserirFIM(x);
        }

        Celula i = primeiro;
        for (int j = 0; j < pos; j++, i = i.prox);
        Celula tmp = new Celula(x);
        tmp.prox = i.prox;
        i.prox = tmp;
        tmp = i = null;
        quantidadeElementos++;
    }

    public int removerInicio(int x) {
        if (primeiro == ultimo) {
            throw new IllegalArgumentException("Fila Vazia");
        }
        Celula tmp = primeiro.prox;
        int elemento = tmp.elemento;
        primeiro.prox = tmp.prox;
        tmp.prox = null;
        if (primeiro.prox == null) {
            ultimo = primeiro;
        }
        tmp = null;
        quantidadeElementos--;
        return elemento;
    }

    public int remover(int x,int pos) {
        int elemento = 0;
        int tam = getSize();

        if (primeiro == ultimo || pos < 0 || pos >= tam) throw new IllegalArgumentException("Posicao Invalida ");
        else if (pos == 0) removerInicio(x);
        else if (pos == tam - 1) removerFIM(x);
        else {
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox);
            Celula tmp = i.prox;
            elemento = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            tmp = null;
        }
        quantidadeElementos--;
        return elemento;
    }

    public int remover2Valida() {
        if (primeiro == ultimo) {
            throw new IllegalArgumentException("Lista vazia");
        }

        Celula p = primeiro.prox; // Primeiro elemento válido
        Celula q = p.prox;        // Segundo elemento válido

        if (q == null) {
            throw new IllegalArgumentException("Lista com apenas um elemento válido");
        }

        // Remoção do segundo elemento válido
        p.prox = q.prox;

        // Atualiza o ponteiro `ultimo` se necessário
        if (p.prox == null) {
            ultimo = p;
        }

        // Isola `q`
        q.prox = null;
        quantidadeElementos--;
        return q.elemento;
    }

    public void inserirOrdenado(int x) {
        Celula i = primeiro;
        while (i.prox != null && i.prox.elemento < x) {
            i = i.prox;
        }
        Celula tmp = new Celula(x);
        tmp.prox = i.prox;
        i.prox = tmp;
        if (i == ultimo) {
            ultimo = tmp;
        }
        tmp = i = null;
        quantidadeElementos++;
    }

    public void inverter() {
        Celula i = primeiro.prox; // Inicializa 'i' apontando para o primeiro elemento real da lista (após o nó cabeça)
        Celula j = ultimo;        // Inicializa 'j' apontando para o último elemento da lista
        Celula k;                 // Declara uma variável auxiliar 'k' para percorrer a lista

        while (i != j && j.prox != i) { // Continua enquanto 'i' e 'j' não se cruzarem ou forem iguais
            // Troca os elementos das células apontadas por 'i' e 'j'
            int temp = i.elemento;   // Armazena temporariamente o elemento de 'i'
            i.elemento = j.elemento; // Atribui o elemento de 'j' a 'i'
            j.elemento = temp;       // Atribui o elemento temporário a 'j'

            i = i.prox; // Avança 'i' para a próxima célula

            // Move 'j' para a célula anterior, percorrendo a lista desde o início
            for (k = primeiro; k.prox != j; k = k.prox); // Encontra a célula anterior a 'j'
            j = k; // Atualiza 'j' para a célula anterior encontrada
        }
    }

    public int particiona(int inicio, int fim) {
        int pivo = inicio;
        int i = inicio + 1;
        int f = fim;
        while (i <= f) {
            if (primeiro.prox.elemento <= pivo) {
                i++;
            } else if (pivo < primeiro.prox.elemento) {
                f--;
            } else {
                int troca = primeiro.prox.elemento;
                primeiro.prox.elemento = f;
                f = troca;
                i++;
                f--;
            }
        }
        primeiro.elemento = f;
        f = pivo;
        return f;
    }

    public void quickSort() {
        quickSort(0, quantidadeElementos - 1);
    }

    public void quickSort (int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = particiona(inicio, fim);
            quickSort(inicio, posicaoPivo - 1);
            quickSort(posicaoPivo + 1, fim);
        }

    }


}
