package com.peterss7.datageneration.data_resources;

public enum EmailComponent {
	
	EMAIL_HOSTS(new String[] { "gmail", "hotmail", "yahoo",
		"somemail", "everymail", "mailbox", "bizmail", "mail2u"}),	
	
	EMAIL_TLDS(new String[] { ".org", ".net", ".com", ".biz", ".us", ".co.uk"});

	private final String[] array;
	
	EmailComponent(String[] array) {
		this.array = array;			
	}
	
	public String[] getArray() {
		return array;
	}
}
