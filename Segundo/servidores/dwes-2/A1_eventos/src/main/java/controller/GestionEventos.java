package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Evento;
import model.beans.TipoEvento;
import model.daos.IntEventoDao;
import model.daos.IntTipoEventoDao;

/**
 * Servlet implementation class GestionEventos
 */
@WebServlet("/eventos")
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IntEventoDao iEventos = (IntEventoDao) request.getServletContext().getAttribute("iEventos");
		IntTipoEventoDao iTipos = (IntTipoEventoDao) request.getServletContext().getAttribute("iTipos");
		
		String opcion = request.getParameter("opcion");
		if (opcion == null) opcion = "optionless";
		switch (opcion) {
			case "todos":
				mostrarEventos(request, response, iEventos);
				break;
			case "activos":
				mostrarActivos(request, response, iEventos);
				break;
			case "cancelados":
				mostrarCancelados(request, response, iEventos);
				break;
			case "destacados":
				mostrarDestacados(request, response, iEventos);
				break;
			case "alta":
				registrarEvento(request, response, iEventos, iTipos);
				break;
			case "editar":
				editarEvento(request, response, iEventos, iTipos);
				break;
			case "eliminar":
				eliminarEvento(request, response, iEventos);
				break;
			case "cancelar":
				cancelarEvento(request, response, iEventos);
				break;
				default:
					System.out.println("opcion incorrecta: " + opcion);
		}			
	}
	
	/**
	 * Muestra la lista de todos los eventos
	 * @param request
	 * @param response
	 * @param iEventos
	 * @throws ServletException
	 * @throws IOException
	 */
	private void mostrarEventos(HttpServletRequest request, HttpServletResponse response,
			IntEventoDao iEventos) 
					throws ServletException, IOException {
		List<Evento> eventos = iEventos.fetchAll();
		request.setAttribute("eventos", eventos);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	/**
	 * Cambia el estado de un evento a "cancelado" y 
	 * vuelve al listado de todos los eventos
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void cancelarEvento(HttpServletRequest request, 
			HttpServletResponse response, IntEventoDao iEventos)
					throws ServletException, IOException {
		int idEvento = Integer.parseInt(request.getParameter("id"));
		iEventos.cancelarEvento(idEvento);
		request.getRequestDispatcher("eventos?opcion=todos").forward(request, response);
	}

	/**
	 * Elimina un evento de la lista de eventos y 
	 * vuelve al listado de todos los eventos
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void eliminarEvento(HttpServletRequest request, 
			HttpServletResponse response, IntEventoDao iEventos)
					throws ServletException, IOException {
		int idEvento = Integer.parseInt(request.getParameter("id"));
		iEventos.eliminarEvento(idEvento);
		request.getRequestDispatcher("home").forward(request, response);
	}

	/**
	 * Muestra un formulario de edicion del evento elegido con
	 * los campos pre-rellenados con la informacion del evento.
	 * Al enviar el formulario, el evento se reemplaza con la  
	 * nueva informacion.
	 * 
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void editarEvento(HttpServletRequest request, HttpServletResponse response, 
			IntEventoDao iEventos, IntTipoEventoDao iTipos)
					throws ServletException, IOException {		
		
		int idEvento = Integer.parseInt(request.getParameter("id"));
		
		if (request.getParameter("submit") == null) { //no se ha enviado el formulario; dirigimos al usuario al formulario
			Evento evento = iEventos.findById(idEvento);
			request.setAttribute("evento", evento);
			
			//modificar el formato de la fecha de inicio
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String fechaFormateada = sdf.format(evento.getFechaInicio());
			request.setAttribute("fechaInicio", fechaFormateada);
			
			/*
			 * pasamos por separado un boolean especificando si el evento
			 * es destacado
			*/
			boolean isDestacado = evento.getDestacado() == "s".charAt(0);
			request.setAttribute("isDestacado", isDestacado);
			
			List<TipoEvento> tipos = iTipos.fetchAll();
			request.setAttribute("tipos", tipos);
			
			
			request.setAttribute("editar", true); //variable utilizada por el formulario
			request.getRequestDispatcher("postEvento.jsp").forward(request, response);
		} else { //se ha enviado el formulario; procesar cambios
			
			// obtener parametros enviados por el formulario
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			String direccion = request.getParameter("direccion");
			String estado = "activo";
			char destacado = request.getParameter("destacado") != null? "s".charAt(0) : "n".charAt(0);
			int maxAforo = Integer.parseInt(request.getParameter("maxAforo"));
			int minAsistencia = Integer.parseInt(request.getParameter("minAsistencia"));
			double precio = Double.parseDouble(request.getParameter("precio"));
			
			//obtener tipo
			int idTipo = Integer.parseInt(request.getParameter("tipo"));
			TipoEvento tipo = iTipos.findById(idTipo);
			
			//parsear fecha
			String inputFecha = request.getParameter("fechaInicio");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-LL-dd");
			sdf.setLenient(false);
			try {
				Date fechaInicio = sdf.parse(inputFecha);
				Evento nuevoEvento = new Evento(idEvento, nombre, descripcion, 
						fechaInicio, duracion, direccion, 
						estado, destacado, maxAforo, minAsistencia,
						precio, tipo);
				iEventos.editarEvento(nuevoEvento);
				
			} catch (ParseException e) {
				System.out.println("error al parsear la fecha; no se ha realizado ningun cambio");
				request.getRequestDispatcher("eventos?opcion=todos").forward(request, response);
			} catch (Exception e) {
				System.out.println("no se ha podido realizar el cambio");
				request.getRequestDispatcher("eventos?opcion=todos").forward(request, response);
			}
			
			request.getRequestDispatcher("eventos?opcion=todos").forward(request, response);
		}

	}
	
	/**
	 * Procesa el alta de un evento, creando el objeto y 
	 * aniadiendolo a la lista de eventos
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void registrarEvento(HttpServletRequest request, 
			HttpServletResponse response,
			IntEventoDao iEventos, IntTipoEventoDao iTipos) 
					throws ServletException, IOException {
		
		if (request.getParameter("submit") == null) { //no se ha enviado el formulario; dirigimos al usuario al formulario
			List<TipoEvento> tipos = iTipos.fetchAll();
			request.setAttribute("tipos", tipos);
			request.getRequestDispatcher("postEvento.jsp").forward(request, response);
		} else { //se ha enviado el formulario; registramos el evento
			
			// obtener parametros enviados por el formulario
			String nombre = request.getParameter("nombre");
			String descripcion = request.getParameter("descripcion");
			int duracion = Integer.parseInt(request.getParameter("duracion"));
			String direccion = request.getParameter("direccion");
			String estado = "activo";
			char destacado = request.getParameter("destacado") != null? "s".charAt(0) : "n".charAt(0);
			int maxAforo = Integer.parseInt(request.getParameter("maxAforo"));
			int minAsistencia = Integer.parseInt(request.getParameter("minAsistencia"));
			double precio = Double.parseDouble(request.getParameter("precio"));

			//generar idEvento
			List<Evento> eventos = iEventos.fetchAll();
			int ultimoId = eventos.get(eventos.size() - 1).getIdEvento();
			int idEvento = ultimoId + 1;
			
			//obtener tipo
			int idTipo = Integer.parseInt(request.getParameter("tipo"));
			TipoEvento tipo = iTipos.findById(idTipo);
			
			//parsear fecha
			String inputFecha = request.getParameter("fechaInicio");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sdf.setLenient(false);
			try {
				Date fechaInicio = sdf.parse(inputFecha);
				Evento nuevoEvento = new Evento(idEvento, nombre, descripcion, 
						fechaInicio, duracion, direccion, 
						estado, destacado, maxAforo, minAsistencia,
						precio, tipo);
				iEventos.registrarEvento(nuevoEvento);
				
			} catch (ParseException e) {
				System.out.println("error al parsear la fecha");
				request.getRequestDispatcher("postEvento.jsp").forward(request, response);
			}
			
			request.getRequestDispatcher("home").forward(request, response);

		
		}
		
	}

	/**
	 * Muestra un listado con los eventos activos
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void mostrarActivos(HttpServletRequest request, 
			HttpServletResponse response, IntEventoDao iEventos) 
					throws ServletException, IOException {
		List<Evento> eventosActivos = iEventos.findByEstado("activo");
		request.setAttribute("eventosActivos", eventosActivos);
		request.getRequestDispatcher("eventosFiltrados.jsp").forward(request, response);
		
	}
	
	/**
	 * Muestra un listado con los eventos cancelados
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void mostrarCancelados(HttpServletRequest request, 
			HttpServletResponse response, IntEventoDao iEventos) 
					throws ServletException, IOException {
		List<Evento> eventosCancelados = iEventos.findByEstado("cancelado");
		request.setAttribute("eventosCancelados", eventosCancelados);
		request.getRequestDispatcher("eventosFiltrados.jsp").forward(request, response);
		
	}
	
	/**
	 * Muestra un listado con los eventos destacados
	 * @param request
	 * @param response
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void mostrarDestacados(HttpServletRequest request, 
			HttpServletResponse response, IntEventoDao iEventos) 
					throws ServletException, IOException {
		List<Evento> eventosDestacados = iEventos.fetchDestacados();
		request.setAttribute("eventosDestacados", eventosDestacados);
		request.getRequestDispatcher("eventosFiltrados.jsp").forward(request, response);
		
	}
}
