package itt.com.teatro;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.HashMap;

/**
 * La clase teatro representa un teatro. 
 * Puede o no tener actualemente una función
 * @author hannnah
 * @version 1.0
 * @since v1.0
 */

public class Teatro extends Local implements Sala{
	private Obra obra;
	private double precio;
	private Espectador[][] localidades;
	private Map descuentos;
	
	
	/**
	 * Constructor de la clase Teatro sin una función predeterminada.
	 * Se asume que el teatro tiene 5 filas con 10 butacas cada una. Todas las butacas están vacías
	 * @param domicilio la dirección donde se encuentra el teatro
	 * @param metros el área en metros cuadrados del teatro
	 * @param accesos el número de accesos al teatro
	 */
	public Teatro(String domicilio, int metros, int accesos) {
		super(domicilio, metros, accesos);
		this.obra = new Obra("TBD", "TBD", 0);
		this.precio = 0.0;
		this.localidades = new Espectador[5][10];
		this.descuentos = new HashMap();
		this.descuentos.put("INFANTIL", 50);
		this.descuentos.put("MENOR", 20);
		this.descuentos.put("MAYOR", 0);
		this.descuentos.put("JUBILADO", 66);
	}

	/**
	 * Constructor de la clase Teatro con una función predeterminada.
	 * Se asume que el teatro tiene 5 filas con 10 butacas cada una. Todas las butacas están vacías
	 * @param domicilio la dirección donde se encuentra el teatro
	 * @param metros el área en metros cuadrados del teatro
	 * @param accesos el número de accesos al teatro
	 * @param obra la obra que el teatro va a representar
	 * @param precio el precio de la entrada
	 */
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
		this.localidades = new Espectador[5][10];
		this.descuentos = new HashMap();
		this.descuentos.put("INFANTIL", 50);
		this.descuentos.put("MENOR", 20);
		this.descuentos.put("MAYOR", 0);
		this.descuentos.put("JUBILADO", 66);
	}

	/**
	 * Constructor de la clase Teatro con una función predeterminada.
	 * Todas las butacas están vacías
	 * @param domicilio la dirección donde se encuentra el teatro
	 * @param metros el área en metros cuadrados del teatro
	 * @param accesos el número de accesos al teatro
	 * @param obra la obra que el teatro va a representar
	 * @param precio el precio de la entrada
	 * @param filas número de filas en el teatro
	 * @param butacas número de butacas por cada fila
	 */
	public Teatro(String domicilio, int metros, int accesos, Obra obra, double precio, int filas, int butacas) {
		super(domicilio, metros, accesos);
		this.obra = obra;
		this.precio = precio;
		this.localidades = new Espectador[filas][butacas];
		this.descuentos = new HashMap();
		this.descuentos.put("INFANTIL", 50);
		this.descuentos.put("MENOR", 20);
		this.descuentos.put("MAYOR", 0);
		this.descuentos.put("JUBILADO", 66);
	}
	
	/**
	 * @return the obra
	 */
	public Obra getObra() {
		return obra;
	}

	/**
	 * @param obra the obra to set
	 */
	public void setObra(Obra obra) {
		this.obra = obra;
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	/**
	 * @return the descuentos
	 */
	public Map getDescuentos() {
		return descuentos;
	}

	/**
	 * @param descuentos the descuentos to set
	 */
	public void setDescuentos(Map descuentos) {
		this.descuentos = descuentos;
	}

	/**
	 * @return the localidades
	 */
	public Espectador[][] getLocalidades() {
		return localidades;
	}
	
	/**
	 * @return una cadena con la obra representada en el teatro
	 */
	public String verProgramacion() {
		return this.obra.toString();
	}
	
	/**
	 * @return una cadena con una representación visual de todas las localidades del teatro
	 * (las butacas ocupadas se marcan con una X)
	 */
	public String verLocalidades() {
		String cadenaLocalidades = "";
		for (int f = 0; f < this.localidades.length; f++) {
			for (int b = 0; b < this.localidades[f].length; b++) {
				if (this.localidades[f][b] == null) {
					cadenaLocalidades = cadenaLocalidades + "[ ]";
				} else {
					cadenaLocalidades = cadenaLocalidades + "[X]";
				}
			}
			cadenaLocalidades = cadenaLocalidades + "\n";
		}
		
		return cadenaLocalidades;
	}
	
	/**
	 * @return una lista de las localidades ocupadas en formato fila:butaca
	 */
	public String verLocalidadesOcupadas() {
		String localidadesOcupadas = "Lista de ocupadas ocupadas en formato fila:butaca\n";
		for (int f = 0; f < this.localidades.length; f++) {
			for (int b = 0; b < this.localidades[f].length; b++) {
				if (this.localidades[f][b] != null) {
					localidadesOcupadas = localidadesOcupadas + (f + 1) + ":" + (b + 1) + "\n";
				}
			}
		}
		
		return localidadesOcupadas;
	}
	

	/**
	 * Método que asigna una localidad a un espectador
	 * @param fila la fila de la localidad
	 * @param butaca el número de butaca de la localidad
	 * @param e espectador que compra la entrada
	 * @return una cadena informando del éxito o fracaso de la operación
	 */
	public String venderLocalidad(int fila, int butaca, Espectador e) {
		if (this.localidades[fila - 1][butaca - 1] != null) {
			return "Esa localidad ya está ocupada. Seleccione otra localidad";
		} else {
			this.localidades[fila-1][butaca-1] = e;
			return this.consultarLocalidad(fila, butaca);
		}
	}
	
	/**
	 * Método que libera una localidad si estaba asignada a algún espectador
	 * @param fila la fila de la localidad
	 * @param butaca el número de butaca de la localidad
	 * @return una cadena informando del éxito of fracaso de la operación
	 */
	public String cancelarLocalidad(int fila, int butaca) {
		if (this.localidades[fila - 1][butaca - 1] == null) {
			return "La localidad indicada ya está libre";
		} else {
			this.localidades[fila - 1][butaca -1] = null;
			return "Localidad " + fila + ":" + butaca + " queda libre";
		}
	}
	
	/**
	 * Método que indica si una localidad está libre u ocupada
	 * @param fila la fila de la localidad
	 * @param butaca el número de butaca de la localidad
	 * @return una cadena informando del estado de la localidad
	 */
	public String consultarLocalidad(int fila, int butaca) {
		String cadena = "La localidad " + fila + ":" + butaca;
		if (this.estaLibre(fila, butaca)) {
			cadena = cadena + " está libre";
		} else {
			cadena = cadena + " está ocupada por el " + this.localidades[fila - 1][butaca - 1].toString();
		}
		return cadena;
	}
	
	/**
	 * Método que indica si una localidad está libre u ocupada
	 * @param fila la fila de la localidad
	 * @param butaca el número de butaca de la localidad
	 * @return una cadena informando del estado de la localidad
	 */
	public boolean estaLibre(int fila, int butaca) {
		if (this.localidades[fila -1][butaca -1] == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @return la recaudación total del teatro para la obra actual
	 */
	public double calcularRecaudacion() {
		double recaudacion = 0.0;
		for (int f = 0; f < this.localidades.length; f ++) {
			for (int b = 0; b < this.localidades[f].length; b++) {
				if (this.localidades[f][b] != null) {
					String rango = this.localidades[f][b].rangoEdad();
					double descuento = (int)this.descuentos.get(rango)/100.0;
					recaudacion += precio * (1 - descuento);
				}
			}
		}
		return recaudacion;
	}
	
	@Override
	protected void finalize() {
		for (int f = 0; f < this.localidades.length; f ++) {
			for (int b = 0; b < this.localidades[f].length; b++) {
				this.localidades[f][b] = null;
			}
		}
	}
	
}
