package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.daos.EventoDaoImpl;
import model.daos.IntEventoDao;
import model.daos.IntTipoEventoDao;
import model.daos.TipoEventoDaoImpl;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc = config.getServletContext();
		
		/*
		 * instanciamos una interfaz de eventos y otra de tipos y
		 * las establecemos como atributos de aplicacion. Los cambios 
		 * seran persistentes en el contexto de la vida del servlet
		 */
		IntEventoDao iEventos = new EventoDaoImpl();
		IntTipoEventoDao iTipos = new TipoEventoDaoImpl();
		sc.setAttribute("iEventos", iEventos);
		sc.setAttribute("iTipos", iTipos);
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtenemos la interfaz de eventos del servlet
		ServletContext sc = this.getServletContext();
		IntEventoDao iEventos = (IntEventoDao) sc.getAttribute("iEventos");
		
		//dirigimos al usuario a la pagina de inicio.
		//en la A1, la pagina de inicio es el listado de todos los eventos
		request.getRequestDispatcher("eventos?opcion=todos").forward(request, response);
	}

}
