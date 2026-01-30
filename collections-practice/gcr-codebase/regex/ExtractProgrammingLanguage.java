package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractProgrammingLanguage {
	public static void main(String[] args) {
		String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
		
		String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
  
        System.out.println("Programming Language Names are : ");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
	}

}