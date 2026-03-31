package scenario.FoodDeliveryOrderRoutingSystem;

public class Order {

	private int orderId;
	private String customerName;
	private String deliveryAddress;
	
	public Order(int orderId, String customerName, String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.deliveryAddress = deliveryAddress;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	
	@Override
	public String toString() {
		return "Order { " + "orderId = " + orderId + ", customerName = " + customerName
				+ ", deliveryAddress = " + deliveryAddress + " }";
	}
}
