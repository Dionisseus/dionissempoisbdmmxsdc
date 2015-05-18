<%-- 
    Document   : productoUsuario
    Created on : 16-may-2015, 22:52:46
    Author     : Asus
--%>

<%@page import="DAO.ProductoDAO"%>
<%@page import="POJO.Producto"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/productoUsuario.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
       
    </head>
    <body>
          <jsp:include page="ProductosUsuario"></jsp:include>
        <%@include file="general.jsp" %>
      
     
        
        
    </body>
</html>
