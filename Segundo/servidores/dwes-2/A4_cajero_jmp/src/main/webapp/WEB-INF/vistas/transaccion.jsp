<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ transaccion eq "extraccion" ? 'Extraer' : 'Ingresar' } dinero</title>
		<link href="<c:url value='/css/style.css' />" rel="stylesheet">
  		<link href='<c:url value="/css/form.css" />' rel="stylesheet">
	</head>
	<body>
		<main>
			<form action="/cliente/${ transaccion }" method="post">
				<fieldset>
					<legend class="form-title">${ transaccion eq "extraccion" ? 'Extraer' : 'Ingresar' } dinero</legend>
					<fieldset>
						<label for="cantidad">Cantidad</label><br>
						<input type="number" name="cantidad" id="cantidad" step="10" min="10" required>
					</fieldset>
					<fieldset class="form__actions">
						<input type="hidden" name="operacion" value="${ transaccion eq 'extraccion' ? 'cargo' : 'abono' }">
						<button type="submit" class="btn-link cta">${ transaccion eq "extraccion" ? 'Extraer' : 'Ingresar' }</button>
						<a href="/cliente" class="btn-link">Volver al menu</a>
					</fieldset>				
				</fieldset>
				<p class="mensaje-error">${ mensajeError }</p>
			</form>
		</main>
	</body>
</html>