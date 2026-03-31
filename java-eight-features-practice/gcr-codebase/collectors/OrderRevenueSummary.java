package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Order{
	String customerName;
	double amount;
	public Order(String customerName, double amount) {
		this.customerName = customerName;
		this.amount = amount;
	}
	public String getCustomerName() {
		return customerName;
	}
	public double getAmount() {
		return amount;
	}
	
}

public class OrderRevenueSummary {

	public static void main(String[] args) {
		List<Order> orders = Arrays.asList(new Order("Deepa",1000.0),new Order("Mahi", 2000.0),
				new Order("Deepa",4000.0),new Order("Mahi", 1000.0),new Order("Rahul",3000.0));

		Map<String , Double> orderSum = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomerName,Collectors.summingDouble(Order :: getAmount)));
		
		orderSum.forEach((customer, total) ->
        System.out.println(customer + " -> " + total));
	}

}
