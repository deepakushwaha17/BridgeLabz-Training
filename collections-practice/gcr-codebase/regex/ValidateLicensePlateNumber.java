package regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicensePlateNumber {

	public static boolean validatePlateNumber(String plateNumber) {
		String regex = "^([A-Z]{2})\\d{4}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(plateNumber);
		
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the license plate number: ");
		String plateNumber = input.nextLine();

		if(validatePlateNumber(plateNumber)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
		input.close();
	}

}
