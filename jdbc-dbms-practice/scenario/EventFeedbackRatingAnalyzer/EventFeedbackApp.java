package scenario.EventFeedbackRatingAnalyzer;

public class EventFeedbackApp {
    public static void main(String[] args) throws Exception {
        EventFeedbackAnalyzer analyzer = new EventFeedbackAnalyzer();

        analyzer.addFeedback("E101", 5);
        analyzer.addFeedback("E101", 4);
        analyzer.addFeedback("E102", 3);
        analyzer.addFeedback("E102", 5);
        analyzer.addFeedback("E103", 5);

        try {
            analyzer.addFeedback("E103", 6); // Invalid rating
        } catch (InvalidRatingException e) {
            System.out.println(e.getMessage());
        }

        analyzer.showAverageRatings();
        analyzer.showTopRatedEvent();
    }
}