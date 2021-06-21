import com.itt.academia.*;

public class Principal {

	public static void main(String[] args) {
		//Crear objetos de distintos tipos de Persona
		Persona profEinstein = new Profesor("123", "Einstein", "Calle falsa", "456");
		Persona profTesla = new Profesor("456", "Tesla", "Calle de mentira", "789", "electromagnetismo");
		Persona alumZoquete = new Alumno("789", "Zoquete", "Avda inventada", "012", "Mecánica Cuántica");
		Persona alumBrillante = new Alumno("012", "Brillante", "Avda de la falacia", "345","Comer helado");
		Persona adminSmith = new Administrativo("345", "Smith", "Plaza del engaño", "678", 
												new String[]{"administrar", "hacer cuentas"});
		Persona adminSmoth = new Administrativo("678", "Smoth", "Ronda fraudulenta", "901", new String[] {});
		
		Persona [] personas = {profEinstein, profTesla, alumZoquete, alumBrillante, adminSmith, adminSmoth}; //array de todos los objetos creados
		Profesor [] profesores = {(Profesor) profEinstein, (Profesor) profTesla}; //array de los objetos creados con la clase Profesor
		Alumno [] alumnos = {(Alumno) alumZoquete, (Alumno) alumBrillante}; //array de los objetos creados con la clase Alumno
		Administrativo [] administrativos = {(Administrativo) adminSmith, (Administrativo) adminSmoth};
		
		System.out.println("Objetos creados para la prueba:");
		System.out.println("==========================================");
		//Mostrar los detalles de cada objeto
		for (Persona p: personas) {
			System.out.println(p.toString());
			System.out.println("------------------------------------------");
		}
		System.out.println("==========================================");	
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();

		System.out.println("Método .trabajar():");
		System.out.println("==========================================");
		//Enviar a cada objeto a trabajar
		for (Persona p: personas) {
			System.out.println(p.trabajar());
			System.out.println("------------------------------------------");
		}
		
		System.out.println("==========================================");	
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		System.out.println("Método .llamar():");
		System.out.println("==========================================");		
		//Hacer que cada objeto llame a los otros objetos
		for (Persona p: personas) {
			for (Persona otraP: personas) {
				if (!p.equals(otraP)) {
					System.out.println(p.llamar(otraP));
					System.out.println("------------------------------------------");
				}
			}
		}
		
		System.out.println("==========================================");	
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		System.out.println("Método profesor.ponerNotas():");
		System.out.println("==========================================");		
		//Enviar a los profesores a poner notas
		for (Profesor prof: profesores) {
			System.out.println(prof.ponerNotas());
			System.out.println("------------------------------------------");
		}
		
		System.out.println("==========================================");	
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		System.out.println("Método alumno.hacerExamen():");
		System.out.println("==========================================");	
		//enviar a alumBrillante a estudiar hasta haber llegado a las horas de estudio necesarias
		do {
			alumBrillante.trabajar();
		} while (((Alumno)alumBrillante).necesitaEstudiar());
		
		//Enviar a los estudiantes a hacer un examen			
		for (Alumno alum: alumnos) {
			System.out.println(alum.hacerExamen());
			System.out.println("------------------------------------------");
		}
		
		System.out.println("==========================================");	
		System.out.println();
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println();
		
		System.out.println("Método administrativo.gestionarMatricula():");
		System.out.println("==========================================");		
		//Enviar a los administrativos a gestionar matrícula
		for (Administrativo admin: administrativos) {
			System.out.println(admin.gestionarMatricula());
			System.out.println("------------------------------------------");
		}
		System.out.println("==========================================");	
	}

}
