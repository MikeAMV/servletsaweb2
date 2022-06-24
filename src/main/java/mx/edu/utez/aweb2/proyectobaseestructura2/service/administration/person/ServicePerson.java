package mx.edu.utez.aweb2.proyectobaseestructura2.service.administration.person;

import mx.edu.utez.aweb2.proyectobaseestructura2.model.administration.person.BeanPerson;
import mx.edu.utez.aweb2.proyectobaseestructura2.utils.ResultAction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicePerson {
    Logger logger = Logger.getLogger("ServicePerson");
    public ResultAction<BeanPerson> savePerson(BeanPerson person){
        // llamamos a dao Logica de Negocio
        ResultAction<BeanPerson> resultPerson = new ResultAction<BeanPerson>(person);
        resultPerson.setMessage("Regitro OK");
        resultPerson.setResult(true);
        resultPerson.setType("success");
        logger.log(Level.INFO,"Pasamos al service :D ");
        return resultPerson;
    }

    public List<BeanPerson> getPersons() {
        List<BeanPerson> listPersons = new ArrayList<BeanPerson>();
        listPersons.add(new BeanPerson(1,"Jose","Narváez", 1.70, new Date()));
        listPersons.add(new BeanPerson(2,"Christian","Figueroa", 1.70, new Date()));
        listPersons.add(new BeanPerson(3,"Manuel","Juarez", 1.70, new Date()));
        return listPersons;
    }

    public BeanPerson getPerson(int idPerson) {
        if(idPerson>0){
            return new BeanPerson(1,"José","Narváez",170,new Date());
        }else{
            return new BeanPerson();
        }

    }
    public ResultAction<BeanPerson> updatePerson(BeanPerson person){
        // Logica de Negocio y llamamos a dao
        ResultAction<BeanPerson> resultPerson = new ResultAction<BeanPerson>(person);
        resultPerson.setMessage("Actualización OK");
        resultPerson.setResult(true);
        resultPerson.setType("success");
        logger.log(Level.INFO,"Pasamos al service :D ");
        return resultPerson;
    }

}
