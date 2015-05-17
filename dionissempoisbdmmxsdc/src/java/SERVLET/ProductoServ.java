/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.ImagenDAO;
import DAO.ProductoDAO;
import POJO.Imagen;
import POJO.Producto;
import POJO.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;

/**
 *
 * @author Diosio
 */
@WebServlet(name = "ProductoServ", urlPatterns = {"/ProductoServ"})
@MultipartConfig
public class ProductoServ extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("UnusedAssignment")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession respuesta = request.getSession(true);
        String titulo = request.getParameter("sTitulo");
        String sPrecio = request.getParameter("sPrecio");
        String sExistencias = request.getParameter("sExistencias");
        String sVigencia = request.getParameter("sVigencia");
        String sCaracteristicas = request.getParameter("sCaracteristicas");
        String sDescripcion = request.getParameter("sDescripcion");
        Part sFoto = request.getPart("sFoto");
         InputStream is;
          OutputStream out;
          String file="",file1="",file2="";
          if (!sFoto.getSubmittedFileName().equals("")){
       is = sFoto.getInputStream();
         file = ("C:\\Users\\Diosio\\Documents\\GitHub\\ProductosImgs\\" + sFoto.getSubmittedFileName());
       out = new FileOutputStream(file);
        IOUtils.copy(is, out);}
        Part sFoto1 = request.getPart("sFoto1");
        if (!sFoto1.getSubmittedFileName().equals("")){
          is = sFoto1.getInputStream();
          file1 = ("C:\\Users\\Diosio\\Documents\\GitHub\\ProductosImgs\\" + sFoto1.getSubmittedFileName());
         out = new FileOutputStream(file1);
        IOUtils.copy(is, out);}
        Part sFoto2 = request.getPart("sFoto2");
        if (!sFoto2.getSubmittedFileName().equals("")){
          is = sFoto2.getInputStream();
          file2 = ("C:\\Users\\Diosio\\Documents\\GitHub\\ProductosImgs\\" + sFoto2.getSubmittedFileName());
         out = new FileOutputStream(file2);
        IOUtils.copy(is, out);}
        Usuario user = (Usuario) respuesta.getAttribute("usuario");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();

        float precio = Float.parseFloat(sPrecio);
        int existencias= Integer.parseInt(sExistencias);
        int id = Integer.parseInt(user.getIdUsuario().trim());
         Producto pro =null;
        try {
            pro = new Producto(titulo, sDescripcion, precio, existencias, sVigencia, sCaracteristicas, "2", "1",id, true);
        } catch (Exception e) {
            e.toString();
        }             
                ProductoDAO.insertar(pro);
                pro = ProductoDAO.buscar(titulo);
                  if (!sFoto.getSubmittedFileName().equals("")){
                   Imagen imagen = new Imagen( file, pro.getIdProducto(), true);
                ImagenDAO.insertar(imagen);}
                  if (!sFoto1.getSubmittedFileName().equals("")){
                   Imagen imagen = new Imagen( file1, pro.getIdProducto(), true);
                ImagenDAO.insertar(imagen);}
                  if (!sFoto2.getSubmittedFileName().equals("")){
                   Imagen imagen = new Imagen( file2, pro.getIdProducto(), true);
                ImagenDAO.insertar(imagen);}
               
              
                
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
