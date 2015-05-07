<%-- 
    Document   : index
    Created on : Apr 4, 2015, 11:33:54 AM
    Author     : Diosio
--%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("home.jsp");%>
</t:if>--%>

<!DOCTYPE>
<html>
    <head>
        <!-- Demo CSS -->
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

        <!-- Modernizr -->
        <script src="js/modernizr.js"></script>
        <script defer src="js/jquery.flexslider.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<meta charset="utf-8">
	<title></title>
	<script>
                $(window).load(function() {
                  $('.flexslider').flexslider({
                    animation: "slide",
                    animationLoop: false,
                    itemWidth: 210,
                    itemMargin: 5,
                    minItems: 2,
                    maxItems: 4
                  });
                });
	</script>
</head>
<body>
    <div id="divContent" >
            <div class="divPrductos">
                <h3>Lo mas reciente</h3>
                    <div class="masReciente">
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_lemon.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_lemon.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_lemon.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_lemon.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                </div>            
                <h3>Lo mas vendido</h3>
                <div class="masVendido">
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                </div>    
                <h3>Lo mas comentado</h3>
                <div class="masComentado">
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_donut.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_donut.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_donut.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_donut.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                </div>    
                <h3>Lo mas caro</h3>
                <div class="masCaro">
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_caramel.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_caramel.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_caramel.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                    <div class="contenido">
                        <div class="divImgProducto"><a href="producto.jsp"><img class="imgProducto" src="imagenes/kitchen_adventurer_caramel.jpg" /></a></div>
                        <div class="infoProducto">
                            Descripcion breve<br>
                            Precio<br>
                            Nickname de Usuario<br>
                            Fecha y hora<br>
                            <br>
                        </div>
                    </div>
                </div>    
            </div>         
        </div>
    <%@include file="general.jsp" %>
     </body>
</html>   