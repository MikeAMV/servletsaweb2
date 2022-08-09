package mx.edu.utez.aweb.pokemonapp.service.auth;

import mx.edu.utez.aweb.pokemonapp.model.auth.BeanUser;
import mx.edu.utez.aweb.pokemonapp.model.auth.DaoAuth;
import mx.edu.utez.aweb.pokemonapp.utils.EmailService;

public class AuthService {

    DaoAuth auth = new DaoAuth();

    public BeanUser login(String username, String password) {
        return auth.validate(username, password);
    }

    public void sendEmail(String username){
        if (auth.verifyUser(username)){
            new EmailService().sendEmail(username);
        }
    }
}
