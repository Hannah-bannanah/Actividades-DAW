<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Proyecto ${ proyecto.idProyecto }</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/detalleProyecto.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="${ empleado.perfil.idPerfil eq 1 ? '/gestion' : empleado.perfil.idPerfil eq 2 ? '/jefe' : empleado.perfil.idPerfil eq 4 ? '/rrhh' : '' }" a class="btn-link">Inicio</a></li>
					<c:if test="${ empleado.perfil.idPerfil eq 1 }">
						<li class="main-nav__item"><a class="btn-link" href="/gestion/proyectos">Proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProyecto">Nuevo proyecto</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProducto">Nuevo producto</a></li>			
					</c:if>
					<c:if test="${ empleado.perfil.idPerfil eq 2 }">
						<li class="main-nav__item"><a class="btn-link" href="/jefe/proyectos">Mis proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarEmpleados">Asignar empleados</a></li>				
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarProductos">Asignar productos</a></li>				
					</c:if>
					<c:if test="${ empleado.perfil.idPerfil eq 4 }">
						<li class="main-nav__item"><a class="btn-link" href="/rrhh/empleados">Ver empleados</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/rrhh/altaEmpleado">Nuevo Empleado</a></li>				
					</c:if>
					<li class="main-nav__item"><a class="btn-link"href="/cerrarSesion">Salir</a></li>
				</ul>
			</nav>
		</header>	
		<main>
			<table>
				<tbody>
					<tr><th>ID Proyecto</th><td>${ proyecto.idProyecto }</td></tr>
					<tr><th>Descripcion</th><td>${ proyecto.descripcion }</td></tr>
					<tr><th>Cliente</th><td>${ proyecto.cliente.nombre }</td></tr>
					<tr><th>Jefe de Proyecto</th><td>${ proyecto.jefeProyecto.nombre }</td></tr>
					<tr><th>Fecha Inicio</th><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proyecto.fechaInicio }" /></td></tr>
					<tr><th>Fecha fin prevista</th><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proyecto.fechaFinPrevisto }" /></td></tr>
					<tr><th>Fecha fin real</th><td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ proyecto.fechaFinReal }" /></td></tr>
					<tr><th>Previsi&oacute;n costes (&euro;)</th><td>${ proyecto.costesPrevisto }</td></tr>
					<tr><th>Coste real (&euro;)</th><td>${ proyecto.costeReal }</td></tr>
					<tr><th>Previsi&oacute;n ventas (&euro;)</th><td>${ proyecto.ventaPrevisto }</td></tr>
					<tr><th>Estado</th><td>${ proyecto.estado }</td></tr>
				</tbody>
			</table>
			<div class="flex-container">
				<div class="flex-container__item flex-container">
					<div class="feedback-usuario">
						<p class="mensaje-error">${ mensajeError }</p>
						<p class="mensaje-exito">${ mensajeExito }</p>
					</div>
				<table>
					<thead>
						<tr><th>ID Empleado</th><th>Nombre</th><th>Fecha de incorporacion</th><th>Horas Asignadas</th><th class="buffer-cell"></th><th>Opciones</th></tr>
					</thead>
					<tbody>
						<c:forEach var="proyEmp" items="${ proyecto.proyectoConEmpleados }">
							<tr>
								<td>${ proyEmp.empleado.idEmpl }</td>
								<td>${ proyEmp.empleado.nombre }</td>
								<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${proyEmp.fechaIncorporacion}" /></td>
								<td>${ proyEmp.horasAsignadas }</td>
								<td class="buffer-cell"></td>
								<td><a href="/jefe/proyectos/${ proyecto.idProyecto }/desasignarEmpleado?numeroOrden=${ proyEmp.numeroOrden }">Desasignar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn-link" href="/jefe/asignarEmpleados?idProyecto=${ proyecto.idProyecto}">Asignar empleados</a>
				</div>
				<div class="flex-container__item flex-container">
				<table>
					<thead>
						<tr><th>ID Producto</th><th>Nombre</th><th>Cantidad</th><th>Precio asignado (&euro;)</th><th class="buffer-cell"></th><th>Opciones</th></th>
					</thead>
					<tbody>
						<c:forEach var="proyProd" items="${ proyecto.proyectoConProductos }">
							<tr>
								<td>${ proyProd.producto.idProducto }</td>
								<td>${ proyProd.producto.descripcionBreve }</td>
								<td>${ proyProd.cantidad }</td>
								<td>${ proyProd.precioAsignado }</td>
								<td class="buffer-cell"></td>
								<td><a href="/jefe/proyectos/${ proyProd.proyecto.idProyecto }/desasignarProducto?numeroOrden=${ proyProd.numeroOrden }">Desasignar</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn-link" href="/jefe/asignarProductos?idProyecto=${ proyecto.idProyecto}">Asignar productos</a>
				</div>
			</div>

		</main>
	</body>
</html>