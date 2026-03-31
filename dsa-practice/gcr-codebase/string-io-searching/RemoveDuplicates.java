package dsaProblems;
import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
	
	public static void removeDuplicates(String text) {
		StringBuilder string = new StringBuilder();
		HashSet<String> set = new HashSet<>(); 
		
		for(int i = 0 ; i < text.length() ; i++) {
			char ch = text.charAt(i);
			if(!set.contains(Character.toString(ch))) {
				set.add(Character.toString(ch));
				string.append(ch);
			}
		}
		System.out.println("String without duplicate character is "+string.toString());
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the text : ");
		String text = input.next();
		
		removeDuplicates(text);
		input.close();

	}

}
