package contact_data_generation;

import java.util.Random;

import org.fluttercode.datafactory.impl.DataFactory;

import com.peterss7.datageneration.data_resources.PhoneNumberComponent;

public class PhoneNumberGenerator {
	
    public static String generatePhoneNumber() {
    	
    	Random rand = new Random();
    	DataFactory df = new DataFactory();
    	
		String phoneNumber = PhoneNumberComponent.AREA_CODES.getArray()[rand.nextInt(50)] + "-" + df.getNumberText(3) +
				"-" + df.getNumberText(4);
		
		return phoneNumber;		
    }
    
    public static String generatePhoneNumberByStateId(int id) {
    	
    	Random rand = new Random();
    	DataFactory df = new DataFactory();
    	
		String phoneNumber = PhoneNumberComponent.AREA_CODES.getArray()[id] + "-" + df.getNumberText(3) +
				"-" + df.getNumberText(4);
		
		return phoneNumber;		
    }

}
