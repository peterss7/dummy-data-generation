package com.peterss7.datageneration.data_resources;

public enum PasswordComponent {
	
	SPECIAL_CHARACTERS(new char [] {'!', '@', '#', '$', '%', '^', '*', '(', ')'});

	private final char[] array;
	
	PasswordComponent(char[] array) {
		this.array = array;			
	}
	
	public char[] getArray() {
		return array;
	}
}
