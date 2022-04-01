<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Log in</title>
  <link href="<c:url value='/css/style.css' />" rel="stylesheet">
  <link href='<c:url value="/css/form.css" />' rel="stylesheet">
</head>
	<body>
		<header>
		</header>
  		<main>
    		<form action="/login" method="post">
      			<fieldset>
        			<legend>Log in</legend>
        			<fieldset class="block-fieldset">
          				<legend>Informaci&oacute;n login</legend>
          				<label for="idEmpl">ID Empleado: </label>
          				<input type="number" name="idEmpl" id="idEmpl" value="${ idEmpl }" required>
          				<label for="email">Correo electr&oacute;nico: </label>
          				<input type="text" name="correo" id="correo" value="${ correo }" required>
          				<label for="password">Contrase&ntilde;a:</label>
          				<input type="password" name="password" id="password" required>
        			</fieldset>
        			<fieldset class="form__actions">
          				<button type="submit" name="submit" id="submit" class="btn-link cta">Log in</button>
          				<button type="reset" name="reset" id="reset" class="btn-link">Borrar formulario</button>
        			</fieldset>
        			<p class="mensaje-error">${ mensajeError }</p>
      			</fieldset>
    		</form>
  		</main>
	</body>
</html>