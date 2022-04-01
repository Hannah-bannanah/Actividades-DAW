<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Asignar Empleados</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet">
  		<link href="<c:url value="/css/form.css" />" rel="stylesheet">
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
			<form action="/jefe/asignarEmpleados" method="post">
				<fieldset>
					<legend>Asignar Empleados </legend>
					<fieldset>
						<legend>Elige proyecto y empleado</legend>
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
        						<label for="empleado">Empleado:</label>
        						<select name="empleado" id ="empleado" required>
        							<option value="">Seleccione un empleado</option>
        							<c:forEach var="empl" items="${ listaOperativos }">
        								<option value="${ empl.idEmpl }">${ empl.nombre }</option>
        							</c:forEach>
        						</select>
        					</div>
					</fieldset>
					
					<fieldset>
						<legend>Detalles asignaci&oacute;n</legend>
						<div class="fieldset-row">
						<div class="fieldset-column">
							<label for="fechaIncorporacion">Fecha de Incorporaci&oacute;n:</label>
							<input type = "date" name="fechaIncorporacion" id="fechaIncorporacion" required>
						</div>
						<div class="fieldset-column">
							<label for="horasAsignadas">Horas asignadas:</label>
							<input type = "number" name="horasAsignadas" id="horasAsignadas" required min="1">
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