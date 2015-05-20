<%-- 
    Document   : preguntasUsuario
    Created on : 18-may-2015, 17:17:32
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/preguntasUsuario.css" type="text/css" media="screen" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Preguntas al usuario</title>
    </head>
    <body>
        <div id="divContent">
            <div class="divPregunta">
                <label class="labelProducto">Nombre del producto(del aviso)</label> - <label class="labelUsuario">Usuario que pregunto</label><br>
                <label class="labelPregunta">Pregunta</label><br>
                <textarea class="textRespuesta"></textarea><br>
                <input id="btnContestar" type="button" value="Contestar">
            </div>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
