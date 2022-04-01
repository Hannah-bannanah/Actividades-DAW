<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Empleados</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/tablas.css" />" rel="stylesheet">
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
		    <div class="feedback-usuario">
				<p class="mensaje-error">${ mensajeError }</p>
				<p class="mensaje-exito">${ mensajeExito }</p>
			</div>
			<table>
				<thead>
					<tr>
						<th>ID Empleado</th>
						<th>Nombre</th>
						<th>Fecha de Nacimiento</th>
						<th>Correo</th>
						<th>Fecha de Ingreso</th>
						<th>Salario</th>
						<th>Departamento</th>
						<th>Rol</th>
						<th class="buffer-cell"></th>
						<th colspan ="${ empleado.perfil.idPerfil eq 1 ? 2 : 3 }">Opciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="empl" items="${ listaEmpleados }">
						<tr>
						  <td>${ empl.idEmpl }</td>
						  <td>${ empl.nombre }</td>
						  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ empl.fechaNacimiento }" /></td>
						  <td>${ empl.correo }</td>
						  <td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${ empl.fechaIngreso }" /></td>						  
						  <td>${ empl.salario }</td>
						  <td>${ empl.departamento.nombre }</td>
						  <td>${ empl.perfil.nombre }</td>
						  <td class="buffer-cell"></td>
						  <td><a href="/rrhh/empleados/${ empl.idEmpl }">Detalle</a></td>
						  <td><a href="/rrhh/bajaEmpleado/${ empl.idEmpl }">Dar de baja</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>