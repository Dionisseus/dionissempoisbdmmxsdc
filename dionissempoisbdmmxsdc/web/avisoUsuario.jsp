<%-- 
    Document   : avisoUsuario
    Created on : 18-may-2015, 22:54:28
    Author     : Asus
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="DAO.AvisoDAO"%>
<%@page import="POJO.Aviso"%>
<%@page import="java.util.List"%>

<%--<jsp:include page="AvisoUsuario"></jsp:include>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/productoUsuario.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avisos del usuario</title>
    </head>
    <body>
        <div id="divContent">
            <%
                Usuario user = (Usuario) session.getAttribute("usuario");
                session.setAttribute("isAviso", true);
                List<POJO.Aviso> listaProductos = new  ArrayList<POJO.Aviso>();
                if(user != null){
                listaProductos = AvisoDAO.misAvisos(Integer.parseInt(user.getIdUsuario())); }
                String busqueda;
                try{
                 busqueda = session.getAttribute("esBusquedaCat").toString();
                   if(busqueda.equals("cat")){
                 listaProductos = AvisoDAO.avisosSubCategoria(Integer.parseInt(session.getAttribute("idSubcategoria").toString().trim()));
             
                }
                     if(busqueda.equals("busqueda")){
                listaProductos = (List<POJO.Aviso>)session.getAttribute("busquedaLista");
                }
                }catch(Exception ex){ ex.toString();}
                  session.removeAttribute("esBusquedaCat");
               
                for (int i = 0; i < listaProductos.size(); i++) {
                    String imagenFirst = listaProductos.get(i).getPathImagen();
                   if(listaProductos.get(i).isActivoAviso()==true){
            %>
           
                <div class="divProductoUsuario">
                    
                    <div class="divImgPUsr">
                        <img class="imgProductoUsuario" src="ProductosImgs/<%=imagenFirst%>" >
                        <div class="divContenido">
                    <form method="post" action="AvisoInter">
                    <input type="hidden" name="numeroLista" value="<%=listaProductos.get(i).getIdAviso()%>" />
                            <table>
                                <tr>
                                    <td colspan="2" class="nombreProducto"><%=listaProductos.get(i).getNombreProducto()%></td>
                                </tr>
                                <tr>
                                    <td><input type="Submit" value="Ver"></td>
                                </tr>
                            </table>
                                 </form> <form method="post" action="EliminarAvisoProducto">   <input type="hidden" name="numeroLista" value="<%=listaProductos.get(i).getIdAviso()%>" /> <input type="Submit" value="Eliminar"></form> 
                        </div>
                    </div>
                </div>
           
            <% 
                }}
            %>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
