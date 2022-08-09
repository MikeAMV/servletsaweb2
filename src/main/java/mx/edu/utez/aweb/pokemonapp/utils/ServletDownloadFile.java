package mx.edu.utez.aweb.pokemonapp.utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "download", urlPatterns = {"/download-file"})
public class ServletDownloadFile extends HttpServlet {
    String uploadDir = "C:" + File.separator + "temp" + File.separator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        switch (action) {
            case "/download-file":
                resp.setContentType("image/png");
                resp.setHeader("Content-disposition", "attachment; filename=img.png");
                String fileName = req.getParameter("fileName");
                File img = new File(uploadDir + fileName);
                try (InputStream in = new FileInputStream(img);
                     OutputStream out = resp.getOutputStream()) {
                    byte[] buffer = new byte[1048];
                    int lengthBytesRead;
                    while ((lengthBytesRead = in.read(buffer)) > 0) {
                        out.write(buffer, 0, lengthBytesRead);
                    }
                }
                break;
            default:
                req.getRequestDispatcher("/get-pokemons").forward(req, resp);
        }
    }
}
