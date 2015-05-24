<%-- 
    Document   : subirProducto
    Created on : 21-abr-2015, 22:15:26
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/subirProducto.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
        <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
        <script>
            $(function(){
                    $(".datepicker").each(function(){
                      $(this).datepicker();
                    });
                    
                
                  
                    
                    function validarFotos(){
                            var imagen1 = $("#sFoto").val();
                    var imagen2 = $("#sFoto1").val();
                    var imagen3 = $("#sFoto2").val();
                        if(imagen1 == "" || imagen2== "" || imagen3 == ""){
                            alert("Necesita agregar 3 fotografias");
                            return false;
                        }    
                        return true;
                       
                    };
                    
                    function validarVideos(){
                          var video1 = $('#sVideo').val();
                    var video2 = $('#sVideo1').val();
                        if(video1 == "" || video2 == "" ){
                            alert("Necesita agregar 2 videos");
                            return false;
                        }
                        return true;
                        
                    };
                                        
                    $('#btnGuardar').click(function (){
                       if(validarVideos()== false ||  validarFotos()==false    ) 
                       {return false;}else{
                        return true;}
                    });                  
                    
                });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="divContent" >
            <form method="post" action="ProductoServ" enctype="multipart/form-data">
            <fieldset class="setSubir">
                <legend>Datos del producto</legend>
                <table>
                    <tr>
                        <td><p class="pSubir">Titulo: <input class="txtSubir" id="sTitulo" name="sTitulo"type="text" /></p></td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Precio: <input class="txtSubir" id="sPrecio" name="sPrecio" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Existencias: <input class="txtSubir" id="sExistencias" name="sExistencias" type="text"/></p></td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Vigencia: <input type="text" class="datepicker txtSubir" id="sVigencia" name="sVigencia" readonly/></p></td>
                    </tr>
                    <tr>
                         <td><p class="pSubir">Caracteristicas <textarea class="txtSubir" id="sCaracteristicas" name="sCaracteristicas"></textarea></p></td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Descipción: <textarea class="txtSubir" id="sDescripcion" name="sDescripcion"></textarea></p></td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Fotos:</p> <br>
                        <p class="pSubir"><input class="txtSubir" id="sFoto" name="sFoto" type="file"/></p><br>
                        <p class="pSubir"><input class="txtSubir" id="sFoto1" name="sFoto1" type="file"/></p><br>
                        <p class="pSubir"><input class="txtSubir" id="sFoto2" name="sFoto2" type="file"/></p>
                        </td>
                    </tr>
                    <tr>
                        <td><p class="pSubir">Videos:</p> <br>
                        <p class="pSubir"><input class="txtSubir" id="sVideo" name="sVideo" type="file"/></p><br>
                        <p class="pSubir"><input class="txtSubir" id="sVideo1" name="sVideo1" type="file"/></p><br>
                        </td>
                    </tr>
                </table>
            </fieldset>
            <br>
            <input id="btnGuardar" type="submit" value="Finalizar"/>
            </form>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
