<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Alta Proyecto</title>
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
			<form action="/gestion/altaProyecto" method="post">
				<fieldset>
					<legend class="form-title">Nuevo Proyecto</legend>
    				<div class="feedback-usuario">
						<p class="mensaje-error">${ mensajeError }</p>
						<p class="mensaje-exito">${ mensajeExito }</p>
					</div>
					<fieldset>
						<legend>Informaci&oacute;n b&aacute;sica</legend>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="idProyecto">ID Proyecto:</label>
									<input type="text" id="idProyecto" name="idProyecto" required>
								</div>
								<div class="fieldset-column">
									<label for="descripcion">Descripcion:</label>
									<input type="text" id="descripcion" name="descripcion" required>
								</div>
							</div>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="cliente">Cliente:</label>
									<select id="cliente" name="cliente.cif" required>
										<option value="">Seleccione cliente</option>
										<c:forEach var="cliente" items="${ clientes }">
											<option value="${ cliente.cif }">${ cliente.nombre }</option>
										</c:forEach>
									</select>
								</div>
								<div class="fieldset-column">
									<label for="jefeProyecto">Jefe de pryecto:</label>
									<select id="jefeProyecto" name="jefeProyecto.idEmpl" required>
										<option value="">Seleccione jefe de proyecto</option>
										<c:forEach var="jefe" items="${ jefes }">
											<option value="${ jefe.idEmpl }">${ jefe.idEmpl } - ${ jefe.nombre }</option>
										</c:forEach>
									</select>
								</div>
							</div>
					</fieldset>
					<fieldset>
						<legend>Planificaci&oacute;n</legend>
						<div class="fieldset-row">
        					<div class="fieldset-column">
								<label for="fechaInicio">Fecha de inicio:</label>
								<input type="date" name="fechaInicio" id="fechaInicio" required>
							</div>
							<div class="fieldset-column">
								<label for="fechaFinPrevisto">Previsi&oacute;n fecha fin:</label>
								<input type="date" name="fechaFinPrevisto" id="fechaFinPrevisto" required>
							</div>
						</div>
						<div class="fieldset-row">
        					<div class="fieldset-column">
								<label for="costesPrevisto">Previsi&oacute;n costes:</label>
								<input type="number" name="costesPrevisto" id="costesPrevisto" required>
							</div>
							<div class="fieldset-column">
								<label for="ventaPrevisto">Previsi&oacute;n ventas:</label>
								<input type="number" name="ventaPrevisto" id="ventaPrevisto" required>
							</div>
						</div>
					</fieldset>
					<fieldset class="form__actions">
						<input type="hidden" name="costeReal" value=0>
						<input type="hidden" name="estado" value="ACTIVO">
						<button type="submit" name="submit" id="submit" class="btn-link cta">Crear Proyecto</button>
						<button type="reset" name="reset" id="reset" class="btn-link">Borrar Formulario</button>
					</fieldset>
				</fieldset>
			</form>
		</main>
	</body>
</html>