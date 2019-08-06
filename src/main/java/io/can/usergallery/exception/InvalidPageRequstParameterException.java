package io.can.usergallery.exception;

public class InvalidPageRequstParameterException extends RuntimeException {

	private static final long serialVersionUID = -519502760508015545L;

	public InvalidPageRequstParameterException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidPageRequstParameterException(String message) {
		super(message);
	}

	public InvalidPageRequstParameterException(Throwable cause) {
		super(cause);
	}

}
