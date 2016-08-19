package ua.nure.soklakov.SummaryTask4;

public class LoginDuplicateException extends Exception {

	private static final long serialVersionUID = -6003145638521255299L;

	public LoginDuplicateException() {

	}

	public LoginDuplicateException(String message) {
		super(message);
	}

	public LoginDuplicateException(Throwable cause) {
		super(cause);
	}

	public LoginDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}
}
