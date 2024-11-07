package exercicios.estruturas.matrizFlexivel;

import exercicios.estruturas.matrizFlexivel.*;

import java.util.Arrays;

public class exercicioMax {

    public static void setMatrixWithValues(Matriz a) {
        for (int i = 0; i < a.getLinha(); i++) {
            for (int j = 0; j < a.getColuna(); j++) {
                a.set(i, j, i + j);
            }
        }
    }

    public static void main(String[] args) {
        Matriz a = new Matriz(3, 3);
        Matriz b = new Matriz(3, 3);
        setMatrixWithValues(a);
        setMatrixWithValues(b);
        System.out.println("Matriz A:");
        a.mostrar();
        System.out.println("Matriz B:");
        b.mostrar();
        System.out.println("Matriz C:");
        Matriz c = Matriz.soma(a, b);

        if (c != null) {
            c.mostrar();
            System.out.println(Arrays.toString(c.getDiagonalPrincipal()));
            System.out.println(Arrays.toString(c.getDiagonalSecundaria()));
        }
    }

}
