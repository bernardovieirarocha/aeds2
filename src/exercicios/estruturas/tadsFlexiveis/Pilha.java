package exercicios.estruturas.tadsFlexiveis;

public class Pilha {
    private Celula topo;

    public Pilha() {
        topo = null;
    }

    public void empilhar(int x) {
        // Cria uma nova célula com o valor x
        Celula tmp = new Celula(x);
        // Conecta a nova célula ao topo da pilha
        tmp.prox = topo;
        // Atualiza o topo da pilha para a nova célula
        topo = tmp;
        tmp = null;
    }

    public int desempilhar() {
        if (topo == null) {
            throw new ArrayStoreException("Pilha vazia");
        }
        // Guarda o valor do topo da pilha
        int resp = topo.elemento;
        // Atualiza o topo da pilha para a célula seguinte
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    public Celula getTopo() {
        return topo;
    }

    public void mostrar(){
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.println("| " + i.elemento + " |");
        }
    }

    // Exercício 01
    public static int somaElementos(Pilha p){
        int soma = 0;
        for (Celula i = p.topo; i != null; i = i.prox) {
            soma += i.elemento;
        }
        return soma;
    }

    // Exercício 02
    // A celula i é o topo da pilha
    public static int somarElementosRecursivo(Pilha p, Celula i){
        // Se a célula for nula, retorna 0
        if (i == null) {
            return 0;
        }
        return i.elemento + somarElementosRecursivo(p, i.prox);
    }

    // Exercício 03
    public static int maiorElemento(Pilha p) {
        int maior = Integer.MIN_VALUE;
        for (Celula i = p.topo; i != null; i = i.prox) {
            if (i.elemento > maior) {
                maior = i.elemento;
            }
        }
        return maior;
    }

    // Exercício 04
    public static int maiorElementoRecursivo(Celula i){
        if (i == null) {
            return Integer.MIN_VALUE;
        }
        int maior = maiorElementoRecursivo(i.prox);
        return i.elemento > maior ? i.elemento : maior;
    }

    // Exercício 05
    // Seja nossa Pilha, faça um metodo RECURSIVO para mostrar os elementos da pilha na ordem em que os mesmos serão removidos
   // A mesma logica do metodo mostrar, mas ao inves de imprimir, chama o metodo recursivamente


    // Exercício 06
    public static void mostrarElementosInverso(Celula i){
        if (i == null) {
            return;
        }
        mostrarElementosInverso(i.prox);
        System.out.println("| " + i.elemento + " |");
    }
    /*
    * Exercício 07
    * Faça um metodo iterativo que mostre os elementos da pilha na ordem inversa
    * O funcionamento é semelhante ao metodo mostrarElementosInverso, mas ao invés de chamar o metodo recursivamente, empilha os elementos em uma nova pilha e depois mostra os elementos da nova pilha
    *
    * */
    public static void mostrarElementosInversoIterativo(Pilha p) {
        // Cria uma nova pilha para armazenar os elementos da pilha p
        Pilha saida = new Pilha();
        // Cria uma célula para percorrer a pilha p
       Celula atual = p.topo;

       while (atual != null) {
           // Empilha o elemento da pilha p na pilha saida
           saida.empilhar(atual.elemento);
           // Atualiza a célula para a próxima célula
           atual = atual.prox;
       }
        // Mostra os elementos da pilha saida
       saida.mostrar();
    }

    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.empilhar(1);
        p.empilhar(2);
        p.empilhar(3);
        p.empilhar(4);
        p.empilhar(5);

        p.mostrar();

        System.out.println();
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Desempilhado elemento: " + p.desempilhar());
        System.out.println("Topo: " + p.topo.elemento);

        System.out.println("Soma dos elementos: " + somaElementos(p));
        System.out.println("Soma dos elementos recursivo: " + somarElementosRecursivo(p, p.topo));
        System.out.println("Maior elemento: " + maiorElemento(p));
        System.out.println("Maior elemento recursivo: " + maiorElementoRecursivo(p.topo));
        mostrarElementosInversoIterativo(p);
    }
}
