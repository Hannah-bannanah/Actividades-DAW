<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eventos</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">	
		<link href="<c:url value="/css/eventos.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li>
					<li class="main-nav__item current-tab"><a class="btn-link" href="/eventos/todos">Eventos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li>
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
			<h2>Listado de todos los Eventos</h2>
			<a class="btn-link" href="alta">Nuevo Evento</a>
			<section id="filtros">
				<a href="/eventos/activos">Mostrar solo activos</a>
				<a href="/eventos/cancelados">Mostrar solo cancelados</a>
				<a href="/eventos/destacados">Mostrar solo destacados</a>
			</section>
			<table class="tabla-eventos">
				<thead>
					<tr><th>Id</th><th>Nombre</th><th>Precio</th><th>Estado</th><th>Destacado?</th>
					<th class="buffer-cell"></th>
					<th colspan=3>Opciones</th></tr>
				</thead>
				<tbody>
					<c:forEach var="evento" items="${ eventos }">
						<tr>
							<td>${ evento.idEvento }</td>
							<td>${ evento.nombre }</td>
							<td>${ evento.precio }</td>
							<td>${ evento.estado }</td>
							<td>${ evento.destacado }</td>
							<th class="buffer-cell"></th>
							<td class="tabla-eventos__accion editar"><a href="/eventos/editar/${ evento.idEvento }">Editar</a></td>
							<td class="tabla-eventos__accion eliminar"><a href="/eventos/eliminar/${ evento.idEvento }">Eliminar</a></td>
							<c:choose>
								<c:when test="${ evento.estado eq 'cancelado' }">
									<td class="tabla-eventos__accion activar"><a href="/eventos/activar/${ evento.idEvento }">Activar</a></td>
								</c:when>
								<c:otherwise>
									<td class="tabla-eventos__accion cancelar"><a href="/eventos/cancelar/${ evento.idEvento }">Cancelar</a></td>	
								</c:otherwise>
							</c:choose>						
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>