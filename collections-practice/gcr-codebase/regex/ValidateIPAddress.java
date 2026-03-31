package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress {

	public static void main(String[] args) {
		String[] ipAddress = {"255.35.78.0","344.98.67.8","123.44.57.97"};
		
		String regex = "^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\.){3}"
				+ "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";
        Pattern pattern = Pattern.compile(regex); 
  
        for(String ip : ipAddress ) {
        	Matcher matcher = pattern.matcher(ip);
        	System.out.println(ip + " is valid : " +matcher.matches());
        }
	}
}
