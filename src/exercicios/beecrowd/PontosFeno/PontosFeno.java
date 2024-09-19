package exercicios.beecrowd.PontosFeno;

import java.util.Scanner;

class HayWords {
    public String word;
    public int points;

    public HayWords( String word, int points) {
        this.word = word;
        this.points = points;
    }
}

public class PontosFeno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int qtdHayPoints = sc.nextInt();
        int qtdDescriptions = sc.nextInt();
        // Consumir o \n
        sc.nextLine();

        HayWords[] hayWords = new HayWords[qtdHayPoints];

        for (int i = 0 ; i < qtdHayPoints; i++){
            String[] line = sc.nextLine().split(" ");
            hayWords[i] = new HayWords(line[0],Integer.parseInt(line[1]));
        }

        for (int i =0; i < qtdDescriptions ; ++i) {
            int points = 0;
            String allText = sc.nextLine();
            while (!allText.equals(".")) {
                String[] words = allText.split(" ");
                for (String word : words) {
                    for (HayWords hayWord : hayWords) {
                        if (hayWord.word.equals(word)) {
                            points += hayWord.points;
                        }
                    }
                }
                allText = sc.nextLine();
            }
            System.out.println(points);
        }

        sc.close();
    }
}
