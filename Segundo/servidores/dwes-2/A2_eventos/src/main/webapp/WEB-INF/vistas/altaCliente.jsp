<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
	<head>
  		<meta charset="UTF-8">
  		<meta http-equiv="X-UA-Compatible" content="IE=edge">
  		<meta name="viewport" content="width=device-width, initial-scale=1.0">
  		<title>Registrar usuario</title>
  		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/form.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/todos">Eventos</a></li>
					<li class="main-nav__item current-tab"><a class="btn-link" href="#">Usuarios</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/activos">Eventos/Tipo</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/reservas/">${ idCliente ne null ? 'Mis ' : '' }Reservas</a></li>
					<li class="main-nav__item"><a class="btn-link"href=${ idCliente !=null ? "/clientes/cerrarSesion" : "/clientes/login" }>${ idCliente !=null ? "Salir" : "Login" }</a></li>
					<c:if test="${ idCliente eq null }">
						<li class="main-nav__item"><a class="btn-link" href="/clientes/registrar">Registrar</a></li>
					</c:if>		
				</ul>
			</nav>
		</header>
  		<main>
    		<form action="/clientes/registrar" method="post">
      			<fieldset>
        			<legend>Registrar nuevo usuario</legend>
        			<fieldset class="block-fieldset">
          				<legend>Informaci&oacute;n login</legend>
          				<label for="username">Nombre de usuario:</label>
          				<input type="text" name="username" id="username" required>
          				<label for="password">Contrase&ntilde;a:</label>
          				<input type="password" name="password" id="password" required>
        			</fieldset>
        			<fieldset class="block-fieldset">
          				<legend>Tus datos</legend>
          				<label for="nombre">Nombre:</label>
          				<input type="text" name="nombre" id="nombre" required>
          				<label for="email">Email:</label>
          				<input type="email" name="email" id="email" required>
          				<label for="direccion">Direcci&oacute;n:</label>
          				<input type="text" name="direccion" id="direccion" required>
        			</fieldset>
        			<fieldset class="form__actions">
          				<button type="submit" name="submit" id="submit" class="btn-link cta">Registrarse</button>
          				<button type="reset" name="reset" id="reset" class="btn-link">Borrar formulario</button>
        			</fieldset>
        			<p class="mensaje-error">${ mensajeError }</p>
      			</fieldset>
    		</form>
  		</main>
	</body>
</html>