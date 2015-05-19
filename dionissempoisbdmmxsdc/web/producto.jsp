<%-- 
    Document   : producto
    Created on : 05-abr-2015, 21:32:58
    Author     : Asus
--%>

<%@page import="POJO.Subcategoria"%>
<%@page import="DAO.SubcategoriaDAO"%>
<%@page import="DAO.CategoriaDAO"%>
<%@page import="POJO.Imagen"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ImagenDAO"%>
<%@page import="POJO.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/producto.css" type="text/css" media="screen" />
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script>
            $(document).ready(function ($) {

                $('#checkbox').change(function () {
                    setInterval(function () {
                        moveRight();
                    }, 3000);
                });

                var slideCount = $('#slider ul li').length;
                var slideWidth = $('#slider ul li').width();
                var slideHeight = $('#slider ul li').height();
                var sliderUlWidth = slideCount * slideWidth;

                $('#slider').css({width: slideWidth, height: slideHeight});

                $('#slider ul').css({width: sliderUlWidth, marginLeft: -slideWidth});

                $('#slider ul li:last-child').prependTo('#slider ul');

                function moveLeft() {
                    $('#slider ul').animate({
                        left: +slideWidth
                    }, 200, function () {
                        $('#slider ul li:last-child').prependTo('#slider ul');
                        $('#slider ul').css('left', '');
                    });
                }
                ;

                function moveRight() {
                    $('#slider ul').animate({
                        left: -slideWidth
                    }, 200, function () {
                        $('#slider ul li:first-child').appendTo('#slider ul');
                        $('#slider ul').css('left', '');
                    });
                }
                ;

                $('a.control_prev').click(function () {
                    moveLeft();
                });

                $('a.control_next').click(function () {
                    moveRight();
                });

                //console.log($('#textPregunta').val());
                $('#hacerPregunta').submit(function () {
                    if ($('#textPregunta').val() === "") {
                        alert("Formule una pregunta antes de enviarla");
                    }
                });

            });
        </script>
    </head>
    <body>
        <%
            Producto pro = (Producto) session.getAttribute("producto");
        %>
        <div id="divContent">
            <h2><%= pro.getNombreProducto()%></h2>
            <div id="slider">
                <a href="#" class="control_next">></a>
                <a href="#" class="control_prev"><</a>
                <ul>
                    <%
                        List<Imagen> listaImagen = ImagenDAO.TodasImagenes(pro.getIdProducto());
                        for (int i = 0; i < listaImagen.size(); i++) {
                    %>
                    <li><img src="ProductosImgs/<%=listaImagen.get(i).getPathImagen()%>"/></li>
                        <%
                            }
                        %>

                </ul>  
            </div>
            <div id="datosCompra">
                <form method="post" action="PublicarAviso">
                    <table class="tablaDC">
                        <tr>
                            <td colspan="2">Métodos de pago
                                <select name="opcion">
                                    <option value="todos" selected>Elegir</option>
                                    <option value="efectivo">Efectivo</option>
                                    <option value="tarjeta">Tarjeta crédito/débito</option>
                                    <option value="paypal">Paypal</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Precio:<input name="precio" value="<%= Float.toString(pro.getPrecioProducto())%>"/></td>
                            <td>Existencias: <input name="existencias" class="inp" value="<%= pro.getExistenciaProducto()%> "type="text" readonly/></td>
                        </tr>
                        <tr>
                            <td colspan="2">Vigencia: <input name="vigencia"  value="<%= pro.getVigenciaProducto()%>" type="text" class="datepicker txtSubir" readonly/></td>
                                <% if (session.getAttribute("isAviso").toString().equals("false")) { %>
                            <td  > <input class="inp" type="Submit" value="Publicar Aviso"/>   </td>
                                <%}%>
                        </tr>
                        <tr>
                            <td colspan="2">Categoria: 
                                <% if (session.getAttribute("isAviso").toString().equals("false")) { %>
                                <select name="Categoria">
                                    <%   List<POJO.Categoria> listaCategoria = CategoriaDAO.lista();
                                        for (int i = 0; i < listaCategoria.size(); i++) {
                                    %>
                                    <option disabled style="background-color: aqua" value="<%=listaCategoria.get(i).getIdCategoria()%>" selected><%=listaCategoria.get(i).getNombreCategoria().toUpperCase()%></option>
                                    <%
                                        List<Subcategoria> listaSubCategoria = SubcategoriaDAO.lista(listaCategoria.get(i).getIdCategoria());
                                        for (int x = 0; x < listaSubCategoria.size(); x++) {
                                    %>
                                    <option value="<%=listaSubCategoria.get(x).getIdSubcategoria()%>" selected><%=listaSubCategoria.get(x).getNombreSubcategoria()%></option>
                                    <%
                                            }
                                        }
                                    %>
                                </select>
                                <%}%>

                            </td>
                        </tr>

                    </table>
                </form>
            </div>
            <div id="divDescripcion">
                <p><h6>Descripcion del producto</h6> <br><%= pro.getNombreProducto()%></p>
            </div>
            <div id="divPreguntas">
                <h2>Preguntas</h2><br>
                <label id="labPreguntas">Hacer una pregunta</label><br>
                <form id="hacerPregunta" method="post">
                    <textarea id="textPregunta" name="pregunta"></textarea><br>
                    <input class="inp" type="submit" class="btnRespuesta" value="Preguntar"/>
                </form>
                <!--<p class="pregunta">Pregunta</p>
                <ul class="respuesta">
                    <li>Respuesta</li>
                </ul>-->               
            </div>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
