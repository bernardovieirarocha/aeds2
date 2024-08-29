/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB01_01 - AquecimentoIterativo (AquecimentoIterativoJava)
*/
import java.util.Scanner;
@SuppressWarnings("WrongPackageStatement")
class AquecimentoIterativo {

    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
        //  Character.isUpperCase(c);
    }

    public static int countUpperChar(String str) {
        int count = 0;
        for (int i = 0 ; i < str.length() ; ++i) {
            if (isUpperCase(str.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isFIM(String string) {
        return string.length() == 3 && string.charAt(0) == 'F' && string.charAt(1) == 'I' && string.charAt(2) == 'M';
    }

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int quantasEntradas = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            entrada[quantasEntradas] = scanner.nextLine();
        } while (!isFIM(entrada[quantasEntradas++]));
        quantasEntradas--; // Tirar o FIM

        for(int i = 0; i < quantasEntradas; i++){
            System.out.printf("%d\n", countUpperChar(entrada[i]));
        }

        scanner.close();
    }
}