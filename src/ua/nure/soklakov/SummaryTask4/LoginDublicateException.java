package ua.nure.soklakov.SummaryTask4;

public class LoginDublicateException extends Exception {

	private static final long serialVersionUID = -6003145638521255299L;

	public LoginDublicateException() {

	}

	public LoginDublicateException(String message) {
		super(message);
	}

	public LoginDublicateException(Throwable cause) {
		super(cause);
	}

	public LoginDublicateException(String message, Throwable cause) {
		super(message, cause);
	}
}
