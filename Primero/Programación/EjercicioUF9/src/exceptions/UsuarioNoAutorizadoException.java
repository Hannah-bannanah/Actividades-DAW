package exceptions;

public class UsuarioNoAutorizadoException extends RuntimeException{
	
	public UsuarioNoAutorizadoException() {
		super("Usuario no autorizado");
	}
	
}
