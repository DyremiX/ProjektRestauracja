package exceptions;

public class TooManyItemsException extends Exception {
	public TooManyItemsException(int n) {
		super("Za duzo zam�wionych przedmiot�w ["+n+"]! Spr�buj zamowi� mniej ni� 20.");
	}
}