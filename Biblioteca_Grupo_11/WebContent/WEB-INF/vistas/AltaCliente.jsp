<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>

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

			
			function AltaOrModification(){
				var url = window.location.href;

			}
			
		   function valideKey(evt){	    
			   var code = (evt.which) ? evt.which : evt.keyCode;
			    
			  if(code==8) { 
				  return true;
	    	  } else if(code>=48 && code<=57) { 
				   return true;
	     	 } else{
				   return false;
			  }
			}
		   
		   function confirmarGuardar(){
				
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
						
						
						var nombre = document.getElementById('inputNombre').value;
						var apellido = document.getElementById('inputApellido').value;
						var email = document.getElementById('inputEmail').value;
						var clave = document.getElementById('inputDni').value;
						var nacionalidad = document.getElementById('nacionalidad').selectedIndex;
						var fecha = document.getElementById('txtFecha').value;
						
						  if (clave.length < 7) {
						    alert('Debe ingresar un DNI real');
						    return;
						  }
						  if(email.length == 0) {
						    alert('No has escrito nada en el campo mail');
						    return;
						  }
						  if(nombre.length == 0 || apellido.lenght) {
						    alert('Debe completar el nombre!');
						    return;
						  }
						  if(fecha.length == 0) {
							    alert('Debe seleccionar una fecha');
							    return;
						  }
						  if(nacionalidad == null || nacionalidad == 0) {
							    alert('Debe seleccionar una nacionalidad');
							    return;
						  }
						
					  if (result.value) {
						var elem = document.getElementById("txtGuardar");
						
						elem.value = "si";
						
					
						
						form.submit();
					  }
					});
			}
		 
		</script>
		<style>
		.botonHome{
			webkit-appearance: button;
    		background-color: #343a40!important;
    		color: white;
    		border: 0;
		}
		</style>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">
<form action ="Home.html" method="post">
<a style="color:white" class="navbar-toggler"><img src="img/casa.png" height="40" width="40"> <input type="submit" class="botonHome"  value="Home" name="btnSalir"> </a>
</form>
<div class="dropdown">
<a style="color: white" href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Cerrar Session</a>
<div class="dropdown-menu text-center">
<a><img src="img/PerfilUsuario.png" height="80" width="80"></a><br>
<a>Usuario: </a>
<%=session.getAttribute("nombre")%>
<div class="dropdown-divider"></div>
	<div class="titulo2">
		<img src="img/biblioteca.jpg" id="ImagenMenu" width="200" height="200">
	</div>
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
	<br><br>
		<ul>
			<form action = "Redireccionar_ListaClientes.html" method="get">	
				<input type="submit" value="CLIENTES" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 			
			 <form action = "ListaBiblioteca.html" method="get">	
				<input type="submit" value="BIBLIOTECA" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 
			 <form action = "Redireccionar_ListaPrestamos.html" method="get">	
				<input type="submit" value="PRESTAMOS" name="btnConfirmar"  class="btn btn-dark btn-Menu" ><br>
			</form> 
		</ul>
	</div>
</div>

<div class="parteDer" >

	<a> DATOS DEL CLIENTE </a>
	 <form action="GuardarCliente.html" method="post" id="formulario">
	
	
  <input type="hidden" id="txtID" class="form-control"  name="IdCliente" value="${DatosCliente.id}">
	<br>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputNombre">Nombre</label>
      <input type="nombre" class="form-control" id="inputNombre" name="txtNombre" value="${DatosCliente.nombres}">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Apellido</label>
      <input type="apellido" class="form-control" id="inputApellido" name="txtApellido" value="${DatosCliente.apellidos}">
    </div>
  </div>
   
  <div class="form-row">
  				<div class="form-group col-md-6">
                <label for="fechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" name="txtFecha" id="txtFecha" class="form-control datepicker"  value="${DatosCliente.fecha_nacimiento}">
           		       
       </div>    
         
		   <div class="form-group col-md-6">
		     <label for="inputDni">DNI</label>
		     <input type="text" class="form-control" id="inputDni" name="txtDni" maxlength="8" onkeypress="return valideKey(event);" value="${DatosCliente.dni}">
		   </div>
		 </div>
  
  <div class="form-group">
    <label for="inputAddress">Direccion</label>
    <input type="text" class="form-control" id="inputDirecccion" placeholder="" name="txtDireccion" value="${DatosCliente.direccion}">
  </div>
  
  <div class="form-row">
  
 
           <div class="form-group col-md-6">       
       <label for="txtNacionalidad">Nacionalidad</label>      
       <select id="nacionalidad" name="txtNacionalidad" class="form-control">
       <option value="" disabled selected>Seleccione...</option>
       <c:forEach items="${ListaNacionalidades}" var="item">     
           <c:choose>
       		<c:when test="${item.id eq IdNacionalidad}">    
	        	<option value="${item.id}" selected>${item.descripcion}</option>    
	    	</c:when>
	    	<c:otherwise>
                <option value="${item.id}">${item.descripcion}</option>    
            </c:otherwise>
	    
	       </c:choose>   
		</c:forEach>
	   </select>   
    </div> 
    
      <div class="form-group col-md-6">
      <label for="inputLocalidad">Localidad</label>
      <select id="inputLocalidad" class="form-control" name="txtLocalidad" >
      <option value="-1" disabled selected>Seleccione...</option>
      
        <c:forEach items="${ListarLocalidadaes}" var="item">     
           <c:choose>
       		<c:when test="${item eq DatosCliente.localidad}">    
	        	<option selected>${item}</option>    
	    	</c:when>
	    	<c:otherwise>
                <option >${item}</option>    
            </c:otherwise>
	    
	       </c:choose>   
		</c:forEach>
        
      </select>
      </div>
   </div>
     <div class="form-row">
    
      <div class="form-group col-md-6">
    <label for="inputEmail">Email</label>
    <input type="text" class="form-control" id="inputEmail" placeholder=""  name="txtMail" value="${DatosCliente.email}" required>
  </div>
  
  <div class="form-group col-md-6">
    <label for="inputTelefono">Telefono</label>
    <input type="text" class="form-control" id="inputTelefono" placeholder="" maxlength="10" name="txtTelefono" onkeypress="return valideKey(event);" value="${DatosCliente.telefono}">
  </div>
  </div>
  
  <div>
  <button type="submit" class="btn btn-primary" onclick="confirmarGuardar()" >Guardar</button>
       <input type="hidden" id="txtGuardar" name="txtGuardar" class="form-control" value="no">
  </div>
</form>
  
    </div>
    

	



</body>
</html>