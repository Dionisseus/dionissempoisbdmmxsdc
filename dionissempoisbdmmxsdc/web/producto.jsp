<%-- 
    Document   : producto
    Created on : 05-abr-2015, 21:32:58
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/producto.css" type="text/css" media="screen" />
        <title></title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script>
            $(document).ready(function ($) {

                $('#checkbox').change(function(){
                  setInterval(function () {
                      moveRight();
                  }, 3000);
                });

                      var slideCount = $('#slider ul li').length;
                      var slideWidth = $('#slider ul li').width();
                      var slideHeight = $('#slider ul li').height();
                      var sliderUlWidth = slideCount * slideWidth;

                      $('#slider').css({ width: slideWidth, height: slideHeight });

                      $('#slider ul').css({ width: sliderUlWidth, marginLeft: - slideWidth });

                  $('#slider ul li:last-child').prependTo('#slider ul');

                  function moveLeft() {
                      $('#slider ul').animate({
                          left: + slideWidth
                      }, 200, function () {
                          $('#slider ul li:last-child').prependTo('#slider ul');
                          $('#slider ul').css('left', '');
                      });
                  };

                  function moveRight() {
                      $('#slider ul').animate({
                          left: - slideWidth
                      }, 200, function () {
                          $('#slider ul li:first-child').appendTo('#slider ul');
                          $('#slider ul').css('left', '');
                      });
                  };

                  $('a.control_prev').click(function () {
                      moveLeft();
                  });

                  $('a.control_next').click(function () {
                      moveRight();
                  });
                  
                  //console.log($('#textPregunta').val());
                  $('#hacerPregunta').submit(function(){
                      if($('#textPregunta').val() === ""){
                          alert("Formule una pregunta antes de enviarla");
                      }
                  });
                    
              }); 
        </script>
    </head>
    <body>
        <div id="divContent" role="main">
            <h2>Titulo producto</h2>
            <div id="slider">
                <a href="#" class="control_next">></a>
                <a href="#" class="control_prev"><</a>
                <ul>
                    <li>Foto 1</li>
                    <li>Foto 2</li>
                    <li>Foto 3</li>
                    <li>Foto 4</li>
                    <li>Video 1</li>
                    <li>Video 2</li>
                    <li>Video 3</li>
                </ul>  
            </div>
            <div id="datosCompra">
                <table class="tablaDC">
                    <tr>
                        <td colspan="2">Métodos de pago
                        <select>
                            <option value="default" selected>Elegir</option>
                            <option>Efectivo</option>
                            <option>Targeta crédito/débito</option>
                            <option>Paypal</option>
                        </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Precio</td>
                        <td>Existencias: <input type="text" readonly/></td>
                    </tr>
                    <tr>
                        <td colspan="2">Vigencia: <input type="text" readonly/></td>
                    </tr>
                </table>
            </div>
            <div id="divDescripcion">
                <p>Descripcion del producto</p>
            </div>
            <div id="divPreguntas">
                <h2>Preguntas</h2><br>
                <label>Hacer una pregunta</label><br>
                <form id="hacerPregunta" method="post">
                    <textarea id="textPregunta" name="pregunta"></textarea><br>
                    <input type="submit" class="btnRespuesta" value="Preguntar"/>
                </form>
                <p class="pregunta">Pregunta</p>
                <ul class="respuesta">
                    <li>Respuesta</li>
                </ul>                
            </div>
        </div>
        <%@include file="general.jsp" %>
    </body>
</html>
