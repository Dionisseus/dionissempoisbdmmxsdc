/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.UsuarioDao;
import POJO.Usuario;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import xClasses.Validador;

/**
 *
 * @author Diosio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Login extends HttpServlet{
 
    
      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           HttpSession respuesta = request.getSession(true);
           String emailUsuario = request.getParameter("emailUsuario");
           String passwordUsuario = request.getParameter("passwordUsuario");  
          Pattern pattern = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
         Matcher _matcher = pattern.matcher(emailUsuario);
          Validador v = new Validador();
        
        //campos vacios
        if (emailUsuario.isEmpty() || passwordUsuario.isEmpty()) {
            respuesta.setAttribute("error", "Hay campos vacios");
 
        } else {
            //No hay campos vacios, veo que la direccion de email sea válida
            if (!_matcher.find()) {
                respuesta.setAttribute("error", "La direccion de email no es correcta");
 
            } else {
                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                if (v.isUsernameOrPasswordValid(passwordUsuario)) {
                        try {
                           
                            if (UsuarioDao.exists(emailUsuario, passwordUsuario)) {
                                //Significa que la cuenta si existe
                                //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                                Usuario user = UsuarioDao.buscar(emailUsuario, passwordUsuario);
                               respuesta.setAttribute("sessionNombre", user.getNombreUsuario());
                               respuesta.setAttribute("sessionEmail", user.getEmailUsuario());
                                
                            } else {
                                respuesta.setAttribute("error", "Favor de registrarse.");
                            }
                        } catch (Exception e) {}
                } else {
                    respuesta.setAttribute("error", "Contraseña no es válida");
                }
            }
        }
        response.sendRedirect("home.jsp");       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }  
}