package regex;

public class ReplaceMultipleSpaces {
	public static void main(String[] args) {
		
		String text = "This  is an example  with multiple  spaces.";	
		String regex = "\\s+";
  
		System.out.println("Original text: " + text);
        System.out.print("Replaced text: ");
        System.out.println(text.replaceAll(regex, " "));
	}
}
