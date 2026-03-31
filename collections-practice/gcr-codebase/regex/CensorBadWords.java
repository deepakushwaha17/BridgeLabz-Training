package regex;

public class CensorBadWords {
public static void main(String[] args) {
		
		String text = "This is a damn bad example with some stupid words.";	
		String[] badWords = {"damn","stupid","foolish"};
		
		String regex = "(?i)\\b+(" + String.join("|", badWords)+")\\b";
  
		System.out.println("Original text: \n" + text);
        System.out.print("Text without bad words: \n");
        System.out.println(text.replaceAll(regex, "****"));
	}
}
