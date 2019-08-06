package io.can.usergallery.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5021686160866912366L;

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
	}

}
