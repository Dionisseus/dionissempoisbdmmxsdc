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
    <%@include file="general.jsp" %>
        <div id="divContent" >
                <div class="slider">
                    <h3>Lo mas vendido</h3>
                  <div class="flexslider carousel">
                    <ul class="slides">
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_lemon.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_donut.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_caramel.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_lemon.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_donut.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_caramel.jpg" /></a>
                        </li>
                    </ul>
                  </div>            
            <h3>Lo mas buscado</h3>
                  <div class="flexslider carousel">
                    <ul class="slides">
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_lemon.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_donut.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_caramel.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_cheesecake_brownie.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_lemon.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_donut.jpg" /></a>
                        </li>
                        <li>
                            <a href="producto.jsp"><img src="imagenes/kitchen_adventurer_caramel.jpg" /></a>
                        </li>
                    </ul>
                  </div>
                </div>
            </div>
     </body>
</html>   