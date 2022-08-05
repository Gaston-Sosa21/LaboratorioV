<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Sistema de Administracion de Biblioteca</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js"></script>


<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/index.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/login.css" type="text/css" media="screen" />
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">
function mostrarMensaje (){
	if('${mostrarMensaje}'){
		 
		 if('${Logeo}' == "no"){
			 swal("Oops!", "Usuario o contraseña incorrectas!", "error");
		 }
	 }
}
</script>
</head>
<body class="noOverflow" onLoad="mostrarMensaje()">
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
					<label>Nombre de usuario</label><br>
					<input type="text" name="txtUsuario"  class="col-12 inputs" placeholder="Nombre"><br><br>
					<label>Contraseña</label><br>
					<input type="password" name="txtClave"  class="col-12 inputs" placeholder="Contraseña"><br><br><br>
					
					<input type="submit" value="INGRESAR" name="btnConfirmar"  class="btn btn-primary col-6"><br>
					<span></span>
	
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