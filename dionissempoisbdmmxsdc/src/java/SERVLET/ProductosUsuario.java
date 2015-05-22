/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.ImagenDAO;
import DAO.ProductoDAO;
import POJO.Producto;
import POJO.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diosio
 */
@WebServlet(name = "ProductosUsuario", urlPatterns = {"/ProductosUsuario"})
public class ProductosUsuario extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession(true);
            Usuario user = (Usuario) session.getAttribute("usuario");
             session.setAttribute("isAviso", false);
            List<Producto> listaProductos = ProductoDAO.todosProductos(Integer.parseInt(user.getIdUsuario()));        
            String fs = getServletContext().getContextPath();
            for (int i = 0; i < listaProductos.size(); i++) {
                String imagenFirst = ImagenDAO.firstImagen(listaProductos.get(i).getIdProducto());
                out.println("<form method=\"post\" action=\"Producto\">");
                out.println("<div class=\"divProductoUsuario\">\n");
                   out.println("<input type=\"hidden\" name=\"numeroLista\" value="+i+" />"+
"                <div class=\"divImgPUsr\">\n" +
"                <img class=\"imgProductoUsuario\" src=\"ProductosImgs/"+imagenFirst+"\" >"+               
"                </div>\n" +
"                <div class=\"divContenido\">\n" +
"                    <table>\n" +
"                        <tr>\n" +
"                            <td colspan=\"2\" class=\"nombreProducto\">"+listaProductos.get(i).getNombreProducto()+"</td>\n" +
"                        </tr>\n" +
"                        <tr>\n" +
"                            <td><a href=\"#\">Editar</a></td><td><input type=\"Submit\" value=\"Detalles\"></td>\n" +
"                        </tr>\n" +
"                    </table>\n" +
"                </div>\n" +
"            </form>");
            }
            
            
            out.println("</body>");
            out.println("</html>");
           
            
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
