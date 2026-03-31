package scenario.FoodDeliveryOrderRoutingSystem;

public class FoodDeliverySystem {
    public static void main(String[] args) {
        DeliveryService service = new DeliveryService();

        // Add agents
        service.addAgent(new Agent(1, "Sahil"));
        service.addAgent(new Agent(2, "Amit"));

        // Add orders
        service.addOrder(new Order(101, "Deepa", "123 Street"));
        service.addOrder(new Order(102, "Mahi", "456 GLA"));
        service.addOrder(new Order(103, "Rahul", "789 Road"));

        try {
            service.assignOrders(); // Assign orders
        } catch (NoAgentAvailableException e) {
            System.out.println(e.getMessage());
        }

        service.viewActiveDeliveries();

        // Cancel one delivery
        service.cancelDelivery(101);
        service.viewActiveDeliveries();
    }
}
