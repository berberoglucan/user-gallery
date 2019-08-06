package io.can.usergallery.enums;

public enum EmailFilterPattern {
	
	// Extension example given 'com' -> can.berberoglu@gmail.?
	// Last example example given 'lu' -> can.berberog?@gmail.com
	
	EXTENSION("%@%.?"), LAST("%?@%");
	
	private String pattern;

	private EmailFilterPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
	
}
