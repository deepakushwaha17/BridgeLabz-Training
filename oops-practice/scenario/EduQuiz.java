/*EduQuiz – Student Quiz Grader"
Story: You’re building the grading module for a quiz app. A student answers a 10-question quiz.
You must compare their answers to the correct ones, give feedback, and calculate scores.
Requirements:
● Use two String[] arrays: correctAnswers[] and studentAnswers[].
● Implement a method calculateScore(String[] correct, String[]
student) that returns a score.
● Use string comparison with .equalsIgnoreCase() for case-insensitive matching.
● Print detailed feedback: Question 1: Correct / Incorrect.
● Bonus: Show percentage score and pass/fail message.*/

package classandobject;

import java.util.Scanner;

public class EduQuiz {

    // Calculate score
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                score++;
            }
        }
        return score;
    }

    // Print feedback
    public static void printFeedback(String[] questions, String[] correct, String[] student) {
        System.out.println("\n--- Quiz Feedback ---");
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                System.out.println("Q" + (i + 1) + ": Correct");
            } else {
                System.out.println("Q" + (i + 1) + ": Incorrect "
                        + "(Correct Answer: " + correct[i] + ")");
            }
        }
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Questions
        String[] questions = {"What is the size of int in Java?",
                "Which keyword is used to inherit a class?",
                "Which method is the entry point of Java program?",
                "Which package contains Scanner class?",
                "Which operator is used for comparison?",
                "Which loop is guaranteed to execute at least once?",
                "Which keyword is used to create an object?",
                "Which data type stores decimal values?",
                "Which keyword is used for exception handling?",
                "Which collection allows duplicate elements?"};

        // Correct answers
        String[] correctAnswers = {"4 bytes", "extends",  "main", "java.util", 
        		"==","do-while", "new", "float or double", "try", "List or ArrayList" };

        // Student answers
        String[] studentAnswers = new String[10];

        System.out.println("Enter your answers for the following questions:\n");

        // Take student input
        for (int i = 0; i < 10; i++) {
            System.out.println("Q" + (i + 1) + ": " + questions[i]);
            System.out.print("Your Answer: ");
            studentAnswers[i] = input.nextLine();
            System.out.println();
        }

        // Calculate score
        int score = calculateScore(correctAnswers, studentAnswers);

        // Feedback
        printFeedback(questions, correctAnswers, studentAnswers);

        // Percentage & result
        double percentage = (score / 10.0) * 100;
        String result = (percentage >= 40) ? "PASS" : "FAIL";

        System.out.println("\nTotal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Result: " + result);

        input.close();
    }
}

