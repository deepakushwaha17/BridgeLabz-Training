package ECommerceOrderManagement;

public class Order {
	
	private int orderId;
	private Customer customer;
	private Product product;
	private String status;
	
	Order(int orderId , Customer customer , Product product){
		this.orderId = orderId;
		this.customer = customer;
		this.product = product;
		this.status = "ORDER PLACED";
	}
	
	public int getOrderId() {
		return orderId;
	}
	public String getStatus() {
		return status;
	}
	
	public String cancelOrder() {
		return this.status = "ORDER CANCELLED";
	}
	
	public void displayOrder() {
		System.out.println("Order ID : " + orderId);
		System.out.println("Customer Name : " + customer.getCustomerName());
		System.out.println("Product Name : " + product.getProductName());
		System.out.println("Product Price : " + product.getPrice());
		System.out.println("Order Status : " + status);
	}
}
