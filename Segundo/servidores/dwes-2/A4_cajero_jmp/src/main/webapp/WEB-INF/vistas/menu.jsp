<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Men&uacute; Principal</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/menu.css' />" rel="stylesheet">
	</head>
	<body>
		<h1>Bienvenido</h1>
		<h2>Seleccionar acci&oacute;n</h2>
		<nav class="menu">
			<a class="btn-link menu__item" href="/cliente/ingresar">Ingresar</a>
			<a class="btn-link menu__item" href="/cliente/extraer">Extraer</a>
			<a class="btn-link menu__item" href="/cliente/movimientos">Ver movimientos</a>
			<a class="btn-link menu__item" href="/cliente/transferencia">Transferencia</a>
			<a class="btn-link menu__item danger" href="/cerrarSesion">Salir</a>
		</nav>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
	</body>
</html>