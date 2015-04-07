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
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<meta charset="utf-8">
	<title></title>
	<script>
		$(function(){
			$(".shadow").toggle();
			$(".toggle").click(function(){
				$(".shadow").toggle();
			});
                        

		});
	</script>
</head>
<body>
	<header>
		<nav>
		<div id="divHeader">
                    <a href="index.jsp"><img id="imgHome" src="imagenes/home_w.png" /></a>
                <input type="text" id="txtBuscar" style="position: absolute; right:43%; width:28%;height: 33px; margin-top:10px;border-radius: 3px;">
                    <ul class="nav">
                            <li class="toggle">
                                    Iniciar Sesión
                            </li>
                    </ul>
		</div>
		</nav>
	</header>
        <div id="divMenu">
            <label id="labCategorias">Categorías</label>
            <div class="menu-wrap">
                <nav class="menu">
                    <ul class="clearfix">
                        <li>
                            <a href="#">Categoría 1<span class="arrow">&#9660;</span></a>
                            <ul class="sub-menu">
                                <li><a href="#">Subcategoria 1</a></li>
                                <li><a href="#">Subcategoria 2</a></li>
                                <li><a href="#">Subcategoria 3</a></li>
                                <li><a href="#">Subcategoria 4</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Caregoría 2<span class="arrow">&#9660;</span></a>
                            <ul class="sub-menu">
                                <li><a href="#">Subcategoria 1</a></li>
                                <li><a href="#">Subcategoria 2</a></li>
                                <li><a href="#">Subcategoria 3</a></li>
                                <li><a href="#">Subcategoria 4</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Categoría 3<span class="arrow">&#9660;</span></a>
                            <ul class="sub-menu">
                                <li><a href="#">Subcategoria 1</a></li>
                                <li><a href="#">Subcategoria 2</a></li>
                                <li><a href="#">Subcategoria 3</a></li>
                                <li><a href="#">Subcategoria 4</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
  	<div class="shadow">
  		<div class="loginContainer">  
                    <form action="Login" method="post">
  		<button class="toggle" id="botonCerrar" ></button>
  		<h3 id="hIngresar" style="font-family:Arial, Helvetica, sans-serif;">Ingrese un usuario</h3>	
  		 <table style="margin-top:40px;">
		 <tr>
			<td><label class="logLab">Correo Electronico: </label></td><td><input name="emailUsuario" class="logtxt" type="text" /></td>
		 </tr> 
		 <tr>
			<td><label class="logLab">Contraseña: </label></td><td><input name="passwordUsuario" class="logtxt" type="password"/></td>
		 </tr>	
		</table>
		<input type="submit" value="Entrar"><br><br>
                    </form>
		<a href="registrarUsuario.jsp">¿No tienes cuenta? Regístrare ahora</a>
  		</div>
  	</div>
</body>
</html>   