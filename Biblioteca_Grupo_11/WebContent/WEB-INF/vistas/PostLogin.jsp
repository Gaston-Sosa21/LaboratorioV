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
<div class="tittle-header"> 
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
				<form action = "Redireccionar_ListaBiblioteca.html" method="get">	
					<input type="submit" value="Biblioteca" name="btnConfirmar"  class="cuadrado "><br>
				</form> 
				<br>
				<form action = "Redireccionar_ListaPrestamos.html" method="get">	
					<input type="submit" value="Presstamos" name="btnConfirmar"  class="cuadrado "><br>
				</form>  
		</div>	
</div>	


<footer class="footerIndex">
	<p>Ricardo Recofsky - Gastón Sosa - Francisco Madoery - Santiago Daniel Ros</p>
	<p>© LAB V 2022 | Carrera TUSI - UTN FRGP | Desarrollado por alumnos UTN FRGP.</p>
</footer>
</body>
</html>