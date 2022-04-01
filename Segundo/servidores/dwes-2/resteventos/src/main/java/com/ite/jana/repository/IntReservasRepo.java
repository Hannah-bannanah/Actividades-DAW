package com.ite.jana.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.jana.model.beans.Evento;
import com.ite.jana.model.beans.Reserva;

public interface IntReservasRepo extends JpaRepository<Reserva, Integer>{
	@Query("select r from Reserva r where r.evento.idEvento = ?1")
	public List<Reserva> findByEvento(int idEvento);
}
