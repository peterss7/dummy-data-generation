package com.peterss7.datageneration.table_data_generators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.opencsv.CSVWriter;
import com.peterss7.console.Console;
import com.peterss7.datageneration.address_data.AddressGenerator;
import com.peterss7.datageneration.vendor_data.VendorCodeGenerator;
import com.peterss7.datageneration.vendor_data.VendorNameGenerator;

import contact_data_generation.EmailGenerator;
import contact_data_generation.PhoneNumberGenerator;

public class VendorsDataGenerator {
	
	private final static int NUMBER_OF_VENDORS = 500;
	public static String id;
	private static String code;
	private static String name;
	private static String state;
	private static String address;
	private static String city;
	private static String zip;
	private static String phoneNumber;
	private static String emailAddress;
    
    public static List<String[]> generateVendorData(String[] headers) {    	
    	    	
    	List<String[]>  vendorData = new ArrayList<>();
    	
    	for (int i = 0; i < NUMBER_OF_VENDORS; i++)	{
	    	
    		AddressGenerator addressGenerator = new AddressGenerator();
    		
    		Random rand = new Random();
    		int stateRand = rand.nextInt(50);   		
    		
    		addressGenerator.setStateIndex(stateRand);
    		
	    	setId(i);
    		setCode();
	    	setName();
	    	setAddress(addressGenerator);
	    	setCity(addressGenerator);
	    	setState(addressGenerator);
	    	setZip(addressGenerator);    	
	    	setPhoneNumber(addressGenerator);
	    	setEmailAddress();
	    	
	    	vendorData.add(new String[] {id, code, name, address, city, state,
	    			zip, phoneNumber, emailAddress});
	    	
	    	if (city != null)
	    		Console.println(vendorData.get(i));
	    	
	    	addressGenerator = null;
    	}
    
    	
    	return vendorData;   	
    	
    }
	
	public static String getPhoneNumber() {
		return phoneNumber;
	}

	public static void setPhoneNumber(AddressGenerator addressGenerator) {
		phoneNumber = PhoneNumberGenerator.generatePhoneNumberByStateId(addressGenerator.getStateId());
	}

	public static String getEmailAddress() {
		return emailAddress;
	}
	
	public static void setEmailAddress() {
		emailAddress = EmailGenerator.generateEmailByBusiness(name);  
	}
	
	public static void setId(int i) {
		id = i + "";
	}

	public static String getCode() {
		return code;
	}

	public static void setCode() {
		code = VendorCodeGenerator.generateVendorCode();
	}

	public static String getName() {
		return name;
	}
	
	public static void setName() {
		name = VendorNameGenerator.getVendorName();
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(AddressGenerator addressGenerator) {
		address = addressGenerator.getAddress();
	}

	public static String getCity() {
		return city;
	}

	public static void setCity(AddressGenerator addressGenerator) {
		city = addressGenerator.getCity();
	}

	public static String getState() {
		return state;
	}

	public static void setState(AddressGenerator addressGenerator) {
		state = addressGenerator.getState();
	}

	public static String getZip() {
		return zip;
	}

	public static void setZip(AddressGenerator addressGenerator) {
		zip = addressGenerator.getZip();
	}



    

   

}
