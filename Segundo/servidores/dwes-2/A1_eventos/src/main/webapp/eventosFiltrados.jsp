<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Eventos ${ not empty eventosActivos ? 'Activos' : not empty eventosCancelados ? 'Cancelados' : 'Destacados'}</title>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/eventos.css">		
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="eventos?opcion=todos">Eventos</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li><!--
					--><li class="main-nav__item current-tab"><a class="btn-link" href="eventos?opcion=activos">Eventos/Tipo</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Login</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Registro</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Salir</a></li>					
				</ul>
			</nav>
		</header>
		<main>
			<h2>Listado de Eventos ${ not empty eventosActivos ? 'Activos' : not empty eventosCancelados ? 'Cancelados' : 'Destacados' }</h2>
			<a class="btn-link" href="eventos?opcion=alta">Nuevo Evento</a>
			<section id="filtros">
				<a href="eventos?opcion=todos">Mostrar todos</a>
				<a class=${ not empty eventosActivos ? "filtro-activo" : "filtro-inactivo"} href="eventos?opcion=activos">Mostrar solo activos</a>
				<a class=${ not empty eventosCancelados ? "filtro-activo" : "filtro-inactivo"} href="eventos?opcion=cancelados">Mostrar solo cancelados</a>
				<a class=${ not empty eventosDestacados ? "filtro-activo" : "filtro-inactivo"} href="eventos?opcion=destacados">Mostrar solo destacados</a>
			</section>
			<table class="tabla-eventos">
				<thead>
					<tr>
						<th>Id</th><th>Tipo</th><th>Nombre</th><th>Precio</th>
						<th class="buffer-cell"></th>
            			<th colspan=3>Opciones</th>
            		</tr>
            	</thead>
				<tbody>
					<c:forEach var="evento" items="${ not empty eventosActivos ? eventosActivos : not empty eventosCancelados ? eventosCancelados : eventosDestacados }">
						<tr>
							<td>${ evento.idEvento }</td>
							<td>${ evento.tipo.nombre }</td>
							<td>${ evento.nombre }</td>
							<td>${ evento.precio }</td>
							<td class="buffer-cell"></td>
							<td class="tabla-eventos__accion editar"><a href="eventos?opcion=editar&id=${ evento.idEvento }">Editar</a></td>
							<td class="tabla-eventos__accion eliminar"><a href="eventos?opcion=eliminar&id=${ evento.idEvento }">Eliminar</a></td>
							<td class="tabla-eventos__accion cancelar"><a href="eventos?opcion=cancelar&id=${ evento.idEvento }">Cancelar</a></td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>