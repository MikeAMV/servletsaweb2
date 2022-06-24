package mx.edu.utez.aweb2.proyectobaseestructura2.controller.authentication.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUser",
        urlPatterns = {
        "/login",
                "/logout"

        })
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.getAttribute("login");
        session.setAttribute("login",true);
    }
}
