package ECommerceOrderManagement;

public class Customer {

	private int customerId;
	private String customerName;
	
	Customer(int customerId , String customerName){
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	
	public String getCustomerName() {
		return customerName;
	}
}
