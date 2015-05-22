<%@page import="DAO.ImagenDAO"%>
<%@page import="POJO.Usuario"%>
<%-- 
    Document   : productoUsuario
    Created on : 16-may-2015, 22:52:46
    Author     : Asus
--%>

<%@page import="DAO.ProductoDAO"%>
<%@page import="POJO.Producto"%>
<%@page import="java.util.List"%>
<%--<jsp:include page="ProductosUsuario"/>--%>
<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/productoUsuario.css">
    </head>
    <body>
        <div id="divContent">
            <%
            Usuario user = (Usuario) session.getAttribute("usuario");
            session.setAttribute("isAviso", false);
            List<Producto> listaProductos = ProductoDAO.todosProductos(Integer.parseInt(user.getIdUsuario()));        
            String fs = getServletContext().getContextPath();
            for (int i = 0; i < listaProductos.size(); i++) {
                String imagenFirst = ImagenDAO.firstImagen(listaProductos.get(i).getIdProducto());
            %>
            <form method="post" action="Producto">
                <div class="divProductoUsuario">
                    <input type="hidden" name="numero" value="<%=i%>"/>
                    <div class="divImgPUsr">
                        <img class="imgProductoUsuario" src="ProductosImgs/<%=imagenFirst %>" >
                    </div>
                    <div class="divContenido">
                        <table>
                            <tr>
                                <td colspan="2" class="nombreProducto"><%=listaProductos.get(i).getNombreProducto()%></td>
                            </tr>
                            <tr>
                                <td>  <input type="hidden" name="numero" value="<%=i%>" />     </td><td><input type="Submit" value="Detalles"></td>
             
                            </tr>
                        </table>
                    </div>
                </div>
            </form>
                <%
                    }
                %>
        </div>    
         <jsp:include page ="general.jsp" flush="true" />
    </body>
</html>
   
          
          
      
     
        
        


