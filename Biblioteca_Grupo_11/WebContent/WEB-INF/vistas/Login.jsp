<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Sistema de Administracion de Biblioteca</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
</head>
</head>
<body class="noOverflow">
<div class="tittle-header"> 
	<h1 class="text-center"> Bienvenidos</h1>
	<h2 class="text-center">Sistema de Administracion de Biblioteca</h2>
</div>
<div class="text-center">
	<div class="modal-dialog" id="base-login" style="display: block; justify-content: center;text-align: -webkit-center;">
	    <div class="col-sm-8 main-section">
		   	   
		    	
		     	<form action = "Redireccionar_ClienteAlta.html" method="post">
					
					<div class="loginDiv">
					<br><br>
						<p>Nombre de usuario</p>
						<input type="text" name="txtUsuario"  class="col-12"><br><br>
						<p>Contraseña</p><br>
						<input type="password" name="txtContraseña"  class="col-12"><br><br><br>
						
						<input type="submit" value="Confirmar" name="btnConfirmar"  class="btn btn-primary col-12"><br>
					</div>

				</form>  
				
				
				
	    </div>
	</div>	
</div>


		   

<div class="olas">
	<div class="ola"></div>
	<div class="ola"></div>
	<div class="ola"></div>
</div>


<footer class="footerIndex">
	<p>Ricardo Recofsky - Gastón Sosa - Francisco Madoery - Santiago Daniel Ros</p>
	<p>© LAB V 2022 | Carrera TUSI - UTN FRGP | Desarrollado por alumnos UTN FRGP.</p>
</footer>

<!-- <a href="ClienteAlta.jsp" class="btn btn-dark btn-Menu" role="button"> CLIENTE ALTA</a>	-->
</body>
</html>