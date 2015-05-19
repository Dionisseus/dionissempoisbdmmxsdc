<%-- 
    Document   : productoUsuario
    Created on : 16-may-2015, 22:52:46
    Author     : Asus
--%>

<%@page import="DAO.ProductoDAO"%>
<%@page import="POJO.Producto"%>
<%@page import="java.util.List"%>

<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/productoUsuario.css">
    </head>
    <body>
        <div id="divContent">
           <jsp:include page="ProductosUsuario"/>
        </div>    
         <jsp:include page ="general.jsp" flush="true" />
    </body>
</html>
   
          
          
      
     
        
        


