import com.itt.calificaciones.Alumno;

public class Principal {

	public static void main(String[] args) {
		
		//Crear alumno
		Alumno alum = new Alumno("Carmen Torres", 31553);
		
		//introducir calificaciones
		alum.calificar("Matemáticas", 70);
		alum.calificar("Lengua", 55);
		alum.calificar("Inglés", 93);
		alum.calificar("Física", 82);
		alum.calificar("Educación física", 82);
		alum.calificar("Biología y geología", 58);

		//Imprimir resultados
		System.out.println(alum);
		System.out.println(alum.listarCalificaciones());
		System.out.println("Nota media: " + alum.calcularMedia());
	}

}