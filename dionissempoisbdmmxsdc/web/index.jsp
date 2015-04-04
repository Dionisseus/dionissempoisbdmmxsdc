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
        </div>
    <div id="divContent">
        
    </div>
  	<div class="shadow">
  		<div class="loginContainer">  
  		<button class="toggle" id="botonCerrar" ></button>
  		<h3 id="hIngresar" style="font-family:Arial, Helvetica, sans-serif;">Ingrese un usuario</h3>	
  		 <table style="margin-top:40px;">
		 <tr>
			<td><label class="logLab">Nombre de usuario: </label></td><td><input id="txtNombre" class="logtxt" type="text" /></td>
		 </tr> 
		 <tr>
			<td><label class="logLab">Contraseña: </label></td><td><input id="txtContra" class="logtxt" type="text"/></td>
		 </tr>	
		</table>
		<input type="submit" value="Entrar"><br><br>
		<a href="registrarUsuario.jsp">¿No tienes cuenta? Regístrare ahora</a>
  		</div>
  	</div>
</body>
</html>   