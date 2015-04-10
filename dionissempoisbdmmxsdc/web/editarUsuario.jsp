<%-- 
    Document   : editarUsuario
    Created on : 09-abr-2015, 17:53:52
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/editarUsuario.css" type="text/css" media="screen" />
        <title>Edición de usuario</title>
    </head>
    <body>
        <div id="divContent">
            <h2>Editar Usuario</h2>
            <fieldset class="setEditar">
                <legend class="legendEditar">Datos del usuario</legend>
                <table>
                    <tr>
                        <td><p class="pEditar">Nombre: <input class="txtEditar" id="eNombre" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pEditar">Apellido Paterno: <input class="txtEditar" id="eApellidoP" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pEditar">Apellido Materno: <input class="txtEditar" id="eApellidoM" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pEditar">Teléfono: <input class="txtEditar" id="eTelefono" type="tel"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pEditar">Correo electrónico: <input class="txtEditar" id="eMail" type="email"/></p></td>
                    </tr>
                </table>
            </fieldset>
            <br>
            <fieldset class="setEditar">
                <legend class="legendEditar">Datos de la cuenta</legend>
                <table>
                    <tr>
                        <td><p class="pEditar">Nickname: <input class="txtEditar" id="eNick" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pEditar">Foto: <input class="txtEditar" id="eImagen" type="file"/></p></td>
                    </tr>
                </table>
            </fieldset><br>
            <input id="btnGuardar" type="submit" value="Guardar cambios"/>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
