/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;


import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import xClasses.EmailUtility;

/**
 *
 * @author Carlos
 */
@WebServlet(name = "SendEmailServlet", urlPatterns = {"/SendEmailServlet"})
public class SendEmailServlet extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;
    
    @Override
    public void init() {
        // Lee la configuacion del servidor SMTP desde el archivo web.xml
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aqui implementamos la logica para activar la cuenta de usuario
        // Se ejecuta cuando se le da click al link que viende dentro del correo
        System.out.println("EMAIL: " + request.getParameter("email"));
        System.out.println("CODIGO: " + request.getParameter("codigo"));
        getServletContext().getRequestDispatcher("/activation.jsp").forward(
                    request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String passs = session.getAttribute("pass").toString();
        String result = "Email enviado correctamente.";
        try {
            String verificationCode = UUID.randomUUID().toString();
            
            // El link que viene en el mensaje en este caso apunta a una direccion 
            // en la propia maquina. Si se instalara la aplicacion en un servidor web
            // se debe de cambiar por el dominio o la ip del servidor.
            String message = "<html><body>";
            message += "Bienvenido al Mercado thedamnedsobs. Esperamos que tengas una experiencia grata.<br/> Te recordamos que tu contraseña es ";
             message += passs;
            message += "</body></html>";
            EmailUtility.sendEmail(host, port, user, pass, email, 
                    "Bienvenido!!!", message);
        } catch (Exception ex) {
            ex.printStackTrace();
            result = "Ocurrio un error.";
        } finally {
            request.setAttribute("result", result);
            getServletContext().getRequestDispatcher("/index.jsp").forward(
                    request, response);
        }
    }
}