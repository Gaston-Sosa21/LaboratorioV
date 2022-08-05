<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Sistema de Administracion de Biblioteca</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/index.css">

<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/postLogin.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/StyleSheetAdmin.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/ControlsTable.css" type="text/css" media="screen" />
<link rel="stylesheet" href="/Biblioteca_Grupo_11/css/datepicker.css" type="text/css" media="screen" />


</head>
<body class="noOverflow">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<nav class="navbar navbar-dark bg-dark">
<a style="color:white" class="navbar-toggler"><img src="img/casa.png" height="40" width="40"><input type="submit" value="Home" name="btnSalir"></a>
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
<div class="tittle-header"> <br><br>
	<h2 class="text-center">Administrar de Biblioteca</h2>
</div>
<br>
<br>
<br>
<div class="text-center">
		<div class="base">
		     	<form action = "Redireccionar_ListaClientes.html" method="get">	
					<input type="submit" value="Clientes" name="btnConfirmar"  class="cuadrado "><br>
				</form> 
				<br>
				<form action = "ListaBiblioteca.html" method="get">	
					<input type="submit" value="Biblioteca" name="btnConfirmar"  class="cuadrado "><br>
				</form> 
				<br>
				<form action = "Redireccionar_ListaPrestamos.html" method="get">	
					<input type="submit" value="Prestamos" name="btnConfirmar"  class="cuadrado "><br>
				</form>  
		</div>	
</div>	

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<footer class="footerIndex">
	<p>Ricardo Recofsky - Gastón Sosa - Francisco Madoery - Marcos Zone</p>
	<p>© LAB V 2022 | Carrera TUSI - UTN FRGP | Desarrollado por alumnos UTN FRGP.</p>
</footer>

</body>
</html>