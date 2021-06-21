package com.itt.calculadora;

/**
 * La clase Suma contiene métodos para sumar distintos tipos de variables numéricas.  <br>
 * Todos los métodos de esta clase aceptan números negativos. <br>
 * <p>
 * Esta clase pertenece al paquete {@link com.itt.calculadora}, que reune varias clases para realizar distintas operaciones matemáticas.
 * 
 * @author Jana Montero Perales
 * @version 1.4
 * @since 17-01-2021
 * @see com.itt.calculadora 
 * 
 */
public final class Suma {
	
	/**
	 * Variable que contiene el valor acumulado de todas las sumas acumuladas realizadas.
	 */
	public static double suma_acumulada = 0.0;
	
	private Suma() {
	}
	
	/**
	 * Función que suma dos números reales
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (double).
	 * @param oper2 Representa el segundo operando. Es un número real (double).
	 * @return Devuelve el resultado de la suma oper1 + oper2. Es un número real (double).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que alguno de los operandos sea un número negativo, el resultado será una resta 
	 * @see Resta
	 */
	public static double sumaReales(double oper1, double oper2) {
		return 0.0;
	}
	
	/**
	 * Función que suma dos números enteros
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (int).
	 * @param oper2 Representa el segundo operando. Es un número real (int).
	 * @return Devuelve el resultado de la suma oper1 + oper2. Es un número real (int).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que alguno de los operandos sea un número negativo, el resultado será una resta 
	 * @see Resta
	 */
	public static int sumaEnteros(int oper1, int oper2) {
		return 0;
	}	
	
	/**
	 * Función que suma tres números reales
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (double).
	 * @param oper2 Representa el segundo operando. Es un número real (double).
	 * @param oper3 Representa el tercer operando. Es un número real (double).
	 * @return Devuelve el resultado de la suma oper1 + oper2 + oper3.
	 * 
	 * Casos especiales:<br>
	 * En el caso de que alguno de los operandos sea un número negativo, el resultado será una resta 
	 * @see Resta
	 *  
	 */
	public static double sumaTres(double oper1, double oper2, double oper3) {
		return 0.0;
	}
	
	/**
	 * Función que suma el número introducido como argumento a la variable estática suma_acumulada de la clase Suma. Por ejemplo:<br> 
	 * Si el valor de suma_acumulada cuando se llama al método es 100.0, y el argumento con el que se le llama es 5.0, el valor de suma_acumulada tras su ejecución será 100.0 <br>
	 * Este método no devuelve ningún valor.
	 * 
	 * @param oper Representa el operando. Es un número real (double).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que el operando sea un número negativo, el valor de suma_acumulada se verá reducido por el valor absoluto del operando. 
	 * 
	 * @see suma_acumulada
	 */
	public static void sumaAcumulada(double oper) {
	}	
}
