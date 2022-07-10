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
	 <%@include file="./shared/navBar.jsp" %>
<main>    
    <div class="container-fluid mt-5">
        <div class="card">
            <div class="card-header">
                <h2> Préstamos</h2>
            </div>
            <div class="card-body">
                <div class="botones">
                 <a href="AltaPrestamos.html" >   <button type="button" class="btn btn-secondary"> Agregar Préstamo</button> </a>  
                </div>
                <table id="tabla" class="table table-dark table-striped tabla table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Libro</th>
                            <th>Fecha de préstamo</th>
                            <th>Cant. de días</th>
                            <th>Cliente</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                       <c:forEach items="${listaPrestamos}" var="item">
								<tr>
                                	<td>${item.getId()}</td>
                                	<td>${item.getBiblioteca().getLibro().getTitulo()}</td>
                                	<td>${item.getFechaPrestamo()}</td>
                                	<td>${item.getCantDias()}</td>
                                	<td>${item.getCliente().getNombre()}</td>
                                	
                                	<td>
                                    	<button class="btn btn-success" type="button" onclick='openModaleditar("Editar",${item.ConvertToJson()});'><i class="fas fa-edit"></i></button>
                                		<button class="btn btn-danger" type="button" onclick="openModal('Eliminar', ${item.id}, ${item.getBiblioteca().getId()});"><i class="fas fa-times"></i></button>
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
                <form action="modificarPrestamo.html" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar Préstamo</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <div class="row">
                                <div class="col-12">
                                    <label><b>Biblioteca:</b></label>
                                    <input type="text" placeholder="Ingrese la biblioteca" class="form-control" id="Titulo" readonly />
                                     <input type="hidden" name="ID" id="id" />
                                </div>
                                <div class="col-12">
                                    <label><b>Fecha de préstamo:</b></label>
                                    <input type="date" class="form-control" id="FechaPrestamo" readonly/>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Cant de dias:</b></label>
                                    <input type="number" placeholder="Ingrese la cantidad de páginas"  name="txtDias" class="form-control" id="Dias" />
                                </div>
                                <div class="col-12">
                                    <label><b>Cliente:</b></label>
                                    <input type="text" placeholder="Ingrese el cliente" class="form-control" id="Cliente" readonly/>
                                </div>
                            </div>


                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-success" ><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>

                    </div>
                     </form>
                </div>
			 <h3>${Mensaje}</h3>
            </div>
        </div>
        <div class="modal fade" id="myModalEliminar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Préstamo</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este préstamo?</label>


                        </div>
                    </div>
                   <form action="bajaPrestamos.html" method="post">
                    <div class="modal-footer">
                    	<input type="hidden" id="id" name="ID" />
                    	<input type="hidden" id="idbiblioteca" name="IDbiblioteca" />
                        <button type="submit" class="btn btn-success" data-bs-dismiss="modal"><i class="fa fa-check"></i>Aceptar</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal"><i class="fa fa-times"></i> Cancelar</button>
                    </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
   
</main>


<script>

function openModal(modal, id, idbiblioteca) {
    $('#myModal' + modal).modal('show');
    $('#myModal' + modal + ' #id').val(id);
    $('#myModal' + modal + ' #idbiblioteca').val(idbiblioteca);
}


	function openModaleditar(modal,Jsonitem) {
	    $('#myModal' + modal).modal('show');
	    var item = Jsonitem;
	    $('#myModal' + modal + ' #id').val(item.id);
	    $('#myModal' + modal + ' #Titulo').val(item.biblioteca.libro.titulo);
	    var date = new Date(item.fechaPrestamo);
	    $('#myModal' + modal + ' #FechaPrestamo').val(date.toJSON().slice(0,10));
	    $('#myModal' + modal + ' #Dias').val(item.cantDias);
	    $('#myModal' + modal + ' #Dias').attr("min",item.cantDias);
	    $('#myModal' + modal + ' #Cliente').val(item.cliente.nombre);
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