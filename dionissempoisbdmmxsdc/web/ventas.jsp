<%-- 
    Document   : ventas
    Created on : 25-may-2015, 21:31:52
    Author     : Asus
--%>

<%@page import="DAO.VentaDAO"%>
<%@page import="java.util.List"%>
<%@page import="POJO.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/ventas.css" type="text/css" > 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script>
            $(document).ready(function () {                           
                total = 0;
                $(".subtotalC").each(function(){
                    total= total + eval(parseInt($(this).text()));
                });
                
                $("#toatlVentas").text(total);
            });
        </script>
        <title>Reporte de ventas</title>
    </head>
    <body>
        <div id="divContent">
            <h3 id="h">Reportes de ventas</h3>
            <label id="labFecha" class="labels">Ventas entre hoy y la ultima semana</label><br>
            <%
                Usuario user = (Usuario) session.getAttribute("usuario");
                List<Venta> listaVentas = VentaDAO.misVentas(Integer.parseInt(user.getIdUsuario()));
                for(int i=0; i< listaVentas.size(); i++){               
            %>
            <div class="divVentas">
                <div class="divInfo">
                <table>
                    <tr>
                        <td colspan="2"><p class="nombreProducto"><%=listaVentas.get(i).getNombreProducto()%></p></td>
                    </tr>
                    <tr>
                        <td colspan="2"><p class="fecha">Fecha: <%=listaVentas.get(i).getFechaVenta()%></p></td>
                    </tr>
                    <tr>
                        <td><p class="nickComprador">Comprador: <%=listaVentas.get(i).getNickNameUsuario()%></p></td><td><p class="nickVendedor">Vendeor: <%=listaVentas.get(i).getNickVendedor()%></p></td>
                    </tr>
                    <tr>
                        <td colspan="2"><p class="metodoPago">Metodo de pago: <%=listaVentas.get(i).getMetodoPago()%></p></td>
                    </tr>             
                    <tr>
                        <td colspan="2"><p class="descripcion">Descripcion Aviso: <%=listaVentas.get(i).getDescripcionAviso()%></p></td>
                    </tr>
                    <tr>
                        <td><p class="cantidad">Cantidad: </p></td><td><p class="cantidadC"><%=listaVentas.get(i).getCantidadCompradaVenta()%></p></td>
                    </tr>
                    <tr>
                        <td><p class="precio">Precio: $</p></td><td><p class="precioC"><%=listaVentas.get(i).getPrecioProducto()%></p></td>
                    </tr>
                    <tr>
                        <td><p class="subtotal">Subtotal: $</p></td><td><p class="subtotalC"><%=listaVentas.get(i).getPrecioProducto()%></p></td>
                    </tr>
                </table>
                </div>
                <div class="divImgReporte">
                    <img class="imagenReporte" src="ProductosImgs/<%=listaVentas.get(i).getPathImagen()%>">
                </div>
            </div>
            <%
                }
            %>
            <lablel id="labelTotal" class="labels">TOTAL VENTAS: $</lablel><label id="toatlVentas"></label>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
