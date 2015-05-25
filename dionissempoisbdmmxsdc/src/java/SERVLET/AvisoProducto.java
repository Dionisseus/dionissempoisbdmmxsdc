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
@WebServlet(name = "AvisoProducto", urlPatterns = {"/AvisoProducto"})
public class AvisoProducto extends HttpServlet {

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
        HttpSession session = request.getSession(true);//no hay session
        String numeroLista = request.getParameter("numeroLista").trim();
        int i = Integer.parseInt(numeroLista);
        String tipo = request.getParameter("tipo");
         List<Aviso> listaAviso = null;
         POJO.Producto pro = null;
        
        if (tipo.equals("masReciente")) {
         listaAviso = AvisoDAO.recientesAvisos();
         pro = ProductoDAO.buscarId(listaAviso.get(i).getIdProductoAviso());  
        }
         if (tipo.equals("masCaro")) {
        listaAviso = AvisoDAO.preciosAvisos();
         pro = ProductoDAO.buscarId(listaAviso.get(i).getIdProductoAviso());    
        }
          if (tipo.equals("masComentado")) {
         listaAviso = AvisoDAO.comentadosAvisos();
         pro = ProductoDAO.buscarId(listaAviso.get(i).getIdProductoAviso());  
        }
         if (tipo.equals("masVendido")) {
        listaAviso = AvisoDAO.vendidosAvisos();
         pro = ProductoDAO.buscarId(listaAviso.get(i).getIdProductoAviso());    
        }
            session.setAttribute("producto", pro);

            session.setAttribute("isAviso", true);
            response.sendRedirect("producto.jsp");
       
        
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
