package streamAPI;

import java.util.Arrays;
import java.util.List;

public class AttendeeWelcomeMessage {
	
	public static void main(String[] args) {
		List<String> attendees = Arrays.asList("Deepa", "Amit", "Mahi");

		attendees.forEach(name ->
		    System.out.println("Welcome to the event, " + name + "!"));

	}

}
