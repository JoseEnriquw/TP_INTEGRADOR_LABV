<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<form action="insertPrestamos.html" method="post">
		<div class="divFormulario">
			<div class="card">
				<div class="card-header">
					<h2>Alta de préstamos</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>Libro : </b></label> <select class="form-control" name="selectLibro">
								<option value="">Seleccione una opcion</option>
								<option value="El senior de los anillos">El senior de los anillos</option>
								<option value="El Hobbit">El Hobbit</option>
								<option value="El Silmarillion">El Silmarillion</option>
								<option value="Cuentos inconclusos">Cuentos inconclusos de numenor y la tierra
									media</option>
							</select>
						</div>
						<div class="col-6">
							<label><b>Fecha:</b></label> <input type="date" name= "txtFecha" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Cantidad de dias: </b></label> <input type="number" name="txtDias" min="1" class="form-control" />
							<div class="invalid-feedback">Nombre requerido</div>
						</div>
						<div class="col-6">
							<label><b>Cliente:</b></label> <input type="text" name="txtDNI"	placeholder="Ingrese el DNI" class="form-control" />
							<div class="invalid-feedback">Nombre requerido</div>
						</div>
					</div>

					<div class="btn-group mt-3 px-2">
						<input type="submit" class="btn btn-success form" value="Aceptar" />
						<a class="btn btn-danger form" href="Prestamos.html" >Cancelar</a>
					</div>
				</div>
				 <h3>${Mensaje}</h3>
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