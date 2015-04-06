<%-- 
    Document   : registrarUsuario
    Created on : Apr 4, 2015, 3:32:20 PM
    Author     : Diosio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/registroUsuario.css">
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<meta charset="utf-8">
	<title>Registro de usuario</title>
	<script>

	</script>
</head>
	<body>
        <%@include file="general.jsp" %>
        <div id="divContent" >
            <h3>Registro de usuario</h3>
            <div id="divRegistro">
                    <form method="post">
                            <fieldset class="fSet">
                                    <legend style="font-family:Arial, Helvetica, sans-serif;">Datos del usuario</legend>
                                    <dl>
                                            <dt><label class="registroLab">Nombre completo </label></dt>
                                                    <dd><input id="txtNombre" class="regtxt" name="nombre" type="text" /></dd>
                                            <dt><label class="registroLab">Apellido Paterno</label></dt>
                                            <dd><input id="txtPaterno" class="regtxt" name="aPaterno" type="text"/></dd>
                                            <dt><label class="registroLab">Apellido Materno</label></dt>
                                            <dd><input id="txtMaterno" class="regtxt" name="aMaterno" type="text"/></dd>
                                            <dt><label class="registroLab">Teléfono</label></dt>
                                            <dd><input id="txtTelefono" class="regtxt" name="telefono" type="tel"/></dd>
                                            <dt><label class="registroLab">Correo electrónico</label></dt>
                                            <dd><input id="txtCorreo" class="regtxt" name="email" type="email"/></dd>
                                            <dt><label class="registroLab">Contraseña</label></dt>
                                            <dd><input id="txtContra" class="regtxt" name="password" type="email"/></dd>
                                    </dl>	
                                    <input type="submit" value="Registrarse"/>
                            </fieldset>					
                </form>
            </div>
        </div>
	</body>
</html>   