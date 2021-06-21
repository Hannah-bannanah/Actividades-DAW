import itt.com.teatro.*;
import java.util.Scanner;

public class Principal {
		 private static Scanner lector;
         private static Obra obra = new Obra("La cena de los idiotas", "Comedia", 95);
         private static Teatro teatro = new Teatro("C/ Sol, 45", 300, 2, obra, 30);

         public static void main(String[] args) {

                       lector = new Scanner(System.in);

                       char opc;

                       do {

                                    opc = mostrarMenu();

                                    switch (opc) {

                                                  case '1': System.out.println(teatro.verProgramacion());
                                                  break;

                                                  case '2': System.out.println(teatro.verLocalidades());
                                                  break;

                                                  case '3': System.out.println(teatro.verLocalidadesOcupadas());
                                                  break;

                                                  case '4': 
                                                	  System.out.println("Introduzca fila");
                                                	  int filaVenta = lector.nextInt();
                                                	  lector.nextLine();
                                                	  System.out.println("Introduzca butaca");
                                                	  int butacaVenta = lector.nextInt();
                                                	  if (teatro.estaLibre(filaVenta, butacaVenta)) {
                                                    	  lector.nextLine();
                                                    	  System.out.println("Introduzca nombre del espectador");
                                                    	  String nombreEspectador = lector.nextLine();
                                                    	  System.out.println("Introduzca teléfono del espectador");
                                                    	  String tlfEspectador = lector.nextLine();
                                                    	  System.out.println("Introduzca edad del espectador");
                                                    	  int edadEspectador = lector.nextInt();
                                                    	  lector.nextLine();
                                                    	  Espectador e = new Espectador(nombreEspectador, tlfEspectador, edadEspectador);
                                                    	  System.out.println(teatro.venderLocalidad(filaVenta, butacaVenta, e));
                                                    	  break;
                                                	  } else {
                                                		  lector.nextLine();
                                                		  System.out.println("Esa butaca ya está ocupada.\nSeleccione la opcion 2 para consultar las localidades disponibles.");
                                                		  break;
                                                	  }
                                                	  //break;
                                                	  
                                                  case '5':
                                                	  System.out.println("Introduzca fila");
                                                	  int filaCancelacion = lector.nextInt();
                                                	  lector.nextLine();
                                                	  System.out.println("Introduzca butaca");
                                                	  int butacaCancelacion = lector.nextInt();                                                	  
                                                	  lector.nextLine();    
                                                	  System.out.println(teatro.cancelarLocalidad(filaCancelacion, butacaCancelacion));
                                                	  break;

                                                  case '6':
                                                	  System.out.println("Introduzca fila");
                                                	  int filaConsultada = lector.nextInt();
                                                	  lector.nextLine();
                                                	  System.out.println("Introduzca butaca");
                                                	  int butacaConsultada = lector.nextInt();                                                	  
                                                	  lector.nextLine();   
                                                	  System.out.println(teatro.consultarLocalidad(filaConsultada, butacaConsultada));
                                                	  break;
 
                                                  case '7': System.out.println(teatro.calcularRecaudacion());
                                                  break;

                                                  case '8':
                                                	  System.out.println("Hasta la vista!");
                                                	  break;

                                                  default: 
                                                	  System.out.println("0_0");
                                                	  

                                     }

                         } while (opc!='8');

                         lector.close();

}

public static char mostrarMenu() {

         String opcion;

         System.out.println ("TEATRO LA BOMBILLA DE DON BLAS");

         System.out.println ("------------------------------");

         System.out.println ("1. Ver la programación actual");

         System.out.println ("2. Mostrar todas las localidades");

         System.out.println ("3. Mostrar localidades ocupadas");

         System.out.println ("4. Vender localidad");

         System.out.println ("5. Cancelar localidad");

         System.out.println ("6. Consultar localidad");

         System.out.println ("7. Calcular recaudación");

         System.out.println ("8. Terminar programa");

         System.out.println ("------------------------------");

         System.out.println ("¿Qué opción deseas?");

         opcion = lector.nextLine();

         return opcion.charAt(0); // Devuelvo el primer caracter tecleado.
	}

}
