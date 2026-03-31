package scenario;
import java.util.*;

public class LexicalTwist {
	
	// Requirement 1 : Check if the second word is a reversed version of the first word
	public static boolean isReversedVersion(String firstWord, String secondWord) {
		if(firstWord.length() != secondWord.length()) {
			return false;
		}
		// reverse the second word and store in secondWord
		StringBuilder str = new StringBuilder(secondWord);
		str.reverse();
		secondWord = str.toString();
		
		if(firstWord.equalsIgnoreCase(secondWord)) {
			return true;
		}
		return false;
	}
	
	/* Requirement 2 : If the second word is a reversed version of the first word,
	 * then Replace all vowels with '@ */
	public static void reverseAllVowels(String firstWord, String secondWord) {
		// reverse the first word and store in firstWord
		StringBuilder str = new StringBuilder(firstWord);
		str.reverse();
		firstWord = str.toString().toLowerCase();
		
		//replace all vowels with @
		String transformedWord = firstWord.replaceAll("[aeiou]", "@");
		System.out.println("Transformed word after replacing all vowels: "+transformedWord);
		
	}

	/* Requirement 3 : If the second word is not a reversed version of the first word,
	 * then combine first and second word and Count the number of vowels and consonants */
	
	// Method to count vowels and consonants
	public static String[] countVowelsConsonants(String combinedWord) {
		String vowels = "";
		String consonants = "";
		for(int i = 0; i < combinedWord.length(); i++) {
			char ch = combinedWord.charAt(i);
			if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				vowels += ch;
			}else {
				consonants += ch;
			}
		}
		return new String[]{vowels,consonants};
		
	}
	
	// Method to remove duplicates
	public static char removeDuplicates(String word) {
		for(int i = 1 ; i < word.length(); i++) {
			char ch = word.charAt(i);
			if(ch != word.charAt(i-1)) {
				return ch;
			}
		}
		return ' ';
	}
	
	public static void printVowelConsonants(String firstWord, String secondWord) {
		//combined first and second word and converted to uppercase
		String combinedWord = firstWord.concat(secondWord).toUpperCase();
		
		String[] countArray = countVowelsConsonants(combinedWord);
		int vowelsCount = countArray[0].length(); // get total number of vowels 
		int consonantsCount = countArray[1].length(); // get total number of consonants 
		
		if(vowelsCount > consonantsCount) {
			System.out.println("First 2 vowels: " + countArray[0].charAt(0) + "" + removeDuplicates(countArray[0]));
		}
		else if(vowelsCount < consonantsCount) {
			System.out.println("First 2 consonants: " + countArray[1].charAt(0) + "" + removeDuplicates(countArray[1]));
		}else {
			System.out.println("Vowels and consonants are equal.");
		}
	}
		
	public static void main(String[] args) {
		try{
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the first word: ");
			String firstWord = input.next();
			String leftover1 = input.nextLine().trim();
			
			// Validate If the input words contain more than one word, it throw an exception
			if(!leftover1.isEmpty()) {
				input.close();
				throw new Exception(firstWord +" "+ leftover1 + " is an invalid word.");
				 
			}
			
			System.out.print("Enter the second word: ");
			String secondWord = input.next();
			String leftover2 = input.nextLine().trim();	
			
			// Validate If the input words contain more than one word, it throw an exception
			if(!leftover2.isEmpty()) {
				input.close();
				throw new Exception(secondWord +" "+ leftover2 + " is an invalid word.");
			}

			if(isReversedVersion(firstWord, secondWord)) {
				System.out.println("Second word is a reversed version of the First word");
				reverseAllVowels(firstWord, secondWord);
				
			}else {
				System.out.println("Second word is not a reversed version of the First word");
				printVowelConsonants(firstWord, secondWord);
			}
			
			input.close();

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}