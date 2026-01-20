package ExamProctor;

import java.util.HashMap;
import java.util.Stack;

public class OnlineExamReview {
	
	static Stack<String> questions = new Stack<>();
	static HashMap<Integer,String> correctAnswers = new HashMap<>();
	
	// Add questions to stack
	public static void addQuestions() {
		questions.push("Is java object-oriented?");
		questions.push("Is String muttable?");
		questions.push("Can we overload main method?");
		questions.push("Can static method is overridden?");
		questions.push("Can we perform operator overloading in java?");
		questions.push("Is StringBuilder faster than StringBuffer?");
	}
	
	// Set correct answers
	public static void setCorrectAnswers() {
		correctAnswers.put(0, "YES");
		correctAnswers.put(1, "NO");
		correctAnswers.put(2, "YES");
		correctAnswers.put(3, "NO");
		correctAnswers.put(4, "YES");		
	}
	
	// Get next question safely
    public static String getNextQuestion() {
        return questions.pop();
    }
    
    // Calculate score
	public static int calculateScore() {
		int score = 0;

        for (int i = correctAnswers.size() - 1; i >= 0; i--) {
            String correct = correctAnswers.get(i);
            String user = TakeOnlineExam.getUserAnswers().get(i);

            if (correct != null && correct.equalsIgnoreCase(user)) {
                score++;
            }
        }
        return score;
	}
}