<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página Principal</title>
</head>
<body>
	<section>
		<h1>Registro</h1>
		<form:form action="/procesa/registro" method="POST" modelAttribute="usuario">
			<div>
				<form:label path="nombreUsuario">Nombre de Usuario</form:label>
				<form:input path="nombreUsuario" />
				<form:errors path="nombreUsuario" /> 
			</div>
			<div>
				<form:label path="contrasenia">Contraseña</form:label>
				<form:input path="contrasenia" type="password"/>
				<form:errors path="contrasenia" /> 
			</div>
			<div>
				<form:label path="confirmacionContrasenia">Confirmar Contraseña</form:label>
				<form:input path="confirmacionContrasenia" type="password"/>
				<form:errors path="confirmacionContrasenia" /> 
			</div>
			<div>
				<form:label path="correo">Correo</form:label>
				<form:input path="correo" type="email" />
				<form:errors path="correo" /> 
			</div>
			<div>
				<form:label path="nombre">Nombre</form:label>
				<form:input path="nombre" />
				<form:errors path="nombre" /> 
			</div>
			<div>
				<form:label path="apellido">Apellido</form:label>
				<form:input path="apellido" />
				<form:errors path="apellido" /> 
			</div>
			<div>
				<form:label path="fechaDeNacimiento">Fecha de Nacimiento</form:label>
				<form:input path="fechaDeNacimiento" type="date"/>
				<form:errors path="fechaDeNacimiento" /> 
			</div>
			<button>
				Registrar
			</button>
		</form:form>
	</section>
	
	<section>
		<h1> Login </h1>
		<form:form action="/procesa/login" method="POST" modelAttribute="usuarioLogin">
			<div>
				<form:label path="nombreUsuarioLogin">Nombre de Usuario</form:label>
				<form:input path="nombreUsuarioLogin" />
				<form:errors path="nombreUsuarioLogin" /> 
			</div>
			<div>
				<form:label path="contraseniaLogin">Contraseña</form:label>
				<form:input path="contraseniaLogin" type="password"/>
				<form:errors path="contraseniaLogin" /> 
			</div>
			<button>
				Login
			</button>
		</form:form>
	</section>
</body>
</html>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Registro y Login</title>
</head>
<body>
	
</html>