<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nuevo Empleado</title>
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
			<form action="/rrhh/altaEmpleado" method="post">
				<fieldset>
					<legend class="form-title">Nuevo Empleado</legend>
    				<div class="feedback-usuario">
						<p class="mensaje-error">${ mensajeError }</p>
						<p class="mensaje-exito">${ mensajeExito }</p>
					</div>
					<fieldset>
						<legend>Datos del empleado</legend>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="idEmpl">ID Empleado</label>
									<input type="number" id="idEmpl" name="idEmpl" required>
								</div>
								<div class="fieldset-column">
									<label for="correo">Correo:</label>
									<input type="email" id="correo" name="correo" required>
								</div>
							</div>
					</fieldset>
					<fieldset>
						<legend>Datos Personales</legend>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="nombre">Nombre</label>
									<input type="text" id="nombre" name="nombre" required>
								</div>
								<div class="fieldset-column">
									<label for="fechaNacimiento">Fecha de nacimiento:</label>
									<input type="date" id="fechaNacimiento" name="fechaNacimiento" required>
								</div>
							</div>
					</fieldset>
					<fieldset>
						<legend>Detalles de la incorporaci&oacute;n</legend>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="fechaIngreso">Fecha de incorporaci&oacute;n:</label>
									<input type="date" id="fechaIngreso" name="fechaIngreso" required>
								</div>
								<div class="fieldset-column">
									<label for="salario">Salario:</label>
									<input type=number id="salario" name="salario" required>
								</div>
							</div>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="perfil">Rol:</label>
									<select name="perfil" id="perfil">
										<option value="" selected>Elige un rol</option>
										<c:forEach var="perf" items="${ listaPerfiles }">
											<option value="${ perf.idPerfil }">${ perf.nombre }</option>
										</c:forEach>
									</select>
								</div>
								<div class="fieldset-column">
									<label for="departamento">Departamento:</label>
									<select name="departamento" id="departamento">
										<option value="" selected>Elige un departamento</option>
										<c:forEach var="dept" items="${ listaDepartamentos }">
											<option value="${ dept.idDepar }">${ dept.nombre }</option>
										</c:forEach>
									</select>
								</div>
							</div>
					</fieldset>
					<fieldset class="form__actions">
						<button type="submit" name="submit" id="submit" class="btn-link cta">Registrar Empleado</button>
						<button type="reset" name="reset" id="reset" class="btn-link">Borrar Formulario</button>
					</fieldset>
				</fieldset>
			</form>
		</main>	
	</body>
</html>