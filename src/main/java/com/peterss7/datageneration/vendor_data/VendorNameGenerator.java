package com.peterss7.datageneration.vendor_data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;
import org.fluttercode.datafactory.impl.DefaultContentDataValues;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.peterss7.console.Console;
import com.peterss7.csv_helpers.Filepaths;
import com.peterss7.datageneration.data_resources.NameComponent;
import com.peterss7.datageneration.data_resources.VendorComponent;

public class VendorNameGenerator {
	
	private static String vendorName;

	public VendorNameGenerator() {
				
	}
	
	public static String wordCapitalizer(String word) {
		
		char[] wordChars = word.toCharArray();
		int indexOfSpace = -1;
		String word1 = "";
		String word2 = "";
		
		for (int i = 0; i < wordChars.length; i++) {
			if ((wordChars[i] + "").equals(" ")) {
				indexOfSpace = i;
				break;
			}
		}
		
		if (indexOfSpace == -1) {
			word2 = "";
			word1  = cappedWord(word, wordChars);
		}
		else {		
			word1 = word.substring(indexOfSpace, indexOfSpace + 1);
			word2 = word.substring(indexOfSpace + 1, word.length());
			
			word1 = cappedWord(word1, wordChars);
			word2 = cappedWord(word2, wordChars);
		}
		
		return word1 + word2;
		
	}
	
	private static String cappedWord(String word, char[] wordChars) {
		
		String cappedWord = "";
		String firstLetterCapped = (wordChars[0] + "").toUpperCase();
		cappedWord = firstLetterCapped;
		
		for (int i = 1; i < word.length(); i++) 
			cappedWord = cappedWord + (wordChars[i] + "");
		
		return cappedWord;
		
		
	}
	
	public static String getVendorName() {
		
		DataFactory df = new DataFactory();		
		String[] vendorTypes = getVendorTypes();
		
		String noun = wordCapitalizer(VendorComponent.NOUNS.getArray()[df.getNumberBetween(0, VendorComponent.NOUNS.getArray().length)]);
		String verb = wordCapitalizer(VendorComponent.VERBS.getArray()[df.getNumberBetween(0, VendorComponent.VERBS.getArray().length)]);
		String owner= "";
		String vendorType = vendorTypes[(new Random()).nextInt(vendorTypes.length)];
		
		Random rand = new Random();
		
		if (rand.nextInt(100) > 50)
			owner =	NameComponent.FIRST_NAMES.getArray()[rand.nextInt(NameComponent.FIRST_NAMES.getArray().length)];
		else
			owner =	NameComponent.LAST_NAMES.getArray()[rand.nextInt(NameComponent.LAST_NAMES.getArray().length)];
			
		int nameTypeDeterminer = rand.nextInt(2);	
		
		if (nameTypeDeterminer == 0)
			vendorName = owner  + "'s " + noun + " " + verb + " and " 
				+ vendorType;
		else if (nameTypeDeterminer == 1)
			vendorName = owner  + "'s " + verb + " " + noun + " " 
				+ vendorType;
		else
			vendorName = "ERROR";
		
		return vendorName;	
	}
	
	public static String[] getVendorTypes() {
		
		FileReader fileReader = null;
		List<String[]> vendorTypes = new ArrayList<>();
		
		
		try {
			fileReader = new FileReader(Filepaths.VENDOR_TYPES_CSV.getFilepath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CSVReader csvReader = new CSVReader(fileReader);
		
		try {
			vendorTypes = csvReader.readAll();
		} catch (IOException | CsvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		vendorTypes.remove(0);
		
		String[] result = new String[vendorTypes.size()];
	
		int count = 0;
		for (String[] row : vendorTypes) {
			result[count] = row[0];
			count++;			
		}
		
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	

}
