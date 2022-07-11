<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous"/>


<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/StyleSheetAdmin.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/ControlsTable.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/datepicker.css" type="text/css" media="screen" />


<!-- BOOSTRAP  -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>

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
			alert("Se ha dado de alta corectamente al Cliente");
			}
			//Detectamos si el usuario denegó el mensaje
			else {
			alert("¡No se ha dado de alta al cliente!");
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
			<form action = "Redireccionar_ListaClientes.html" method="get">	
				<input type="submit" value="CLIENTES" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 			
			 <form action = "Redireccionar_ListaBiblioteca.html" method="get">	
				<input type="submit" value="BIBLIOTECA" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 
			 <form action = "Redireccionar_ListaPrestamos.html" method="get">	
				<input type="submit" value="PRESTAMOS" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 
		</ul>
	</div>
</div>

<div class="parteDer" >


	 <form action="GuardarCliente.html" method="post">
		
	
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputNombre">Nombre</label>
      <input type="nombre" class="form-control" id="inputNombre" name="txtNombre">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Apellido</label>
      <input type="apellido" class="form-control" id="inputApellido" name="txtApellido">
    </div>
  </div>
  <div class="form-row">
  				<div class="form-group col-md-6">
                <label for="fechaNacimiento">Fecha de Nacimiento</label>
                <input type="datetime-local" name="date4" id="date4" class="form-control datepicker" aria-labelledby="date4-label">
           		
   </div>
            
  
 
		   <div class="form-group col-md-6">
		     <label for="inputDni">DNI</label>
		     <input type="text" class="form-control" id="inputDni" name="txtDni">
		   </div>
		 </div>
  
  <div class="form-group">
    <label for="inputAddress">Direccion</label>
    <input type="text" class="form-control" id="inputDirecccion" placeholder="" name="txtDireccion">
  </div>
  
  <div class="form-row">
      <div class="form-group col-md-6">
      <label for="inputNacionalidad">Nacionalidad</label>
      <select id="inputNacionalidad" class="form-control" name="txtNacionalidad">
        <option selected>Seleccione...</option>
        <option>...</option>
      </select>
      </div>
      
      <div class="form-group col-md-6">
      <label for="inputProvincia">Localidad</label>
      <select id="inputProvincia" class="form-control" name="txtLocalidad">
        <option selected>Seleccione...</option>
        <option>...</option>
      </select>
      </div>
    
    </div>
    
  <div class="form-group">
    <label for="inputEmail">Email</label>
    <input type="text" class="form-control" id="inputEmail" placeholder="" name="txtMail">
  </div>
  
  <div class="form-group">
    <label for="inputTelefono">Telefono</label>
    <input type="text" class="form-control" id="inputTelefono" placeholder="" name="txtTelefono">
  </div>
  
     <button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Agregar</button>
  
</form>
	
 

	
 </div>



</body>
</html>