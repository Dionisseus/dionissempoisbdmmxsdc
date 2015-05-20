/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.AvisoDAO;
import POJO.Aviso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diosio
 */
@WebServlet(name = "AvisosIndex", urlPatterns = {"/AvisosIndex"})
public class AvisosIndex extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("  <head>\n"
                    + "        <script defer src=\"js/jquery.flexslider.js\"></script>\n"
                    + "        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/avisos.css\">\n"
                    + "	<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js\"></script>\n"
                    + "	<meta charset=\"utf-8\">\n"
                    + "</head>");

            out.println("<body>");
            out.println("   <div id=\"divContent\">\n");

            out.println("<h3>Lo mas Reciente</h3>");
            out.println("  <div class=\"masReciente\">\n");
            List<Aviso> listaAvisos = AvisoDAO.recientesAvisos();
            for (int i = 0; i < listaAvisos.size(); i++) {
                out.println("<form method=\"post\" id=\"form"+i+"\" action=\"AvisoProducto\">");
                out.println("<input type=\"hidden\" name=\"numeroLista\" value=" + i + " />");
                out.println("<input type=\"hidden\" name=\"tipo\" value=\"masReciente\" />");
                out.println("                            <br>\n"
                        + "<div class=\"contenido\"> "
                        + "<div class=\"divImgProducto\"><a href=\"javascript:;\" onclick=\"document.getElementById('form"+i+"').submit();\">"
                        + "<img class=\"imgProducto\" src=\"ProductosImgs/" + listaAvisos.get(i).getPathImagen() + "\" /></a></div>\n"
                        + "                        <div class=\"infoProducto\">\n"
                        + "                            " + listaAvisos.get(i).getNombreProducto() + "<br>\n"
                        + "                             " + listaAvisos.get(i).getPrecioAviso() + "$" + "<br>\n"
                        + "                           " + listaAvisos.get(i).getNicknameUsuario() + "<br>\n"
                        + "                             " + listaAvisos.get(i).getFechaAviso() + "<br>\n"
                        + "                        </div>"
                        + "</form> "
                        + "</div>");
                if (i == 3) {
                    break;
                }
            }
            out.println("</div>");
            /////
            out.println("<h3>Lo mas caro</h3>");
            out.println("  <div class=\"masCaro\">\n");
            List<Aviso> listaAvisoss = AvisoDAO.preciosAvisos();
            for (int i = 0; i < listaAvisoss.size(); i++) {
                out.println("<form method=\"post\" id=\"formx"+i+"\" action=\"AvisoProducto\">");
                out.println("<input type=\"hidden\" name=\"numeroLista\" value=" + i + " />");
                out.println("<input type=\"hidden\" name=\"tipo\" value=\"masCaro\" />");
                out.println("                            <br>\n"
                        + "<div class=\"contenido\"> "
                        + "<div class=\"divImgProducto\"><a href=\"javascript:;\" onclick=\"document.getElementById('formx"+i+"').submit();\">"
                        + "<img class=\"imgProducto\" src=\"ProductosImgs/" + listaAvisoss.get(i).getPathImagen() + "\" /></a></div>\n"
                        + "                        <div class=\"infoProducto\">\n"
                        + "                            " + listaAvisoss.get(i).getNombreProducto() + "<br>\n"
                        + "                             " + listaAvisoss.get(i).getPrecioAviso() + "$" + "<br>\n"
                        + "                           " + listaAvisoss.get(i).getNicknameUsuario() + "<br>\n"
                        + "                             " + listaAvisoss.get(i).getFechaAviso() + "<br>\n"
                        + "                        </div>"
                        + "</form> "
                        + "</div>");
                if (i == 3) {
                    break;
                }
            }
            out.println("</div>");

            out.println("</div></div>");

            out.println("</body></html>");
        }
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
