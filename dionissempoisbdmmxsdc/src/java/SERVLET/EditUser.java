/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.UsuarioDAO;
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
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class EditUser extends HttpServlet {

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
       HttpSession session = request.getSession(false);
       String nombreUsuario = request.getParameter("eNombre");
       String apellidoPaterno=request.getParameter("eApellidoP");
       String apellidoMaterno=request.getParameter("eApellidoM");
       String telefonoUsuario=request.getParameter("eTelefono");
       String mailUsuario = request.getParameter("eMail");
       String nickNameUsuario=request.getParameter("eNick");
       // Blob avatarUsuario=request.getParameter("eImagen");
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
       Matcher _matcher = pattern.matcher(mailUsuario);
        Validador v = new Validador();
        
          if (mailUsuario.isEmpty()) {
            session.setAttribute("error", "Hay campos vacios");
        } else {
            //No hay campos vacios, veo que la direccion de email sea válida
            if (!_matcher.find()) {
                session.setAttribute("error", "La direccion de email no es correcta");
           
            } else {
                //La direccion de email si es correcta, verifico que la contraseña tambien lo sea
             
                        try {
                           
                            if (UsuarioDAO.exists(mailUsuario, "")) {
                                //Significa que la cuenta si existe
                                //OBTENGO EL NOMBRE DEL USUARIO Y LO GUARDO EN UNA SESION
                                Usuario user = UsuarioDAO.buscar(mailUsuario, "");
                                user.setNombreUsuario(nombreUsuario);
                                user.setApellidoUsuario(apellidoPaterno+" "+apellidoMaterno);
                                int i = Integer.parseInt(telefonoUsuario);
                                user.setTelefonoUsuario(i);
                                user.setEmailUsuario(mailUsuario);
                                user.setNicknameUsuario(nickNameUsuario);
                                //user.setAvatarUsuario(null);
                                UsuarioDAO.actualizar(user);
                                 session.setAttribute("sessionNombre",user.getNombreUsuario() );
                                
                            } else {
                                session.setAttribute("error", "Favor de registrarse.");
                            }
                        } catch (Exception e) {
                        e.getCause();
                        }
            }
        } 
     
        request.getRequestDispatcher("index.jsp").include(request, response);
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
