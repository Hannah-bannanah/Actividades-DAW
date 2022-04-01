package com.ite.libreria_jmp.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ite.libreria_jmp.model.beans.Libro;
import com.ite.libreria_jmp.model.beans.Tema;
import com.ite.libreria_jmp.repository.LibroRepo;

/**
 * Servicio de libros
 * @author hannah
 *
 */
@Service
public class LibroSvc implements IntLibroSvc{
	
	@Autowired
	private IntTemaSvc tSvc;
	
	@Autowired
	private LibroRepo lRepo;

	/**
	 * Aniade 20 libros a la base de datos
	 */
	@Override
	public void inicializarLibros() {
		List<Tema> temas = tSvc.fetchAll();
		Random rd = new Random();
		
		for (int i = 1; i <= 20; i++) {
			Libro libro = new Libro();
			long isbn = rd.nextInt(1000000000) + 100000000;
			libro.setIsbn(isbn);
			libro.setAutor("Autor " + i);
			String novedad = rd.nextDouble() > 0.7 ? "s" : "n";
			libro.setNovedad(novedad);
			libro.setPaginas(rd.nextInt(4700) + 300);
			BigDecimal precio = BigDecimal.valueOf((rd.nextInt(5001) + 500) / 100);
			libro.setPrecioUnitario(precio);
			libro.setTitulo("Libro " + i);
			libro.setTema(temas.get(rd.nextInt(temas.size())));
			libro.setImagen("https://picsum.photos/id/" + i + "/100/150");
			lRepo.save(libro);
		}
	}

	@Override
	public List<Libro> fetchAll() {
		return lRepo.findAll();
	}

	@Override
	public Libro findByIsbn(long isbn) {
		return lRepo.findById(isbn).orElse(null);
	}

	@Override
	public int insertOne(Libro libro) {
		if (findByIsbn(libro.getIsbn()) != null) return 0;
		int filas = 0;
		try {
			lRepo.save(libro);
			filas ++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int updateOne(Libro libro) {
		if (findByIsbn(libro.getIsbn()) == null) return 0;
		int filas = 0;
		try {
			lRepo.save(libro);
			filas ++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int eliminar(long isbn) {
		int filas = 0;
		try {
			lRepo.deleteById(isbn);
			filas = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Libro> fetchNovedades() {
		return lRepo.fetchNovedades();
	}

	@Override
	public List<Libro> fetchByTema(Tema tema) {
		return lRepo.fetchByTema(tema.getIdTema());
	}

	@Override
	public List<Libro> searchByTitle(String subcadena) {
		String regex = "%" + subcadena + "%";
		return lRepo.searchTitles(regex);
	}

}
