/*Online Quiz Platform – Result Processor
Scenario: A quiz platform processes user answers and compares them to correct answers.
Problem Requirements:
● Use String[] for correct answers and user answers.
● Use methods to compare answers, calculate scores, and return grade.
● Store scores of multiple users in a List<Integer>.
● Validate input (length mismatch) and throw an    InvalidQuizSubmissionException.*/

package classandobject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineQuizPlatform {
	
	// Fixed questions and their correct answers
    static String[] questions = { "Q1: What is 2 + 2?","Q2: What is square of 9?",
            "Q3: What is 5 * 6?", "Q4: What is 144/12?", "Q5: What is the square root of 81?"};

    static String[] correctAnswers = {"4", "81","30","12", "9"};


    //calculate score by comparing answers
    static int calculateScore(String[] correctAnswers, String[] userAnswers) throws InvalidQuizSubmissionException {
        if (correctAnswers.length != userAnswers.length) {
            throw new InvalidQuizSubmissionException("Number of user answers does not match number of questions.");
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i].trim())) {
                score++;
            }
        }
        return score;
    }

    //return grade
    static String getGrade(int score, int totalQuestions) {
        double percent = (score * 100.0) / totalQuestions;
        if (percent >= 90) {
        	return "A+";
        }else if (percent >= 80) {
        	return "A";
        }else if (percent >= 70) {
        	return "B";
        }else if (percent >= 60) {
        	return "C";
        }else {
        	return "F";
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        List<Integer> allUserScores = new ArrayList<>();

        System.out.print("Enter number of users: ");
        int numUsers = input.nextInt();
        input.nextLine(); // consume newline

        for (int u = 1; u <= numUsers; u++) {
            System.out.println("\n----User " + u + " Quiz----");
            System.out.println("Questions:");
            for (String q : questions) {
                System.out.println(q);
            }

            System.out.print("Enter all answers separated by commas: ");
            String userinput = input.nextLine();
            String[] userAnswers = userinput.split(",");

            try {
                int score = calculateScore(correctAnswers, userAnswers);
                allUserScores.add(score);
                String grade = getGrade(score, correctAnswers.length);
                System.out.println("Score: " + score + "/" + correctAnswers.length + ", Grade: " + grade);
            } catch (InvalidQuizSubmissionException e) {
                System.out.println("Error for User " + u + ": " + e.getMessage());
            }
        }

        //print all user scores
        System.out.println("\nAll User Scores: " + allUserScores);

        input.close();
    }
}

//custom exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}
