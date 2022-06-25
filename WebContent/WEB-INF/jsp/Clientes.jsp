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
                            <tr>
                                <td>1002</td>
                                <td>33092123</td>
                                <td>Pepe</td>
                                <td>Alvarez</td>
                                <td>Hombre</td>
                                <td>Argentina</td>
                                <td>12/07/1989</td>
                                <td>Av. Palacios 1923</td>
                                <td>Berazategui</td>
                                <td>pepe@gmail.com</td>
                                <td>11 2345-9021</td>
                                <td>
                                    <button class="btn btn-success" type="button"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-danger" type="button"><i class="fas fa-times"></i></button>
                                </td>
                            </tr>



                        </tbody>
                    </table>
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