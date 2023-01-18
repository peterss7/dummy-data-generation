package com.peterss7.datageneration.table_data_generators;

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
import com.peterss7.datageneration.data_resources.EmailComponent;
import com.peterss7.datageneration.data_resources.NameComponent;
import com.peterss7.datageneration.data_resources.PasswordComponent;
import com.peterss7.datageneration.data_resources.PhoneNumberComponent;

import contact_data_generation.EmailGenerator;
import contact_data_generation.PhoneNumberGenerator;

//import static org.junit.Assert.assertTrue;


public class UsersDataGenerator
{
	
	private static DataFactory df = new DataFactory();
	private final static int NUMBER_OF_USERS = 2500;
	
	private static String firstName;
	private static String lastName;
	private static String emailAddress;
	private static String phoneNumber;
	private static String username;
	private static String id;

	private static String password = "";    	
	private static final String BUFFER_STRING = "";
	private static int isReviewer, isAdmin;
	
    public static ArrayList<String[]> generateUserData(String[] usersHeader) {   
    	
    	ArrayList<String[]> dataLines = new ArrayList<>();    	
    	Random rand = new Random();
    	
    	for (int i = 0; i < NUMBER_OF_USERS; i ++)	{
    		
    		generateFirstName();
        	generateLastName();
        	generateEmail();
        	generatePhoneNumber();
        	generateUsername(dataLines);
    		generateIsReviewer(rand.nextInt(2));
    		generateIsAdmin(rand.nextInt(2));
    		generatePassword();
    		id = i + "";
    		   		
    		dataLines.add(new String[] {id, username, password, firstName, lastName, phoneNumber, emailAddress, 
    			String.valueOf(isReviewer), String.valueOf(isAdmin), BUFFER_STRING});
    		
    		password = "";
    	}
    	
    	return dataLines;
    }
    
    private static void generateId(){
    	
    }
    
    private static void generateFirstName() {
		firstName = df.getItem(NameComponent.FIRST_NAMES.getArray(), 99, "Benjamin");    	
    }    
    
    private static void generateLastName() {   	
		lastName = df.getItem(NameComponent.LAST_NAMES.getArray(), 99, "King");   	
    }
    
    private static void generateEmail() {
    	emailAddress = EmailGenerator.generateEmailByName(firstName, lastName);
    }
    
    public static void generatePhoneNumber() {
    	phoneNumber = PhoneNumberGenerator.generatePhoneNumber();
    }
   
    public static String generateUsername(ArrayList<String []> dataLines) {
    	
    	Random rand = new Random();
    	
    	int numNum = rand.nextInt(3) + 1;
    	boolean isCheckingForDuplicate = true;
    	
    	username = firstName.substring(0,1) + lastName + df.getNumberText(numNum);
    	
    	while (isCheckingForDuplicate && dataLines.size() > 0) {    
	    	for (int i = 0; i < dataLines.size(); i++) {
	    		if (username.equals(dataLines.get(i)[1])) {
	    			isCheckingForDuplicate = true;	    			
	    			numNum = rand.nextInt(3) + 1;	    			
		    		username = firstName.substring(0,1) + lastName + df.getNumberText(numNum);	    			
	    			i = dataLines.size();
	    		}
	    		else if (!(username.equals(dataLines.get(i)[1])))
	    			isCheckingForDuplicate = false;
	    		else
	    			Console.println("ERROR DUPLICATE? USERNAME");
	    	}
    	}    	
    	// Console.println("NO DUPLICATE " + username);
    	return username;
    }
    
    public static void generatePassword() {    	
    	
    	Random rand = new Random();
		char [] tempPassword = df.getRandomText(5,9).toCharArray();
		int tempUppercaseIndex = rand.nextInt(tempPassword.length);
		int specialCharIndex = rand.nextInt(tempPassword.length);
		char specialChar = PasswordComponent.SPECIAL_CHARACTERS.getArray()
				[rand.nextInt(PasswordComponent.SPECIAL_CHARACTERS.getArray().length)];
		String uppercaseChar = Character.toString(tempPassword[tempUppercaseIndex]).toUpperCase();
		
		for (int j = 0; j < tempPassword.length; j++)
		{
			if (j == tempUppercaseIndex) password += uppercaseChar;
			else password += Character.toString(tempPassword[j]);
			
			if (j == specialCharIndex) password += Character.toString(specialChar);
		}
		
		password += df.getNumberText(2);
    }
    
    public static void generateIsReviewer(int randBit) {
    	isReviewer = randBit;
    }
    
    public static void generateIsAdmin(int randBit) {
    	isAdmin = randBit;
    }
    
}
