package scenario.EventFeedbackRatingAnalyzer;

import java.util.*; 

public class EventFeedbackAnalyzer {
    private Map<String, List<Integer>> feedbackData = new HashMap<>();

    public void addFeedback(String eventID, int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5.");
        }
        feedbackData.putIfAbsent(eventID, new ArrayList<>());
        feedbackData.get(eventID).add(rating);
    }

    public void showAverageRatings() {
        System.out.println("Average Ratings:");
        for (Map.Entry<String, List<Integer>> entry : feedbackData.entrySet()) {
            double avg = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0);
            System.out.println("Event " + entry.getKey() + ": " + avg);
        }
    }

    public void showTopRatedEvent() {
        String topEvent = null;
        double topAvg = 0;

        for (Map.Entry<String, List<Integer>> entry : feedbackData.entrySet()) {
            double avg = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0);
            if (avg > topAvg) {
                topAvg = avg;
                topEvent = entry.getKey();
            }
        }

        System.out.println("Top-rated event: " + topEvent + " with average rating: " + topAvg);
    }
}
