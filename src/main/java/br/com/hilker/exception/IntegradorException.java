package br.com.hilker.exception;

public class IntegradorException extends Exception {

	private static final long serialVersionUID = 1L;

	public IntegradorException() {
		super();
	}
	
	public IntegradorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public IntegradorException(String message) {
		super(message);
	}
	
	public IntegradorException(Throwable cause) {
		super(cause);
	}
}
