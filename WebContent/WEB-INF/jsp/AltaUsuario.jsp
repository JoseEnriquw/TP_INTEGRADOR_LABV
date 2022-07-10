<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
    
    <!-- <style><//%@include file="/WEB-INF/css/css.css"%></style><style><//%@include file="/WEB-INF/css/css.css"%></style> -->
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/css.css"/>
    
    <title>Document</title>
</head>
<body>
  <%@include file="./shared/navBar.jsp" %>
<main>
    

    <div class="container-fluid" style="margin-top:20px">

        
        <div class="divFormulario">
            <div class="card">
                <div class="card-header">
                    <h2> Alta de Usuarios</h2>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <label><b>Usuario:</b></label>
                            <input type="text" placeholder="Ingrese el Usuario" class="form-control" />
                        </div>
                        <div class="col-6">
                            <label><b>Contraseña:</b></label>
                            <input type="password" placeholder="Ingrese la contraseña" class="form-control" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label><b>Rol:</b></label>
                            <input type="text" placeholder="Ingrese el rol" class="form-control" />
                        </div>
                       
                    </div>               
                    <div class="mt-3 px-2">
                        <input type="button" class="btn btn-success form" value="Guardar" />
                        <input type="button" class="btn btn-danger form" value="Volver" />
                    </div>
                   
                </div>
            </div>
        </div>
    </div>

   
</main>


<script>
    $('#tabla').DataTable({

        "language": {
            "processing": "Procesando...",
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "emptyTable": "Ningún dato disponible en esta tabla",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "search": "Buscar:",
            "infoThousands": ",",
            "loadingRecords": "Cargando...",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            },
        }

    });

</script>

</body>
</html>