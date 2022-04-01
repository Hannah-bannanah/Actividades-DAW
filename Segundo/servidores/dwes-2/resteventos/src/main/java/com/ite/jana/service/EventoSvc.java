package com.ite.jana.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.jana.model.beans.Evento;
import com.ite.jana.model.beans.Reserva;
import com.ite.jana.model.beans.Tipo;
import com.ite.jana.repository.EventosRepo;
import com.ite.jana.repository.IntReservasRepo;

@Service
public class EventoSvc implements IntEventoSvc{
	
	@Autowired
	private EventosRepo erepo;
	
	@Autowired
	private IntTipoSvc tsvc;
	
	@Autowired
	private IntReservasRepo rrepo;
	
	/**
	 * Metodo auxiliar que genera 20 eventos. 
	 * Requiere que exista al menos 1 registro en la tabla tipos.
	 */
	public void inicializar() {
		Random rd = new Random();
		Calendar cal = Calendar.getInstance();
		for (int i=0; i < 20; i++) {
			Evento evento = new Evento();
			evento.setAforoMaximo(rd.nextInt(1000) + 1);
			evento.setDescripcion("Este es un evento cualquiera con id ");
			String destacado = rd.nextFloat() > 0.65 ? "s" : "n";
			evento.setDestacado(destacado);
			evento.setDireccion("Calle falsa, " + (i+1));
			evento.setDuracion(rd.nextInt(24) + 1);
			String activo = rd.nextDouble() > 0.7 ? "activo" : "cancelado";
			evento.setEstado(activo);
			cal.set(2022, rd.nextInt(12) + 1, rd.nextInt(28) + 1);
			Date fechaInicio = cal.getTime();
			evento.setFechaInicio(fechaInicio);
			evento.setMinimoAsistencia(rd.nextInt(evento.getAforoMaximo() / 2));
			evento.setNombre("Evento #");
			evento.setPrecio(BigDecimal.valueOf(rd.nextDouble() * 400));
			Tipo tipo = tsvc.findRandom();
			evento.setTipo(tipo);
			try {
				evento = erepo.save(evento);
				evento.setDescripcion(evento.getDescripcion() + evento.getIdEvento());
				evento.setNombre(evento.getNombre() + evento.getIdEvento());
				erepo.save(evento);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Busca un evento por id
	 * @param idEvento el id del evento buscado
	 * @return el evento si existe, null si no
	 */
	@Override
	public Evento findById(int idEvento) {
		return erepo.findById(idEvento).orElse(null);
	}
	
	/**
	 * Obtiene todos los eventos activos
	 * @return la lista de eventos activos
	 */
	@Override
	public List<Evento> findActivos() {
		return erepo.findByEstado("activo");
	}

	/**
	 * Obtiene todos los eventos destacados
	 * @return la lista de eventos destacados
	 */
	@Override
	public List<Evento> findDestacados() {
		return erepo.findDestacados("s");
	}

	/**
	 * Busca eventos cuyo nombre contiene una subcadena
	 * @param subcadena la subcadena a buscar
	 * @return la lista de eventos cuyo nombre contiene subcadena
	 */
	@Override
	public List<Evento> buscarSubcadena(String subcadena) {
		String query = "%" + subcadena + "%";
		return erepo.buscarSubcadena(query);
	}

	/**
	 * Obtiene las plazas disponibles en un evento
	 * @param idEvento el id del evento
	 * @return el numero de plazas disponibles para el evento, -1 si el evento no existe
	 */
	@Override
	public int getPlazasDisponibles(int idEvento) {
		Evento evento = findById(idEvento);
		if (evento == null) return -1;
		List<Reserva> reservas = rrepo.findByEvento(idEvento);
		int plazasReservadas = 0;
		for (Reserva r: reservas) {
			plazasReservadas += r.getCantidad();
		}
		return evento.getAforoMaximo() - plazasReservadas;
	}

	/**
	 * Crea un evento
	 * @param evento el nuevo evento
	 * @return <ul>
	 * 	 <li> 1 si el evento se cre&oacute; con exito </li>
	 *  <li> -1 si el evento ya existe </li>
	 *  <li> 0 si el evento no se pudo crear por otro motivo </li>
	 *  </ul>
	 */
	@Override
	public int crearEvento(Evento evento) {

		if (evento.getIdEvento() != 0 && findById(evento.getIdEvento()) != null) 
			return -1;
		int filas = 0;
		if (evento.getTipo() == null || evento.getTipo().getIdTipo() == 0 
				|| tsvc.findById(evento.getTipo().getIdTipo()) == null)
			return filas;
		try {
			erepo.save(evento);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	/**
	 * Modifica un evento
	 * @param evento el evento a actualizar
	 * @return <ul>
	 * 	 <li> 1 si el evento se actualiz&oacute; con exito </li>
	 *  <li> -1 si el evento no existe </li>
	 *  <li> 0 si el evento no se pudo actualizar por otro motivo </li>
	 *  </ul>
	 */
	@Override
	public int modificarEvento(Evento evento) {
		if (evento.getIdEvento() == 0 || findById(evento.getIdEvento()) == null)
			return -1;
		int filas = 0;
		if (evento.getTipo() == null || evento.getTipo().getIdTipo() == 0 
				|| tsvc.findById(evento.getTipo().getIdTipo()) == null)
			return filas;
		try {
			erepo.save(evento);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	/**
	 * Elimina un evento
	 * @param idEvento el id del evento a eliminar
	 * @return <ul>
	 * 	 <li> 1 si el evento se elimin&oacute; con exito </li>
	 *  <li> -1 si el evento no existe </li>
	 *  <li> 0 si el evento no se pudo eliminar por otro motivo </li>
	 *  </ul>
	 */
	@Override
	public int eliminarEvento(int idEvento) {
		if (findById(idEvento) == null) return -1;
		try {
			erepo.deleteById(idEvento);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
