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
                <form action="modificarLibros.html" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar Libro</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-12">
                                    <label><b>Título:</b></label>
                                    <input type="text" placeholder="Ingrese el titulo" name="txtTitulo" class="form-control" id="titulo" pattern="[a-zA-Z ]{2,254}" required/>
                                    <input type="hidden" name="ID" id="id" />
                                </div>
                                <div class="col-12">
                                    <label><b>Fecha de lanzamiento:</b></label>
                                    <input type="date" class="form-control" name="txtFecha" id="fechaLanzamiento" pattern="[a-zA-Z ]{2,254}" required/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Idioma:</b></label>
                                    <input type="text" name="txtIdioma" placeholder="Ingrese el idioma" class="form-control" id="idioma" pattern="^[a-zA-ZÀ-ÿ\u00f1\u00d1]+(\s*[a-zA-ZÀ-ÿ\u00f1\u00d1]*)*[a-zA-ZÀ-ÿ\u00f1\u00d1]+$" required />
                                </div>
                                <div class="col-12">
                                    <label><b>Cant. de páginas:</b></label>
                                    <input type="number" min="1" name ="txtCant" placeholder="Ingrese la cantidad de páginas" class="form-control" id="cantPaginas" pattern="[a-zA-Z ]{2,254}" required/>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Autor:</b></label>
                                  <select name="selectAutores" class="form-control" required>
								<c:forEach items="${Autores}" var="item">
                                	<option value="${item.getId() }">${item.getNombre() } ${item.getApellido() }</option>
                                </c:forEach>
							</select>
                                </div>
                                <div class="col-12">
                                    <label><b>Descripción:</b></label>
                                    <input type="text" name="txtDesc" placeholder="Ingrese la cantidad de páginas" class="form-control" id="descripcion" pattern="[a-zA-Z ]{2,254}" required/>

                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                <label><b>Géneros:</b></label> </br>
									<c:forEach items="${Generos}" var="item">
								 		<input type="checkbox" name="chkGenero" value="${item.getID()}" id="${item.getDescripcion()}">
                                 		<label for="chkGenero">${item.getDescripcion()}</label><br>
									</c:forEach> 
								</div>

                            </div>

                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success"><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>
                    </div>
                       </form>
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
                    <form action="bajaLibros.html" method="post">
                    <div class="modal-footer">
                    	<input type="hidden" id="id" name="ID" />
                        <button type="submit" class="btn btn-success" data-bs-dismiss="modal"><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>
                    </div>
                    </form>
                </div>

            </div>
        </div>

	</div>
	<input type="hidden" id="Mensaje" value="${Mensaje}">
	</main>


	<script>
	function openModalEditar(modal, Jsonitem) {
	    $('#myModal' + modal).modal('show');
	    var item = Jsonitem;
	    $('#myModal' + modal + ' #id').val(item.isbn);
	    $('#myModal' + modal + ' #titulo').val(item.titulo);
	    $('#myModal' + modal + ' #cantPaginas').val(item.cantPaginas);
	    $('#myModal' + modal + ' #idioma').val(item.idioma);
	    $('#myModal' + modal + ' #descripcion').val(item.descripcion);	   
	    $('#myModal' + modal + ' #fechaLanzamiento').val(new Date(item.fechaLanzamiento).toISOString().split('T')[0]);
	    for (const genero of item.generos){
	    	document.getElementById(genero.descripcion).checked = true;
	    }
	    
	}
	
	function openModal(modal, id) {
	    $('#myModal' + modal).modal('show');
	    $('#myModal' + modal + ' #id').val(id);
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
    
    $(function() {
    	if ($('#Mensaje').val()){
    		Swal.fire({
    			  text: $('#Mensaje').val(),
    			  confirmButtonText: 'Aceptar',
    			  confirmButtonColor: '#3085d6'
    			})
    	}
    	
    })

</script>

</body>
</html>