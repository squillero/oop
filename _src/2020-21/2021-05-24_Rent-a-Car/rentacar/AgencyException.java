package rentacar;

public class AgencyException extends Exception {
	private static final long serialVersionUID = 1L;

	AgencyException() {
		super("Unknown problem");
	}
	
	AgencyException(String explanation) {
		super(explanation);
	}
}
