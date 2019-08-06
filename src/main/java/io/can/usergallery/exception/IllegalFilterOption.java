package io.can.usergallery.exception;

public class IllegalFilterOption extends RuntimeException {

	private static final long serialVersionUID = 4373702622863190901L;

	public IllegalFilterOption(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalFilterOption(String message) {
		super(message);
	}

	public IllegalFilterOption(Throwable cause) {
		super(cause);
	}
	
}
