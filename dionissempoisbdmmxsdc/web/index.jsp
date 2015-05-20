<%-- 
    Document   : index
    Created on : Apr 4, 2015, 11:33:54 AM
    Author     : Diosio
--%>
<%@page import="DAO.AvisoDAO"%>
<%@page import="POJO.Aviso"%>
<%@page import="java.util.List"%>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<t:if test="${sessionScope['sessionEmail']!=null}">
    <% response.sendRedirect("home.jsp");%>
</t:if>--%>

<%-- 
          <%@include file="general.jsp" %>  <jsp:include page="AvisosIndex"/>    
--%>

<!DOCTYPE html>
    <html>
        <head>
            <script defer src="js/jquery.flexslider.js"></script>
              <link rel="stylesheet" type="text/css" href="css/avisos.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
           <meta charset=\"utf-8\">
        </head>
        <body>
            <div id="divContent">
                <h3>Lo mas reciente</h3>
                <div class="masReciente">
                    <% List<Aviso> listaAvisos = AvisoDAO.recientesAvisos();
                    for (int i = 0; i < listaAvisos.size(); i++) {
                    %>
                    <form method="post" id="form<%=i%>" action="AvisoProducto">
                        <input type="hidden" name="numeroLista" value="<%=i%>  " />
                        <input type="hidden" name="tipo" value="masReciente" />
                        <div class="contenido">
                            <div class="divImgProducto">
                                <a href="javascript:;" onclick="document.getElementById('form'+<%=i%>+').submit()">
                                    <img class="imgProducto" src="ProductosImgs/<%=listaAvisos.get(i).getPathImagen()%>"  />
                                </a>
                            </div>
                            <div class="infoProducto">
                                <%=listaAvisos.get(i).getNombreProducto() %> <br>
                                <%= "$"+listaAvisos.get(i).getPrecioAviso()%> <br>
                                <%=listaAvisos.get(i).getNicknameUsuario() %> <br>
                                <%=listaAvisos.get(i).getFechaAviso()%> <br>
                            </div>
                        </div>
                    </form>
                    <% if(i== 3){
                    break;
                        }
                    }
                %>
                </div>

                <h3>Lo mas caro</h3>
                <div class="masCaro">
                    <% List<Aviso> listaAvisoss = AvisoDAO.recientesAvisos();
                    for (int i = 0; i < listaAvisoss.size(); i++) {
                    %>
                    <form method="post" id="form<%=i%>" action="AvisoProducto">
                        <input type="hidden" name="numeroLista" value="<%=i%>  " />
                        <input type="hidden" name="tipo" value="masCaro" />
                        <div class="contenido">
                            <div class="divImgProducto">
                                <a href="javascript:;" onclick="document.getElementById('form+<%=i%>+').submit()">
                                    <img class="imgProducto" src="ProductosImgs/<%=listaAvisoss.get(i).getPathImagen()%>"  />
                                </a>
                            </div>
                            <div class="infoProducto">
                                <%=listaAvisoss.get(i).getNombreProducto() %> <br>
                                <%= "$"+listaAvisoss.get(i).getPrecioAviso()%> <br>
                                <%=listaAvisoss.get(i).getNicknameUsuario() %> <br>
                                <%=listaAvisoss.get(i).getFechaAviso()%> <br>
                            </div>
                        </div>
                    </form>
                <% if(i== 3){
                    break;
                        }
                    }
                %>
                </div>
            </div>
            <%@include file="general.jsp" %>
        </body>
    </html>