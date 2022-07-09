<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
     <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    
</head>
<body>
   <%@include file="./shared/navBar.jsp" %>
<main>
    

    
    <div class="container-fluid mt-5">
        <div class="card">
            <div class="card-header">
                <h2> Autores</h2>
            </div>
            <div class="card-body">
                <div class="botones">
                
                    <a href="AltaAutores.html"> <button type="button" class="btn btn-secondary"> Agregar Autor</button> </a>
                </div>
                <table id="tabla" class="table table-dark table-striped tabla table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Nacionalidad</th>
                            <th>Correo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaAutores}" var="item">
								<tr>
									
                                	<td>${item.id}</td>
                                	<td>${item.getNombre()}</td>
                                	<td>${item.getApellido()}</td>
                                	<td>${item.getNacionalidad().getDescripcion()}</td>
                                	<td>${item.getEmail()}</td>
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
        <input type="hidden" id="Mensaje" value="${Mensaje}">
        <div class="modal fade" id="myModalEditar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                	<form action="modificarAutores.html" method="post">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar Autor</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    
                    <div class="modal-body">
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Nombre:</b></label>
                                    <input type="text" placeholder="Ingrese el nombre" class="form-control" name="txtNombre" id="Nombre" />
                                    <input type="hidden" name="ID" id="id" />
                                </div>
                                <div class="col-12">
                                    <label><b>Apellido:</b></label>
                                    <input type="text" placeholder="Ingrese el apellido" class="form-control" name="txtApellido" id="Apellido"  />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Correo electrónico:</b></label>
                                    <input type="text" placeholder="Ingrese el correo electrónico" name="txtMail" id="Mail" pattern="[a-zA-Z0-9!#$%&'*_+-]([\.]?[a-zA-Z0-9!#$%&'*_+-])+@[a-zA-Z0-9]([^@&%$\/()=?¿!.,:;]|\d)+[a-zA-Z0-9][\.][a-zA-Z]{2,4}([\.][a-zA-Z]{2})?"
                                           class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Nacionalidad:</b></label>
                                    <br />
                                    <select name="selectNacionalidad" class="form-control">
                                        <c:forEach items="${Nacionalidades}" var="item">
                                        	<option value="${item.getID() }">${item.getDescripcion() }</option>
                                        </c:forEach>
                                    </select>

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
                        <h4 class="modal-title">Eliminar Autor</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este autor?</label>


                        </div>
                    </div>
                    <form action="bajaAutores.html" method="post">
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
   
</main>


<script>

	

	function openModalEditar(modal, Jsonitem) {
	    $('#myModal' + modal).modal('show');
	    var item = Jsonitem;
	    $('#myModal' + modal + ' #id').val(item.id);
	    $('#myModal' + modal + ' #Nombre').val(item.nombre);
	    $('#myModal' + modal + ' #Apellido').val(item.apellido);
	    $('#myModal' + modal + ' #Mail').val(item.email);
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