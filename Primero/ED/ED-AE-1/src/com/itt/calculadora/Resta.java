package com.itt.calculadora;

/**
 * La clase Resta contiene métodos para restar distintos tipos de variables numéricas.  <br>
 *  
 * Esta clase pertenece al paquete {@link com.itt.calculadora}, que reune varias clases para realizar distintas operaciones matemáticas.
 * 
 * @author Paula Casado García
 * @version 1.3
 * @since 17-01-2021
 * @see com.itt.calculadora 
 * 
 */
public class Resta {

	private Resta () {
		
	}
	
	/**
	 * Variable que contiene el valor acumulado de todas las restas realizadas con valor acumulado
	 */
	public static float resta_acumulada = 0.0F;	
	
	/**
	 * Este método resta dos números reales y devuelve el resultado.
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (double).
	 * @param oper2 Representa el segundo operando. Es un número real (double).
	 * 
	 * @return Valor obtenido al restar oper2 a oper1. Es un número real (double).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que el primer operando sea un número positivo, y el segundo operando, un número negativo, la operación será una suma: 
	 * @see Suma
	 */
	public static double restaReales (double oper1, double oper2){
		return 0.0;
	}
	
	
	/**
	 * Este método resta dos números enteros y devuelve el resultado.
	 * 
	 * @param oper1 Representa el primer operando. Es un número entero (int).
	 * @param oper2 Representa el segundo operando. Es un número entero (int).
	 * 
	 * @return Valor obtenido al restar oper2 a oper1. Es un número entero (int).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que el primer operando sea un número positivo, y el segundo operando, un número negativo, la operación será una suma:
	 * @see Suma
	 */
	public static int restaEnteros (int oper1, int oper2){
		return 0;
	}
	
	/**
	 * Este método resta tres números reales y devuelve el resultado.
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (double).
	 * @param oper2 Representa el segundo operando. Es un número real (double).
	 * @param oper3 Representa el tercer operando. Es un número real (double).
	 * 
	 * @return Valor obtenido al restar los tres números. Es un número real (double).
	 * 
	 * Casos especiales:<br>
	 * En el caso de que el primer operando sea un número positivo, y el segundo y tercer operando, un número negativo, la operación será una suma:
	 * @see Suma
	 */
	public static double restaTres (double oper1, double oper2, double oper3){
		return 0.0;
	}
	
	
	/**
	 * Este método acumula el resultado.
	 * Para ello, se resta el valor introducido al último resultado de la resta.<br>
	 * Por ejemplo:<br> resultado acumulado=0; <br> Si el oper1 vale 5, el valor del resultado acumulado será: 0-5= <b>-5</b>
	 * 
	 * @param oper Representa el operando. Es un número real (double).
	 * 
	 * Este método no devuelve un resultado, sino que éste queda guardado en la clase.
	 */
	public static void restaAcumulado (double oper){
	}

}