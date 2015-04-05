/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.UsuarioDao;
import POJO.Usuario;
import java.io.IOException;
import java.sql.Blob;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import xClasses.Validador;

/**
 *
 * @author Diosio
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession respuesta = request.getSession(true);
     String url = "index.jsp";           
           String nombreUsuario = request.getParameter("nombre");
           String apellidosUsuario = request.getParameter("aPaterno"); 
           String apellidoMaterno = request.getParameter("aMaterno");
           String telefonoUsuario = request.getParameter("telefono");
           String emailUsuario = request.getParameter("email");    
           String passwordUsuario = request.getParameter("password");
           Pattern pattern = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
           Matcher _matcher = pattern.matcher(emailUsuario);
           Validador v = new Validador();
          
          if (emailUsuario.isEmpty() || passwordUsuario.isEmpty() || nombreUsuario.isEmpty() || apellidosUsuario.isEmpty() || apellidoMaterno.isEmpty()) {
               respuesta.setAttribute("error", "Hay campos vacios");
               url ="index.jsp"; 
               //TODO para abajo
        } else {
            //No hay campos vacios, veo que la direccion de email sea válida
            if (!_matcher.find()) {
                respuesta.setAttribute("error", "La direccion de email no es correcta");
                url ="index.jsp"; 
 
            } else {
                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
                if (v.isUsernameOrPasswordValid(passwordUsuario)) {
                        try {
                           
                            if (!UsuarioDao.exists(emailUsuario, passwordUsuario)) {
                              byte[] bytes = {0};
                               Usuario user = new Usuario(emailUsuario,passwordUsuario,"",nombreUsuario,apellidosUsuario+""+apellidoMaterno,Integer.parseInt(telefonoUsuario),(Blob)new SerialBlob(bytes),true,true);
                                UsuarioDao.insertar(user);
                                url ="home.jsp"; 
                                
                            } else {
                                respuesta.setAttribute("error", "Usuario ya existente.");
                                 url ="index.jsp"; 
                            }
                        } catch (Exception e) {
                        e.getCause();
                        }
                } else {
                    respuesta.setAttribute("error", "Contraseña no es válida");
                     url ="index.jsp"; 
                }
            }
        }
        response.sendRedirect(url);                  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
