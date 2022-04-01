<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nuevo Producto</title>
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
			<form action="/gestion/altaProducto" method="post">
				<fieldset>
					<legend class="form-title">Nuevo Producto</legend>
    				<div class="feedback-usuario">
						<p class="mensaje-error">${ mensajeError }</p>
						<p class="mensaje-exito">${ mensajeExito }</p>
					</div>
					<fieldset>
						<legend>Informaci&oacute;n del producto</legend>
							<div class="fieldset-row">
								<div class="fieldset-column">
									<label for="descripcionBreve">Nombre:</label>
									<input type="text" id="descripcionBreve" name="descripcionBreve" required>
								</div>
							</div>
							<div class="fieldset-row">
        						<div class="fieldset-column columna-doble">
									<label for="descripcionLarga">Descripcion:</label>
									<textarea id="descripcionLarga" name="descripcionLarga" cols="40" rows="4" placeholder="Descripcion del producto..." required></textarea>
								</div>
							</div>
							<div class="fieldset-row">
        						<div class="fieldset-column">
									<label for="precioUnitario">Precio unitario:</label>
									<input type="number" name="precioUnitario" id="precioUnitario" min="0" step="0.01" required>
								</div>
								<div class="fieldset-column">
									<label for="stock">Cantidad en stock:</label>
									<input type="number" name="stock" id="stock" required>
								</div>
							</div>
					</fieldset>
					<fieldset class="form__actions">
						<button type="submit" name="submit" id="submit" class="btn-link cta">Crear Producto</button>
						<button type="reset" name="reset" id="reset" class="btn-link">Borrar Formulario</button>
					</fieldset>
				</fieldset>
			</form>
		</main>	
	</body>
</html>