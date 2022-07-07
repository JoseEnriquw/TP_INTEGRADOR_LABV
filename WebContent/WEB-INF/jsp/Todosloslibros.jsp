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

	<div class="container-fluid mt-5">
		<div class="card">
			<div class="card-header">
				<h2>Todos los Libros</h2>
			</div>
			<div class="card-body">
				<div class="botones">
					<a href="AltaLibros.html"> <button type="button" class="btn btn-secondary">Agregar Libro</button></a>
				</div>
				<table id="tabla"
					class="table table-dark table-striped tabla table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Titulo</th>
							<th>Fecha de lanzamiento</th>
							<th>Idioma</th>
							<th>Cant. de páginas</th>
							<th>Autor</th>
							<th>Descripcion</th>
							<th>Géneros</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listaLibros}" var="item">
								<tr>
									
                                	<td>${item.getId()}</td>
                                	<td>${item.getTitulo()}</td>
                                	<td>${item.getFechaLanzamiento()}</td>
                                	<td>${item.getIdioma()}</td>
                                	<td>${item.getCantPaginas()}</td>
                                	<td>${item.getAutor().getNombre()} ${item.getAutor().getApellido()}</td>
                                	<td>${item.getDescripcion()}</td>
                                	<td>${item.getGenerosString()}</td>
                                	<td>
                                    	<button class="btn btn-success" type="button" onclick='openModalEditar("Editar",${item.ConvertToJson()});'><i class="fas fa-edit"></i></button>
                                		<button class="btn btn-danger" type="button" onclick="openModal('Eliminar', ${item.id});"><i class="fas fa-times"></i></button>
                                	</td>
                                	
                            	</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="modal fade" id="myModalEditar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar Libro</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-12">
                                    <label><b>Título:</b></label>
                                    <input type="text" placeholder="Ingrese el titulo" class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Fecha de lanzamiento:</b></label>
                                    <input type="date" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Idioma:</b></label>
                                    <input type="text" placeholder="Ingrese el idioma" class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Cant. de páginas:</b></label>
                                    <input type="number" placeholder="Ingrese la cantidad de páginas" class="form-control" />

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Autor:</b></label>
                                    <input type="text" placeholder="Ingrese el autor" class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Descripción:</b></label>
                                    <input type="text" placeholder="Ingrese la cantidad de páginas" class="form-control" />

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Géneros:</b></label>
                                    <input type="text" placeholder="Ingrese el género" class="form-control" />
                                </div>

                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal"><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>

                    </div>
                </div>

            </div>
        </div>
        <div class="modal fade" id="myModalEliminar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Libro</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este libro?</label>


                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal"><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>

                    </div>
                </div>

            </div>
        </div>

	</div>

	</main>


	<script>
	function openModal(modal) {
        $('#myModal' + modal).modal('show');
    }

    $('#tabla').DataTable({

        "language": {
            "processing": "Procesando...",
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "emptyTable": "Ningún dato disponible en esta tabla",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "info": "Mostrando página _PAGE_ de _PAGES_",
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