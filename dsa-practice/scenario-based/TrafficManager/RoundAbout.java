package TrafficManager;

public class RoundAbout {
    private Vehicle head; // first vehicle
    private Vehicle tail; // last vehicle for easy insertion

    // Add vehicle to roundabout (at the end)
    public void enterVehicle(String plateNumber) {
        Vehicle vehicle = new Vehicle(plateNumber);

        if (head == null) {
            head = vehicle;
            tail = vehicle;
            vehicle.next = head; // circular link
        } else {
            tail.next = vehicle;
            vehicle.next = head;
            tail = vehicle;
        }

        System.out.println("Vehicle " + plateNumber + " entered roundabout.");
    }

    // Remove vehicle from roundabout by plate number
    public void exitVehicle(String plateNumber) {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle current = head;
        Vehicle prev = tail;
        boolean found = false;

        do {
            if (current.plateNumber.equals(plateNumber)) {
                found = true;
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Vehicle " + plateNumber + " not found on roundabout.");
            return;
        }

        // Single vehicle case
        if (current == head && current == tail) {
            head = tail = null;
        } 
        // Head removal
        else if (current == head) {
            head = head.next;
            tail.next = head;
        } 
        // Tail removal
        else if (current == tail) {
            tail = prev;
            tail.next = head;
        } 
        // Middle removal
        else {
            prev.next = current.next;
        }

        System.out.println("Vehicle " + plateNumber + " exited roundabout.");
    }

    // Print roundabout state
    public void printRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle current = head;
        System.out.print("\nRoundabout Vehicles: ");
        do {
            System.out.print(current.plateNumber + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.plateNumber + ")");
    }
}