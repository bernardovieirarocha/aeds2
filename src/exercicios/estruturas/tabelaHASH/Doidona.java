package exercicios.estruturas.tabelaHASH;


class Celula {
    public String valor;
    public Celula proximo;

    public Celula(String valor) {
        this.valor = valor;
        this.proximo = null;
    }
}

class Lista {
    public Celula primeiro;
    public Celula ultimo;

    public Lista() {
        this.primeiro = new Celula(null);
        this.ultimo = this.primeiro;
    }

    public void inserir(String valor) {
        this.ultimo.proximo = new Celula(valor);
        this.ultimo = this.ultimo.proximo;
    }

    // Inserir Ordenado
    public void inserirOrdenado(String valor) {
        Celula aux = this.primeiro;
        while (aux.proximo != null) {
            if (aux.proximo.valor.compareTo(valor) > 0) {
                Celula nova = new Celula(valor);
                nova.proximo = aux.proximo;
                aux.proximo = nova;
                return;
            }
            aux = aux.proximo;
        }
        this.ultimo.proximo = new Celula(valor);
        this.ultimo = this.ultimo.proximo;
    }

    public void remover(String valor) {
        Celula aux = this.primeiro;
        while (aux.proximo != null) {
            if (aux.proximo.valor.equals(valor)) {
                aux.proximo = aux.proximo.proximo;
                return;
            }
            aux = aux.proximo;
        }
    }

    public boolean buscar(String valor) {
        Celula aux = this.primeiro;
        while (aux.proximo != null) {
            if (aux.proximo.valor.equals(valor)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    // Busca Ordenado
    public boolean buscarOrdenado(String valor) {
        Celula aux = this.primeiro;
        while (aux.proximo != null) {
            if (aux.proximo.valor.equals(valor)) {
                return true;
            }
            if (aux.proximo.valor.compareTo(valor) > 0) {
                return false;
            }
            aux = aux.proximo;
        }
        return false;
    }
}

// NO da arvore binaria
class No {
    public char valor;
    public No esquerda;
    public No direita;
    public T1 tabela;

    public No(char valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.tabela = new T1(10);
    }
}

class Arvore {
    public No raiz;

    public Arvore() {
        this.raiz = null;
    }

    public void inserir(char valor ){
        raiz = inserir(raiz, valor);
    }

    public No inserir(No no, char valor) {
        if (no == null) {
            no = new No(valor);
        } else if (valor < no.valor) {
            no.esquerda = inserir(no.esquerda, valor);
        } else if (valor > no.valor) {
            no.direita = inserir(no.direita, valor);
        }
        return no;
    }

    // Inserir previamente as letras A B C D e F G H i H J K N P U R Y
    public void inserirPreviamente() {
        inserir('A');
        inserir('B');
        inserir('C');
        inserir('D');
        inserir('F');
        inserir('G');
        inserir('H');
        inserir('I');
        inserir('J');
        inserir('K');
        inserir('N');
        inserir('P');
        inserir('U');
        inserir('R');
        inserir('Y');
    }

}

// Tabela HASH 1
class T1 {
    public int tamanho1;
    public String[] tabela;
    public T2 reserva;
    public int tamanho2;

    public T1() {
       this(10);
    }

    public T1(int tamanho) {
        this.tamanho1 = tamanho;
        this.tamanho2 = 10;
        this.tabela = new String[tamanho];
        this.reserva = new T2(tamanho2);
    }


    // Ultima letra do nome
    public int hash(char x) {
        return x % tamanho1;
    }

    public int rehash(char x) {
        return (x + 1) % tamanho1;
    }

    // Inserir
    public void inserir(String valor) {
        char letra = valor.charAt(valor.length() - 1);
        int pos = hash(letra);
        if (tabela[pos] == null) {
            tabela[pos] = valor;
        } else  {
            // Rehash
            pos = rehash(letra);
            if (tabela[pos] == null) {
                tabela[pos] = valor;
            } else {
                reserva.inserir(valor);
            }
        }
    }

    // Pesquisar
    public boolean pesquisar(String valor) {
        char letra = valor.charAt(valor.length() - 1);
        int pos = hash(letra);
        if (tabela[pos] != null && tabela[pos].equals(valor)) {
            return true;
        }
        pos = rehash(letra);
        if (tabela[pos] != null && tabela[pos].equals(valor)) {
            return true;
        }
        return reserva.pesquisar(valor);
    }
}

class T2 {
    public int tamanho;
    public Lista[] tabela;

    public T2() {
        this(10);
    }

    public T2(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new Lista[tamanho];
    }

    // Quantidade de letras do nome
    public int hash(int x){
        return x % tamanho;
    }

    public void inserir(String valor) {
        int pos = hash(valor.length());

        if ( pos > tamanho) {
            System.out.println("Erro: Tamanho da tabela menor que a quantidade de letras do nome");
            return;
        }

        if (tabela[pos] == null) {
            tabela[pos] = new Lista();
        }
        tabela[pos].inserirOrdenado(valor);
    }

    // Pesquisar
    public boolean pesquisar(String valor) {
        int pos = hash(valor.length());
        if (tabela[pos] == null) {
            return false;
        }
        return tabela[pos].buscarOrdenado(valor);
    }

}

public class Doidona {
    public Arvore arvore;

    public Doidona() {
        this.arvore = new Arvore();
    }

    // Pesquisar um nome na estrutura toda
    public boolean pesquisar(String nome) {
        return pesquisar(arvore.raiz, nome);
    }

    public boolean pesquisar(No no, String nome) {
       // Procurar no com letra correspondente
        if (no == null) {
            return false;
        }
        if (nome.charAt(0) < no.valor) {
            return pesquisar(no.esquerda, nome);
        } else if (nome.charAt(0) > no.valor) {
            return pesquisar(no.direita, nome);
        } else {
            // Procurar na tabela correspondente a letra e consequentemente na reserva
            return no.tabela.pesquisar(nome);
        }
    }
}
