<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bienvenido</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">	
		<link href="<c:url value="/css/welcome.css" />" rel="stylesheet">
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
			<h2>Bienvenido, ${ empleado.nombre }!</h2>
			<h3>&#191;Qu&eacute; quieres hacer hoy?</h3>
			<c:choose>
				<c:when test="${ empleado.perfil.idPerfil eq 1 }">
					<section class="empleado__actions gestor">
						<a href="/gestion/proyectos"><div class="empleado__action">Ver proyectos</div></a>
						<a href="/gestion/altaProyecto"><div class="empleado__action">Nuevo Proyecto</div></a>
						<a href="/gestion/altaProducto"><div class="empleado__action">Nuevo Producto</div></a>			
					</section>
				</c:when>
				<c:when test="${ empleado.perfil.idPerfil eq 2 }">
					<section class="empleado__actions jefe">
						<a href="/jefe/proyectos"><div class="empleado__action">Ver proyectos</div></a>
						<a href="/jefe/asignarEmpleados"><div class="empleado__action">Asignar empleados</div></a>
						<a href="/jefe/asignarProductos"><div class="empleado__action">Asignar productos</div></a>
´					</section></c:when>
				<c:when test="${ empleado.perfil.idPerfil eq 3 }">
					<section class="empleado__actions operativo">
						<a href=""><div class="empleado__action">Nada</div></a>
						<a href=""><div class="empleado__action">Nada</div></a>			
					</section>
				</c:when>
				<c:otherwise>
					<section class="empleado__actions rrhh">
						<a href="/rrhh/empleados"><div class="empleado__action">Ver empleados</div></a>
						<a href="/rrhh/altaEmpleado"><div class="empleado__action">Nuevo Empleado</div></a>			
					</section>
				</c:otherwise>
			</c:choose>


			
		</main>
	</body>
</html>