package exceptions;
import com.itt.maquinaexpendedora.Bebida;

public class bebidaAgotadaException extends Exception {
	private Bebida bebida;
	
	public bebidaAgotadaException(Bebida bebida) {
		super("Bebida agotada");
		this.bebida = bebida;
	}
	
	public Bebida getBebida() {
		return this.bebida;
	}
}
