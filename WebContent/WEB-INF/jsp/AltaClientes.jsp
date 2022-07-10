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

       
		<form action="insertClientes.html" method="post">
		
		
			<div class="divFormulario">
				<div class="card">
					<div class="card-header">
						<h2>Alta de clientes</h2>
					</div>
					<div class="card-body">
						<div class="row">
							<div class="col-6">
								<label><b>Nombre:</b></label> 
								<input type="text" name="txtNombre" placeholder="Ingrese el nombre" class="form-control" pattern="[a-zA-Z ]{2,254}" required/>
							</div>
							<div class="col-6">
								<label><b>Apellido:</b></label> 
								<input type="text" name="txtApellido" placeholder="Ingrese el apellido" class="form-control" pattern="[a-zA-Z ]{2,254}" required/>
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label><b>Correo electr�nico:</b></label> <input type="email" name="txtMail"
									placeholder="Ingrese el correo electr�nico"
									class="form-control" required/>
							</div>
							<div class="col-6">
								<label><b>Tel�fono:</b></label> <input type="tel" name="txtTelefono"
									placeholder="Ingrese el tel�fono" class="form-control" pattern="^(0|[1-9][0-9]*)$" required/>
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label><b>Direcci�n:</b></label> <input type="text" name="txtDireccion"
									placeholder="Ingrese la direccion" class="form-control" required />
							</div>
							<div class="col-6">
								<label><b>Localidad:</b></label> <input type="text" name="txtLocalidad"
									placeholder="Ingrese la localidad" class="form-control"  required />
							</div>
						</div>
						<div class="row">
							<div class="col-6">
								<label><b>DNI:</b></label> <br /> <input type="tel" name="txtDni"
									placeholder="Ingrese el DNI" class="form-control" pattern="^(0|[1-9][0-9]*)$" required/>

							</div>
							<div class="col-6">
								<label><b>Fecha de nacimiento:</b></label> <input type="date" name="txtFecha"
									class="form-control" required/>


							</div>
						</div>
						<div class="row">
							<div class="col-6">
									<label><b>Nacionalidad:</b></label> <br /> 
							<select name="selectNacionalidad" class="form-control" required>
								<c:forEach items="${Nacionalidades}" var="item">
                                	<option value="${item.getID() }">${item.getDescripcion() }</option>
                                </c:forEach>
							</select>

							</div>

						</div>
						<div class=" mt-3 px-2">
							<input type="submit" class="btn btn-success form" value="Guardar" />
							<a class="btn btn-danger form" href="Clientes.html" >Volver</a>
						</div>
                        
					</div>
				</div>
			</div>
		</form>
	</div>


	</main>


	<script>
		$('#tabla')
				.DataTable(
						{

							"language" : {
								"processing" : "Procesando...",
								"lengthMenu" : "Mostrar _MENU_ registros",
								"zeroRecords" : "No se encontraron resultados",
								"emptyTable" : "Ning�n dato disponible en esta tabla",
								"infoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
								"infoFiltered" : "(filtrado de un total de _MAX_ registros)",
								"search" : "Buscar:",
								"infoThousands" : ",",
								"loadingRecords" : "Cargando...",
								"paginate" : {
									"first" : "Primero",
									"last" : "�ltimo",
									"next" : "Siguiente",
									"previous" : "Anterior"
								},
							}

						});
	</script>
</body>
</html>