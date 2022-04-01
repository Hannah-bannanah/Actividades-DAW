<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Proyectos</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="${ idPerfil eq 1 ? '/gestion' : idPerfil eq 2 ? '/jefe' : idPerfil eq 4 ? '/rrhh' : '' }" a class="btn-link">Inicio</a></li>
					<c:if test="${ idPerfil eq 1 }">
						<li class="main-nav__item"><a class="btn-link" href="/gestion/proyectos">Proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProyecto">Nuevo proyecto</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProducto">Nuevo producto</a></li>			
					</c:if>
					<c:if test="${ idPerfil eq 2 }">
						<li class="main-nav__item"><a class="btn-link" href="/jefe/proyectos">Mis proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarEmpleados">Asignar empleados</a></li>				
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarProductos">Asignar productos</a></li>				
					</c:if>
					<c:if test="${ idPerfil eq 4 }">
						<li class="main-nav__item"><a class="btn-link" href="/rrhh/empleados">Ver empleados</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/rrhh/altaEmpleado">Nuevo Empleado</a></li>				
					</c:if>
					<li class="main-nav__item"><a class="btn-link"href="/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
		</header>	
		<main>
		    <div class="feedback-usuario">
				<p class="mensaje-error">${ mensajeError }</p>
				<p class="mensaje-exito">${ mensajeExito }</p>
			</div>
			<table>
				<thead>
					<tr>
						<th>ID Proyecto</th>
						<th>Descripcion</th>
						<th>Cliente</th>
						<th>Jefe de Proyecto</th>
						<th>Fecha Inicio</th>
						<th>Fecha fin prevista</th>
						<th>Fecha fin real</th>
						<th>Previsi&oacute;n costes (&euro;)</th>
						<th>Coste real (&euro;)</th>
						<th>Previsi&oacute;n ventas (&euro;)</th>
						<th>Estado</th>
						<th class="buffer-cell"></th>
						<th colspan ="${ idPerfil eq 1 ? 2 : 3 }">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="proy" items="${ listaProyectos }">
						<tr>
						  <td>${ proy.idProyecto }</td>
						  <td>${ proy.descripcion }</td>
						  <td>${ proy.cliente.nombre }</td>
						  <td>${ proy.jefeProyecto.nombre }</td>
						  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proy.fechaInicio }" /></td>
						  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proy.fechaFinPrevisto }" /></td>
						  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proy.fechaFinReal }" /></td>
						  <td>${ proy.costesPrevisto }</td>
						  <td>${ proy.costeReal }</td>
						  <td>${ proy.ventaPrevisto }</td>
						  <td>${ proy.estado }</td>
						  <td class="buffer-cell"></td>
						  <c:choose>
						  	<c:when test="${ idPerfil eq 1 }">
						  		<td><a href="/gestion/terminar/${ proy.idProyecto }">Terminar proyecto</a></td>
						  	</c:when>
						  	<c:when test="${ idPerfil eq 2 }">
						  		<td><a href="/jefe/proyectos/${ proy.idProyecto }">Detalle</a></td>
						  		<td><a href="/jefe/asignarEmpleados?idProyecto=${ proy.idProyecto}">Asignar empleados</a></td>
						  		<td><a href="/jefe/asignarProductos?idProyecto=${ proy.idProyecto}">Asignar productos</a></td>
						  	</c:when>
						  </c:choose>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>