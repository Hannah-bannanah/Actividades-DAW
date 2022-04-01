<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empleado ${ empleado.idEmpl }</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/detalleEmpleado.css" />" rel="stylesheet">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="${ sessionScope.empleado.perfil.idPerfil eq 1 ? '/gestion' : empleado.perfil.idPerfil eq 2 ? '/jefe' : empleado.perfil.idPerfil eq 4 ? '/rrhh' : '' }" a class="btn-link">Inicio</a></li>
					<c:if test="${ sessionScope.empleado.perfil.idPerfil eq 1 }">
						<li class="main-nav__item"><a class="btn-link" href="/gestion/proyectos">Proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProyecto">Nuevo proyecto</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/gestion/altaProducto">Nuevo producto</a></li>			
					</c:if>
					<c:if test="${ sessionScope.empleado.perfil.idPerfil eq 2 }">
						<li class="main-nav__item"><a class="btn-link" href="/jefe/proyectos">Mis proyectos</a></li>
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarEmpleados">Asignar empleados</a></li>				
						<li class="main-nav__item"><a class="btn-link" href="/jefe/asignarProductos">Asignar productos</a></li>				
					</c:if>
					<c:if test="${ sessionScope.empleado.perfil.idPerfil eq 4 }">
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
					<tr><th>ID Empleamdo</th><td>${ empleadoDetalle.idEmpl }</td></tr>
					<tr><th>Nombre</th><td>${ empleadoDetalle.nombre }</td></tr>
					<tr><th>Correo</th><td>${ empleadoDetalle.correo }</td></tr>
					<tr><th>Fecha de ingreso</th><td><fmt:formatDate pattern = "dd/MM/yyyy" value="${ empleadoDetalle.fechaIngreso }" /></td></tr>
					<tr><th>Fecha de nacimiento</th><td><fmt:formatDate pattern="dd/MM/yyyy" value="${ empleadoDetalle.fechaNacimiento }" /></td></tr>
					<tr><th>Salario</th><td>${ empleadoDetalle.salario }</td></tr>
					<tr><th>Departamento</th><td>${ empleadoDetalle.departamento.nombre }</td></tr>
					<tr><th>Rol</th><td>${ empleadoDetalle.perfil.nombre }</td></tr>
				</tbody>
			</table>
			<a class="btn-link" href="/rrhh/bajaEmpleado/${ empleadoDetalle.idEmpl }">Dar de baja</a>
		</main>
	</body>
</html>