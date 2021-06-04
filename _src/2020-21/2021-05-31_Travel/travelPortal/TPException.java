package travelPortal;

@SuppressWarnings("serial")
public class TPException extends Exception {

	public TPException(String message) {
		super(message);
	}
	
	public TPException() {
		super("Don't Panik");
	}
}
