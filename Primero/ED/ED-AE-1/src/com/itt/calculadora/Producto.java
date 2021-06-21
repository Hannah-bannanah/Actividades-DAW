package com.itt.calculadora;
/**
 * 
 * La clase Producto contiene métodos para multiplicar dos o tres operadores y calcular la potencia de un número.
 * <p>
 * Esta clase pertenece al paquete {@link com.itt.calculadora}, que reune varias clases para realizar distintas operaciones matemáticas.
 * 
 * @author Pilar Navío Colón
 * @since 17/01/2021
 * @version 1.4
 * @see com.itt.calculadora
 *
 */

public final class Producto {
	
	private Producto() {
	}
	
	/**
	 * Método que multiplica dos números reales
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (float).
	 * 
	 * @param oper2 Representa el segundo operando. Es un número real (float).
	 * 
	 * @return Resultado de la multiplicación de oper1 y oper2. Es un número real (float).
	 * 	
	 */
	public static float productoDosReales (float oper1, float oper2){
		return 0.0F;
	}
	
	
	/**
	 * Método que multiplica dos números enteros
	 * 
	 * @param oper1 Representa el primer operando. Es un número entero (int).
	 * 
	 * @param oper2 Representa el segundo operando. Es un número entero (int).
	 * 
	 * @return Resultado de la multiplicación de oper1 y oper2. Es un número entero (int).
	 * 	
	 */
	public static int productoDosEnteros (int oper1, int oper2){
		return 0;
	}
	
	
	/**
	 * Método que multiplica tres números reales
	 * 
	 * @param oper1 Representa el primer operando. Es un número real (float).
	 * 
	 * @param oper2 Representa el segundo operando. Es un número real (float).
	 * 
	 * @param oper3 Representa el tercer operando. Es un número real (float).
	 * 
	 * @return Resultado de la multiplicación de oper1, oper2 y oper3. Es un número real (float).
	 * 	
	 */
	public static float productoTres (float oper1, float oper2, float oper3){
		return 0.00F;
	}
	
	
	/**
	 * Método que devuelve la potencia de un número
	 * 
	 * @param base Número que se multiplica varias veces. Es un número entero (int).<br>
	 * 
	 * @param exp Exponente: Número de veces que se multiplica la base. Es un número entero (int). <br>
	 * 
	 * @return Resultado de multiplicar base tantas veces como se indique en exp. Es un número entero (long). <br>
	 * 			Por ejemplo: int base=5, int exp=4 <br>
	 * 			El resultado será el producto de: 5*5*5*5 <p>
	 * 
	 * Casos especiales:<br>
	 * Si la base es 0 y el exponente es 0, el resultado dará un error.<br>
	 * Si el exponente es 0, el resultado será 1.<br>
	 * Si el exponente es 1, el resultado será igual a la base.<br>
	 * Si la base es 0, el resultado será 0.<br>
	 * Si la base es un número negativo, el signo del resultado depende de si el exponente es par, en cuyo caso el signo será positivo, o impar, resultando en negativo. <p>
	 * 			
	 */
	public static long potencia (int base, int exp){
		return 0L;
	}
}