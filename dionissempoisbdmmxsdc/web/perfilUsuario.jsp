<%-- 
    Document   : perfilUsuario
    Created on : 16-may-2015, 20:55:18
    Author     : Asus
--%>

<%@page import="POJO.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/perfilUsuario.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfil de usuario</title>
    </head>
    <body>
        <div id="divContent" >
            <ul class="listaPerfil">
                <li><a href="editarUsuario.jsp">Editar datos</a></li>
                <li id="productos"> 
                    <a>Productos</a>
                    <ul class="subnav">
                        <li><a href="subirProducto.jsp">Agregar un producto</a></li>
                        <li><a href="productoUsuario.jsp">Ver mis productos</a></li>
                    </ul>
                </li>
                <li>
                    <a>Ventas</a>
                </li>
                <li><a href="avisoUsuario.jsp">Avisos</a></li>
            </ul>
          <h2>Datos personales</h2>  
                        <%  Usuario user = (Usuario)session.getAttribute("usuario");%> 
          <table class="tablaDatos">
              <tr>
                <td><label class="pUsuario">Nombre:</label></td><td><label class="pUsuario2"> <%= user.getNombreUsuario()%> </label></td>
            </tr>
            <tr>
                <td><label class="pUsuario">Apellido :</label></td><td><label class="pUsuario2"><%= user.getApellidoUsuario()%></label></td>
            </tr>
            <tr>
                <td><label class="pUsuario">Teléfono:</label></td><td><label class="pUsuario2"><%= user.getTelefonoUsuario()%></label></td>
            </tr>
            <tr>
                <td><label class="pUsuario">Correo electrónico:</label></td><td><label class="pUsuario2"><%= user.getEmailUsuario()%></label></td>
            </tr>
          </table>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
