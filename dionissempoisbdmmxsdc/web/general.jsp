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
        <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
            $(function(){
                    $(".shadow").toggle();
                    $(".toggle").click(function(){
                            $(".shadow").toggle();
                    });

                    $(".datepicker").each(function(){
                      $(this).datepicker();

                    });
                });
	</script>
</head>
<body>
	<header>
		<nav>
		<div id="divHeader">
                   <a href="index.jsp"><img id="imgHome" src="imagenes/home_w.png" /></a>
                   <span class="sBuscar"><input type="text" id="txtBuscar" /><button id="botonBus"></button></span>
                <div class="menu-wrapF">
                    <nav class="menuF">
                        <ul class="clearfixF">
                            <li>
                                <a href="#" class="filtrar">Filtrar búsqueda<span class="arrow">&#9660;</span></a>
                                <ul class="sub-menuF">
                                    <li><input type="checkbox" class="busqueda"/>Fecha: Entre <input type="text" class="datepicker" readonly/> y <input type="text" class="datepicker" readonly/></li>
                                            <li>
                                                <input type="checkbox" class="busqueda"/>Usuario 
                                                <select>
                                                    <option></option>
                                                    <option>Usuario1</option>
                                                    <option>Usuario2</option>
                                                    <option>Usuario3</option>
                                                </select>
                                            </li>
                                    <li><input type="checkbox" class="busqueda"/>Subcategoria 3</li>
                                    <li><input type="checkbox" class="busqueda"/>Subcategoria 4</li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
                    <ul class="nav">
                        <li class="toggle">
                            Iniciar Sesión
                        </li>
                    </ul>
		</div>
		</nav>
	</header>
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
        <div id="divMenu">
            <jsp:include page ="Categoria"/>
<!--            <label id="labCategorias">Categorías</label>
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
            </div>-->
        </div>
</body>
</html>   