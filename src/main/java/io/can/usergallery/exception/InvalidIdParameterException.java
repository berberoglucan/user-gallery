package io.can.usergallery.exception;

public class InvalidIdParameterException extends RuntimeException {

	private static final long serialVersionUID = 7003659989671218644L;

	public InvalidIdParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidIdParameterException(String message) {
		super(message);
	}

	public InvalidIdParameterException(Throwable cause) {
		super(cause);
	}

}
