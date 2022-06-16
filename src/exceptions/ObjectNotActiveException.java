package exceptions;

public class ObjectNotActiveException extends Exception {
	public ObjectNotActiveException(int i) {
		super("Ekran nr."+i+" nie jest aktywny! Wybierz inny ekran.");
	}
}
