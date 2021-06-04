package fit;
@SuppressWarnings("serial")
public class FitException extends Exception {
    public FitException() {
        super("No description");
    }
	public FitException(String reason) {
		super(reason);
	}
}
