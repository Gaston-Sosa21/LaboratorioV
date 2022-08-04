<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">


<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/index.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/StyleSheetAdmin.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/ControlsTable.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/datepicker.css" type="text/css" media="screen" />



<!-- BOOSTRAP  -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<!-- Filtros de Tabla -->
<script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/fixedheader/3.2.0/js/dataTables.fixedHeader.min.js" crossorigin="anonymous"></script>
<script src="./js/FiltrosTheadTabla.js"></script>
<script src="./js/datepicker.js"></script>

<!-- Date Picker -->



<!-- Mensaje de confirmacion -->
<script type="text/javascript">
			function ConfirmDemo(){
				//Ingresamos un mensaje a mostrar
				var mensaje = confirm("Confirma");
				//Detectamos si el usuario acepto el mensaje
				if (mensaje) {
				alert("Se ha dado de alta corectamente al Alumno Legajo N");
				}//Detectamos si el usuario deneg� el mensaje
				else {
					alert("�No se ha dado de alta al alumno!");
				}
			 }
			function MsjCerrarSesion(){
				//Ingresamos un mensaje a mostrar
				var mensaje = confirm("Realmente desea cerrar la sesion?");
				//Detectamos si el usuario acepto el mensaje
				if (mensaje) {
				alert("Se cerrado la sesion correctamente");
				}//Detectamos si el usuario deneg� el mensaje
				else {
					alert("No se ha podido cerrar la sesiom");
				}
			 }
		</script>
</head>
<body>
<div class="parteIzq">
	<div class="titulo2">
		<h2>Administrar: </h2>
	</div>
	<div>	
		<ul>			
			<form action = "ListaBiblioteca.html" method="get">	
				<input type="submit" value="BIBLIOTECA" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 			
			 <form action = "Redireccionar_ListaClientes.html" method="get">	
				<input type="submit" value="CLIENTES" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 
			<form action = "Redireccionar_Login.html" method="get">	
				<input type="submit" value="CERRAR SESION" name="btnConfirmar" onclick="MsjCerrarSesion()"  class="btn btn-dark btn-Menu" ><br>
			</form> 	
		</ul>
	</div>
</div>

<div class="parteDer" >
    
	<div class="titulo1">
		<h1>Administrar Prestamos</h1>
	</div>
	 <form action = "Redireccionar_PrestamosAlta.html" method="get">	
			<input type="submit" value="Nuevo Prestamo" name="btnConfirmar"  class="btn btn-dark botonAlta"><br>
	</form> 
	 <!-- <a href="Redireccionar_index.html" class="btn btn-dark botonAlta" role="button"> Nuevo Cliente</a>
	 -->
		<table class="table table-dark" id="TdWithFilter" >
	  <thead>
	    <tr>
	      <th scope="col">Editar</th>
	      <th scope="col">Eliminar</th>
	      <th scope="col">Libro</th>
	      <th scope="col">Fecha</th>
	      <th scope="col">Cantidad de Dias</th>
	      <th scope="col">Cliente</th>
	    </tr>
	  </thead>
	  <tbody style="text-align:center">
	  <c:forEach items="${listaPrestamos}" var="item">
	    <tr>
	       <!-- <td><a class="btn btn-primary" href="#" role="button">Editar</a></td> -->
	      <td style="text-align:center">
		      <form action = "Redireccionar_EditarBiblioteca.html" method="post">	
					<button type="submit" name="btnConfirmar"  class="btn btn-primary" >
						<i class="fa fa-edit"></i>
					</button>
					<input type="hidden" id="txtEditar" name="txtEditar" class="form-control" value="${item[0].id}">
			  </form> 
	      </td>
	      <td style="text-align:center">
		      <form action = "EliminarPrestamo.html" method="post"> 
			      	<button type="submit" class="btn btn-danger" onclick="confirmarEliminar2()">
						<i class="fa fa-close"></i>
				  	</button>
				  	<input type="hidden" id="txtEliminar" name="txtEliminar" class="form-control" value="${item[0].id}">
				  	<input type="hidden" id="confirmarEliminar" name="confirmarEliminar" class="form-control" value="no">
			  </form>
		  </td>
	     <td style="text-align:center">${item[1].titulo}</td>
	     <td style="text-align:center">${item[0].fecha_prestamo}</td>
  		 <td style="text-align:center">${item[0].cantidad_dias}</td>
  		 <td style="text-align:center">${item[0].cliente.nombres}</td>
	    </tr>
	    
	</c:forEach>    	
	  </tbody>
	</table>	
 </div>
</body>
</html>