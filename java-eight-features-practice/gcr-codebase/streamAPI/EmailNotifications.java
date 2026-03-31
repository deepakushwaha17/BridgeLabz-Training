package streamAPI;

import java.util.Arrays;
import java.util.List;

public class EmailNotifications {
	
	public static void sendEmailNotification(String email) {
	    System.out.println("Email sent to " + email);
	}

	public static void main(String[] args) {
		List<String> emails = Arrays.asList("deepa124@gmail.com", "mahi456@gmail.com");

		emails.forEach(email -> sendEmailNotification(email));
	}

}
