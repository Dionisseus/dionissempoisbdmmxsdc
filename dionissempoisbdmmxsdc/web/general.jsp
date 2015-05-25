<%-- 
    Document   : index
    Created on : Apr 4, 2015, 11:33:54 AM
    Author     : Diosio
--%>
<%@page import="sun.misc.BASE64Encoder"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="java.util.Base64"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.awt.Image"%>
<%@page import="java.io.InputStream"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.io.ByteArrayInputStream"%>
<%@page import="POJO.Usuario"%>
<%@page import="java.sql.Blob"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("asdf.jsp");%>
</t:if>--%>

<!DOCTYPE>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
           
            $(function () {
                $(".shadow").toggle();
                $(".toggle").click(function () {
                    $(".shadow").toggle();
                });
                $(".datepicker").each(function () {
                    $(this).datepicker();

                });
                $(".buttonEditUser").click(function () {
                    window.location.href = '/dionissempoisbdmmxsdc/perfilUsuario.jsp';
                });
                  $(".cerrarSesion").click(function () {       
                    window.location.href = '/dionissempoisbdmmxsdc/DestroySession';
                });
                  
            });
        </script>
    </head>
    <body>
        <header>
            <nav>
                <div id="divHeader">
                    <a href="index.jsp"><img id="imgHome" src="imagenes/home_w.png" /></a>
                     <form method="post" action="AvisosIndex" >
                         <div class="dBuscar"><input type="text" name="texto" id="txtBuscar" /><input id="botonBus" type="Submit" value=""></div>
                    <div class="menu-wrapF">
                        <nav class="menuF">
                            <ul class="clearfixF">
                                <li>
                                    <a href="#" class="filtrar">Filtrar búsqueda<span class="arrow">&#9660;</span></a>
                                    <ul class="sub-menuF">
                                        <li>Fecha: Entre <input type="text" name="fechaOrigen" class="datepicker" id="fechaOrigen" readonly/> y <input name="fechaFin" id="fechaDestino" type="text" class="datepicker" readonly/></li>
                                        <li>
                                           Usuario <input type="text" name="usuarioFiltro" class="busqueda"/> 
                                        </li>
                                       
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </form>
                    <ul class="nav">
                        <li>
                            <t:if test="${sessionScope['sessionNombre']!=null}">
                                <div class="menuInicioSesion">
                                 <img src="<%= request.getServletContext().getContextPath() + "/AvatarUsuario"%>" style="height: 50px; width: 50px;">
                                         
                                 

                                  <%= session.getAttribute("sessionNombre")%>
                                    <div class="subMenuInicioSesion">
                                        <a class="buttonEditUser" >Perfil</a> <br>
                                        <a class="cerrarSesion">Salir</a>
                                    </div>
                                </div>
                            </t:if>
                            <t:if test="${sessionScope['sessionEmail']==null}">
                                <label class="toggle">Iniciar Sesion</label>
                            </t:if>
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
        </div>
    </body>
</html>   