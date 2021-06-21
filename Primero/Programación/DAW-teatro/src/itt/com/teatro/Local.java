package itt.com.teatro;

/**
 * La clase Local representa locales
 * @author hannnah
 * @version 1.0
 * @since 1.0
 */

public class Local {
	private String domicilio;
	private int metros; //área en metros cuadrados
	private int accesos;
	
	/**
	 * Constructor de la clase Local
	 * @param domicilio
	 * @param metros
	 * @param accesos
	 */
	public Local(String domicilio, int metros, int accesos) {
		this.domicilio = domicilio;
		this.metros = metros;
		this.accesos = accesos;
	}
	
	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the metros
	 */
	public int getMetros() {
		return metros;
	}

	/**
	 * @param metros the metros to set
	 */
	public void setMetros(int metros) {
		this.metros = metros;
	}

	/**
	 * @return the accesos
	 */
	public int getAccesos() {
		return accesos;
	}

	/**
	 * @param accesos the accesos to set
	 */
	public void setAccesos(int accesos) {
		this.accesos = accesos;
	}

	@Override
	public String toString() {
		return "Local:\nDomicilio: " + this.domicilio + "\nÁrea en metros cuadrados: " + 
				this.metros + "\nNúmero de accesos: " + this.accesos;
	}
}
