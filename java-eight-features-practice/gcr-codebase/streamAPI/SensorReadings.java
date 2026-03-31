package streamAPI;

import java.util.Arrays;
import java.util.List;

public class SensorReadings {

	public static void main(String[] args) {
		List<Integer> readings = Arrays.asList(45, 80, 30, 90);

		int threshold = 60;

		readings.stream()
		        .filter(r -> r > threshold)
		        .forEach(r -> System.out.println("High Reading: " + r));
	}
}