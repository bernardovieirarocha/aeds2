package tps.tp2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import static tps.tp2.ReadCSV.readCSV;

public class Pokemon {

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
                this.isLegendary = Boolean.parseBoolean(linhaCSV[10]);
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

    public String toString() {
        SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String captureDateFormatted = (captureDate != null) ? outputDateFormat.format(captureDate) : "Data não disponível";

        // [#id -> name: description - [types] - [abilities] - weight - height - captureRate - isLegendary - generation] - captureDate].
        return "[#" + id + " -> " + name + ": " + description + " - " + types + " - " + abilities + " - " + weight + "kg - " + height + "m - " + captureRate + "% - " + isLegendary + " - " + generation + " gen] - " + captureDateFormatted;
    }

    public static void main(String[] args) {
        List<Pokemon> pokemons = readCSV("src/tps/tp2/pokemon.csv");
        List<Pokemon> pokedex = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()){
            String numeroPokemonLeitura = sc.nextLine();

            if (numeroPokemonLeitura.equals("FIM")){
                break;
            }
            if (Integer.parseInt(numeroPokemonLeitura) == -1) {
                break;
            }


            Pokemon pokemonEncontrado = PokemonSearch.searchPokemonId(pokemons, Integer.parseInt(numeroPokemonLeitura));
            pokedex.add(pokemonEncontrado);
            sc.nextLine();

            if (pokemonEncontrado == null) {
                System.out.println("Pokemon nao encontrado");
            }

        }

        for (Pokemon pokemon : pokedex) {
            System.out.println(pokemon);
        }

    }
}

