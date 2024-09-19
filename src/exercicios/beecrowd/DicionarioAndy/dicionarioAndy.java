    package exercicios.beecrowd.DicionarioAndy;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Scanner;

    public class dicionarioAndy {

        public static List<String> extrairPalavrasSetenca(String input) {
           String[] arrayPalavras = input.split("[^a-zA-Z]+");
           List<String> words = new ArrayList<>();

           for (String word : arrayPalavras) {
               if (!word.isEmpty()) {
                   words.add(word);
               }
           }
           return words;
        }

        public static void manualLexSort(List<String> words) {
            // Using Selection Sort algorithm
            for (int i = 0; i < words.size(); i++) {
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(i).compareTo(words.get(j)) > 0) {
                        String temp = words.get(i);
                        words.set(i, words.get(j));
                        words.set(j, temp);
                    }
                }
            }
        }

        public static void removeRepeatingWords(List<String> words) {
            for (int i = 0; i < words.size(); i++) {
                for (int j = i + 1; j < words.size(); j++) {
                    if (words.get(i).equals(words.get(j))) {
                        words.remove(j);
                        j--;
                    }
                }
            }
        }

        public static void main(String[] args) {
            StringBuilder allText = new StringBuilder();

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                if (line.equals("0")) {
                    break;
                }
                allText.append(line).append(" ");
            }

            List<String> output = extrairPalavrasSetenca(allText.toString().toLowerCase());

            Collections.sort(output);
            removeRepeatingWords(output);

            for (String word : output) {
                System.out.println(word);
            }

            sc.close();
        }
    }
