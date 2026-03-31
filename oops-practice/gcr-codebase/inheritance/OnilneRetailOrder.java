package inheritance;

public class OnilneRetailOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = new Order("O011" , "12-01-2026");
		ShippedOrder shpOrder = new ShippedOrder("O011" , "12-01-2026" , "TRC-ID2372");
		DeliveredOrder devOrder = new DeliveredOrder("O011" , "12-01-2026" , "TRC-ID2372","18-01-2026");
		
		System.out.println(order.getOrderStatus());
		System.out.println(shpOrder.getOrderStatus());
		System.out.println(devOrder.getOrderStatus());

	}

}

//Base class
class Order{
	
	String orderId;
	String orderDate;
	
	Order(String orderId, String orderDate){
		this.orderId = orderId;
		this.orderDate = orderDate;
	}
	String getOrderStatus() {
		return "Order id : " + orderId + " Status : Order is placed";
	}
}

//Subclass of Order class
class ShippedOrder extends Order{
	
	String trackingNumber;
	
	ShippedOrder(String orderId, String orderDate , String trackingNumber){
		super(orderId , orderDate);
		this.trackingNumber = trackingNumber;
	}
	
	String getOrderStatus() {
		return "Order Tracking Number : " + trackingNumber + " Status : Order is Shipped";
	}
	
}

//Subclass of ShippedOrder class
class DeliveredOrder extends ShippedOrder{
	
	String deliveryDate;
	
	DeliveredOrder(String orderId, String orderDate , String trackingNumber, String deliveryDate){
		super(orderId , orderDate , deliveryDate);
		this.deliveryDate = deliveryDate;
	}
	String getOrderStatus() {
		return "Order Delivered on : " + deliveryDate + " Status : Order is Delivered";
	}
	
}
