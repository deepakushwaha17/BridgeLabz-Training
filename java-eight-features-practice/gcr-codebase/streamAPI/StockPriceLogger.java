package streamAPI;

import java.util.Arrays;
import java.util.List;

public class StockPriceLogger {

	public static void main(String[] args) {
		List<Double> prices = Arrays.asList(102.5, 105.0, 110.75);

		prices.forEach(price -> System.out.println("Stock Price: " + price));


	}

}
