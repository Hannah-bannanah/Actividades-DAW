<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${ editar ? "Editar Evento" : "Registrar Evento" }</title>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="css/form.css">
	</head>
	<body>
		<header>
			<nav class="main-nav">
				<ul class="main-nav__items">
					<li class="main-nav__item"><a href="#" class="btn-link">Tipos</a></li><!--
					--><li class="main-nav__item current-tab"><a class="btn-link" href="eventos?opcion=todos">Eventos</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Usuarios</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="eventos?opcion=activos">Eventos/Tipo</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Login</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Registro</a></li><!--
					--><li class="main-nav__item"><a class="btn-link" href="#">Salir</a></li>					
				</ul>
			</nav>
		</header>
		<main>
		<h2>${ editar ? "Editar Evento" : "Nuevo Evento" }</h2>
		<a class="btn-link" href="eventos?opcion=todos">Volver al listado</a>
		<form action="${ editar ? 'eventos?opcion=editar&id=' : 'eventos?opcion=alta' }${ editar ? evento.idEvento : '' }" method="post">
    		<fieldset>
      			<legend class="form-title"> ${ editar ? "Editando Evento #" : "Crear Evento"}${ editar ? evento.idEvento : '' }</legend>
      			<fieldset id="basic-info">
        			<legend>Informaci&oacute;n b&aacute;sica</legend>
        			<div class="fieldset-row">
        				<div class="fieldset-column">
        					<label for="nombre">Nombre del evento:</label>
        					<input type="text" name="nombre" id="nombre" value="${ editar ? evento.nombre : '' }"required>
        				</div>
        				<div class="fieldset-column">
        					<label for="descripcion">Descripci&oacute;n:</label>
        					<textarea id="descripcion" name="descripcion" rows="3" cols="30" required>${ editar ? evento.descripcion : ""}</textarea>
        				</div>
        			</div>
        			<div class="fieldset-row">
        				<div class="fieldset-column">
        				    <label for="precio">Precio:</label>
        					<input type="number" name="precio" id="precio" 
        						step="0.01" min="0" value="${ editar ? evento.precio : ''}" required>
        				</div>
        				<div class="fieldset-column">
        				    <label for="tipo">Tipo de Evento:</label>
        					<select id="tipo" name="tipo" required>
        						<option value="">Seleccione tipo de evento</option>
        						<c:forEach var="tipo" items="${ tipos }">
        							<c:choose>
										<c:when test="${ editar && tipo.idTipo eq evento.tipo.idTipo }" >
											<option value="${ tipo.idTipo }" selected>${ tipo.nombre }</option>		
										</c:when>
										<c:otherwise>
											<option value="${ tipo.idTipo }">${ tipo.nombre }</option>							
										</c:otherwise>
        							</c:choose>
        						</c:forEach>
        					</select>
        				</div>
        			</div>
        			<div class="fieldset-row">
        				<div class="fieldset-column inline-column">
        					<label for="destacado" >Destacado?</label>
        	        		<c:choose>
								<c:when test="${isDestacado}" >
        							<input type="checkbox" name="destacado" id="destacado" value="s" checked>
								</c:when>
								<c:otherwise>
									<input type="checkbox" name="destacado" id="destacado" value="s">							
								</c:otherwise>
        					</c:choose>
        				</div>
        			</div>
      			</fieldset>
      			<fieldset>
        			<legend>Fecha y lugar</legend>
        			<div class="fieldset-row">
        				<div class="fieldset-column">
        					<label for="fechaInicio">Fecha de inicio (aaaa-mm-dd):</label>
        					<input type="date" name="fechaInicio" id="fechaInicio" 
        						pattern="\d{4}-\d{2}-\d{2}" value= "${ editar ? fechaInicio : ''}" required>
        				</div>
        				<div class="fieldset-column">
        					<label for="direccion">Direcci&oacute;n:</label>
        					<input type="text" name="direccion" id="direccion"
        						value = "${ editar ? evento.direccion : ''}" required>
        				</div>
        				<div class="fieldset-column">
        					<label for="duracion">Duraci&oacute;n en horas:</label>
        					<input type="number" name="duracion" id="duracion" min="1"
        						value = "${ editar ? evento.duracion : ''}" required>
        				</div>
        			</div>
      			</fieldset>
      			<fieldset>
        			<legend>Asistencia</legend>
        			<div class="fieldset-row">
        				<div class="fieldset-column inline-column">
        					<label for="minAsitencia">M&iacute;nimo:</label>
        					<input type="number" name="minAsistencia" id="minAsistencia"
        						min="1" value="${ editar ? evento.minAsistencia : ''}" required>
        					
        				</div>
        				<div class="fieldset-column inline-column">
        					<label for="maxAforo">M&aacute;ximo:</label>
        					<input type="number" name="maxAforo" id="maxAforo" min="1"
        					value="${ editar ? evento.maxAforo : ''}" required>
        				</div>
        			</div>
        			
      			</fieldset>
      			<fieldset class="form__actions">
      				<button type="submit" name="submit" id="submit" class="btn-link cta">${ editar ? 'Modificar Evento' : 'Registar Evento' }</button>
					<button type="reset" name="reset" id="reset" class="btn-link">${ editar ? 'Anular Cambios' : 'Borrar Formulario' }</button>
				</fieldset>
    		</fieldset>
  		</form>
  		</main>
	</body>
</html>