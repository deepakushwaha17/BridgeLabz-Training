package scenario.FutureLogistics;

public class BrickTransport extends GoodsTransport{
	
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;
	
	// Constructor
	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize, int brickQuantity, float brickPrice) {
		super(transportId,transportDate,transportRating);
		this.setBrickSize(brickSize);
		this.setBrickQuantity(brickQuantity);
		this.setBrickPrice(brickPrice);
		
	}

	// Getter and setter 
	public float getBrickSize() {
		return brickSize;
	}

	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}

	public int getBrickQuantity() {
		return brickQuantity;
	}

	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}

	public float getBrickPrice() {
		return brickPrice;
	}

	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}
	
	// Vehicle selection based on brick quantity
	@Override
	public String vehicleSelection() {
		if(brickQuantity < 300) {
			return "Truck";
		}else if( brickQuantity >= 300 && brickQuantity <= 500) {
			return "Lorry";
		}else {
			return "MonsterLorry";
		}
	}
	
	// Calculates total charge for BrickTransport
	@Override
	public float calculateTotalCharge() {
		float price = brickPrice * brickQuantity; // total brick cost
		float tax = price * 0.3f ; // 30 % tax on price
		
		// Computing Vehicle price based on vehicleSelection
		int vehiclePrice;
		if(vehicleSelection().equalsIgnoreCase("Truck")) {
			vehiclePrice = 1000;
		}else if(vehicleSelection().equalsIgnoreCase("Lorry")) {
			vehiclePrice = 1700;
		}else {
			vehiclePrice = 3000;
		}
		
		// Computing Discount percentage based on rating
		int discountPercentage;
		if(getTransportRating() == 5) {
			discountPercentage = 20;
		}else if(getTransportRating() == 3 || getTransportRating() == 4) {
			discountPercentage = 10;
		}else {
			discountPercentage = 0;
		}
		
		float discount = price * discountPercentage / 100;	// calculating discount
		float totalCharge = (price + vehiclePrice + tax) - discount;
		
		return totalCharge;
	}

}
