/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.PreguntaDAO;
import POJO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asus
 */
@WebServlet(name = "Pregunta", urlPatterns = {"/Pregunta"})
public class Pregunta extends HttpServlet {

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
        String url = "producto.jsp";
        String descripcionPregunta = request.getParameter("pregunta");
        String idUsuario = request.getParameter("idUsuarioP");
        String idAviso = request.getParameter("idAvisoP");
        List<POJO.Pregunta> listaPreguntas = PreguntaDAO.preguntasAviso(Integer.parseInt(idAviso));                    

        HttpSession session = request.getSession();           
        
   
        try{            
            POJO.Pregunta preg = new POJO.Pregunta(descripcionPregunta,Integer.parseInt(idUsuario), Integer.parseInt(idAviso));
            PreguntaDAO.agregarPregunta(preg);
            //pongo la descripcion de la pregunta en sesión para mandarla através del mail para contestarla
            respuesta.setAttribute("preguntaR", listaPreguntas.get(0).getDescripcionPregunta());
            RequestDispatcher rd= request.getServletContext (). getNamedDispatcher("SendMailComentario");
            rd.forward(request, response);
            
        }catch (Exception e) {
            e.toString();
            response.sendRedirect("index.jsp"); 
        }      
          
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


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
