import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Amigo {
    String nome;
    boolean ehAmigo;

    public Amigo(String nome, boolean ehAmigo) {
        this.nome = nome;
        this.ehAmigo = ehAmigo;
    }
}

public class AmigosHabay {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Amigo> amigosYes = new ArrayList<>();
        ArrayList<Amigo> amigosNo = new ArrayList<>();
        Amigo vencedor = null;

        while (true) {
            String nome = sc.next();
            if (nome.equals("FIM")) {
                break;
            }
            boolean ehAmigo = sc.next().equals("YES");

            // Verificar duplicidade para "YES"
            if (ehAmigo && amigosYes.stream().noneMatch(amigo -> amigo.nome.equals(nome))) {
                amigosYes.add(new Amigo(nome, true));

                // Atualizar vencedor somente se o novo nome for mais curto ou se ainda não há um vencedor
                if (vencedor == null ||
                        nome.length() > vencedor.nome.length() ||
                        (nome.length() == vencedor.nome.length() && amigosYes.indexOf(new Amigo(nome, true)) < amigosYes.indexOf(vencedor))) {
                    vencedor = new Amigo(nome, true);
                }
            } else if (!ehAmigo) {
                amigosNo.add(new Amigo(nome, false));
            }
        }

        // Ordenar a lista "YES" e "NO" em ordem alfabética para exibição
        amigosYes.sort(Comparator.comparing(amigo -> amigo.nome));
        amigosNo.sort(Comparator.comparing(amigo -> amigo.nome));

        // Imprimir os amigos "YES" primeiro
        for (Amigo amigo : amigosYes) {
            System.out.println(amigo.nome);
        }

        // Imprimir os amigos "NO"
        for (Amigo amigo : amigosNo) {
            System.out.println(amigo.nome);
        }

        System.out.println();

        // Imprimir o vencedor, que já foi determinado
        if (vencedor != null) {
            System.out.println("Amigo do Habay:");
            System.out.println(vencedor.nome);
        }
    }
}
