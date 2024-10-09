package tps.tp2.ex01_ClasseJAVA;

import java.util.List;

public class PokemonSearch {
    public static Pokemon searchPokemonId(List<Pokemon> pokemons, int id) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null;
    }
}
