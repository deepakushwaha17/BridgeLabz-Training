package classandobject;

public class PalindromeCheckerMain {

	public static void main(String[] args) {
		PalindromeChecker pChecker1 = new PalindromeChecker("A man a plan a canal panama");
		pChecker1.display();
		PalindromeChecker pChecker2 = new PalindromeChecker("Hello");
		pChecker2.display();


	}

}

class PalindromeChecker{
	private String text;
	public PalindromeChecker(String text) {
		this.text = text;
	}
	public boolean checkPalindrome() {
		boolean isPalindrome = true;
		text = text.toLowerCase();
		int start = 0 , end =text.length()-1;
		while(start<end) {
			if(!Character.isLetterOrDigit(text.charAt(start))) {
				start++;
			}
			else if(!Character.isLetterOrDigit(text.charAt(end))) {
				end--;
			}
			else {
				if(text.charAt(start) != text.charAt(end)) {
					isPalindrome = false;
					break;
				}
				start++;
				end--;
			}
			
		}
		return isPalindrome;
		
	}
	
	public void display() {
		if(checkPalindrome()) {
			System.out.println(text + " is Palindrome.");
		}else {
			System.out.println(text + " is not Palindrome.");
		}
	}
}
