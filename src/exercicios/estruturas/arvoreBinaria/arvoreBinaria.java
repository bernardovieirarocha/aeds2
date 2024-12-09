package exercicios.estruturas.arvoreBinaria;

import exercicios.estruturas.tadsFlexiveis.Celula;

import java.util.ArrayList;
import java.util.List;

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



public class arvoreBinaria {
    No raiz;
    arvoreBinaria() {
        raiz = null;
    }

    /*
     * Analise de complexidade do metodo inserir:
     *  Melhor caso (Primeira inserção): O(1)
     *  Pior caso (Ordem crescente ou descrescente): O(n)
     *   - Neste caso, a árvore se torna uma lista encadeada e a inserção ocorre em O(n) devido à altura da árvore.
     *  Caso médio (Inserções aleatórias): O(log n)
     *   - Em média, a altura da árvore é logarítmica em relação ao número de elementos.
     *   - Inserção na folha de uma árvore balanceada ocorre em O(log n).
     */

    // Metodo público para inserir um elemento na árvore binária de busca.
    // Este metodo atua como uma interface para o metodo recursivo privado.
    // Parâmetro:
        // - x: o valor inteiro a ser inserido na árvore.
    void inserir(int x ){
        // Chama o metodo recursivo 'inserir' passando a raiz atual da árvore e o valor a ser inserido.
        // O resultado (possivelmente uma nova raiz) é atribuído de volta à variável 'raiz'.
        raiz = inserir(raiz, x);
    }

    /*
     * Metodo privado recursivo para inserir um elemento na árvore binária de busca por referência.
     * Este metodo percorre a árvore a partir do nó fornecido e insere o novo elemento na posição correta
     * de acordo com as propriedades da árvore binária de busca (esquerda < nó < direita).
     *
     * Parâmetros:
     * - i: o nó atual da árvore onde a inserção está sendo considerada.
     * - x: o valor inteiro a ser inserido na árvore.
     *
     * Retorna:
     * - O nó atualizado após a inserção. Este retorno é essencial para garantir que as referências
     *   dos nós pais sejam corretamente atualizadas com os novos nós inseridos.
     *
     * Exceções:
     * - Lança uma exceção (ou, neste caso, imprime uma mensagem de erro) se o elemento já existir na árvore,
     *   evitando duplicatas.
     *
     * Funcionamento detalhado:
     * 1. Verificação de Nulo:
     *    - Se o nó atual 'i' for nulo, significa que encontramos a posição correta para inserir o novo valor.
     *    - Cria-se um novo nó com o valor 'x' e retorna-se este novo nó, que será conectado ao nó pai na posição correta.
     *
     * 2. Comparação de Valores:
     *    - Se 'x' for menor que o valor do nó atual ('i.valor'), a inserção deve ocorrer na subárvore esquerda.
     *      - Chama-se recursivamente o metodo 'inserir' passando o filho esquerdo do nó atual e o valor 'x'.
     *      - O resultado da inserção (possivelmente uma nova subárvore esquerda) é atribuído a 'i.esquerda'.
     *
     *    - Se 'x' for maior que o valor do nó atual ('i.valor'), a inserção deve ocorrer na subárvore direita.
     *      - Chama-se recursivamente o metodo 'inserir' passando o filho direito do nó atual e o valor 'x'.
     *      - O resultado da inserção (possivelmente uma nova subárvore direita) é atribuído a 'i.direita'.
     *
     * 3. Tratamento de Duplicatas:
     *    - Se 'x' for igual ao valor do nó atual ('i.valor'), significa que o elemento já existe na árvore.
     *    - Em vez de inserir um duplicado, o metodo imprime uma mensagem de erro informando que o valor já existe.
     *    - Não há alteração na árvore neste caso.
     *
     * 4. Retorno do Nó Atualizado:
     *    - Após as operações de inserção, o metodo retorna o nó atual 'i', que pode ter sido atualizado
     *      com novos filhos (esquerda ou direita).
     *    - Este retorno é crucial para manter as conexões corretas na árvore durante a recursão.
     *
     * Exemplo de Inserção:
     * - Suponha que a árvore está vazia inicialmente (raiz = null).
     * - Ao chamar 'inserir(10)', o metodo público chama 'inserir(null, 10)'.
     * - Como 'i' é nulo, um novo nó com valor 10 é criado e se torna a nova raiz da árvore.
     *
     * - Ao chamar 'inserir(5)', o metodo público chama 'inserir(raiz, 5)'.
     * - Como 5 < 10, a inserção ocorre na subárvore esquerda.
     * - O metodo recursivo é chamado com 'i.esquerda' (que é nulo) e 5.
     * - Um novo nó com valor 5 é criado e atribuído a 'raiz.esquerda'.
     *
     * - Ao chamar 'inserir(15)', o processo similar ocorre na subárvore direita.
     *
     * - Se tentarmos inserir novamente o valor 10, o metodo detectará a duplicata e imprimirá uma mensagem de erro.
     */
    No inserir(No i, int x) {
        // Caso base: Se o nó atual for nulo, criamos um novo nó com o valor x.
        if (i == null) {
            i = new No(x);
        }
        // Se o valor a ser inserido for menor que o valor do nó atual, insere-se na subárvore esquerda.
        else if (x < i.valor) {
            // Chamada recursiva para inserir na subárvore esquerda.
            i.esquerda = inserir(i.esquerda, x);
        }
        // Se o valor a ser inserido for maior que o valor do nó atual, insere-se na subárvore direita.
        else if (x > i.valor) {
            // Chamada recursiva para inserir na subárvore direita.
            i.direita = inserir(i.direita, x);
        }
        // Se o valor já existe na árvore, não permite duplicatas e informa o usuário.
        else {
            System.out.println("Erro: Valor já existe na árvore");
        }
        // Retorna o nó atual (pode ser a nova raiz ou o nó com subárvores atualizadas).
        return i;
    }

    /*
     * metodo público para inserir um elemento na árvore binária de busca.
     * Este metodo atua como uma interface para o metodo auxiliar que rastreia o nó pai.
     * Parâmetro:
     * - x: o valor inteiro a ser inserido na árvore.
     */
    public void inserirPai(int x) {
        // Caso base: Se a árvore estiver vazia, cria-se um novo nó que se torna a raiz.
        if (raiz == null) {
            raiz = new No(x);
        }
        // Se o valor a ser inserido for menor que o valor da raiz, insere-se na subárvore esquerda.
        else if (x < raiz.valor) {
            inserirPai(x, raiz.esquerda, raiz);
        }
        // Se o valor a ser inserido for maior que o valor da raiz, insere-se na subárvore direita.
        else if (x > raiz.valor) {
            inserirPai(x, raiz.direita, raiz);
        }
        // Se o valor já existe na árvore, não permite duplicatas e informa o usuário.
        else {
            System.out.println("Erro: Valor já existe na árvore");
        }
    }

    /*
     * metodo auxiliar recursivo para inserir um elemento na árvore binária de busca.
     * Este metodo rastreia explicitamente o nó pai durante a inserção.
     *
     * Parâmetros:
     * - x: o valor inteiro a ser inserido na árvore.
     * - i: o nó atual onde a inserção está sendo considerada.
     * - pai: o nó pai de 'i'.
     *
     * Funcionamento detalhado:
     * 1. Verificação de Nulo:
     *    - Se o nó atual 'i' for nulo, significa que encontramos a posição correta para inserir o novo valor.
     *    - Verifica-se se 'x' é menor ou maior que o valor do nó pai para determinar se o novo nó será o filho esquerdo ou direito.
     *    - Cria-se um novo nó com o valor 'x' e o atribui-se à posição correta (esquerda ou direita) do nó pai.
     *
     * 2. Comparação de Valores:
     *    - Se 'x' for menor que o valor do nó atual ('i.valor'), a inserção deve ocorrer na subárvore esquerda.
     *      - Chama-se recursivamente o metodo 'inserirPai' passando o filho esquerdo do nó atual e o nó atual como novo pai.
     *
     *    - Se 'x' for maior que o valor do nó atual ('i.valor'), a inserção deve ocorrer na subárvore direita.
     *      - Chama-se recursivamente o metodo 'inserirPai' passando o filho direito do nó atual e o nó atual como novo pai.
     *
     * 3. Tratamento de Duplicatas:
     *    - Se 'x' for igual ao valor do nó atual ('i.valor'), o valor já existe na árvore.
     *    - Em vez de inserir um duplicado, o metodo imprime uma mensagem de erro informando que o valor já existe.
     *
     * 4. Retorno:
     *    - Este metodo não retorna nenhum valor. As atualizações são feitas diretamente nas referências dos nós pais.
     */
    public void inserirPai(int x, No i, No pai) {
        // Caso base: Se o nó atual for nulo, insere-se o novo nó na posição correta do pai.
        if (i == null) {
            if (x < pai.valor) {
                // Se 'x' for menor que o valor do pai, insere-se como filho esquerdo.
                pai.esquerda = new No(x);
            } else {
                // Caso contrário, insere-se como filho direito.
                pai.direita = new No(x);
            }
        }
        // Se o valor a ser inserido for menor que o valor do nó atual, insere-se na subárvore esquerda.
        else if (x < i.valor) {
            // Chamada recursiva para inserir na subárvore esquerda, atualizando o pai para o nó atual.
            inserirPai(x, i.esquerda, i);
        }
        // Se o valor a ser inserido for maior que o valor do nó atual, insere-se na subárvore direita.
        else if (x > i.valor) {
            // Chamada recursiva para inserir na subárvore direita, atualizando o pai para o nó atual.
            inserirPai(x, i.direita, i);
        }
        // Se o valor já existe na árvore, não permite duplicatas e informa o usuário.
        else {
            System.out.println("Erro: Valor já existe na árvore");
        }
    }

    /*
     * Análise de complexidade do metodo pesquisar:
     * - Melhor caso (Elemento no topo da árvore): O(1)
     * - Pior caso (Árvore desbalanceada): O(n)
     *   - Neste caso, a árvore se torna uma lista encadeada e a pesquisa ocorre em O(n) devido à a da árvore.
     * - Caso médio (Árvore balanceada): O(log n)
     *   - Em média, a altura da árvore é logarítmica em relação ao número de elementos.
     */

    /*
     * metodo público para pesquisar a existência de um valor na árvore.
     *
     * @param x Valor inteiro a ser pesquisado.
     * @return true se o valor existir na árvore, false caso contrário.
     */
    boolean pesquisar(int x) {
        return pesquisar(x, raiz);
    }

    /*
     * metodo privado recursivo para pesquisar a existência de um valor na árvore.
     *
     * @param x Valor inteiro a ser pesquisado.
     * @param i Nó atual da árvore onde a pesquisa está sendo realizada.
     * @return true se o valor existir na árvore a partir do nó i, false caso contrário.
     */
    boolean pesquisar(int x, No i) {
        boolean resp = false;
        if (i == null) {
            // Se o nó atual for nulo, o valor não está presente na árvore.
            resp = false;
        }
        if (x == i.valor) {
            // Se o valor for encontrado no nó atual, retorna true.
            resp = true;
        } else if (x < i.valor) {
            // Se x for menor que o valor do nó atual, pesquisa-se na subárvore esquerda.
            resp = pesquisar(x, i.esquerda);
        } else {
            // Se x for maior que o valor do nó atual, pesquisa-se na subárvore direita.
            resp = pesquisar(x, i.direita);
        }
        return resp;
    }

    /*
     * metodo para retornar o nó que contém um valor específico.
     *
     * @param x Valor inteiro a ser pesquisado.
     * @return Nó que contém o valor x, ou null se não encontrado.
     */
    No pesquisarNo(int x) {
        return pesquisarNo(x, raiz);
    }

    /*
     * metodo privado recursivo para retornar o nó que contém um valor específico.
     *
     * @param x Valor inteiro a ser pesquisado.
     * @param i Nó atual da árvore onde a pesquisa está sendo realizada.
     * @return Nó que contém o valor x, ou null se não encontrado.
     */
    No pesquisarNo(int x, No i) {
        if (i == null) {
            // Se o nó atual for nulo, o valor não está presente na árvore.
            return null;
        }
        if (x == i.valor) {
            // Se o valor for encontrado no nó atual, retorna o nó.
            return i;
        } else if (x < i.valor) {
            // Se x for menor que o valor do nó atual, pesquisa-se na subárvore esquerda.
            return pesquisarNo(x, i.esquerda);
        } else {
            // Se x for maior que o valor do nó atual, pesquisa-se na subárvore direita.
            return pesquisarNo(x, i.direita);
        }
    }

    /*
     * Análise de complexidade do metodo caminhar:
     * - Melhor caso (Árvore vazia): O(1)
     * - Pior caso (Árvore desbalanceada): O(n)
     *   - Neste caso, a árvore se torna uma lista encadeada e o caminhamento ocorre em O(n) devido à altura da árvore.
     * - Caso médio (Árvore balanceada): O(n)
     *   - Em árvores balanceadas, mesmo com altura logarítmica, o número total de nós visitados é proporcional a n.
     */

    /*
     * metodo para realizar o caminhamento central (in-order traversal) da árvore.
     * Este metodo imprime os valores da árvore em ordem crescente.
     *
     * @param i Nó atual da árvore onde o caminhamento está sendo realizado.
     */
    public void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esquerda);            // Visita a subárvore esquerda.
            System.out.print(i.valor + " ");        // Processa o nó atual.
            caminharCentral(i.direita);             // Visita a subárvore direita.
        }
    }

    /*
     * metodo para realizar o caminhamento pré-ordem (pre-order traversal) da árvore.
     * Este metodo imprime os valores da árvore seguindo a ordem: nó atual, esquerda, direita.
     *
     * @param i Nó atual da árvore onde o caminhamento está sendo realizado.
     */
    public void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.valor + " ");        // Processa o nó atual.
            caminharPre(i.esquerda);                // Visita a subárvore esquerda.
            caminharPre(i.direita);                 // Visita a subárvore direita.
        }
    }

    /*
     * metodo para realizar o caminhamento pós-ordem (post-order traversal) da árvore.
     * Este metodo imprime os valores da árvore seguindo a ordem: esquerda, direita, nó atual.
     *
     * @param i Nó atual da árvore onde o caminhamento está sendo realizado.
     */
    public void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esquerda);                // Visita a subárvore esquerda.
            caminharPos(i.direita);                 // Visita a subárvore direita.
            System.out.print(i.valor + " ");        // Processa o nó atual.
        }
    }

    /*
     * Metodo para realizar o caminhamento central (in-order traversal) da árvore.
     * Este Metodo adiciona os valores da árvore em ordem crescente a uma lista.
     *
     * @param i Nó atual da árvore onde o caminhamento está sendo realizado.
     * @param lista Lista que armazena os valores em ordem.
     */
    private void caminharCentral(No i, List<Integer> lista) {
        if (i != null) {
            caminharCentral(i.esquerda, lista);      // Visita a subárvore esquerda.
            lista.add(i.valor);                      // Adiciona o valor do nó atual à lista.
            caminharCentral(i.direita, lista);       // Visita a subárvore direita.
        }
    }

    /*
     * Metodo para exibir a árvore em ordem (in-order traversal).
     *
     * @param i Nó atual da árvore onde o caminhamento está sendo realizado.
     */
    public static void exibirEmOrdem(No i) {
        if (i != null) {
            exibirEmOrdem(i.esquerda);            // Visita a subárvore esquerda.
            System.out.print(i.valor + " ");        // Processa o nó atual.
            exibirEmOrdem(i.direita);             // Visita a subárvore direita.
        }
    }

    // Metodo público para iniciar a exibição da árvore em ordem.
    public void exibirEmOrdem() {
        exibirEmOrdem(raiz);
        System.out.println();
    }

    /*
     * Metodo público para obter uma lista de elementos em ordem crescente.
     *
     * @return Lista de inteiros ordenados.
     */
    public List<Integer> obterOrdenado() {
        List<Integer> listaOrdenada = new ArrayList<>();
        caminharCentral(raiz, listaOrdenada);
        return listaOrdenada;
    }


    public int getAltura() {
        return getAltura(raiz, 0);
    }

    // A altura da árvore é o comprimento do caminho mais longo da raiz até uma folha.
    public int getAltura(No i, int altura) {
        if (i == null) {
            altura--;
        } else {
            int altEsq = getAltura(i.esquerda, altura + 1);
            int altDir = getAltura(i.direita, altura + 1);
            altura = (altEsq > altDir) ? altEsq : altDir;
        }
        return altura;
    }

    public int getAltura(No i) {
        if (i == null) {
            return -1;
        }
        int altEsq = getAltura(i.esquerda);
        int altDir = getAltura(i.direita);
        return 1 + (altEsq > altDir ? altEsq : altDir);
    }

    public static int  generateRandomElement() {
        return (int) (Math.random() * 100);
    }

    public int numeroElementos() {
        return numeroElementos(raiz);
    }

    public int numeroElementos(No i) {
        if (i == null) {
            return 0;
        }
        return 1 + numeroElementos(i.esquerda) + numeroElementos(i.direita);
    }

    public int soma(){
        return soma(raiz);
    }

    public int soma(No i) {
        if (i == null) {
            return 0;
        }
        return i.valor + soma(i.esquerda) + soma(i.direita);
    }

    public int somaPares(){
        return somaPares(raiz);
    }

    public int somaPares(No i) {
        if (i == null) {
            return  0;
        }
        int soma = 0;
        if (i.valor % 2 == 0) {
            soma += 1;
        }
        soma += somaPares(i.esquerda);
        soma += somaPares(i.direita);
        return  soma;
    }

    public boolean divisivelPor11() {
        return divisivelPor11(raiz);
    }

    public boolean divisivelPor11(No i) {
        if (i == null) {
            return false;
        }
        if (i.valor % 11 == 0){
            return true;
        }
        return divisivelPor11(i.esquerda) || divisivelPor11(i.direita);
    }

    /*
     * Metodo para realizar o TreeSort.
     * Este Metodo recebe um array, insere seus elementos na árvore e retorna um array ordenado.
     *
     * @param array Array de inteiros a ser ordenado.
     * @return Array de inteiros ordenados.
     */
    public static int[] treeSort(int[] array) {
        arvoreBinaria arvore = new arvoreBinaria();

        // Inserindo elementos do array na árvore.
        for (int num : array) {
            arvore.inserir(num);
        }

        // Obtendo a lista ordenada a partir da árvore.
        List<Integer> listaOrdenada = arvore.obterOrdenado();

        // Convertendo a lista ordenada de volta para um array.
        int[] arrayOrdenado = new int[listaOrdenada.size()];
        for (int i = 0; i < listaOrdenada.size(); i++) {
            arrayOrdenado[i] = listaOrdenada.get(i);
        }

        return arrayOrdenado;
    }
    public static arvoreBinaria inserirAleatorio(arvoreBinaria arvore, int n) {
        for (int i = 0; i < n; i++) {
            arvore.inserir(generateRandomElement());
            System.out.println("Numero Elementos: " + arvore.numeroElementos());
            System.out.println("Altura: " + arvore.getAltura());
            System.out.println();
            System.out.print("Logs: " + Math.log(arvore.numeroElementos()) / Math.log(2));
        }
            System.out.println();
        return arvore;
    }

    public static No toAB(Celula p1, CelulaDupla p2) {
        int contador = 0;
        Celula temp1 = p1;
        CelulaDupla temp2 = p2;

        arvoreBinaria arvore = new arvoreBinaria();

        while (temp1 != null  || temp2 != null) {
            if ( contador % 2 == 0 ){
                if ( temp1 != null) {
                    arvore.inserir(temp1.elemento);
                    temp1 = temp1.prox;
                }
            } else {
                if (temp2 != null) {
                    arvore.inserir(temp2.elemento);
                    temp2 = temp2.prox;
                }
            }
            contador++;
        }

        return arvore.raiz;
    }


    public int altura() {
        return altura(raiz);
    }

    public int altura(No raiz) {
        if (raiz == null) {
            return -1;
        }
        int alturaEsquerda = altura(raiz.esquerda);
        int alturaDireita = altura(raiz.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    public int qtdElementos() {
        return qtdElementos(raiz);
    }

    public int qtdElementos(No raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + qtdElementos(raiz.esquerda) + qtdElementos(raiz.direita);
    }

    public boolean isMax(double x) {
        return isMax(raiz, x);
    }

    // Metodo pra fazer log na base 2
    public static double log2(double n) {
        return Math.log(n) / Math.log(2);
    }

    public boolean isMax(No raiz, double x) {
        double maximo = x * log2(qtdElementos());
        return altura(raiz) <= maximo;
    }

    public static void main(String[] args) {
        // Exemplo de criação de uma lista simples
        Celula listaSimples = new Celula(10);
        listaSimples.prox = new Celula(30);
        listaSimples.prox.prox = new Celula(50);

        // Exemplo de criação de uma lista dupla
        CelulaDupla listaDupla = new CelulaDupla(20);
        CelulaDupla segundo = new CelulaDupla(40);
        CelulaDupla terceiro = new CelulaDupla(60);

        listaDupla.prox = segundo;
        segundo.ant = listaDupla;
        segundo.prox = terceiro;
        terceiro.ant = segundo;

        // Mostrar a lista simples
        for (Celula i = listaSimples; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();
        // Mostrar a lista dupla
        for (CelulaDupla i = listaDupla; i != null; i = i.prox) {
            System.out.print(i.elemento + " ");
        }
        System.out.println();

        // Converter as listas em uma árvore binária intercalada
        No raiz = toAB(listaSimples, listaDupla);

        // Metodo para exibir a árvore (in-order traversal para verificar a estrutura)
        exibirEmOrdem(raiz);
    }


}