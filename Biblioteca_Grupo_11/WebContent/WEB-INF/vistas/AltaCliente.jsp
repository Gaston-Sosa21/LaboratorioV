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
		</script>
</head>
<body>
<div class="parteIzq">
	<div class="titulo2">
		<h2>Administrar: </h2>
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


	 <form action="GuardarCliente.html" method="post">
	
	
  <input type="hidden" id="txtID" class="form-control"  name="IdCliente" value="${DatosCliente.id}">
	
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
  
  <div>
  
 
           <div class="form-group col-md-6">       
       <label for="txtNacionalidad">Nacionalidad</label>      
       <select id="nacionalidad" name="txtNacionalidad" class="form-control">
       <option value="-1" disabled selected>Seleccione...</option>
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
    
      <div class="form-group">
    <label for="inputEmail">Email</label>
    <input type="text" class="form-control" id="inputEmail" placeholder="" name="txtMail" value="${DatosCliente.email}">
  </div>
  
  <div class="form-group">
    <label for="inputTelefono">Telefono</label>
    <input type="text" class="form-control" id="inputTelefono" placeholder="" maxlength="10" name="txtTelefono" onkeypress="return valideKey(event);" value="${DatosCliente.telefono}">
  </div>
  
  
       <button type="submit" class="btn btn-primary" onclick="ConfirmDemo()" >Guardar</button>
 </form>
  
    </div>
    

	



</body>
</html>