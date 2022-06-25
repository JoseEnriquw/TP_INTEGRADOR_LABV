<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                    <div class="col-3">
                        <label><b>Filtrar por estado : </b></label>
                        <select class="form-control">
                            <option>En Biblioteca </option>
                            <option>Prestado </option>
                        </select>
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
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Row 1 Data 1</td>
                            <td>Row 1 Data 2</td>
                            <td>Row 2 Data 1</td>
                            <td>Row 2 Data 1</td>
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
                "emptyTable": "Ning�n dato disponible en esta tabla",
                "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
                "infoFiltered": "(filtrado de un total de _MAX_ registros)",
                "info": "Mostrando p�gina _PAGE_ de _PAGES_",
                "search": "Buscar:",
                "infoThousands": ",",
                "loadingRecords": "Cargando...",
                "paginate": {
                    "first": "Primero",
                    "last": "�ltimo",
                    "next": "Siguiente",
                    "previous": "Anterior"
                },
            }

        });

    </script>
</body>
</html>