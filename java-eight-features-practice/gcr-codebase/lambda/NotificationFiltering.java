package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Alert {
    String type;
    String message;

    public Alert(String type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message;
    }
}


public class NotificationFiltering {

	public static void main(String[] args) {
		List<Alert> alerts = Arrays.asList(
	       new Alert("Medication", "Time to take medicine"),
	       new Alert("Appointment", "Doctor appointment at 3 PM"),
	       new Alert("Emergency", "Blood pressure critical"),
	       new Alert("TestResult", "Lab results available"));
		
		String userPreference = "Medication";
		Predicate<Alert> filter = alert -> alert.type.equals(userPreference);
		alerts.stream().filter(filter).forEach(a -> System.out.println(a));
	}

}