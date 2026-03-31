package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRepeatingWords {

	public static void main(String[] args) {
		 String text = "This is is a repeated repeated word test.";

		 String regex = "\\b(\\w+)\\s+\\1\\b";

		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(text);

		 System.out.println("Repeating words in text are:");
	     while (matcher.find()) {
	    	 System.out.println(matcher.group(1));
	     }
	}
}
