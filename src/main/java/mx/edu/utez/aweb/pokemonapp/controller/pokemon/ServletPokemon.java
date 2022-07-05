package mx.edu.utez.aweb.pokemonapp.controller.pokemon;

import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.service.pokemon.ServicePokemon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletPokemon",
        urlPatterns = {
                "/get-pokemons",
                "/add-pokemon",
                "/create-pokemon",
                "/update-pokemon",
                "/get-pokemon"
        })
public class ServletPokemon extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPokemon");
    String action;
    String urlRedirect = "/get-pokemons";
    ServicePokemon servicePokemon = new ServicePokemon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO, "Path-> " + action);
        switch (action) {
            case "/get-pokemons":
                List<BeanPokemon> pokemons = servicePokemon.getAll();
                System.out.println(pokemons.size());
                request.setAttribute("pokemons", pokemons);
                urlRedirect = "/views/pokemon/index.jsp";
                break;
            case "/create-pokemon":
                urlRedirect = "/views/pokemon/create.jsp";
                break;
            default:
                request.setAttribute("pokemons", servicePokemon.getAll());
                urlRedirect = "/get-pokemons";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
}
