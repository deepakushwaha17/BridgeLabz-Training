package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCard {
	public static void main(String[] args) {
		String[] cardNumber = {"4567898765432134","5567898765432134","956782134","5567898765432134"};
		
		String regex = "^(4\\d{15}|5\\d{15})$";
        Pattern pattern = Pattern.compile(regex); 
  
        for(String num : cardNumber ) {
        	Matcher matcher = pattern.matcher(num);
        	System.out.println(num + " is valid : " +matcher.matches());
        }
	}

}
