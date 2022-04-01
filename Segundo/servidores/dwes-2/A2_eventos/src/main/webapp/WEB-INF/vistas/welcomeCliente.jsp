<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bienvenido</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">	
		<link href="<c:url value="/css/welcomeCliente.css" />" rel="stylesheet">
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
			<h2>Bienvenido, ${ nombre }!</h2>
			<h3>&#191;Qu&eacute; quieres hacer hoy?</h3>
			<section class="cliente__actions">
				<a href="/reservas"><div class="cliente__action prueba">Ver mis reservas</div></a>
				<a href="/eventos/activos"><div class="cliente__action">Ver eventos</div></a>
			</section>

			
		</main>
	</body>
</html>