package scenario.FoodDeliveryOrderRoutingSystem;

import java.util.*;

public class DeliveryService {

	Queue<Order> orderQueue = new LinkedList<>();
	List<Agent> agents = new ArrayList<>();
	Map<Order, Agent> activeDeliveries = new HashMap<>();
	
	// Add a new agent
	public void addAgent(Agent agent) {
		agents.add(agent);
	}
	
	// Add a new order
	public void addOrder(Order order) {
		orderQueue.add(order);
		System.out.println("New Order added: " + order);
	}
	
	// Find first available agent
	public Agent findAvailableAgent() {
		for(Agent agent : agents) {
			if(agent.isAvailable()) {
				return agent;
			}
		}
		return null;
	}
	
	// Assign orders to nearest available agent
	public void assignOrders() throws NoAgentAvailableException{
		while(!orderQueue.isEmpty()) {
			Order order = orderQueue.peek();
			Agent freeAgent = findAvailableAgent();
			
			if(freeAgent == null) {
				throw new NoAgentAvailableException("No agent available for order " + order.getOrderId());
			}
			
			orderQueue.poll(); // remove from queue
			freeAgent.setAvailable(false);
			activeDeliveries.put(order, freeAgent);
			System.out.println("Assigned " + order + " to " + freeAgent);
			
		}
	}
	
	// Cancel a delivery
	public void cancelDelivery(int orderId) {
		Order orderToCancel = null;
		for(Order order : activeDeliveries.keySet()) {
			if(order.getOrderId() == orderId) {
				orderToCancel = order;
				break;
			}
		}
		if(orderToCancel != null) {
			Agent agent = activeDeliveries.get(orderToCancel);
			agent.setAvailable(true);
			activeDeliveries.remove(orderToCancel);
			System.out.println("Cancelled delivery for order "+ orderId);
		}else {
			System.out.println("Order not found in active deliveries.");
		}
	}
	
	// View active deliveries
	public void viewActiveDeliveries() {
		if(activeDeliveries.isEmpty()) {
			System.out.println("No active deliveries.");
			return;
		}
		System.out.println("Active Deliveries : ");
		for(Map.Entry<Order, Agent> entry : activeDeliveries.entrySet()) {
			System.out.println("Order: " + entry.getKey() + " -> Agent: "+ entry.getValue());
		}
	}
}
