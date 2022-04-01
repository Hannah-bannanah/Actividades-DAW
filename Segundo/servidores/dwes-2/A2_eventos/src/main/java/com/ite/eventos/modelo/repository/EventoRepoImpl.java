package com.ite.eventos.modelo.repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.ite.eventos.modelo.bean.Evento;
import com.ite.eventos.modelo.bean.Tipo;


/**
 * Clase que implementa los metodos del servicio Eventos
 * @author hannah
 *
 */
@Repository
public class EventoRepoImpl implements IntEventoRepo {
	
	private List<Evento> eventos;
	
	/**
	 * Constructor vacio
	 */
	public EventoRepoImpl() {
		eventos = new ArrayList<Evento>();
		cargarDatos();
	}
	
	/**
	 * Genera 4 tipos de evento 10 eventos
	 */
	private void cargarDatos() {
		IntTipoRepo itipo = new TipoRepoImpl();
		List<Tipo> tipos = itipo.fetchAll();
		
		// crear eventos
		Calendar cal = Calendar.getInstance();
		for (int i = 0; i < 20; i++) { //generar 20 eventos con datos semialeatorios
			Random rd = new Random();
			Tipo tipo = tipos.get(rd.nextInt(4));
			String nombre = tipo.getNombre() + i;
			String descripcion = "Evento - " + tipo.getDescripcion();
			cal.set(2021, rd.nextInt(12) + 1, rd.nextInt(28) + 1); //fecha generada pseudoaleatoriamente
			Date fechaInicio = cal.getTime();
			int duracion = rd.nextInt(24) + 1;
			String direccion = "Tierra";
			char destacado = rd.nextBoolean() ? "s".charAt(0) : "n".charAt(0);
			int maxAforo = 80;
			int minAsistencia = 1;
			double precio = rd.nextInt(200) + (rd.nextInt(100) + 1) / 100.0;
			eventos.add(new Evento(nombre, descripcion,
					fechaInicio, duracion, direccion, 
					destacado, maxAforo, minAsistencia, precio,
					tipo));
		}
	}
	
	/**
	 * Busca un evento a partir de su idEvento
	 * @param idEvento
	 * @return el evento con ese idEvento, null si no existe el idEvento
	 */
	public Evento findById(int idEvento) {
		for (Evento evento : eventos) {
			if (evento.getIdEvento() == idEvento) return evento;
		}
		return null;
	}
	
	/**
	 * Devuelve una lista de todos los eventos
	 * 
	 * @return lista de todos los eventos
	 */
	public List<Evento> fetchAll() {
		return eventos;
	}

	/**
	 * Devuelve una lista de todos los eventos destacados
	 * 
	 * @return lista de eventos activos 
	 */
	@Override
	public List<Evento> fetchDestacados() {
		List<Evento> eventosDestacados = new ArrayList<Evento>();
		for (Evento evento : eventos) {
			if (evento.getDestacado() == "s".charAt(0)) {
				eventosDestacados.add(evento);
			}
		}
		return eventosDestacados;
	}
	

	/**
	 *Devuelve una lista de todos los eventos filtrados por un estado
	 *
	 *@param estado estado por el que se desea filtrar
	 *@return lista de eventos con el estado elegido
	 */
	@Override
	public List<Evento> findByEstado(String estado) {
		List<Evento> eventosEstado = new ArrayList<Evento>();
		for (Evento evento : eventos) {
			if (evento.getEstado() == estado) {
				eventosEstado.add(evento);
			}
		}
		return eventosEstado;
	}

	/**
	 * Anyade un evento a la lista de eventos
	 * 
	 * @return 1 si el evento se ha aniadido con exito; 0 si no
	 */
	@Override
	public int registrarEvento(Evento evento) {
		return eventos.add(evento) ? 1 : 0;
	}

	/**
	 * Reemplaza un evento por otro objeto con el mismo idEvento
	 * 
	 * @return 1 si el evento ha sido reemplazado con exito; 0 si no
	 */
	@Override
	public int editarEvento(Evento evento) {
		int pos = eventos.indexOf(evento); //devuelve el indice del evento a reemplazar
		if (pos == -1) return 0;
		else if (eventos.set(pos, evento) == null) return 0;
		else return 1;
	}

	/**
	 * Elimina un evento
	 * 
	 * @return 1 si el evento se ha eliminado con exito; 0 si no
	 */
	@Override
	public int eliminarEvento(int idEvento) {
		Evento eventoAEliminar = findById(idEvento);
		return eventos.remove(eventoAEliminar) ? 1 : 0;
	}

	/**
	 * Cambia el estado de un evento a "cancelado"
	 * 
	 * @return 1 si el estado se ha modificado con exito; 0 si no
	 */
	@Override
	public int cancelarEvento(int idEvento) {
		Evento eventoACancelar = findById(idEvento);
		if (eventoACancelar == null) return 0;
		eventoACancelar.setEstado("cancelado");
		return 1;
	}

	@Override
	public int activarEvento(int idEvento) {
		Evento eventoACancelar = findById(idEvento);
		if (eventoACancelar == null) return 0;
		eventoACancelar.setEstado("activo");
		return 1;
	}
	
	
}
