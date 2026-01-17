package dsaProblems;
import java.util.Scanner;

public class LinearSearchSentence {
	
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of sentences : ");
        int n = input.nextInt();
        input.nextLine(); 

        String[] sentences = new String[n];
        System.out.println("Enter the sentences :");
        for (int i = 0; i < n; i++) {
            sentences[i] = input.nextLine();
        }

        System.out.print("Enter the word to search : ");
        String wordToSearch = input.nextLine();

        String result = findSentence(sentences, wordToSearch);
        System.out.println("Search Result : " + result);

        input.close();
    }
}
