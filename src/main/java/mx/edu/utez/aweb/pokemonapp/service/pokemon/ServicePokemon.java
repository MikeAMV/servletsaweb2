package mx.edu.utez.aweb.pokemonapp.service.pokemon;

import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.model.pokemon.DaoPokemon;
import mx.edu.utez.aweb.pokemonapp.utils.ResultAction;

import java.util.List;

public class ServicePokemon {
    DaoPokemon daoPokemon = new DaoPokemon();

    public List<BeanPokemon> getAll(){
        return daoPokemon.findAll();
    }

    public ResultAction save(BeanPokemon pokemon){
        ResultAction result = new ResultAction();
        if (daoPokemon.save(pokemon)){
            result.setResult(true);
            result.setMessage("Pokemon registrado correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public BeanPokemon getPokemon(Long id){
        return daoPokemon.findOne(id);
    }

    public ResultAction update(BeanPokemon pokemon){
        ResultAction result = new ResultAction();
        if (daoPokemon.update(pokemon)){
            result.setStatus(200);
            result.setResult(false);
            result.setMessage("Pokemon actualizado correctamente");
        }else{
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }

    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try{
            if (daoPokemon.delete(Long.parseLong(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Pokemon eliminado correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Ocurrió un error");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }
}
