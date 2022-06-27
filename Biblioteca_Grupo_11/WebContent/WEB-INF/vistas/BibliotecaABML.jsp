<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/StyleSheetAdmin.css">
<link rel="stylesheet" href="css/ControlsTable.css">
<link rel="stylesheet" href="css/datepicker.css">
<!-- 
<style type="text/css">
	<jsp:include page="css\StyleSheetAdmin.css"></jsp:include>
	<jsp:include page="css\ControlsTable.css"></jsp:include>
	<!-- Date Picker 
	<jsp:include page="css\datepicker.css"></jsp:include>
</style>
 -->

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
			function ConfirmDemo() {
			//Ingresamos un mensaje a mostrar
			var mensaje = confirm("Confirma");
			//Detectamos si el usuario acepto el mensaje
			if (mensaje) {
			alert("Se ha dado de alta corectamente al Alumno Legajo N");
			}
			//Detectamos si el usuario deneg� el mensaje
			else {
			alert("�No se ha dado de alta al alumno!");
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
			<a href="GestionarDocentes.jsp" class="btn btn-dark btn-Menu" role="button"> ABML CLIENTES</a>	
			<a href="GestionarCursos.jsp" class="btn btn-dark btn-Menu" role="button"> PRESTAMOS</a>
		</ul>
	</div>
</div>

<div class="parteDer" >
<div style="margin:auto; height: 500px; widht:480px; background-color:#acd">
<form method="get" action="">
		
<h3>BIBLIOTECAS</h3>

<br>
<button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Agregar bibliotecas</button>
<br>
<div class="form-row">
  
    <div class="form-group col-md-6	">
    
      <label for="ddlEstados">Filtrar por estados: </label>
      
       <select id="ddlEstados" class="form-control">
        <option selected>Seleccione...</option>
        <option>...</option>
      </select>
      <button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Filtrar</button>
      <button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Eliminar filtros</button>
    </div>
    
  </div>

<br>
  	<table>
  		<tr style="text-align:center; font-weight:bold;">

  			<td></td>
  			<td></td>
  			<td>ID</td>
  			<td>Libro</td>
  			<td>Fecha Alta</td>
  			<td>Estado</td>
  		</tr>
	  	<tr>
	  		<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Eliminar</button></td>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Modificar</button></td>
  			<td>1</td>
  			<td>Harry Potter</td>
  			<td>25/05/2010</td>
  			<td>Prestado</td>
  		</tr>
  		<tr>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Eliminar</button></td>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Modificar</button></td>
  			<td>2</td>
  			<td>Harry Potter</td>
  			<td>25/05/2010</td>
  			<td>En biblioteca</td>
  		</tr>
  		<tr>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Eliminar</button></td>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Modificar</button></td>
  			<td>3</td>
  			<td>El principito</td>
  			<td>10/10/2010</td>
  			<td>Prestado</td>
  		</tr>
  		<tr>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Eliminar</button></td>
  			<td><button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Modificar</button></td>
  			<td>4</td>
  			<td>Leo messi</td>
  			<td>24/06/1987</td>
  			<td>En biblioteca</td>
  		</tr>
  	</table>

  </form>
</div>  

	
 </div>



</body>
</html>