/*Digital Watch Simulation ⏱️
Simulate a 24-hour watch:
● Print hours and minutes in a nested for-loop.
● Use a break to stop at 13:00 manually (simulate power cut).
 */

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatchSimulation {
    public static void main(String[] args) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Start time at 00:00
        LocalTime time = LocalTime.of(0, 0, 0);

        while (true) {
            String currentTime = time.format(formatter);

            // Stop at 13:00:00 (power cut)
            if (currentTime.equals("13:00:00")) {
                System.out.println("Power Cut! Watch stopped.");
                break;
            }

            System.out.println("CurrentTime: " + currentTime);

            // Increment time by 1 second
            time = time.plusSeconds(1);
        }
    }
}
