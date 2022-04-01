<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Registrarse</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="./compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Registrarse</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/alta" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>Introduzca sus datos</legend>
			<fieldset class="flex-container">
				<fieldset class="flex-container">
					<label for="username">Username</label>
					<input type="text" name="username" id="username" required />
					<label for="password">Contrase&ntilde;a</label>
					<input type="password" name="password" id="password" required />		
				</fieldset>		
				<fieldset class="flex-container">
					<label for="email">Email</label>
					<input type="email" name="email" id="email" required/>
				</fieldset>	
				<fieldset class="flex-container">
					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" id="nombre" required />
					<label for="apellido">Apellido</label>
					<input type="text" name="apellido" id="apellido" required />
					<label for="direccion">Direcci&oacute;n</label>
					<input type="text" name="direccion" id="direccion" />
				</fieldset>	
				</fieldset>		
				<button type="submit" class="btn-link">Registrarse</button>
			</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>