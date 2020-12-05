package modelo;

public class JuegoPerdidoException extends Exception {

	public JuegoPerdidoException() {
		super("Juego perdido. Puedes reiniciar el juego");
	}

}
