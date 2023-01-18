package com.peterss7.csv_helpers;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import com.opencsv.CSVWriter;

public class CsvBuilder {
	
	private List<String[]> csvData;
	private String filepath;
	
	public CsvBuilder(List<String[]> csvData, String filepath) {
		this.csvData = csvData;
		this.filepath = filepath;
	}
	
	public void buildCSV(String[] headerRecord, int[] nullableColumns) {
		
		// System.out.println("Hello from within the build csv method...");
		
    	try (
	        Writer writer = Files.newBufferedWriter(Paths.get(filepath));
    		
	        CSVWriter csvWriter = new CSVWriter(writer,
            CSVWriter.DEFAULT_SEPARATOR,
            CSVWriter.NO_QUOTE_CHARACTER,
            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
            CSVWriter.DEFAULT_LINE_END);
	    ) {    		
	        
    		// System.out.println("creating lines now... and filepath: " + filepath);
    		
	        csvWriter.writeNext(headerRecord);
	        
	        Random rand = new Random();
	        
	        for (int i = 0; i < csvData.size(); i++) {
	        	
	        	String csvLine[] = new String[csvData.get(0).length];
	        	int id = i;	        	
	        	
	        	for (int j = 0; j < csvLine.length; j++)
	        	{
	        		csvLine[j] = csvData.get(i)[j];

	        		boolean isNullableColumn = false;
	        		
	        		for (int k = 0; k < nullableColumns.length; k++) {
	        			if (j == nullableColumns[k]) isNullableColumn = true;
	        		}	        		
	        		
	        		if (isNullableColumn) {
	        			if (rand.nextInt(100) > 75) csvLine[j] = null;
	        		}
	        		
	        	}
	        	//// System.out.println("Writing lines to the csv file...");
	        	csvWriter.writeNext(csvLine);
	        }	        
	
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}
