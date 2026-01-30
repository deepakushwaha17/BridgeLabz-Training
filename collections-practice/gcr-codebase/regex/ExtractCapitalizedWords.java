package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCapitalizedWords {

	public static void main(String[] args) {
		String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
		
		String regex = "([A-Z])[A-Za-z]{1,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
  
        System.out.println("All Capitalized Words are:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
	}
}