<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
  		<link href='<c:url value="/css/form.css" />' rel="stylesheet">
	</head>
	<body>
		<main>
			<form action="/login" method="post">
				<fieldset>
					<legend class="form-title">Introduzca detalles de la cuenta</legend>
					<fieldset>
						<label for="idCuenta">N&uacute;mero de cuenta</label><br>
						<input type="number" name="idCuenta" id="idCuenta" required min=1>
					</fieldset>
					<fieldset class="form__actions">
						<button type="submit" class="btn-link cta">Entrar</button>
					</fieldset>				
				</fieldset>
				<p class="mensaje-error">${ mensajeError }</p>
			</form>
		</main>
	</body>
</html>