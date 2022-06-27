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

		<div class="divFormulario">
			<div class="card">
				<div class="card-header">
					<h2>Alta de libros</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>T�tulo:</b></label> <input type="text"
								placeholder="Ingrese el t�tulo" class="form-control" />
						</div>
						<div class="col-6">
							<label><b>Idioma:</b></label> <input type="text"
								placeholder="Ingrese el idioma" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Cantidad de p�ginas:</b></label> <input type="number"
								placeholder="Ingrese la cantidad de p�ginas"
								class="form-control" />
						</div>
						<div class="col-6">
							<label><b>Autor:</b></label> <input type="text"
								placeholder="Ingrese el autor" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Descripci�n:</b></label> <input type="text"
								placeholder="Ingrese la descripci�n" class="form-control" />
						</div>
						<div class="col-6">
							<label><b>G�neros:</b></label> <input type="text"
								placeholder="Ingrese los g�neros" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>ISBN: </b></label> <input type="text"
								placeholder="Ingrese ISBN" class="form-control" />

						</div>
						<div class="col-6">
							<label><b>Fecha de lanzamiento:</b></label> <input type="date" class="form-control" />


						</div>
					</div>
					<div class="btn-group mt-3 px-2">
						<input type="button" class="btn btn-success form" value="Aceptar" />
						<input type="button" class="btn btn-danger form" value="Cancelar" />
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
            "emptyTable": "Ning�n dato disponible en esta tabla",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "search": "Buscar:",
            "infoThousands": ",",
            "loadingRecords": "Cargando...",
            "paginate": {
                "first": "Primero",
                "last": "�ltimo",
                "next": "Siguiente",
                "previous": "Anterior"
            },
        }

    });

</script>
</body>
</html>