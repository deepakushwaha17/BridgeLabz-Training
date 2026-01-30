package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWebPagesLink {
	public static void main(String[] args) {
		String text = "Visit https://www.google.com and http://example.org for more info.";
		
		String regex = "https?://(www\\.)?([a-zA-Z0-9.-]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
  
        System.out.println("All Links in text are:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
	}
}
