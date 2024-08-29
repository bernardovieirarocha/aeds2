import java.util.Scanner;

@SuppressWarnings("WrongPackageStatement")
public class combinador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Check if there's another line to read
            if (!scanner.hasNextLine()) {
                break;
            }
            String str1 = scanner.nextLine();

            // Check if there's another line to read
            if (!scanner.hasNextLine()) {
                break;
            }
            String str2 = scanner.nextLine();

            // Check if the user provided invalid or empty values.
            if (str1.isEmpty() && str2.isEmpty()) {
                break;
            }

            StringBuilder combined = getCombined(str1, str2);
            System.out.println(combined.toString());
        }

        scanner.close();
    }

    private static StringBuilder getCombined(String str1, String str2) {
        int i = 0, j = 0;
        // Loops that alternate between printing characters from the first and second string.
        StringBuilder combined = new StringBuilder();
        while (i < str1.length() || j < str2.length()) {
            // If not at the end of the string, print the character.
            if (i < str1.length()) {
                combined.append(str1.charAt(i));
                i++;
            }
            // If not at the end of the string, print the character.
            if (j < str2.length()) {
                combined.append(str2.charAt(j));
                j++;
            }
        }
        return combined;
    }
}
