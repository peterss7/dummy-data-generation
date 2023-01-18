package com.peterss7.csv_helpers;

public enum Filepaths {
	
	ZIP_CODE_MASTER(new String (
			"C:\\Users\\peter\\eclipse-workspace\\dummy-data-generation\\src\\main\\" + 
			"resources\\zip-code-resource.csv")),		
	USERS(new String ("C:\\Users\\peter\\eclipse-workspace\\dummy-data-generation\\" +
			"src\\main\\resources\\prs-database-users.csv")),
	VENDORS(new String ("C:\\Users\\peter\\eclipse-workspace\\dummy-data-generation\\" +
			"src\\main\\resources\\prs-database-vendors.csv")),
	STATE_DATA_CSV(new String ("C:\\Users\\peter\\eclipse-workspace\\dummy-data-generation\\" +
			"src\\main\\resources\\states.csv")),
	VENDOR_TYPES_CSV(new String("C:\\Users\\peter\\eclipse-workspace\\dummy-data-generation\\" +
			"src\\main\\resources\\business-types.csv"));

	private final String filepath;
	
	Filepaths(String filepath) {
		this.filepath = filepath;			
	}
	
	public String getFilepath() {
		return filepath;
	}

}
