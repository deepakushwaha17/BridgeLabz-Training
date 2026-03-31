package scenario.FutureLogistics;

public class TimberTransport extends GoodsTransport{
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;
	
	// Constructor
	public TimberTransport(String transportId, String transportDate, int transportRating, 
			float timberLength, float timberRadius, String timberType,float timberPrice) {
		super(transportId,transportDate,transportRating);
		this.setTimberLength(timberLength);
		this.setTimberRadius(timberRadius);
		this.setTimberType(timberType);
		this.setTimberPrice(timberPrice);
	}
	
	// Getter and setter 
	public float getTimberLength() {
		return timberLength;
	}

	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}

	public float getTimberRadius() {
		return timberRadius;
	}

	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}

	public String getTimberType() {
		return timberType;
	}

	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}

	public float getTimberPrice() {
		return timberPrice;
	}

	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}
	
	// Vehicle selection based on timber area
	@Override
	public String vehicleSelection() {
		float timberArea = 2 * 3.147f * timberRadius * timberLength;
		if(timberArea < 250) {
			return "Truck";
		}else if( timberArea >= 250 && timberArea <= 400) {
			return "Lorry";
		}else {
			return "MonsterLorry";
		}
	}
	
	// Calculates total charge for TimberTransport
	@Override
	public float calculateTotalCharge() {
		float volume = 3.147f * timberRadius * timberRadius * timberLength; // total brick cost
		
		// Computing Vehicle price based on vehicleSelection
		int vehiclePrice;
		if(vehicleSelection().equalsIgnoreCase("Truck")) {
			vehiclePrice = 1000;
		}else if(vehicleSelection().equalsIgnoreCase("Lorry")) {
			vehiclePrice = 1700;
		}else {
			vehiclePrice = 3000;
		}
		
		// Computing price based on timberType
		float rate = timberType.equalsIgnoreCase("Premium") ? 0.25f : 0.15f;
	    float price = volume * timberPrice * rate;
		
		float tax = price * 0.3f; // 30% tax on price
		
		// Computing Discount percentage based on rating
		float discountPercentage;
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