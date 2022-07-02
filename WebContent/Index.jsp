<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Document</title>
    <script>

      function load(){
    	  var usuario = $('#usuarioLogueado').text();
    	  console.log(usuario);
    	  if (usuario == ""){
    		  window.location = 'http://localhost:9090/TP_INTEGRADOR_GRUPO_9/Login.html';  
    	  }
    	  
      }
      

</script>
</head>
<body onload="load()">
 
<%@include file="./WEB-INF/jsp/shared/navBar.jsp"%>

            <div class="background">
              <div class="container">
                <h2 >Biblioteca de Alejandria</h2>
              </div>
           
            </div>
      <main>

      </main>
       
      
</body>

</html>