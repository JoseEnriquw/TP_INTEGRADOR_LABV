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
                    <h2>Biblioteca</h2>
                </div>
                <div class="card-body">
                <div class="botones">
					<a href="AltaBiblioteca.html"> <button type="button" class="btn btn-secondary">Agregar libro a la biblioteca</button></a>
				</div>
				<div class="row">
                    <div class="col-3">
                        <label><b>Filtrar por estado : </b></label>
                        <select class="form-control" id="selectEstado" selected="En biblioteca">
                        	
                        	<option value="">Todos</option>
                            <option value="En biblioteca">En biblioteca </option>
                            <option value="Prestado">Prestado </option>
                         </select>
                         <input type="hidden" id="hfEstado" value="${EstadoSeleccionado}"/>
                    </div>
                </div>
                </div>
                <br>
                <table id="tabla" class="table table-dark table-striped tabla table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Titulo</th>
                            <th>Fecha de alta</th>
                            <th>Estado</th>
                            <th>Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaBibliotecas}" var="item">
								<tr>
									
                                	<td>${item.getId()}</td>
                                	<td>${item.getLibro().getTitulo()}</td>
                                	<td>${item.getFechaAlta()}</td>
                                	<td>${item.getEstado()}</td>
                                	
                                	<td>
                                    	<button class="btn btn-danger" type="button" onclick="openModal('Eliminar', ${item.id});"><i class="fas fa-times"></i></button>
                                	</td>
                                	
                            	</tr>
						</c:forEach>



                    </tbody>
                </table>
            </div>
            
            
            
             <div class="modal fade" id="myModalEliminar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Eliminar Cliente</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este Libro de Biblioteca?</label>


                        </div>
                    </div>
                    <form action="bajaBiblioteca.html" method="post">
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
        
        $("#selectEstado").on('change', function(){
        	//alert($("#selectEstado").val())
        	window.location = "http://localhost:9090/TP_INTEGRADOR_GRUPO_9/FiltrarBiblioteca.html?estado=" + $("#selectEstado").val();
        })
        
        $(function (){
        	if ($('#hfEstado').val()){
        		$('#selectEstado').val($('#hfEstado').val())
        	}
        })

    </script>
</body>
</html>