package tps.tp4.ex01_AB;

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

class No {
    public Pokemon pokemon;
    public No esq;
    public No dir;

    public No(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.esq = null;
        this.dir = null;
    }

    public No(Pokemon pokemon, No esq, No dir) {
        this.pokemon = pokemon;
        this.esq = esq;
        this.dir = dir;
    }

    public void mostrar() {
        System.out.println(pokemon);
    }


}

class AB_Pokemons {
    private No raiz;

    public AB_Pokemons() {
        this.raiz = null;
    }

    public void inserir(Pokemon pokemon) {
        raiz = inserir(pokemon, raiz);
    }

    private No inserir(Pokemon pokemon, No no) {
        if (no == null) {
            no = new No(pokemon);
        } else if (pokemon.getName().compareTo(no.pokemon.getName()) < 0) {
            no.esq = inserir(pokemon, no.esq);
        } else if (pokemon.getName().compareTo(no.pokemon.getName()) > 0) {
            no.dir = inserir(pokemon, no.dir);
        }
        return no;
    }


    public void mostrar() {
        mostrar(raiz);
    }

    private void mostrar(No no) {
        if (no != null) {
            mostrar(no.esq);
            no.mostrar();
            mostrar(no.dir);
        }
    }

    // Implemente um metodo de pesquisa que procura se alguns registros estao na arvore e mostra seus caminhos de pesquisa
    // Exemplo:
    // Mew
    // =>raiz dir esq dir esq dir esq SIM
    // FIM
    public void pesquisar(String nome) {
        StringBuilder caminho = new StringBuilder("raiz");
        boolean encontrado = pesquisarRec(raiz, nome, caminho);
        System.out.println("=>" + caminho.toString() + (encontrado ? " SIM" : " NAO"));
    }

    private boolean pesquisarRec(No no, String nome, StringBuilder caminho) {
        if (no == null) {
            return false; // Se o nó for nulo, o elemento não está na árvore.
        }

        if (no.pokemon.getName().equals(nome)) {
            return true; // Elemento encontrado.
        } else if (nome.compareTo(no.pokemon.getName()) < 0) {
            caminho.append(" esq"); // Vá para a esquerda.
            return pesquisarRec(no.esq, nome, caminho);
        } else {
            caminho.append(" dir"); // Vá para a direita.
            return pesquisarRec(no.dir, nome, caminho);
        }
    }

}


public class ex01_AB {
    public static void main(String[] args) {
        List<Pokemon> pokemons = ReadCSV.readCSV("/tmp/pokemon.csv");
        AB_Pokemons AB_Poke = new AB_Pokemons();

        Scanner sc = new Scanner(System.in);
        String string_entrada;
        int id_entrada;

        while (!(string_entrada = sc.nextLine()).equals("FIM")) {
            id_entrada = Integer.parseInt(string_entrada);
            Pokemon foundPokemon = PokemonSearch.searchPokemonIdSequential(pokemons, id_entrada);
            if (foundPokemon != null) {
                AB_Poke.inserir(foundPokemon);
            } else {
                System.out.println("Pokemon ID not found: " + id_entrada);
            }
        }

        MyLog.startTimer();

        while (!(string_entrada = sc.nextLine()).equals("FIM")) {
            String nomePoke = string_entrada;
            System.out.println(nomePoke);
            AB_Poke.pesquisar(nomePoke);
        }

        MyLog.endTimer();

        MyLog.createLog("853733", "arvoreBinaria");

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



class MyLog {

    // Variaveis "globais"
    private static long startTime = 0;
    private static long endTime = 0;
    private static int totalComp = 0;
    private static int totalMove = 0;

    // Função para regular comparações
    static void countComp(int x){
        totalComp += x;
    }

    // Função para regular movimentações
    static void countMove(int x){
        totalMove += x;
    }

    // Função para começar o cronometro
    public static void startTimer() {
        startTime = System.currentTimeMillis();
    }

    // Função para encerrar o cronometro
    public static void endTimer() {
        endTime = System.currentTimeMillis();
    }

    // Função para calcular o tempo gasto
    static long getTime() {
        return endTime - startTime;
    }

    // Função para criar o txt contendo as informações de comparações e tempo
    public static void createLog(final String matricula, final String metodo) {
        try {
            FileWriter logArq = new FileWriter(matricula + "_" + metodo +".txt");
            logArq.write(matricula + "\t" + getTime() + "\t" + totalComp + "\t" + totalMove + "\n");
            logArq.close();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao criar txt");
        }
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

