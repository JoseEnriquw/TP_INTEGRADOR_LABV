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
					<h2>Alta de clientes</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>Nombre:</b></label> <input type="text"
								placeholder="Ingrese el nombre" class="form-control" />
						</div>
						<div class="col-6">
							<label><b>Apellido:</b></label> <input type="text"
								placeholder="Ingrese el apellido" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Correo electrónico:</b></label> <input type="email"
								placeholder="Ingrese el correo electrónico" class="form-control" />
						</div>
						<div class="col-6">
							<label><b>Teléfono:</b></label> <input type="tel"
								placeholder="Ingrese el teléfono" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Dirección:</b></label> <input type="text"
								placeholder="Ingrese la direccion" class="form-control" />
						</div>
						<div class="col-6">
							<label><b>Localidad:</b></label> <input type="text"
								placeholder="Ingrese la localidad" class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>DNI:</b></label> <br /> <input type="tel"
								placeholder="Ingrese el DNI" class="form-control" />

						</div>
						<div class="col-6">
							<label><b>Fecha de nacimiento:</b></label> <<input type="date" />


						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<label><b>Nacionalidad:</b></label> <br /> <select name="select">
								Seleccione
								<option value="value1">Argentina</option>
								<option value="value2" selected>Uruguay</option>
								<option value="value3">Brasil</option>
							</select>

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