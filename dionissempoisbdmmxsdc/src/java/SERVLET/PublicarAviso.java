/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.AvisoDAO;
import DAO.ProductoDAO;
import POJO.Aviso;
import java.io.IOException;
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
@WebServlet(name = "PublicarAviso", urlPatterns = {"/PublicarAviso"})
public class PublicarAviso extends HttpServlet {

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
    HttpSession session = request.getSession(true);
    session.setAttribute("isAviso", true);
        POJO.Producto pro = (POJO.Producto) session.getAttribute("producto");
        String precio =  request.getParameter("precio");
        pro.setPrecioProducto(Float.parseFloat(precio.trim()));
        pro.setExistenciaProducto(Integer.parseInt(request.getParameter("existencias").trim()));
        pro.setVigenciaProducto(request.getParameter("vigencia").trim());
        String metodoPago = "todos";//request.getParameter("opcion");
    ProductoDAO.actualizar(pro);
    pro = ProductoDAO.buscar(pro.getNombreProducto());
    POJO.Aviso aviso = new Aviso(pro.getExistenciaProducto(),pro.getPrecioProducto(),metodoPago,pro.getDescripcionProducto(),pro.getVigenciaProducto(),pro.getFechaProducto(),
    pro.getHoraProducto(),Integer.parseInt(request.getParameter("Categoria")),pro.getIdProducto(),true);
        AvisoDAO.insertar(aviso);
    
   response.sendRedirect("index.jsp");
        
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
