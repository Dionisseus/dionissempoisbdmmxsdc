<%-- 
    Document   : editarProducto
    Created on : 21-may-2015, 13:15:50
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="css/editarProducto.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            $(function(){
                    $(".datepicker").each(function(){
                      $(this).datepicker();
                      
                    });
                });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="divContent">
            <h3 class="h3">Editar producto</h3>
            <form enctype="multipart/form-data" method="POST">
                <table>
                    <tr>
                        <td><label class="editarProducto">Título:</label></td><td><input class="txtEditarProducto" type="text"></td>
                    </tr>
                    <tr>
                        <td><label class="editarProducto">Descripción:</label></td><td><textarea></textarea></td>
                    </tr>
                    <tr>
                        <td><label class="editarProducto">Precio:</label></td><td><input class="txtEditarProducto" type="text"></td>
                    </tr>
                    <tr>
                        <td><label class="editarProducto">Existencia:</label></td><td><input class="txtEditarProducto" type="text"></td>
                    </tr>
                    <tr>
                        <td><label class="editarProducto">Vigencia:</label></td><td><input type="text" class="datepicker txtEditarProducto" readonly/></td>
                    </tr>
                    <tr>
                        <td><label class="editarProducto">Caracteristicas:</label></td><td><input class="txtEditarProducto" type="text"></td>
                    </tr>
                    <tr>
                       <td style="font-family: tahoma; font-size: 14px; font-weight: 200; ">Fotos y videos</td> 
                    </tr>
                    <tr>
                        <td>
                            <div class="divImgEditar"><img src="http://i.ebayimg.com/00/s/NzUwWDEwMDA=/z/fDwAAOSweW5VWhok/$_58.JPG"><input type="file"></div>
                            <div class="divImgEditar"><img src="http://i.ebayimg.com/00/s/NzUwWDEwMDA=/z/fDwAAOSweW5VWhok/$_58.JPG"><input type="file"></div>
                            <div class="divImgEditar"><img src="http://i.ebayimg.com/00/s/NzUwWDEwMDA=/z/fDwAAOSweW5VWhok/$_58.JPG"><input type="file"></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="divVideoEditar"><video  controls><source src="https://www.youtube.com/watch?v=oP8HvaQHj3A" type="video/mp4"></video><input type="file"</div>
                            <div class="divVideoEditar"><video  controls><source src="https://www.youtube.com/watch?v=oP8HvaQHj3A" type="video/mp4"></video><input type="file"</div>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="btnEditar" value="Guardar cambios"></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
    <%@include file="general.jsp" %> %>
</html>
