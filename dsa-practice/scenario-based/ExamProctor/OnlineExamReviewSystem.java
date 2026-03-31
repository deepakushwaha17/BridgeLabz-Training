package ExamProctor;

import java.util.Scanner;
public class OnlineExamReviewSystem {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);
        
        // Add questions into stack
        OnlineExamReview.addQuestions();
        // Add correct answers into hash map  
        OnlineExamReview.setCorrectAnswers();
        
        for (int i = 4; i >= 0; i--) {
        	// Show question to user
            System.out.println(OnlineExamReview.getNextQuestion());
            System.out.print("Enter your answer (Yes/No): ");
            // Take user answer
            String answer = input.next().toLowerCase();
            // Add user answer into hash map
            TakeOnlineExam.addUserAnswers(i, answer);
            System.out.println();
        }

        // Calculate score into score variable
        int score = OnlineExamReview.calculateScore();
        System.out.println("Your Score: " + score);

        input.close();
	}

}
