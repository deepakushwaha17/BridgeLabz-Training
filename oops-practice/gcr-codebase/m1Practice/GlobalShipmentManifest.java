package m1Practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;

public class GlobalShipmentManifest {
	
	public static boolean isValidCode(String input) {
		String regex = "^SHIP-(?!.*(\\d)\\1{3})[1-9][0-9]{5}$";
		return input.matches(regex);
	}
	
	public static boolean isValidDate(String date) {
	    try {
	        DateTimeFormatter formatter = DateTimeFormatter
	                .ofPattern("uuuu-MM-dd")
	                .withResolverStyle(ResolverStyle.STRICT);

	        LocalDate d = LocalDate.parse(date, formatter);

	        return d.getYear() >= 2000 && d.getYear() <= 2099;

	    } catch (DateTimeParseException e) {
	        return false;
	    }
	}
 
	public static boolean isValidMode(String mode) {
		String regex = "AIR|SEA|ROAD|RAIL|EXPRESS|FREIGHT";
		return mode.matches(regex);
	}
	
	public static boolean isValidWeight(String weight) {
		if(!weight.matches("(0|[1-9]\\d{0,5})(\\.\\d{1,2})?")) {
			return false;
		}
		
		Double w = Double.parseDouble(weight);
		return w > 0 && w <= 999999.99 ;
	}
	
	public static boolean isValidStatus(String status) {
		String regex = "DELIVERED|CANCELLED|IN_TRANSIT";
		return status.matches(regex);
	}
	
	public static String processTemplate(String input) {
		String[] inputArr = input.split("\\|");
		String code = inputArr[0].trim();
		String date = inputArr[1].trim();
		String mode = inputArr[2].trim();
		String weight = inputArr[3].trim();
		String status = inputArr[4].trim();
		
		if(isValidCode(code) && isValidDate(date) && isValidMode(mode) && 
				isValidWeight(weight) && isValidStatus(status)) {
			return "COMPLIANT RECORD";
		}
		return "NON-COMPLIANT RECORD";
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no : ");
		int n = sc.nextInt();
		sc.nextLine();
		List<String> record = new ArrayList<>();
		
		for(int i = 0 ; i < n ; i++) {
			String input = sc.nextLine();
			record.add(input);
		}
		
		for(String r : record) {
			System.out.println(processTemplate(r));
		}
		 sc.close();
	}

}
