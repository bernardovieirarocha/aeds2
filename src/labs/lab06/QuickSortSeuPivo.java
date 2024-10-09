package labs.lab06;

public class QuickSortSeuPivo
{
    void show(int [] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
    }

    void QuickSortFirstPivot(int [] array, int left, int right) {
        if (left < right) {
            int pivot = array[left];
            int i = left + 1;
            int j = right;

            while (i <= j) {
                if (array[i] <= pivot) {
                    i++;
                } else if (array[j] > pivot) {
                    j--;
                } else {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            array[left] = array[j];
            array[j] = pivot;

            QuickSortFirstPivot(array, left, j - 1);
            QuickSortFirstPivot(array, j + 1, right);
        }
    }

    void QuickSortRandomPivot(int [] array, int left, int right) {
        if (left < right) {
            int pivot = array[(int) (Math.random() * (right - left + 1)) + left];
            int i = left;
            int j = right;

            while (i <= j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            QuickSortRandomPivot(array, left, j);
            QuickSortRandomPivot(array, i, right);
        }
    }

    public static int medianOfThree(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;

        int a = array[left];
        int b = array[mid];
        int c = array[right];

        // Comparar os três valores e retornar o valor mediano
        if ((a > b && a < c) || (a < b && a > c)) {
            return a; // a é a mediana
        } else if ((b > a && b < c) || (b < a && b > c)) {
            return b; // b é a mediana
        } else {
            return c; // c é a mediana
        }
    }

    void QuickSortMedianOfThreePivot(int [] array, int left, int right) {
        if (left < right) {
            int pivot = medianOfThree(array, left, right);
            int i = left;
            int j = right;

            while (i <= j) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }

                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }

            QuickSortMedianOfThreePivot(array, left, j);
            QuickSortMedianOfThreePivot(array, i, right);
        }
    }

    int[] makeRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    public int[] makeNearlyOrderedArray(int size) {
        int[] array = new int[size];

        // Preenche o array de forma ordenada inicialmente
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        // Introduz pequenas desordens trocando elementos em algumas posições
        int swapCount = size / 10; // Troca aproximadamente 10% dos elementos para criar uma pequena desordem

        for (int i = 0; i < swapCount; i++) {
            int index1 = (int) (Math.random() * size);
            int index2 = (int) (Math.random() * size);

            // Troca dois elementos
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }

        return array;
    }

    public int[] makeOrderedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }


    public static void testarEstrategias(QuickSortSeuPivo quickSort, int[] array, String descricao) {
        int[] copiaArray;

        // Teste com pivô sendo o primeiro elemento
        copiaArray = array.clone();
        long inicio = System.nanoTime();
        quickSort.QuickSortFirstPivot(copiaArray, 0, copiaArray.length - 1);
        long fim = System.nanoTime();
        System.out.println("Tempo para " + descricao + " com o pivô sendo o primeiro elemento: " + (fim - inicio) + " nano segundos");

        // Teste com pivô sendo um elemento aleatório
        copiaArray = array.clone();
        inicio = System.nanoTime();
        quickSort.QuickSortRandomPivot(copiaArray, 0, copiaArray.length - 1);
        fim = System.nanoTime();
        System.out.println("Tempo para " + descricao + " com o pivô sendo aleatório: " + (fim - inicio) + " nano segundos");

        // Teste com pivô sendo a mediana de três
        copiaArray = array.clone();
        inicio = System.nanoTime();
        quickSort.QuickSortMedianOfThreePivot(copiaArray, 0, copiaArray.length - 1);
        fim = System.nanoTime();
        System.out.println("Tempo para " + descricao + " com o pivô sendo a mediana de três: " + (fim - inicio) + " nano segundos");
        System.out.println();
    }

    public static void main(String[] args) {
        // Execute cada uma das implementacoes com diferentes tamanhos de arrays (ex: 100, 1.000, 10.000 elementos)
        // e compare o tempo de execucao de cada estrategia.
        // Utilize arrays ordenados, quase ordenados e aleatorios para testar o comportamento dos algoritmos.

        QuickSortSeuPivo quickSort = new QuickSortSeuPivo();

        // Arrays de tamanhos diferentes
        int[] arrayCem = quickSort.makeRandomArray(100);
        int[] arrayMil = quickSort.makeRandomArray(1000);
        int[] arrayDezMil = quickSort.makeRandomArray(10000);

        // Arrays quase ordenados e totalmente ordenados
        int[] arrayCemOrdenado = quickSort.makeOrderedArray(100);
        int[] arrayMilOrdenado = quickSort.makeOrderedArray(1000);
        int[] arrayDezMilOrdenado = quickSort.makeOrderedArray(10000);

        int[] arrayCemQuaseOrdenado = quickSort.makeNearlyOrderedArray(100);
        int[] arrayMilQuaseOrdenado = quickSort.makeNearlyOrderedArray(1000);
        int[] arrayDezMilQuaseOrdenado = quickSort.makeNearlyOrderedArray(10000);

        // Executando e comparando tempos de execução para arrays aleatórios
        System.out.println("Teste em arrays aleatórios:");
        testarEstrategias(quickSort, arrayCem, "100 elementos");
        testarEstrategias(quickSort, arrayMil, "1000 elementos");
        testarEstrategias(quickSort, arrayDezMil, "10000 elementos");

        // Executando e comparando tempos de execução para arrays ordenados
        System.out.println("\nTeste em arrays ordenados:");
        testarEstrategias(quickSort, arrayCemOrdenado, "100 elementos ordenados");
        testarEstrategias(quickSort, arrayMilOrdenado, "1000 elementos ordenados");
        testarEstrategias(quickSort, arrayDezMilOrdenado, "10000 elementos ordenados");

        // Executando e comparando tempos de execução para arrays quase ordenados
        System.out.println("\nTeste em arrays quase ordenados:");
        testarEstrategias(quickSort, arrayCemQuaseOrdenado, "100 elementos quase ordenados");
        testarEstrategias(quickSort, arrayMilQuaseOrdenado, "1000 elementos quase ordenados");
        testarEstrategias(quickSort, arrayDezMilQuaseOrdenado, "10000 elementos quase ordenados");

    }
}
