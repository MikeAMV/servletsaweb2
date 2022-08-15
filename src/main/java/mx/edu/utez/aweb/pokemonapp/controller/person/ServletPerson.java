package mx.edu.utez.aweb.pokemonapp.controller.person;

import mx.edu.utez.aweb.pokemonapp.controller.pokemon.ServletPokemon;
import mx.edu.utez.aweb.pokemonapp.model.person.BeanPerson;
import mx.edu.utez.aweb.pokemonapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokemonapp.service.person.ServicePerson;
import mx.edu.utez.aweb.pokemonapp.utils.ResultAction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletPokemon",
        urlPatterns = {
                "/get-persons",
                "/add-person",
                "/create-person",
                "/save-person",
                "/get-person",
                "/delete-person"
        })

public class ServletPerson extends HttpServlet {
        Logger logger = Logger.getLogger("ServletPerson");
        String action;
        String urlRedirect = "/get-persons";
        ServicePerson servicePerson = new ServicePerson();

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
                action = request.getServletPath();
                logger.log(Level.INFO, "Path-> " + action);
                switch (action) {
                        case "/get-persons":
                                List<BeanPerson> persons = servicePerson.getAll();
                                System.out.println(persons.size());
                                request.setAttribute("persons", persons);
                                urlRedirect = "/views/person/index.jsp";
                                break;
                        case "/create-person":
                                urlRedirect = "/views/person/create.jsp";
                                break;
                        case "/get-person":
                                String id = request.getParameter("id");
                                id = (id == null) ? "0" : id;
                                try {
                                        BeanPerson person = servicePerson.getPerson(Integer.parseInt(id));
                                        System.out.println(person);
                                        request.setAttribute("person", person);
                                        urlRedirect = "/views/person/update.jsp";
                                } catch (Exception e) {
                                        urlRedirect = "/get-persons";
                                }
                                break;
                        default:
                                request.setAttribute("person", servicePerson.getAll());
                                urlRedirect = "/get-persons";
                                break;
                }
                request.getRequestDispatcher(urlRedirect).forward(request, response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/html");
                action = request.getServletPath();
                switch (action) {
                        case "/add-person":
                                try {
                                        String name = request.getParameter("name");
                                        String surname = request.getParameter("surname");
                                        String curp = request.getParameter("curp");
                                        String birthday = request.getParameter("birthday");

                                        BeanPerson person = new BeanPerson();
                                        person.setName(name);
                                        person.setSurname(surname);
                                        person.setCurp(curp);
                                        person.setBirthday(birthday);
                                        System.out.println(person);
                                        ResultAction result = servicePerson.save(person);
                                        urlRedirect = "/get-persons?result=" +
                                                result.isResult() + "&message=" +
                                                URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())
                                                + "&status=" + result.getStatus();
                                } catch (Exception e) {
                                        Logger.getLogger(ServletPokemon.class.getName()).log(Level.SEVERE,
                                                "Error addPerson method" + e.getMessage());
                                        urlRedirect = "/get-persons?result=false&message=" +
                                                URLEncoder.encode("Error al registrar la persona",
                                                        StandardCharsets.UTF_8.name())
                                                + "&status=400";
                                }
                                break;
                        case "/save-person":
                                String name2 = request.getParameter("name");
                                String surname2 = request.getParameter("surname");
                                String curp2 = request.getParameter("curp");
                                String birthday2 = request.getParameter("birthday");
                                String id2 = request.getParameter("id");
                                BeanPerson person2 = new BeanPerson();
                                person2.setId(Integer.parseInt(id2));
                                person2.setName(name2);
                                person2.setSurname(surname2);
                                person2.setCurp(curp2);
                                person2.setBirthday(birthday2);
                                ResultAction result2 = servicePerson.update(person2);
                                urlRedirect = "/get-persons?result=" +
                                        result2.isResult() + "&message=" +
                                        URLEncoder.encode(result2.getMessage(), StandardCharsets.UTF_8.name())
                                        + "&status=" + result2.getStatus();
                                break;
                        case "/delete-person":
                                String idPerson = request.getParameter("id");
                                ResultAction deleteResult = servicePerson.delete(idPerson);
                                urlRedirect = "/get-persons?result=" +
                                        deleteResult.isResult() + "&message=" +
                                        URLEncoder.encode(deleteResult.getMessage(), StandardCharsets.UTF_8.name())
                                        + "&status=" + deleteResult.getStatus();
                                break;
                        default:
                                urlRedirect = "/get-persons";
                                break;
                }
                response.sendRedirect(request.getContextPath() + urlRedirect);
        }

}
