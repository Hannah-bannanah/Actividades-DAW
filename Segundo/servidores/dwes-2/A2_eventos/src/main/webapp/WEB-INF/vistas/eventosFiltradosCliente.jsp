<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eventos ${ not empty eventosActivos ? 'Activos' : not empty eventosCancelados ? 'Cancelados' : 'Destacados'}</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">	
		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
		<link href="<c:url value="/css/eventos.css" />" rel="stylesheet">		
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/todos">Eventos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li>
					<li class="main-nav__item current-tab"><a class="btn-link" href="/eventos/activos">Eventos/Tipo</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/reservas/">${ idCliente ne null ? 'Mis ' : '' }Reservas</a></li>
					<li class="main-nav__item"><a class="btn-link"href=${ idCliente !=null ? "/clientes/cerrarSesion" : "/clientes/login" }>${ idCliente !=null ? "Salir" : "Login" }</a></li>
					<c:if test="${ idCliente eq null }">
						<li class="main-nav__item"><a class="btn-link" href="/clientes/registrar">Registrar</a></li>
					</c:if>		
				</ul>
			</nav>
		</header>
		<main>
			<h2>Listado de Eventos ${ not empty eventosActivos ? 'Activos' : not empty eventosCancelados ? 'Cancelados' : 'Destacados' }</h2>
			<section id="filtros">
				<a class=${ not empty eventosActivos ? "filtro-activo" : "filtro-inactivo"} href="/eventos/activos">Mostrar activos</a>
				<a class=${ not empty eventosDestacados ? "filtro-activo" : "filtro-inactivo"} href="/eventos/destacados">Mostrar destacados</a>
			</section>
			<table class="tabla-eventos">
				<thead>
					<tr>
						<th>Nombre</th><th>Tipo</th><th>Aforo</th><th>Precio</th><th>Fecha</th>
						<th class="buffer-cell"></th>
            			<th colspan=2>Opciones</th>
            		</tr>
            	</thead>
				<tbody>
					<c:forEach var="evento" items="${ not empty eventosActivos ? eventosActivos : not empty eventosCancelados ? eventosCancelados : eventosDestacados }">
						<tr>
							<td>${ evento.nombre }</td>
							<td>${ evento.tipo.nombre }</td>
							<td>${ evento.maxAforo }</td>
							<td>${ evento.precio }&euro;</td>
							<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${evento.fechaInicio}" /></td>
							<td class="buffer-cell"></td>
							<td class="tabla-eventos__accion detalle"><a href="/eventos/${ evento.idEvento }">Detalle</a></td>					
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>