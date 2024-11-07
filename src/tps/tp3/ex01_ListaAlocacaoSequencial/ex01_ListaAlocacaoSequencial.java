package tps.tp3.ex01_ListaAlocacaoSequencial;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class ListaPokemons {
    private Pokemon[] pokemons;
    private int n;

    public ListaPokemons(int qtd) {
        pokemons = new Pokemon[qtd];
        n = 0;
    }

    public int getN() {
        return this.n;
    }

    public Pokemon[] getPokemons() {
        return this.pokemons;
    }

    public Pokemon getPokemon(int pos) {
        return this.pokemons[pos];
    }

    public void inserirInicio(Pokemon pokemon) {
        if (this.n >= this.pokemons.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        for (int i = this.n; i > 0; i--) {
            this.pokemons[i] = this.pokemons[i - 1];
        }
        this.pokemons[0] = pokemon;
        this.n++;
    }

    public void inserir(Pokemon pokemon, int pos) {
        if (this.n >= this.pokemons.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        if (pos < 0 || pos > this.n) {
            throw new ArrayIndexOutOfBoundsException("Posição inválida");
        }

        // Desloca os elementos para a direita para abrir espaço para o novo elemento
        for (int i = this.n; i > pos; i--) {
            this.pokemons[i] = this.pokemons[i - 1];
        }
        this.pokemons[pos] = pokemon;
        this.n++;
    }

    public void inserirFim(Pokemon pokemon) {
        if (this.n >= this.pokemons.length) {
            throw new ArrayStoreException("Lista cheia");
        }
        this.pokemons[this.n] = pokemon;
        this.n++;
    }

    public Pokemon removerInicio() {
        if (this.n == 0 ){
            throw new ArrayStoreException("Lista Vazia");
        }
        Pokemon resp = this.pokemons[0];
        for (int i = 0; i < n; i++) {
            this.pokemons[i] = this.pokemons[i + 1];
        }
        this.pokemons[n - 1] = null; // Remover a referencia ao Pokemon removido
        this.n--;
        return resp;
    }

    public Pokemon remover(int pos) {
        if (n == 0 ){
            throw new ArrayStoreException("Lista Vazia");
        }
        Pokemon resp = this.pokemons[pos];
        for (int i = pos ; i < n ; i++){
            this.pokemons[i] = this.pokemons[i+1];
        }
        this.pokemons[n - 1] = null; // Remover a referencia ao Pokemon removido
        this.n--;
        return resp;
    }

    public Pokemon removerFim() {
        if (n == 0) {
            throw new ArrayStoreException("Lista Vazia");
        }
        this.n--;
        Pokemon resp = this.pokemons[n];
        this.pokemons[n] = null; // Remover a referencia ao Pokemon removido
        return resp;
    }


}

public class ex01_ListaAlocacaoSequencial {
    public static void main(String[] args) {
        List<Pokemon> pokemons = ReadCSV.readCSV("/tmp/pokemon.csv");
        ListaPokemons listaPokemons = new ListaPokemons(801);

        Scanner sc = new Scanner(System.in);
        String string_entrada;
        int id_entrada;

        while (!(string_entrada = sc.nextLine()).equals("FIM")) {
            id_entrada = Integer.parseInt(string_entrada);
            Pokemon foundPokemon = PokemonSearch.searchPokemonIdSequential(pokemons, id_entrada);
            if (foundPokemon != null) {
                listaPokemons.inserirFim(foundPokemon);
            } else {
                System.out.println("Pokemon ID not found: " + id_entrada);
            }
        }
        int qtd_operacoes = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < qtd_operacoes; i++) {
            String[] operacao = sc.nextLine().split(" ");
            switch
            (operacao[0]) {
                case "II":
                    listaPokemons.inserirInicio(PokemonSearch.searchPokemonIdSequential(pokemons, Integer.parseInt(operacao[1])));
                    break;
                case "IF":
                    listaPokemons.inserirFim(PokemonSearch.searchPokemonIdSequential(pokemons, Integer.parseInt(operacao[1])));
                    break;
                case "I*":
                    listaPokemons.inserir(PokemonSearch.searchPokemonIdSequential(pokemons, Integer.parseInt(operacao[2])), Integer.parseInt(operacao[1]));
                    break;
                case "RI":
                    // Deve-se imprimir o pokemon removido
                    System.out.println("(R) "+ listaPokemons.removerInicio().getName());
                     break;
                case "RF":
                    // Deve-se imprimir o pokemon removido
                    System.out.println("(R) "+ listaPokemons.removerFim().getName());
                    break;
                case "R*":
                    // Deve-se imprimir o pokemon removido
                    System.out.println("(R) "+ listaPokemons.remover(Integer.parseInt(operacao[1])).getName());
                    break;
            }
        }


        for (int i = 0; i < listaPokemons.getN(); i++) {
            System.out.println("["+ i + "] " + listaPokemons.getPokemon(i));
        }
    }
}


class Pokemon {

    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    // Construtor padrao para inicializar os atributos
    public Pokemon(){
        this.id = 0;
        this.generation = 0;
        this.name = "";
        this.description = "";
        this.types = new ArrayList<>();
        this.abilities = new ArrayList<>();
        this.weight = 0;
        this.height = 0;
        this.captureRate = 0;
        this.isLegendary = false;
        this.captureDate = new Date();
    }

    // Construtor com parametros para inicializar os atributos
    public Pokemon(int id, int generation, String name, String description, ArrayList<String> types, ArrayList<String> abilities, double weight, double height, int captureRate, boolean isLegendary, Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;
    }

    public static String formatAbilities(String abilities) {
        return abilities.replace("[", "").replace("]", "").replace("\"", "");
    }

    public Pokemon(String[] linhaCSV ){
        for (int i = 0; i < linhaCSV.length; i++) {
            if (linhaCSV[i].isEmpty()) {
                linhaCSV[i] = null;
            }

            this.id = Integer.parseInt(linhaCSV[0] != null ? linhaCSV[0] : "0");
            this.generation = Integer.parseInt(linhaCSV[1]);
            this.name = linhaCSV[2];
            this.description = linhaCSV[3];

            this.types = new ArrayList<String>();
            // Colocar as aspas para impressao
            this.types.add("'" + linhaCSV[4] + "'");
            if (linhaCSV[5] != null) {
                this.types.add("'" + linhaCSV[5] + "'");
            }

            // Formatar as strings de habilidades
            this.abilities = new ArrayList<String>();
            linhaCSV[6] = formatAbilities(linhaCSV[6]);
            String [] abilities = linhaCSV[6].split(",");
            for (String ability : abilities) {
                this.abilities.add(ability);
            }

            if (linhaCSV[7] == null || linhaCSV[7].isEmpty()) {
                this.weight = 0.0;
            } else {
                this.weight = Double.parseDouble(linhaCSV[7]);
            }

            if (linhaCSV[8] == null || linhaCSV[8].isEmpty()) {
                this.height = 0.0;
            } else {
                this.height = Double.parseDouble(linhaCSV[8]);
            }

            if (linhaCSV[9] == null || linhaCSV[9].isEmpty()) {
                this.captureRate = 0;
            } else {
                this.captureRate = Integer.parseInt(linhaCSV[9]);
            }

            if (linhaCSV[10] == null || linhaCSV[10].isEmpty()) {
                this.isLegendary = false;
            } else {
                this.isLegendary = (linhaCSV[10].equals("1"));

            }

            if (linhaCSV[11] == null || linhaCSV[11].isEmpty()) {
                this.captureDate = null;
            } else {
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.captureDate = inputDateFormat.parse(linhaCSV[11]);
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }

        }
    }

    // Metodos de getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGeneration() {
        return generation;
    }
    public void setGeneration(int generation) {
        this.generation = generation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public ArrayList<String> getTypes() {
        return types;
    }
    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }
    public ArrayList<String> getAbilities() {
        return abilities;
    }
    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public int getCaptureRate() {
        return captureRate;
    }
    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }
    public boolean isLegendary() {
        return isLegendary;
    }
    public void setLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }
    public Date getCaptureDate() {
        return captureDate;
    }
    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    // Metodo clone para copiar o objeto Pokemon
    @Override
    public Pokemon clone() {
        try {
            Pokemon cloned = (Pokemon) super.clone();
            // Clonando arrays e objetos mutáveis para garantir que o clone seja independente
            cloned.types = new ArrayList<>(this.types);
            cloned.abilities = new ArrayList<>(this.abilities);
            cloned.captureDate = (Date) this.captureDate.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            // Como estamos implementando Cloneable, não deve ocorrer essa exceção
            throw new RuntimeException("Erro ao clonar o objeto Pokemon", e);
        }
    }

    // Metodo para imprimir todos atributos da instancia apenas chamando ela no println
    public String toString() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String captureDateFormatted = (captureDate != null) ? outputDateFormat.format(captureDate) : "Data não disponível";

        // [#id -> name: description - [types] - [abilities] - weight - height - captureRate - isLegendary - generation] - captureDate].
        return "[#" + id + " -> " + name + ": " + description + " - " + types + " - " + abilities + " - " + weight + "kg - " + height + "m - " + captureRate + "% - " + isLegendary + " - " + generation + " gen] - " + captureDateFormatted;
    }

}


class ReadCSV {

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


class PokemonSearch {

    // Funcao estatica que busca um Pokemon pelo ID
    public static Pokemon searchPokemonIdSequential(List<Pokemon> pokemons, int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }


}

