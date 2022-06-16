package exceptions;

public class TooManyItemsException extends Exception {
	public TooManyItemsException(int n) {
		super("Za duzo zamówionych przedmiotów ["+n+"]! Spróbuj zamowiæ mniej ni¿ 20.");
	}
}
