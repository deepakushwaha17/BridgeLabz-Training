package ExamProctor;

import java.util.HashMap;

public class TakeOnlineExam {

	private static HashMap<Integer, String> userAnswers = new HashMap<>();

    // Method to store user answers
    public static void addUserAnswers(int quesID, String answer) {
        userAnswers.put(quesID, answer);
    }
    
    // Method to get user answers
    public static HashMap<Integer, String> getUserAnswers() {
        return userAnswers;
    }
}