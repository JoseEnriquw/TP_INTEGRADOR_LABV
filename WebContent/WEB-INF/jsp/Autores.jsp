<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                        <tr>
                            <td>2302</td>
                            <td>Juan</td>
                            <td>Gomez</td>
                            <td>Venezuela</td>
                            <td>j_gomez@gmail.com</td>
                            <td>
                                <button class="btn btn-success" type="button" onclick="openModal('Editar');"><i class="fas fa-edit"></i></button>
                                <button class="btn btn-danger" type="button" onclick="openModal('Eliminar');"><i class="fas fa-times"></i></button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="modal fade" id="myModalEditar" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Editar Autor</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

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
                        <h4 class="modal-title">Eliminar Autor</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>

                    </div>
                    <div class="modal-body">
                        <div class="container-fluid">

                            <label>¿Desea eleminar este autor?</label>


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