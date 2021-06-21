import com.itt.libreria.*;

public class Principal {

	public static void main(String[] args) {
		
		//crear objetos Autor y Libro
		Autor asimov = new Autor("Isaac Asimov", "vivió, murió");
		Libro fundacion = new Libro("La Fundación", "ciencia ficción", asimov);

		//modificar la biografía del autor a través del objeto Libro
		fundacion.getAutor().setBiografia("vivió, escribió, murió");
		
		//invocación del método toString() del Autor
		System.out.println("Método toString() del Autor:");
		System.out.println("===========================================");
		System.out.println("asimov.toString():\n");
		System.out.println(asimov.toString());
		System.out.println("-------------------------------------------");
		System.out.println("fundacion.getAutor().toString():\n");
		System.out.println(fundacion.getAutor().toString());
		System.out.println("===========================================\n");

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
		System.out.println("Cambio del genero del libro");
		System.out.println("===========================================");
		//invocación del método toString del Libro
		System.out.println("fundacion.toString() antes del cambio:\n");
		System.out.println(fundacion.toString());
		System.out.println("-------------------------------------------");		
		//modificación del genero del libro
		fundacion.setGenero("Sci-fi");
		//invocación del método toString() del libro para ver los cambios
		System.out.println("fundacion.toString() tras del cambio:\n");
		System.out.println(fundacion.toString());
		System.out.println("===========================================");

	}

}
