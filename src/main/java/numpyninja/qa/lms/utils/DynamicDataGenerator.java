package numpyninja.qa.lms.utils;

import java.util.Random;

public class DynamicDataGenerator {

	// Dynamically generate alphabetic, aplha-numeric and numeric only values

	public static int randomTwoDigitGenerator() {
		Random random = new Random();
		return random.nextInt(90) + 10;
	}

	public static String getRandomEmailId() {
		return "lms_team13" + System.currentTimeMillis() + "@gmail.com";
	}

	public static int generateRandomNumber(int maxLimit) {
		int randomNum = new Random().nextInt(maxLimit) + 1;
		return randomNum;

	}

}
