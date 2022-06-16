package exceptions;

public class IDDoesNotExistException extends Exception {
	public IDDoesNotExistException(int id) {
		super("Podane ID ["+id+"] nie isnieje!");
	}
}
