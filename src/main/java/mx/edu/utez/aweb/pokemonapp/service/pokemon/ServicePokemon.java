package mx.edu.utez.aweb.pokemonapp.service.pokemon;

import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.model.pokemon.DaoPokemon;

import java.util.List;

public class ServicePokemon {
    DaoPokemon daoPokemon = new DaoPokemon();

    public List<BeanPokemon> getAll(){
        return daoPokemon.findAll();
    }
}
