package exceptions;

public class NoActiveObjectsException extends Exception {
	public NoActiveObjectsException(String typ) {
		super("�aden z obiekt�w typu "+typ+" nie jest aktywny.");
	}
}
