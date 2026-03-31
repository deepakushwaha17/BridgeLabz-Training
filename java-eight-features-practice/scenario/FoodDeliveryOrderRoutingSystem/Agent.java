package scenario.FoodDeliveryOrderRoutingSystem;

public class Agent {

	private int agentId;
	private String name;
	private boolean available;
	
	public Agent(int agentId, String name) {
		this.agentId = agentId;
		this.name = name;
		this.available = true;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getAgentId() {
		return agentId;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Agent { " + "agentId = " + agentId + ", name = " + name
				+ ", available = " + available + " }";
	}
}
