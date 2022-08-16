package mx.edu.utez.aweb.pokemonapp.service.person;

import mx.edu.utez.aweb.pokemonapp.model.person.BeanPerson;
import mx.edu.utez.aweb.pokemonapp.model.person.DaoPerson;
import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.utils.ResultAction;

import java.util.List;

//MORONI RODRÍGUEZ BUENO
public class ServicePerson {
    DaoPerson daoPerson = new DaoPerson();

    public List<BeanPerson> getAll(){
        return daoPerson.findAll();
    }

    public ResultAction save(BeanPerson person){
        ResultAction result = new ResultAction();
        if (daoPerson.save(person)){
            result.setResult(true);
            result.setMessage("Persona registrada correctamente");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public BeanPerson getPerson(int id){
        return daoPerson.findOne(id);
    }

    public ResultAction update(BeanPerson person){
        ResultAction result = new ResultAction();
        if (daoPerson.update(person)){
            result.setStatus(200);
            result.setResult(true);
            result.setMessage("Persona actualizada correctamente");
        }else{
            result.setStatus(400);
            result.setResult(false);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }

    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try{
            if (daoPerson.delete(Integer.parseInt(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Persona eliminada correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Ocurrió un error");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(false);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }
}
