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
			<table>
				<tbody>
					<tr><th>ID Empleamdo</th><td>${ empleado.idEmpl }</td></tr>
					<tr><th>Nombre</th><td>${ empleado.nombre }</td></tr>
					<tr><th>Correo</th><td>${ empleado.correo }</td></tr>
					<tr><th>Fecha de ingreso</th><td><fmt:formatDate pattern = "dd/MM/yyyy" value="${ empleado.fechaIngreso }" /></td></tr>
					<tr><th>Fecha de nacimiento</th><td><fmt:formatDate pattern="dd/MM/yyyy" value="${ empleado.fechaNacimiento }" /></td></tr>
					<tr><th>Salario</th><td>${ empleado.salario }</td></tr>
					<tr><th>Departamento</th><td>${ empleado.departamento.nombre }</td></tr>
					<tr><th>Rol</th><td>${ empleado.perfil.nombre }</td></tr>
				</tbody>
			</table>
			<a class="btn-link" href="/rrhh/empleados/${ empleado.idEmpl }/baja">Dar de baja</a>
		</main>
	</body>
</html>