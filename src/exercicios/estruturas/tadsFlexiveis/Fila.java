package exercicios.estruturas.tadsFlexiveis;

public class Fila {
    private Celula primeiro, ultimo;

    public Fila() {
        // Cria célula cabeça e faz primeiro e último apontarem para ela
        // A utilidade da célula cabeça é que ela facilita a implementação de métodos
        primeiro = new Celula();
        ultimo = primeiro;
    }

    public Fila(Celula primeiro, Celula ultimo) {
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    public void inserir(int x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    public int remover() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Fila vazia");
        }
        int elemento = primeiro.prox.elemento;
        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        tmp.prox = null;
        tmp = null;
        return elemento;
    }

    // Exercício 1
    public void mostrar(){
        for (Celula i = primeiro.prox; i !=null ; i = i.prox){
            System.out.print(i.elemento + " ");
        }
    }

    // Exercício 2
    public int maiorElemento() {
        int maior = -1;
        if (primeiro == ultimo) {
            throw new RuntimeException("Fila vazia");
        }
        maior = primeiro.prox.elemento;
        for (Celula i = primeiro.prox.prox; i != null; i = i.prox) {
            if (i.elemento > maior) {
                maior = i.elemento;
            }
        }
        return maior;
    }

    // Exercício 3
    public int thirdElement() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Fila vazia");
        }
        if (primeiro.prox.prox.prox == null) {
            throw new RuntimeException("Fila não possui terceiro elemento");
        }
        return primeiro.prox.prox.prox.elemento;
    }

    // Exercício 4
    public int soma() {
        int soma = 0;
        for (Celula i = primeiro.prox; i != null; i = i.prox) {
            soma += i.elemento;
        }
        return soma;
    }

    /* ----- Exercício 5
    * O metodo inverter() funciona movendo elementos um a um para a posição final da fila até que o primeiro elemento
    * e o fim coincidam, o que indica que todos os elementos foram reposicionados. Ele cria novas células para garantir
    * que a estrutura original seja preservada enquanto a fila é reorganizada.
    *
    * Complexidade O(n)
    * */
    public void inverter() {
        // Se a fila estiver vazia ou tiver apenas um elemento, não há o que inverter
        Celula fim = ultimo;
        // Erro no Slide 35 o while deveria ser while(primeiro.prox != fim)
        while (primeiro.prox != fim) {
            // Cria uma nova célula com o elemento da primeira célula da fila
            Celula nova = new Celula(primeiro.prox.elemento);
            // A nova célula aponta para a célula que está atrás do fim
            nova.prox = fim.prox;
            // A celula final aponta para a nova célula criada
            fim.prox = nova;
            // Move a celula cabeça para a próxima célula
            Celula tmp = primeiro.prox;
            primeiro.prox = tmp.prox;
            nova = tmp = tmp.prox = null;
            if (ultimo == fim) {
                ultimo = fim.prox;
            }
        }
        fim = null;
    }


    /* Exercício 5
     * O metodo inverter2() funciona movendo o ponteiro da célula atual para a célula anterior, e o ponteiro da célula
     *  anterior para a célula atual, até que a célula atual seja nula, indicando que todos os elementos foram reposicionados.
     * O metodo utiliza apenas ponteiros para reorganizar a fila, sem a necessidade de criar novas células.
     *
     * */
    public void inverter2() {
        if (primeiro == ultimo) {
            throw new RuntimeException("Fila vazia");
        }
        if (primeiro.prox == ultimo) {
            // Se a fila tiver apenas um elemento, não há o que inverter
            return;
        }

        Celula anterior = null;
        Celula atual = primeiro.prox;
        Celula proximo;

        // A ultima célula da fila será a primeira
        ultimo = atual;

        while (atual != null) {
            proximo = atual.prox;
            atual.prox = anterior;
            anterior = atual;
            atual = proximo;
        }

        // Atualiza o primeiro
        primeiro.prox = anterior;

    }

    /* Exercício 6
    * O metodo contarParesMultiplos5() conta quantos elementos pares e múltiplos de 5 existem na fila.
    *  */
    public int contarParesMultiplos5() {
        return contarParesMultiplos5(primeiro.prox);
    }
    public int contarParesMultiplos5(Celula i) {
        int resp ;
        if (i == null) {
            return 0;
        } else if (i.elemento % 2 == 0 && i.elemento % 5 == 0) {
            resp = 1 + contarParesMultiplos5(i.prox);
        } else {
            resp = contarParesMultiplos5(i.prox);
        }
        return resp;
    }

    public void metodoDoidao() {
        Celula fim = ultimo;
        // Erro no Slide 38 o while deveria ser while(primeiro.prox != fim)
        while (primeiro.prox != fim) {
            ultimo.prox = new Celula(primeiro.prox.elemento);
            Celula tmp = primeiro;
            primeiro = primeiro.prox;
             tmp.prox = null;
             tmp = null;
             ultimo = ultimo.prox;
        }
        fim = null;
    }

    // Exercício 7
    /*
    * Metodo que receba o endereco de memoria da 1 posicao de uma pilha flexivel
    * e retorne o endereco de memoria da 1 posicao do no cabeca de uma fila flexivel
    * com os elementos da pilha na ordem em que elese foram inseridos
    * Seu metodo deve percorrer a pilha e inserir cada elemento da mesma na nova fila a ser retornada
    * A PILHA NAO PODE SER DESTRUIDA
    *  */
    public static Celula toFila(Celula topo) {
        Fila fila = new Fila();
        Pilha pilhaInvertida = new Pilha();
        Celula atual = topo;

        // Ao re-empilhar os elementos da pilha, eles estarão invertidos
        while (atual != null) {
            pilhaInvertida.empilhar(atual.elemento);
            atual = atual.prox;
        }

        // Desempilha os elementos da pilha invertida e insere na fila
        while(pilhaInvertida.getTopo() != null) {
            fila.inserir(pilhaInvertida.desempilhar());
        }
        return fila.primeiro;
    }

    // Exercício 7
    /*
    * Dessa maneira, o metodo toFilaMax() é uma adaptação do metodo toFila() que utiliza a pilha para inserir os elementos
    * A estratégia utilizada é a mesma, mas ao invés de desempilhar os elementos da pilha invertida, o metodo toFilaMax() utiliza
    * da call-stack da recursidade para inserir os elementos da pilha diretamente na fila na ordem inversa
    * */
    public static Celula toFilaMax(Celula topo) {
        // Cria uma célula cabeça para a fila
        Celula primeiro = new Celula();
        // Cria uma célula para percorrer a pilha
        Celula ultimo = primeiro;
        // Chama o método recursivo que percorre a pilha e insere os elementos na fila
        ultimo = toFilaMax(topo, primeiro);
        return primeiro;
    }

    public static Celula toFilaMax(Celula i, Celula ultimo) {
        if (i !=null) {
            // Chama o metodo recursivamente para percorrer a pilha
            ultimo = toFilaMax(i.prox, ultimo);
            // Insere o elemento da pilha na fila
            ultimo.prox = new Celula(i.elemento);
            // Atualiza a célula para a próxima célula
            ultimo = ultimo.prox;
        }
        return ultimo;
    }

    public boolean isEmpty() {
        return primeiro == ultimo;
    }

    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.empilhar(3);
        p.empilhar(5);
        p.empilhar(7);

        p.mostrar();
//        System.out.println();

        Celula filaCabeca = Fila.toFilaMax(p.getTopo());
        while (filaCabeca.prox != null) {
            System.out.print(filaCabeca.prox.elemento + " ");
            filaCabeca = filaCabeca.prox;
        }


    }

}
