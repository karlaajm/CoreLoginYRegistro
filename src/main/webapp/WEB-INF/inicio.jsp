<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Inicio</title>
</head>
<body>
	<div>
        <h1>Bienvenido, ${nombreUsuario}</h1>
        <p>Correo: ${correo}</p>
        <p>Nombre Completo: ${nombreYApellido}</p>
        <p>Fecha de Nacimiento: ${fechaDeNacimiento}</p>
        <form action="/procesa/logout" method="POST">
            <button>Cerrar sesión</button>
        </form>
    </div>
</body>
</html>