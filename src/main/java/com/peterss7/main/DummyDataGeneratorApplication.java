package com.peterss7.main;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVWriter;
import com.peterss7.console.Console;
import com.peterss7.csv_helpers.CsvBuilder;
import com.peterss7.csv_helpers.Filepaths;
import com.peterss7.datageneration.table_data_generators.UsersDataGenerator;
import com.peterss7.datageneration.table_data_generators.VendorsDataGenerator;

public class DummyDataGeneratorApplication {
	
	private static final String[] USERS_HEADER = {"ID", "Username", "Password", "FirstName",
			"LastName", "PhoneNumber", "Email","IsReviewer", "IsAdmin", "BufferString"};
	private static final int[] USER_NULLABLE_COLUMNS = {5,6};
	
	private static final String[] VENDORS_HEADER = {"Id", "Code", "Name", "Address", "City",
					"State", "Zip", "Phone","Email"};
	
	private static final int[] VENDOR_NULLABLE_COLUMNS = {7, 8};

	public static void main(String[] args) {		
		
    	new CsvBuilder(UsersDataGenerator.generateUserData(USERS_HEADER), Filepaths.USERS.getFilepath())
    		.buildCSV(USERS_HEADER, USER_NULLABLE_COLUMNS);    	
    	
    	new CsvBuilder(VendorsDataGenerator.generateVendorData(VENDORS_HEADER), Filepaths.VENDORS.getFilepath())
			.buildCSV(VENDORS_HEADER, VENDOR_NULLABLE_COLUMNS);
    	
    	Console.println("END");
    	
    	
    	
    	
    	
	}
}
