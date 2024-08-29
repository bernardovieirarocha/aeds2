/**
 * Bernardo Vieira Rocha - 853733
 * Ciencia da Computacao PUC-MINAS
 * LAB01_01 - AquecimentoRecursivo (AquecimentoRecursivoJava)
*/
import java.util.Scanner;

@SuppressWarnings("WrongPackageStatement")
public class AquecimentoRecursivo {
    
    public static boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
        //  Character.isUpperCase(c);
    }

    public static int countUpperChar2(String str, int count, int upper) {
        // Porque o pedro faz recursao de forma diferente?? 
        if (count == str.length()) {
            return upper;
        }
        if (isUpperCase(str.charAt(count))) {
            upper++;
        }
        return countUpperChar2(str, count + 1, upper);
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
        } while (isFIM(entrada[quantasEntradas++]) == false);
        quantasEntradas--; // Tirar o FIM

        for(int i = 0; i < quantasEntradas; i++){
            System.out.printf("%d\n", countUpperChar2(entrada[i], 0, 0));
        }

        scanner.close();
    }
}
