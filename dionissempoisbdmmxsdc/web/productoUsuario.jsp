<%-- 
    Document   : productoUsuario
    Created on : 16-may-2015, 22:52:46
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/productoUsuario.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="divContent" >
            <div class="divProductoUsuario">
                <div class="divImgPUsr">
                    <a href="producto.jsp"><img class="imgProductoUsuario" src="http://www.serebii.net/potw-xy/Krookodile.jpg"></a>
                </div>
                <div class="divContenido">
                    <table>
                        <tr>
                            <td colspan="2" class="nombreProducto">Nombre Producto</td>
                        </tr>
                        <tr>
                            <td><a href="#">Editar</a></td><td><input type="button" value="Eliminar"></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="divProductoUsuario">
                <div class="divImgPUsr">
                    <a href="producto.jsp"><img class="imgProductoUsuario" src="http://www.serebii.net/potw-xy/Krookodile.jpg"></a>
                </div>
                <div class="divContenido">
                    <table>
                        <tr>
                            <td colspan="2" class="nombreProducto">Nombre Producto</td>
                        </tr>
                        <tr>
                            <td><a href="#">Editar</a></td><td><input type="button" value="Eliminar"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
