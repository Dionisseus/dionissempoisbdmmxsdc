/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.CategoriaDAO;
import DAO.SubcategoriaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.sql.DriverManager.println;
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
@WebServlet(name = "Categoria", urlPatterns = {"/Categoria"})
public class Categoria extends HttpServlet {

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

            out.println("<label id=\"labCategorias\">Categorías</label>\n"
                    + "            <div class=\"menu-wrap\">\n"
                    + "                <nav class=\"menu\">\n"
                    + "                    <ul class=\"clearfix\">\n");

            List<POJO.Categoria> listaCategoria = CategoriaDAO.lista();

            for (int i = 0; i < listaCategoria.size(); i++) {
                out.println("                        <li>\n"
                        + "                            <a href=\"#\">" + listaCategoria.get(i).getNombreCategoria() + "<span class=\"arrow\">&#9660;</span></a>\n"
                        + "                            <ul class=\"sub-menu\">\n");
                List<POJO.Subcategoria> listaSubcategoria = SubcategoriaDAO.lista(listaCategoria.get(i).getIdCategoria());
                for (int j = 0; j < listaSubcategoria.size(); j++) {
                         out.println("<form method=\"post\" id=\"Form"+i+"\" action=\"categoriaAvisos.jsp\">");
                         out.println("<input type=\"hidden\" name=\"subCategoria\" value="+listaSubcategoria.get(j).getNombreSubcategoria()+" readonly/>");
                    out.println("                                <li <a href=\"javascript:;\" onclick=\"document.getElementById('Form"+i+"').submit();\">"+listaSubcategoria.get(j).getNombreSubcategoria()+"</li>\n");
                }
                out.println("           </form>                 </ul>\n"
                        + "                        </li>\n");
            }
            out.println("                    </ul>\n"
                    + "                </nav>\n"
                    + "            </div>");
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
