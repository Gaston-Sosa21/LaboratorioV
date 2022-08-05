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
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Filtros de Tabla -->
<script src="https://code.jquery.com/jquery-3.5.1.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/fixedheader/3.2.0/js/dataTables.fixedHeader.min.js" crossorigin="anonymous"></script>
<script src="./js/FiltrosTheadTabla.js"></script>
<script src="./js/datepicker.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>


<!-- Date Picker -->



<!-- Mensaje de confirmacion -->
<script type="text/javascript">
			
			function confirmarEliminar2(){
				event.preventDefault(); // prevent form submit
		        var form = event.target.form;
				Swal.fire({
					  title: 'Estas seguro?',
					  text: "",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Confirmar',
					  cancelButtonText: 'Cancelar'
					}).then(function(result){
						
					  if (result.value) {
						//var elem = document.getElementById("confirmarEliminar");
						//elem.value = "si";
						//console.log(elem.value);
						form.submit();
						
					  }
					});
					
			}
			
			function MsjCerrarSesion(){
				event.preventDefault(); // prevent form submit
		        var form = event.target.form;
				Swal.fire({
					  title: 'Estas seguro?',
					  text: "",
					  icon: 'warning',
					  showCancelButton: true,
					  confirmButtonColor: '#3085d6',
					  cancelButtonColor: '#d33',
					  confirmButtonText: 'Confirmar',
					  cancelButtonText: 'Cancelar'
					}).then(function(result){
						
					  if (result.value) {
						//var elem = document.getElementById("confirmarEliminar");
						//elem.value = "si";
						//console.log(elem.value);
						form.submit();
						
					  }
					});
			 }
			 
			 function mostrarMensaje (){
			 
				 if('${mostrarMensaje}'){
				 
					if('${accion}' == "agregar"){
						
						if('${Agrego}' == "si"){
						 	
					 		Swal.fire(
							  'Exito!',
							  'Se agrego correctamente una biblioteca del libro ' + '${Libro}',
							  'success'
							)
					 		
					 	}
					
					 	else{
					 	
							Swal.fire(
							  'Error!',
							  'No se pudo agregar la nueva biblioteca',
							  'error'
							)				 	
					 	}
					
					}
					else if('${accion}' == "editar"){
						
						if('${Edito}' == "si"){
						 	
					 		Swal.fire(
							  'Exito!',
							  'Se edito correctamente la biblioteca con ID: ' + '${Biblioteca}',
							  'success'
							)
					 		
					 	}
						
					 	else{
					 	
							Swal.fire(
							  'Error!',
							  'No se pudo editar la biblioteca',
							  'error'
							)				 	
					 	}
					}
					else{
						
						if('${Elimino}' == "si"){
						 	
					 		Swal.fire(
							  'Exito!',
							  'Se elimino correctamente la biblioteca con ID: ' + '${Biblioteca}',
							  'success'
							)
					 		
					 	}
						
					 	else{
					 	
							Swal.fire(
							  'Error!',
							  'No se pudo eliminar la biblioteca',
							  'error'
							)				 	
					 	}
					}
					 
					 
				 	
					 	
				 }
											 
			 }
			 
			 
		</script>
</head>
<body onLoad="mostrarMensaje()">
<nav class="navbar navbar-dark bg-dark">
<form action ="Home.html" method="post">
<a style="color:white" class="navbar-toggler"><img src="img/casa.png" height="40" width="40"> <input type="submit" value="Home" name="btnSalir"> </a>
</form>
<div class="dropdown">
<a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Session</a>
<div class="dropdown-menu text-center">
<a><img src="img/PerfilUsuario.png" height="80" width="80"></a><br>
<a>Usuario: </a>
<%=session.getAttribute("nombre")%>
<div class="dropdown-divider"></div>
<form action = "Redireccionar_Login.html" method="post">	
<input type="submit" value="Salir" name="btnSalir"><br>
</form>
</div>
</div>
</nav>
<div class="parteIzq">
<div class="titulo2">
		<img src="img/logo02.png" id="ImagenMenu" width="200" height="200">
		
	</div>
	<div>	
		<ul>			
			<form action = "Redireccionar_ListaClientes.html" method="get">	
				<input type="submit" value="CLIENTES" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 			
			 <form action = "Redireccionar_ListaPrestamos.html" method="get">	
				<input type="submit" value="PRESTAMOS" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 	
		
		</ul>
	</div>
</div>

<div class="parteDer">
    
	<div class="titulo1">
		<h1>Administrar Bibliotecas </h1>
	</div>
	 
	  <form action = "Redireccionar_BibliotecaAlta.html" method="get">	
			<input type="submit" value="Nuevo Libro" name="btnConfirmar"  class="btn btn-dark botonAlta"><br>
	</form> 
	 <!-- <a href="Redireccionar_index.html" class="btn btn-dark botonAlta" role="button"> Nuevo Cliente</a>
	 -->
		<table class="table table-dark" id="TdWithFilter" style="text-align:center" >
	  <thead>
	    <tr>
	      <th scope="col">Editar</th>
	      <th scope="col">Eliminar</th>
	      <th scope="col">ID Biblioteca</th>
	      <th scope="col">Libro</th>
	      <th scope="col">Fecha Alta</th>
	      <th scope="col">Estado</th>
	    </tr>
	  </thead>
	  <tbody style="text-align:center">
	  <c:forEach items="${listaBibliotecas}" var="item">
	  
	    <tr>
	       <!-- <td><a class="btn btn-primary" href="#" role="button">Editar</a></td> -->
	      <td style="text-align:center">
		      <form action = "Redireccionar_EditarBiblioteca.html" method="post">	
					<button type="submit" name="btnConfirmar"  class="btn btn-primary" >
						<i class="fa fa-edit"></i>
					</button>
					<input type="hidden" id="txtEditar" name="txtEditar" class="form-control" value="${item[1].id}">
			  </form> 
	      </td>
	      <td style="text-align:center">
		      <form action = "EliminarBiblioteca.html" method="post"> 
			      	<button type="submit" class="btn btn-danger" onclick="confirmarEliminar2()">
						<i class="fa fa-close"></i>
				  	</button>
				  	<input type="hidden" id="txtEliminar" name="txtEliminar" class="form-control" value="${item[1].id}">
				  	<input type="hidden" id="confirmarEliminar" name="confirmarEliminar" class="form-control" value="no">
			  </form>
		  </td>
	     <td style="text-align:center">${item[1].id}</td>
	     <td style="text-align:center">${item[0].titulo}</td>
  			<td style="text-align:center">${item[1].fecha_alta}</td>
  			<td style="text-align:center">
  			
  			<c:choose>
			    <c:when test= "${item[1].estado eq 0}">
			        En biblioteca 
			    </c:when>    
			    <c:otherwise>
			        Prestado 
			    </c:otherwise>
			</c:choose>
  
  			</td>
	    </tr>
	    
	</c:forEach>
	  </tbody>
	</table>
	
 </div>

</body>
</html>