<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Asignar Productos</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/form.css" />" rel="stylesheet">
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
			<form action="/jefe/asignarProductos" method="post">
				<fieldset>
					<legend>Asignar Productos </legend>
					<fieldset>
						<legend>Elige proyecto y producto</legend>
						<div class="fieldset-row">
        					<div class="fieldset-column">
        						<label for="proyecto">Proyecto: </label>
        						<select name="proyecto" id ="proyecto" required>
        							<option value="">Seleccione un proyecto</option>
        							<c:forEach var="proy" items="${ listaProyectos }">
        								<option value="${ proy.idProyecto }" ${ idProyecto eq proy.idProyecto ? 'selected' : '' }>${ proy. idProyecto } - ${ proy.descripcion }</option>
        							</c:forEach>
        						</select>
        					</div>
        					<div class="fieldset-column">
        						<label for="producto">Producto:</label>
        						<select name=producto id ="producto" required>
        							<option value="">Seleccione un producto</option>
        							<c:forEach var="prod" items="${ listaProductos }">
        								<option value="${ prod.idProducto }">${ prod.descripcionBreve }</option>
        							</c:forEach>
        						</select>
        					</div>
					</fieldset>
					
					<fieldset>
						<legend>Detalles asignaci&oacute;n</legend>
						<div class="fieldset-row">
						<div class="fieldset-column">
							<label for="precioAsignado">Precio asignado:</label>
							<input type = "number" name="precioAsignado" id="precioAsignado" min="0" step="0.01" required>
						</div>
						<div class="fieldset-column">
							<label for="cantidad">Cantidad:</label>
							<input type = "number" name="cantidad" id="cantidad" required min="1">
						</div>
						</div>
					</fieldset>
        			<fieldset class="form__actions">
          				<button type="submit" name="submit" id="submit" class="btn-link cta">Asignar</button>
          				<button type="button" name="reset" id="reset" class="btn-link">Borrar formulario</button>
        			</fieldset>
        			<p class="mensaje-error">${ mensajeError }</p>
        			<p class="mensaje-exito">${ mensajeExito }</p>
				</fieldset>
			</form>
		</main>

	</body>
</html>