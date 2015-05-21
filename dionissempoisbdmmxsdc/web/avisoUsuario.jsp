<%-- 
    Document   : avisoUsuario
    Created on : 18-may-2015, 22:54:28
    Author     : Asus
--%>

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
                List<POJO.Aviso> listaProductos = AvisoDAO.misAvisos(Integer.parseInt(user.getIdUsuario())); 
                String fs = getServletContext().getContextPath();
                for (int i = 0; i < listaProductos.size(); i++) {
                    String imagenFirst = listaProductos.get(i).getPathImagen();
            %>
            <form method="post" action="AvisoInter">
                <div class="divProductoUsuario">
                    <input type="hidden" name="numeroLista" value="<%=i%>" />
                    <div class="divImgPUsr">
                        <img class="imgProductoUsuario" src="ProductosImgs/<%=imagenFirst%>" >
                        <div class="divContenido">
                            <table>
                                <tr>
                                    <td colspan="2" class="nombreProducto"><%=listaProductos.get(i).getNombreProducto()%></td>
                                </tr>
                                <tr>
                                    <td><a href="#">Editar</a></td><td><input type="Submit" value="Eliminar"></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </form>
            <% 
                }
            %>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
