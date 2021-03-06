/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.AvisoDAO;
import DAO.ProductoDAO;
import DAO.VentaDAO;
import POJO.Aviso;
import POJO.Venta;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
@WebServlet(name = "Compra", urlPatterns = {"/Compra"})
public class Compra extends HttpServlet {

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
        String metodo = request.getParameter("metodo");
        String idUsuario = request.getParameter("idUsuario");
        String idAviso = request.getParameter("idAviso");
        Aviso aviso = AvisoDAO.miAviso(Integer.parseInt(idAviso.trim()));

        int cantidad = 1;
        aviso.setCantidadAviso(aviso.getCantidadAviso() - cantidad);
        AvisoDAO.actualizar(aviso);
        try {
            Venta venta = new Venta(true, cantidad, Integer.parseInt(idAviso), Integer.parseInt(idUsuario), Integer.parseInt(metodo));
            VentaDAO.altaVenta(venta);
            POJO.Producto pro = ProductoDAO.buscarId(aviso.getIdProductoAviso());
            respuesta.setAttribute("ventaPro", pro);
           
      
            
        } catch (Exception e) {
            e.toString();
            response.sendRedirect(url);
        }   
          RequestDispatcher rd= request.getServletContext (). getNamedDispatcher("SendMailVenta");
        rd.forward(request, response);
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
