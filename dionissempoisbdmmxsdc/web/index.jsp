<%-- 
    Document   : index
    Created on : Apr 4, 2015, 11:33:54 AM
    Author     : Diosio
--%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("home.jsp");%>
</t:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>DionisseusEmpoistose </h1> 
    <center> <h2>Login</h2> 
        <form action="Login" method="post"> 
            <table>
                <tr>
                    <td>Usuario:</td>
                    <td> <input type="text" name="emailUsuario"></td>
                </tr>
                <tr>
                    <td>Contraseña:</td>
                    <td><input type="password" name="passwordUsuario"> </td>
                </tr>
            </table>
                <br/><input type="submit" value="Iniciar Sesion"> </form>  
                <p><a href="Registrarse.jsp">Registrarse</a></p>
                </center>
                </body>


                </body>
                </html>
