package com.peterss7.datageneration.data_resources;

public enum StateComponent {
	
	STATE_FULL_NAME (new String[] { "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois",
			"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan",
			"Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
			"New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia",
			"Washington", "West Virginia", "Wisconsin", "Wyoming" });
	
	public String[] array;
	
	StateComponent(String[] array) {
		this.array = array;
	}
	
	public String[] getArray() {
		return array;
	}
			
}
