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
</head>
<body>

	<%@include file="./shared/navBar.jsp"%>
	<main>

	<div class="container-fluid" style="margin-top: 20px">
		<form action="insertAutores.html" method="post">
		<div class ="boton volver">
			<a class="btn btn-secondary form" href="Autores.html" >Volver</a>
		 </div>
		<div class="divFormulario">
			<div class="card">
				<div class="card-header">
					<h2>Alta de autores</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>Nombre:</b></label> <input type="text" name="txtNombre" id="nombre" pattern="^[A-Za-z]+$"
								placeholder="Ingrese el nombre" class="form-control" required />
						</div>
						<div class="col-6">
							<label><b>Apellido:</b></label> <input type="text" name="txtApellido" id="apellido" pattern="^[A-Za-z]+$"
								placeholder="Ingrese el apellido" class="form-control" required />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Correo electrónico:</b></label> <input type="email" name="txtMail" id="mail" 
								placeholder="Ingrese el correo electrónico" class="form-control" required />
						</div>
						<div class="col-6">
							<label><b>Nacionalidad:</b></label> <br /> 
							<select name="selectNacionalidad" class="form-control" required>
								<c:forEach items="${Nacionalidades}" var="item">
                                	<option value="${item.getID() }">${item.getDescripcion() }</option>
                                </c:forEach>
							</select>
						</div>
					</div>

					<div class="btn-group mt-3 px-2">
						<input type="submit" class="btn btn-success form" value="Aceptar" id="btnAceptar" />
							<a class="btn btn-danger form" href="Autores.html" >Cancelar</a>
					</div>
					<div>
                        <h3>${Mensaje}</h3>
                    </div>
				</div>
			</div>
		</div>
		</form>
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