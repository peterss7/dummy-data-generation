package contact_data_generation;

import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.peterss7.console.Console;
import com.peterss7.datageneration.data_resources.EmailComponent;
import com.peterss7.datageneration.data_resources.NameComponent;
import com.peterss7.datageneration.data_resources.VendorComponent;
import com.peterss7.datageneration.vendor_data.VendorNameGenerator;

public class EmailGenerator {
	
	public static String generateEmailByName(String firstName, String lastName) {
	
		Random rand = new Random();
		String emailAddress = "";
		
		char [] noSpacesLastName = lastName.toCharArray();
		String emailLastName = "";
		
		for (int j = 0; j < lastName.length(); j++) 
			if (noSpacesLastName[j] != ' ') emailLastName += noSpacesLastName[j];		
		
		
		if (rand.nextInt(100) > 80) emailAddress = firstName + "." + emailLastName;
		else emailAddress = firstName.charAt(0) + emailLastName;
		if (rand.nextInt(100) > 25) emailAddress += Integer.toString(rand.nextInt(100));		
		
		emailAddress += "@" + EmailComponent.EMAIL_HOSTS.getArray()[rand.nextInt(
			EmailComponent.EMAIL_HOSTS.getArray().length)] 
			+ EmailComponent.EMAIL_TLDS.getArray()[rand.nextInt(EmailComponent.EMAIL_TLDS.getArray().length)];
		
		return emailAddress;
	}
	
	public static String generateEmailByBusiness(String businessName) {
		
		Random rand = new Random();		
		String emailAddress;
		String firstNameComponent;
		String ownerThingComponent = "";
		String vendorNounComponent = "";
		String businessTypeComponent = "";
		
		firstNameComponent = NameComponent.FIRST_NAMES
				.getArray()[rand.nextInt(NameComponent.FIRST_NAMES.getArray().length)];
		
		String[] vendorNouns = VendorComponent.NOUNS.getArray();
		
		int count = 0;
		for (String element : vendorNouns) {
			// Console.println(element);
			if (businessName.toLowerCase().contains(element.toLowerCase())) {
				vendorNounComponent = vendorNouns[count];
				break;
			}
			count++;
		}
		
		char[] businessNameChars = businessName.toCharArray();	
		
		for (char element : businessNameChars) {
			if (element == '\'') break;			
			else ownerThingComponent += element;
		}
		
		String[] businessTypes = VendorNameGenerator.getVendorTypes();
		String unformattedBusinessTypeComponent = null;
		
		count = 0;
		for (String element : businessTypes) {
			if (businessName.contains(element)) {
				unformattedBusinessTypeComponent = element;
				break;
			}
			count++;
		}
		
		char[] unformattedBusinessTypeComponentChars = 
				unformattedBusinessTypeComponent.toCharArray();
		
		for (char element : unformattedBusinessTypeComponentChars) {
			if (!(element == ' ')) {
				businessTypeComponent += element;
			}
		}
		
		businessTypeComponent = businessTypeComponent.toLowerCase();
		
				
		
		
		if (rand.nextInt(100) > 50) emailAddress = firstNameComponent  + "." 
			+ ownerThingComponent + "@" + vendorNounComponent + businessTypeComponent;
		else emailAddress = businessTypeComponent 
			+ "@" + ownerThingComponent + vendorNounComponent;
		if (rand.nextInt(100) > 90) emailAddress += Integer.toString(rand.nextInt(100));		
		
		emailAddress += EmailComponent.EMAIL_TLDS.getArray()[rand.nextInt(EmailComponent.EMAIL_TLDS.getArray().length)];
		
		return emailAddress;
	}
}
