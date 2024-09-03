import java.util.Arrays;

/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB04_01 - Sort Sort Sort... (Sort Sort...)
 */

@SuppressWarnings("WrongPackageStatement")
public class sort {

    /**
    * Funcao que le um vetor de inteiros de tamanho 'tamanho' e o preenche com os valores lidos
     * @param vetor - vetor de inteiros
     * @param tamanho - tamanho do vetor
     * @info Complexidade: O(n);
    */
    public static void lerVetor(int [] vetor, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = MyIO.readInt();
        }
    }

    /**
    * Funcao que calcula o modulo de cada elemento do vetor de inteiros
    * @param input - vetor de inteiros
    * @param tamanho - tamanho do vetor
    * @param mod - modulo a ser calculado
    * @return vetor de inteiros com os resultados dos mods
    * @info Complexidade: O(n);
    */
    public static int[] calcularMods(int [] input, int tamanho, int mod) {
        int[] output = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            output[i] = input[i] % mod;
        }
        return output;
    }

    /**
    * Funcao que troca dois elementos de um vetor de inteiros
    * @param input - vetor de inteiros
    * @param i - indice do primeiro elemento
    * @param j - indice do segundo elemento
    * @info Complexidade: O(1);
     */
    public static void swap(int [] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
    * Funcao que ordena um vetor de inteiros com base no resultado dos mods
     * @param input - vetor de inteiros
     * @param mods - vetor de inteiros com os resultados dos mods
     * @info Complexidade: Bubble Sort O(n^2);
     */
    public static void ordenarVetorBubbleSort(int input[] ,int [] mods, int tamanho) {
         // Ordenar o vetor de numeros com base no resultado dos mods
        for (int i = 0; i < tamanho - 1; ++i) {
            for (int j = i + 1; j < tamanho; ++j) {
                if (mods[i] > mods[j]) {
                    swap(mods, i, j);
                    swap(input, i, j);
                }
            }
        }

    }

    /**
    * Funcao que ordena um vetor de inteiros com base no resultado dos mods
    * @param input - vetor de inteiros
    * @param mods - vetor de inteiros com os resultados dos mods
    * @info Complexidade: Selection Sort O(n^2);
     */
    public static void ordenarVetorSelectionSort(int input[], int[] mods, int tamanho){
        // Vai ate o tamanho - 1 para nao comparar o ultimo elemento com o vazio (IndexOutOfBounds)
        for (int i = 0; i < tamanho - 1; i++) {
            int min = i;
            for (int j = i + 1; j < tamanho; j++) {
                if (mods[j] < mods[min]) {
                    min = j;
                }
            }
            // Trocar os valores de input e mods de forma a manter a consistencia
            swap(mods, i, min);
            swap(input, i, min);
        }
    }

    /*
    * Funcao que verifica se a deve-se trocar um par que esta precedendo um impar
    * @param i - inteiro
    * @param j - inteiro
    * @return boolean
     */
    public static boolean NOTprecedenciaImpar(int i, int j) {
        return i % 2 == 0 && j % 2 != 0;
    }

    /*
    * Funcao que verifica se dois impares estao precedendo um ao outro e a regra de desempate e a ordem decrescente
    * @param i - inteiro
    * @param j - inteiro
    * @return boolean
     */
    public static boolean BOTHprecedenciaImpar(int i, int j) {
        return i % 2 != 0 && j % 2 != 0;
    }

    /*
    * Funcao que verifica se dois pares estao precedendo um ao outro e a regra de desempate e a ordem crescente
    * @param i - inteiro
    * @param j - inteiro
    * @return boolean
     */
    public static boolean BOTHprecedenciaPar(int i, int j) {
        return i % 2 == 0 && j % 2 == 0;
    }

    /*
    * Funcao que checa as regras de desempate
    * @param input - vetor de inteiros
    * @param mods - vetor de inteiros com os resultados dos mods
    * @param tam - tamanho do vetor
    * @info Complexidade:
     */
    public static void checarRegrasDesempate(int input[], int[] mods, int tam) {
        // Se houver troca, o loop deve continuar ate que nao haja mais trocas para garantir que a ordenacao esteja correta
        boolean houveTroca = false;
        do {
            houveTroca = false;
            // Loop para comparar o anterior e o proximo
            for (int i = 0 ; i < tam - 1; ++i) {
                if (mods[i] == mods[i+1]) {
                    if (NOTprecedenciaImpar(input[i],input[i+1])) {
                        swap(input, i, i+1);
                        swap(mods, i, i+1);
                        houveTroca = true;
                    }
                    if (BOTHprecedenciaImpar(input[i], input[i+1])) {
                        if (input[i] < input[i+1]) {
                            swap(input, i, i+1);
                            swap(mods, i, i+1);
                            houveTroca = true;
                        }
                    }
                    if (BOTHprecedenciaPar(input[i], input[i+1])) {
                        if (input[i] > input[i+1]) {
                            swap(input, i, i+1);
                            swap(mods, i, i+1);
                            houveTroca = true;
                        }
                    }

                }
            }

        } while(houveTroca);
    }

    public static void imprimirVetor(int [] input, int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            System.out.println(input[i]);
        }
    }

    public static void main(String[] args) {
        while (true) {
            int tamanho = MyIO.readInt();
            int modulo = MyIO.readInt();
            if (tamanho == 0 ){
                System.out.printf("%d %d\n", tamanho, modulo);
                break;
            };


            int[] inputNumeros = new int[tamanho];
            lerVetor(inputNumeros, tamanho);
            int[] mods = calcularMods(inputNumeros, tamanho, modulo);
            ordenarVetorSelectionSort(inputNumeros, mods, tamanho);
            checarRegrasDesempate(inputNumeros, mods, tamanho);
            System.out.printf("%d %d\n", tamanho, modulo);
            imprimirVetor(inputNumeros, tamanho);

        }
    }
}
