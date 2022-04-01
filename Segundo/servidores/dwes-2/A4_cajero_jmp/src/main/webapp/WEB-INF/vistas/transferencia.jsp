<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Transferencia</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
  		<link href='<c:url value="/css/form.css" />' rel="stylesheet">
	</head>
	<body>
		<main>
			<form action="#" method="post">
				<fieldset>
					<legend class="form-title">Realizar transferencia</legend>
					<fieldset>
						<label for="cantidad">Cantidad</label><br>
						<input type="number" name="cantidad" id="cantidad" min="1" required>
					</fieldset>
					<fieldset>
						<label for="destino">Cuenta de destino</label><br>
						<input type="number" name="destino" id="destino" min="1" required>
					</fieldset>
					<fieldset class="form__actions">
						<button type="submit" class="btn-link cta">Enviar</button>
						<a href="/cliente" class="btn-link">Volver al menu</a>
					</fieldset>				
				</fieldset>
				<p class="mensaje-error">${ mensajeError }</p>
			</form>
		</main>
	</body>
</html>