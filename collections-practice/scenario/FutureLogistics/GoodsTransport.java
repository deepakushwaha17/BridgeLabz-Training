package scenario.FutureLogistics;

public abstract class GoodsTransport {
	
	// Attributes
	private String transportId;
	private String transportDate;
	private int transportRating;
	
	// Constructor
	public GoodsTransport(String transportId, String transportDate, int transportRating) {
		this.setTransportId(transportId);
		this.setTransportDate(transportDate);
		this.setTransportRating(transportRating);
	}

	// Getter and setter for attributes
	public String getTransportId() {
		return transportId;
	}

	public void setTransportId(String transportId) {
		this.transportId = transportId;
	}

	public String getTransportDate() {
		return transportDate;
	}

	public void setTransportDate(String transportDate) {
		this.transportDate = transportDate;
	}

	public int getTransportRating() {
		return transportRating;
	}

	public void setTransportRating(int transportRating) {
		this.transportRating = transportRating;
	}
	
	// Abstract Methods
	abstract public String vehicleSelection();
	
	abstract public float calculateTotalCharge();
}