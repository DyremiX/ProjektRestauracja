package exceptions;

public class NoActiveObjectsException extends Exception {
	public NoActiveObjectsException(String typ) {
		super("¯aden z obiektów typu "+typ+" nie jest aktywny.");
	}
}
