<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Sistema de Administracion de Biblioteca</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">


<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/index.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/login.css" type="text/css" media="screen" />

</head>
<body class="noOverflow">
<div class="background-image"></div>
<div class="content">
<div class="tittle-header" style="color: #FFFFFF;"> 
	<h1 class="text-center"> Bienvenidos</h1>
	<h2 class="text-center">Sistema de Administracion de Biblioteca</h2>
</div>
<br>
<br>
<br>
	<div class="text-center">
     	<form action = "Redireccionar_PostLogin.html" method="post">					
			<div class="loginDiv">
					<br><br>
					<p>Nombre de usuario</p>
					<input type="text" name="txtUsuario"  class="col-12 inputs"><br><br>
					<p>Contraseña</p><br>
					<input type="password" name="txtContrasenia"  class="col-12 inputs"><br><br><br>
					
					<input type="submit" value="INGRESAR" name="btnConfirmar"  class="btn btn-primary col-6"><br>
	
			        </form>  
              </div>	
	</div>

<footer class="footerIndex">
	<p>Ricardo Recofsky - Gastón Sosa - Francisco Madoery - Marcos Zone</p>
	<p>© LAB V 2022 | Carrera TUSI - UTN FRGP | Desarrollado por alumnos UTN FRGP.</p>
</footer>
</div>
</body>
</html>