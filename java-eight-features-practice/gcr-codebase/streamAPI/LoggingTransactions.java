package streamAPI;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class LoggingTransactions {

	public static void main(String[] args) {
		List<String> transactionIds = Arrays.asList("TX101", "TX102");

        transactionIds.forEach(id ->
            System.out.println(LocalDateTime.now() + " - Transaction: " + id));
	}
}