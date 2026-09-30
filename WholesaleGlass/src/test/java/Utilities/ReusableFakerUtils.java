package Utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class ReusableFakerUtils {
	
	public Faker faker;
	
	public ReusableFakerUtils() {
		faker = new Faker(Locale.UK);
	}
	
	public String randomName() {
		return faker.name().fullName();
	}
	
	public String randomFirstName() {
		return faker.name().firstName();
	}
	
	public String randomLastName() {
		return faker.name().lastName();
	}
	
	
	public String randomEmail() {
		return faker.internet().safeEmailAddress();
	}
	
	
	public String randomPhoneNumber() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String randomComment() {
		return faker.commerce().department();
	}
	
	public String randomPassword() {
	    return faker.internet().password(
	        8,      // minimum length
	        16,     // maximum length
	        true,   // include at least 1 uppercase letter
	        true,   // include at least 1 special character
	        true    // include at least 1 digit/number
	    );
	}
	
	public String randomAddress() {
		return faker.address().fullAddress();
	}
	
	public String randomCity() {
		return faker.address().cityName();
	}
	
	public String randomPostCode() {
		return faker.address().zipCode();
	}

	
	
}
