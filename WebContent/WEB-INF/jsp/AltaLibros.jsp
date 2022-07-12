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
		<form action="insertLibro.html" method="post">
		
		<div class="divFormulario">
			<div class="card">
				<div class="card-header">
					<h2>Alta de libros</h2>
				</div>
				<div class="card-body">
					<div class="row">
						<div class="col-6">
							<label><b>Título:</b></label> <input type="text" name="txtTitulo"
								placeholder="Ingrese el título" class="form-control" required />
						</div>
						<div class="col-6">
							<label><b>Idioma:</b></label> <input type="text" name="txtIdioma"
								placeholder="Ingrese el idioma" class="form-control" pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$" required />
						</div>
					</div>
					<div class="row">
						<div class="col-6">
							<label><b>Cantidad de páginas:</b></label> <input type="number" name="txtCant" min="1"
								placeholder="Ingrese la cantidad de páginas"
								class="form-control" required />
						</div>
						<div class="col-6">
							<label><b>Autor:</b></label> 
							<select name="selectAutores" class="form-control" required>
								<c:forEach items="${Autores}" var="item">
                                	<option value="${item.getId() }">${item.getNombre() } ${item.getApellido() }</option>
                                </c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row">
						
						<div class="col-6">
							<label><b>Fecha de lanzamiento:</b></label> <input type="date" name="txtFecha" class="form-control" required/>
							
						</div>
					</div>
					
					<div class="row">
						
						<div class="col-12">							
							<label><b>Descripción:</b></label> <input type="textarea" name="txtDesc"
								placeholder="Ingrese la descripción" class="form-control" required/>
						

						</div>
					</div>
					
					
					
					
					
					<div class="row">
						
						<div class="col-6">
						<label><b>Generos:</b></label> </br>
							<c:forEach items="${Generos}" var="item">
								 <input type="checkbox" name="chkGenero" class="chkGenero"  value="${item.getID()}">
                                 <label for="chkGenero">${item.getDescripcion()}</label><br>
							</c:forEach> 
						</div>
					</div>
					<div class="mt-3 px-2">
						<input type="submit" class="btn btn-success form" value="Guardar" id="btnAceptar" />
							<a class="btn btn-danger form" href="Todosloslibros.html" >Volver</a>
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
    
    $('form').submit(function(e){
    // si la cantidad de checkboxes "chequeados" es cero,
    // entonces se evita que se envíe el formulario y se
    // muestra una alerta al usuario
	    if ($('input[type=checkbox]:checked').length === 0) {
	        e.preventDefault();
	        swal.fire('Debe seleccionar por lo menos un género!');
	    }
	});


</script>
</body>
</html>