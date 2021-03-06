/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.AvisoDAO;
import DAO.ProductoDAO;
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
@WebServlet(name = "AvisoInter", urlPatterns = {"/AvisoInter"})
public class AvisoInter extends HttpServlet {

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
        String numeroLista = request.getParameter("numeroLista");
        int i = Integer.parseInt(numeroLista);
       //  Usuario user = (Usuario) session.getAttribute("usuario");
           POJO.Aviso listaProductos = AvisoDAO.AvisoIdPro(i);
           // List<POJO.Producto> list = ProductoDAO.todosProductos(Integer.parseInt(user.getIdUsuario()));
         //   for (int j = 0;j < list.size(); j++) {
              //  if (list.get(j).getIdProducto() ==   listaProductos.get(i).getIdProductoAviso()) {
           POJO.Producto pro = null;
           try {
          pro = ProductoDAO.buscarId(listaProductos.getIdProductoAviso());
        } catch (Exception e) {
            e.toString();
        }
          
                    session.setAttribute("producto",pro );  
            //    }
     //   }
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
