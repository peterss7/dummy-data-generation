package com.peterss7.datageneration.vendor_data;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.opencsv.CSVWriter;

//import static org.junit.Assert.assertTrue;


public class VendorCodeGenerator
{	
    public static String generateVendorCode() {
    	
    	DataFactory df = new DataFactory();    	   	
    	
    	String partOne = null;
    	String partTwo = null;
    	String partThree = null;
    	String vendorCode = null;
    	
    	int charStringLength = df.getNumberBetween(3, 6);
    	int numberRangeIndex1 = df.getNumberBetween(1, 4);
    	int numberRangeIndex2 = df.getNumberBetween(1, 3);
    	int randomOrderDetermination = df.getNumberBetween(1, 3);
		
    	switch (numberRangeIndex1){
    		case 1: 
    			partOne = df.getNumberBetween(100, 999) + "";
    			break;
    		case 2:
    			partOne = df.getNumberBetween(1001, 9999) + "";
    			break;
    		case 3:
    			partOne = df.getNumberBetween(10001, 99999) + "";
    			break;
    		case 4:	
    			partOne = df.getNumberBetween(100000, 999999) + "";
    			break;
    	}
    	    		
		partTwo = df.getRandomChars(charStringLength);
		
    	switch (numberRangeIndex2){
			case 1: 
				partThree = df.getNumberBetween(100, 999) + "";
				break;
			case 2:
				partThree = df.getNumberBetween(1001, 9999) + "";
				break;
			case 3:
				partThree = df.getNumberBetween(10001, 99999) + "";
				break;			
    	}
    	
    	switch (randomOrderDetermination){
			case 1: 
				vendorCode = partOne + "-" + partTwo + "-" + partThree;
				break;
			case 2:
				vendorCode = partTwo + "-" + partThree + "-" + partOne;
				break;
			case 3:
				vendorCode = partThree + "-" + partOne + "-" + partTwo;
				break;			
    	}
		
		if (vendorCode.equals(null)) {
			vendorCode = "12345";
		}
		
    	return vendorCode;
    }
}
