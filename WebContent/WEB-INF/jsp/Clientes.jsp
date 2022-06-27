<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
<title>Insert title here</title>
</head>
<body>
	<%@include file="./shared/navBar.jsp" %>
    <main>
        <div class="container-fluid mt-5">
            <div class="card">
                <div class="card-header">
                    <h2> Clientes</h2>
                </div>
                <div class="card-body">
                    <div class="botones">
                        <a href="AltaClientes.html"> <button type="button" class="btn btn-secondary"> Agregar Cliente</button> </a>
                    </div>
                    <table id="tabla" class="table table-dark table-striped table-bordered tabla">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>DNI</th>
                                <th>Nombre</th>
                                <th>Apellido</th>
                                <th>Sexo</th>
                                <th>Nacionalidad</th>
                                <th>Fecha nacimiento</th>
                                <th>Direccion</th>
                                <th>Localidad</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                     
                        	<c:forEach items="${listaClientes}" var="item">
				
				               <tr>	
				                  <td> ${item.id}</label> </td>
				                  <td>${item.nombreU}</td>
				                  <td>${item.passU}</td>
				                   <td>
                                    <button class="btn btn-success" type="button" onclick="openModal('Editar');"><i class="fas fa-edit"></i></button>
                                	<button class="btn btn-danger" type="button" onclick="openModal('Eliminar');"><i class="fas fa-times"></i></button>
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
                        <h4 class="modal-title">Editar Cliente</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid" style="margin-top:20px">

                            <div class="row">
                                <div class="col-12">
                                    <label><b>Nombre:</b></label>
                                    <input type="text" placeholder="Ingrese el nombre" class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Apellido:</b></label>
                                    <input type="text" placeholder="Ingrese el apellido" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Correo electrónico:</b></label>
                                    <input type="email" placeholder="Ingrese el correo electrónico"
                                           class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Teléfono:</b></label>
                                    <input type="tel" placeholder="Ingrese el teléfono" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Dirección:</b></label>
                                    <input type="text" placeholder="Ingrese la direccion" class="form-control" />
                                </div>
                                <div class="col-12">
                                    <label><b>Localidad:</b></label>
                                    <input type="text" placeholder="Ingrese la localidad" class="form-control" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>DNI:</b></label>
                                    <br />
                                    <input type="tel" placeholder="Ingrese el DNI" class="form-control" />

                                </div>
                                <div class="col-12">
                                    <label><b>Fecha de nacimiento:</b></label>
                                    <input type="date" class="form-control" />


                                </div>
                            </div>
                            <div class="row">
                                <div class="col-12">
                                    <label><b>Nacionalidad:</b></label>
                                    <br />
                                    <select name="select" class="form-control">
                                        Seleccione
                                        <option value="value1">Argentina</option>
                                        <option value="value2" selected>Uruguay</option>
                                        <option value="value3">Brasil</option>
                                    </select>

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
                        <h4 class="modal-title">Eliminar Cliente</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este cliente?</label>


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