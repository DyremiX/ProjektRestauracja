package exceptions;

public class WrongNumberException extends Exception {
	public WrongNumberException(int n) {
		super(n+" to nieprawid�owy numer!");
	}
}
