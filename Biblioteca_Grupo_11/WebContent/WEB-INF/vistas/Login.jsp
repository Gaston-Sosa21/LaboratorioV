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
<body class="noOverflow">
<div class="tittle-header"> 
	<h1 class="text-center"> Bienvenidos</h1>
	<h2 class="text-center">Sistema de Administracion de Biblioteca</h2>
</div>
<br>
<br>
<br>
	<div class="text-center">
     	<form action = "Redireccionar_PostLogin.html" method="get">					
			<div class="loginDiv">
					<br><br>
					<p>Nombre de usuario</p>
					<input type="text" name="txtUsuario"  class="col-12"><br><br>
					<p>Contraseña</p><br>
					<input type="password" name="txtContrasenia"  class="col-12"><br><br><br>
					
					<input type="submit" value="Confirmar" name="btnConfirmar"  class="btn btn-primary col-12"><br>
	
			        </form>  
              </div>	
	</div>

<footer class="footerIndex">
	<p>Ricardo Recofsky - Gastón Sosa - Francisco Madoery - Santiago Daniel Ros</p>
	<p>© LAB V 2022 | Carrera TUSI - UTN FRGP | Desarrollado por alumnos UTN FRGP.</p>
</footer>
</body>
</html>