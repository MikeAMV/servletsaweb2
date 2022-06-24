package mx.edu.utez.aweb2.proyectobaseestructura2.controller.administration.person;

import mx.edu.utez.aweb2.proyectobaseestructura2.model.administration.person.BeanPerson;
import mx.edu.utez.aweb2.proyectobaseestructura2.service.administration.person.ServicePerson;
import mx.edu.utez.aweb2.proyectobaseestructura2.utils.ResultAction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(
        name = "ServletPerson",
        urlPatterns = {
                "/getPersons",
                "/savePerson",
                "/createPerson",
                "/getPerson",
                "/updatePerson"}
)
public class ServletPerson extends HttpServlet {

    Logger logger = Logger.getLogger("ServletPerson");
    String action;
    String urlRedirect = "/getPersons";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        logger.log(Level.INFO,"GET: "+action);
        switch (action){
            case "/createPerson":
                urlRedirect="/WEB-INF/view/administration/person/createPerson.jsp";
                break;
            case "/getPersons":
                List<BeanPerson> listPersons = new ServicePerson().getPersons();
                request.setAttribute("listPersons",listPersons);
                urlRedirect="/WEB-INF/view/administration/person/homePerson.jsp";
                break;
            case "/getPerson":
                String idPersonString = request.getParameter("id")!=null?request.getParameter("id"):"0";
                try{
                    int idPerson = Integer.parseInt(idPersonString);
                    BeanPerson person = new ServicePerson().getPerson(idPerson);
                    request.setAttribute("person",person);
                    request.setAttribute("agePerson",new SimpleDateFormat("yyyy-MM-dd").format(person.getAge()));
                    urlRedirect="/WEB-INF/view/administration/person/updatePerson.jsp";
                }catch (Exception ex){
                    urlRedirect="/getPersons";
                }
                break;
            default:
                List<BeanPerson> listPersons1 = new ServicePerson().getPersons();
                request.setAttribute("listPersons",listPersons1);
                urlRedirect="/getPersons";
                break;
        }

        request.getRequestDispatcher(urlRedirect).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType( "text/html" );
        ServicePerson servicePerson = new ServicePerson();
        action = request.getServletPath(); // decidir si le quitamos la diagonal
        logger.log(Level.INFO,"POST: "+action);
        switch (action){
            case "/savePerson":
                SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String name = request.getParameter("name")!=null ? request.getParameter("name"):"";
                String lastName = request.getParameter("lastname")!=null?request.getParameter("lastname"):"";
                String heightString = request.getParameter("height")!=null?request.getParameter("height"):"";
                String ageString = request.getParameter("age")!=null?request.getParameter("age"):"";
                urlRedirect="/getPersons";
                try{
                    double height = Double.parseDouble(heightString);
                    Date age = sdp.parse(ageString);
                    BeanPerson aPerson = new BeanPerson(name,lastName,height,age); // Enseñar que podemos crear objetos con varios constructores
                    ResultAction<BeanPerson> result = servicePerson.savePerson(aPerson);
                    urlRedirect="/getPersons?result="+result.isResult()+
                            "&message="+URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())+
                            "&type="+result.getType();
                }catch (Exception ex){
                    logger.log(Level.WARNING,ex.getMessage());
                }
                break;
            case "/updatePerson":
                SimpleDateFormat sdpUpdate = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                String idPersonString = request.getParameter("id")!=null?request.getParameter("id"):"0";
                String nameUpdate = request.getParameter("name")!=null ? request.getParameter("name"):"";
                String lastNameUpdate = request.getParameter("lastname")!=null?request.getParameter("lastname"):"";
                String heightStringUpdate = request.getParameter("height")!=null?request.getParameter("height"):"";
                String ageStringUpdate = request.getParameter("age")!=null?request.getParameter("age"):"";
                urlRedirect="/getPersons";
                try{
                    int idPerson = Integer.parseInt(idPersonString);
                    double height = Double.parseDouble(heightStringUpdate);
                    Date age = sdpUpdate.parse(ageStringUpdate);
                    BeanPerson aPerson = new BeanPerson(idPerson,nameUpdate,lastNameUpdate,height,age); // Enseñar que podemos crear objetos con varios constructores
                    ResultAction<BeanPerson> result = servicePerson.updatePerson(aPerson);
                    // Se hace encode para que respete caracteres especiales para mostrar u.U
                    String params ="result="+result.isResult()+
                            "&message="+URLEncoder.encode(result.getMessage(), StandardCharsets.UTF_8.name())+
                            "&type="+result.getType();
                    urlRedirect="/getPersons?"+ params;
                }catch (Exception ex){
                    logger.log(Level.WARNING,ex.getMessage());
                    urlRedirect="/getPersons";
                }
                break;
            case "/deletePerson":
                break;
            default:
                urlRedirect="/getPersons";
                break;

        }
        response.sendRedirect(request.getContextPath()+urlRedirect);
        //request.getRequestDispatcher(urlRedirect).forward(request,response);


        // redirect generico
    }
}
