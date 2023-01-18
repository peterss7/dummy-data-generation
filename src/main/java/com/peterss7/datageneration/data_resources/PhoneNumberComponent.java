package com.peterss7.datageneration.data_resources;

public enum PhoneNumberComponent {
	
	AREA_CODES(new String[] {"205", "907", "480", "479", "209", "303", 
			"203", "302", "239", "229", "808", "208", "217", "219", "319",
		"316", "859", "225", "207", "240", "339", "231", "218", "228", "314",
		"406", "308", "702", "603", "201", "505", "212", "252", "701", "513",
		"405", "458", "215", "401", "803", "605", "423", "210","385", "802",
		"276", "206", "304", "262", "307"});

	private final String[] array;
	
	PhoneNumberComponent(String[] array) {
		this.array = array;			
	}
	
	public String[] getArray() {
		return array;
	}
}
