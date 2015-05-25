/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLET;

import DAO.ImagenDAO;
import DAO.ProductoDAO;
import DAO.VideoDAO;
import POJO.Imagen;
import POJO.Producto;
import POJO.Usuario;
import POJO.Video;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
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
          String path ="C:\\Users\\Diosio\\Documents\\GitHub\\dionissempoisbdmmxsdc\\dionissempoisbdmmxsdc\\web\\ProductosImgs\\";
        File fdir = new File(path);
        if (!fdir.exists()) {
            fdir.mkdir();
        }
          String file="",file1="",file2="",file3="",file4="";
          if (!sFoto.getSubmittedFileName().equals("")){
       is = sFoto.getInputStream();
         file = (sFoto.getSubmittedFileName());
       out = new FileOutputStream(path+file);
        IOUtils.copy(is, out);}
        Part sFoto1 = request.getPart("sFoto1");
        if (!sFoto1.getSubmittedFileName().equals("")){
          is = sFoto1.getInputStream();
          file1 = (sFoto1.getSubmittedFileName());
         out = new FileOutputStream(path+file1);
        IOUtils.copy(is, out);}
        Part sFoto2 = request.getPart("sFoto2");
        if (!sFoto2.getSubmittedFileName().equals("")){
          is = sFoto2.getInputStream();
          file2 = (sFoto2.getSubmittedFileName());
         out = new FileOutputStream(path+file2);
        IOUtils.copy(is, out);}
        
        //Video
        Part sVideo = request.getPart("sVideo");
        if (!sVideo.getSubmittedFileName().equals("")){
          is = sVideo.getInputStream();
          file3 = (sVideo.getSubmittedFileName());
         out = new FileOutputStream(path+file3);
        IOUtils.copy(is, out);}
        
         Part sVideo1 = request.getPart("sVideo1");
        if (!sVideo1.getSubmittedFileName().equals("")){
          is = sVideo1.getInputStream();
          file4 = (sVideo1.getSubmittedFileName());
         out = new FileOutputStream(path+file4);
        IOUtils.copy(is, out);}
        ///
        Usuario user = (Usuario) respuesta.getAttribute("usuario");
   

        float precio = Float.parseFloat(sPrecio);
        int existencias= Integer.parseInt(sExistencias);
        int id = Integer.parseInt(user.getIdUsuario().trim());
         Producto pro =null;
        try {
            pro = new Producto(titulo, sDescripcion, precio, existencias, sVigencia, sCaracteristicas, getCurrentTimeStamp(), getCurrentTimeStamp(),id, true);
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
                  //Video
                  if (!sVideo.getSubmittedFileName().equals("")){
                   Video vid = new Video( file3, pro.getIdProducto(), true);
                VideoDAO.insertar(vid);}
                  if (!sVideo1.getSubmittedFileName().equals("")){
                   Video vid = new Video( file4, pro.getIdProducto(), true);
                VideoDAO.insertar(vid);}
               //VIdeo
              
                
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
public static String getCurrentTimeStamp() {
    SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
    String strDate = sdfDate.format(new Date());
    return strDate;
}
}
