package regex;

import java.util.regex.*;

public class ExtractEmailAddresses {

	public static void main(String[] args) {
		String text = "Contact us at support@example.com and info@company.org";
		
		String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
  
        System.out.println("Email are : ");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
	}
}