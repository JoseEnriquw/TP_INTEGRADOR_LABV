<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="./shared/navBar.jsp"%>
	<main>


	<div class="container-fluid" style="margin-top: 20px">
		<form action="insertBiblioteca.html" method="post">
		<div class="divFormulario">
			<div class="card">
				<div class="card-header">
					<h2>Alta de biblioteca</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>Libro:</b></label> <input type="text" name="txtLibro"
								placeholder="Ingrese el libro" class="form-control" />
						</div>
						
						<div class="col-6">
							<label><b>Fecha de alta:</b></label> <input type="date" name="txtFecha" class="form-control" />


						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Estado:</b></label> 
							<select name="selectEstado" class="form-control">
                                	<option value="En biblioteca">En biblioteca</option>
                                	<option value="Prestado">Prestado</option>
							</select>
						</div>
		
					<div class="btn-group mt-3 px-2">
						<input type="submit" class="btn btn-success form" value="Aceptar" />
							<a class="btn btn-danger form" href="Todosloslibros.html" >Cancelar</a>
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