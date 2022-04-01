<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta usuario</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
		<link href="<c:url value='/css/table.css' />" rel="stylesheet">
		<link href="<c:url value='/css/form.css' />" rel="stylesheet">
	</head>
	<body>
		<jsp:include page="../compartido/header.jsp"></jsp:include>
		<main>
		<sec:csrfInput />
		<h1>Alta usuario</h1>
		<a class="btn-link" href="/">Volver</a>
		<form action="/admon/altaUsuario" method="post">
			<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<fieldset class="full-form">
				<legend>Datos del usuario</legend>
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
					<label for="perfil">Perfil</label>
					<select name="perfil" id="perfil" required multiple>
						<option value ="">Seleccione perfil</option>
						<c:forEach var="p" items="${ listaPerfiles }">
							<option value="${ p.idPerfil }">${ p.descripcion }</option>
						</c:forEach>
					</select>
				</fieldset>	
				<fieldset class="flex-container">
					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" id="nombre" required />
					<label for="apellido">Apellido</label>
					<input type="text" name="apellido" id="apellido" required />
					<label for="direccion">Direcci&oacute;n</label>
					<input type="text" name="direccion" id="direccion" />
				</fieldset>	
				<fieldset class="flex-container">
					<label for="enabled">Enabled</label>
					<input type="checkbox" name="enabled" id="enabled" value="1" checked>
					 
				</fieldset>
				</fieldset>		
				<button type="submit" class="btn-link">Crear usuario</button>
			</fieldset>
		</form>
		<p class="mensaje-exito">${ mensajeExito }</p>
		<p class="mensaje-error">${ mensajeError }</p>
		</main>
	</body>
</html>