<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    
    <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script> 
    
    
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css">
    <title>Document</title>
</head>
<body>
<script src="https://use.typekit.net/rjb4unc.js"></script>
    <script>try { Typekit.load({ async: true }); } catch (e) { }</script>

    <div class="container">
        <div class="logo">Est? seguro que desea salir?</div>
         <div class="login-item"> 
            <form action="LogOutAceptar.html" method="post" class="form form-login"> 

                <div class="form-field">
                     <input type="submit" value="Aceptar" name="btnAceptar"> 
                </div>
                <div class="form-field">
                    <input type="button" value="Cancelar" name="btnCancelar" onclick="return cancelar();"> 
                </div>
            </form> 
        </div>
    </div>
    <script>
    	function cancelar(){
    		window.location = "http://localhost:9090/TP_INTEGRADOR_GRUPO_9/Index.jsp"
    	}
    </script>
</body>
</html>