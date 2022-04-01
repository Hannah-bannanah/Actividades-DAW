<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">	
		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" a class="btn-link">Tipos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/todos">Eventos</a></li>
					<li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li>
					<li class="main-nav__item"><a class="btn-link" href="/eventos/activos">Eventos/Tipo</a></li>
					<li class="main-nav__item current-tab"><a class="btn-link" href="/reservas/">${ idCliente ne null ? 'Mis ' : '' }Reservas</a></li>
					<li class="main-nav__item"><a class="btn-link"href=${ idCliente !=null ? "/clientes/cerrarSesion" : "/clientes/login" }>${ idCliente !=null ? "Salir" : "Login" }</a></li>
					<c:if test="${ idCliente eq null }">
						<li class="main-nav__item"><a class="btn-link" href="/clientes/registrar">Registrar</a></li>
					</c:if>		
				</ul>
			</nav>
		</header>
		<main>
			<h2>${idCliente ne null ? 'Mis reservas' : 'Reservas'}</h2>
			<table>
				<thead>
					<tr>
						<th>Id</th>
						<c:if test="${ idCliente eq null }">
							<th>Id Cliente</th>
						</c:if>
						<th>${ reservasCliente ne null ? 'Evento' : 'IdEvento' }</th>
						<th>N&uacute;mero de entradas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="reserva" items="${ reservas }" >
						<tr>
							<td>${ reserva.idReserva }</td>
							<c:if test="${ idCliente eq null }">
								<td>${ reserva.usuario.idUsuario }</td>
							</c:if>
							<td>${ idCliente eq null ? reserva.evento.idEvento : reserva.evento.nombre}</td>
							<td>${ reserva.cantidad }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>