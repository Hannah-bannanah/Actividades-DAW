package com.ite.cajero.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Componente que valida si un usuario está logueado antes de procesar 
 * cada petición.
 * @author hannah
 *
 */
@Component
public class AccessValidator extends OncePerRequestFilter{

	/**
	 * Valida si un usuario está logueado antes de procesar cada petición
	 * Si no es así, redirige al usuario a la página de inicio
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		if (sesion.getAttribute("cuenta") == null) {
			request.setAttribute("mensajeError", "Es necesario loguearse para acceder a esa p&aacute;gina");
			request.getRequestDispatcher("/").forward(request, response);
			return;
		}
		filterChain.doFilter(request, response);
	}
	
	/**
	 * Excluye a todos los path que no comienzan por "/cliente" 
	 * del filtro
	 */
	@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return !path.startsWith("/cliente");
    }
}
