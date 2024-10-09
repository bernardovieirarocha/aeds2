package tps.tp2.ex01_ClasseJAVA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ReadCSV {

    // Funcao para ler o arquivo CSV e retornar uma lista de Pokemons
    public static List<Pokemon> readCSV(String path) {
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader( new FileReader(path) );
            br.readLine();
            String linha;
            while ((linha = br.readLine()) != null) {
                linha = formatarLinha(linha);
                String[] argumentos_poke = linha.split(";");
                Pokemon pokemon = new Pokemon(argumentos_poke);
                pokemons.add(pokemon);
            }

        } catch (IOException e) {
            pokemons = null;
            throw new RuntimeException(e);
        }

        return pokemons;
    }
    public static String formatarLinha(String linha) {
        char[] formattedArray = linha.toCharArray();
        boolean naLista = false;
        for (int i = 0 ; i < formattedArray.length; i++){
            if (!naLista && formattedArray[i] == ',') {
                formattedArray[i] = ';';
            } else if (formattedArray[i] == '"') {
                naLista = !naLista;
            }
        }
        return new String(formattedArray);
    }

}