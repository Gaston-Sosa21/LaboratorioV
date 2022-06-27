<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Sistema de Gestión de Biblioteca - Login </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/index.css"/>
</head>
</head>
<body class="noOverflow">
<div class="tittle-header"> 
	<h1 class="text-center"> Bienvenidos</h1>
	<h2 class="text-center">Sistema de Gestión de Biblioteca</h2>
</div>
<div class="text-center">
	<div class="modal-dialog" id="base-login" style="display: block; justify-content: center;text-align: -webkit-center;">
	    <div class="col-sm-8 main-section">
		    <div class="modal-content">
		    <svg style="position: absolute; top: -42px; left: 106px; z-index: 1;"><circle cx="60" cy="65" r="65" fill="WHITE" stroke="#333333" stroke-width="4"></svg>
		    	<div class="col-12 user-img">
			    	<svg xmlns="http://www.w3.org/2000/svg" width="140" height="140" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
		    	</div>
		     	<form action = "" method="post" class="col-12">
					
					<div class="form-group">
					<input type="text" id="username" class="form-control" placeholder="Nombre de usuario" required>
					</div>
			        
					<div class="form-group">
					<input type="password" id="password" class="form-control" placeholder="Contraseña" autocomplete="off" required>
					</div>
			
					<button type="submit" class="btn btn-info btn-block btnIndex">INICIAR SESIÓN</button>
					<a class="btn btn-link btn-block forgot" href="#">¿Olvidó su nombre de usuario o contraseña?</a>
				</form>
		    </div>
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
</body>
</html>