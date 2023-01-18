package com.peterss7.datageneration.monument_to_my_sillyness;

/*
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
*/

public class PrimaryKeyAdder {

	/*
	private String filepath;

	public PrimaryKeyAdder(String filepath) {		
		this.filepath = filepath;
		try {
			addKey();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addKey() throws IOException {
		

		
		List<String[]> csvData = null;
		CSVReader reader = null;
		
		String filepathAVar = filepath.substring(filepath.length() - 6, filepath.length() - 5);
		String filepathBVar = filepath.substring(filepath.length() - 5, filepath.length() - 4); 
		

		
		//Read the CSV file 
		if (filepathAVar.equals("b") &&
				filepathBVar.compareTo("r") < 0) {	
			try {	
				reader = new CSVReader(new FileReader(filepath));
				reader.toString();			
				csvData = reader.readAll();
				
			} catch (IOException | CsvException e ) {
				e.printStackTrace();
			}
			reader.close();
	
			// Add primary key to the CSV data 
			int primaryKey = 1;
			for(String[] row : csvData) {
			    String[] newRow = new String[row.length + 1];
			    newRow[0] = Integer.toString(primaryKey);
			    for (int i = 0; i < row.length; i++) {
			        newRow[i + 1] = row[i];
			    }
			    primaryKey++;
			}
	
			//Write the updated CSV file
			CSVWriter writer = new CSVWriter(new FileWriter(filepath));
			writer.writeAll(csvData);
			writer.close();
		}
		else System.out.println("");
	}
	
	
	*/
}
