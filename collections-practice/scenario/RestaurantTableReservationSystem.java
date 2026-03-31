package scenario;
import java.util.*;

// Custom Exception
class TableAlreadyReservedException extends Exception {
	public TableAlreadyReservedException(String message) {
		super(message);
	}
}

class Table {
	int tableNumber;
	int capacity;
	
	public Table(int tableNumber, int capacity) {
		this.tableNumber = tableNumber;
		this.capacity = capacity;
	}
}

class Reservation {
	int tableNumber;
	String name;

	String timeSlot;
	
	public Reservation(int tableNumber, String name, String timeSlot) {
		this.tableNumber = tableNumber;	
		this.name = name;
		this.timeSlot = timeSlot;
	}
	
}

// Class to add table, reserve, cancel and show available tables
class RestaurantReservation {
	
	Map<Integer,Table> tables = new HashMap<>();
	List<Reservation> reservations = new ArrayList<>();
	
	// Add tables to restaurant
	void addTable(int tableNumber, int capacity) {
		tables.put(tableNumber, new Table(tableNumber,capacity));
	}
	
	// Reserve table
	void reserveTable(int tableNumber, String name, String timeSlot) throws TableAlreadyReservedException{
		for(Reservation r : reservations) {
			if(r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
				throw new TableAlreadyReservedException("Table "+ tableNumber + " is already reserved for " + timeSlot);
			}
		}
		
		reservations.add(new Reservation(tableNumber, name, timeSlot));
		System.out.println("Table "+ tableNumber + " reserved for " + name);
	}
	
	// Cancel reservation
	void cancelReservation(int tableNumber, String timeSlot) {
		Iterator<Reservation> iterator = reservations.iterator();
		
		while(iterator.hasNext()) {
			Reservation r = iterator.next();
			if(r.tableNumber == tableNumber && r.timeSlot.equals(timeSlot)) {
				iterator.remove();
				System.out.println("Reservation cancelled for table "+tableNumber);
				return;
			}
		}
		System.out.println("No Reservation found to cancel.");
	}
	
	// Show available tables for a time slot
	void showAvailableTables(String timeSlot) {
		System.out.println("Available tables for " + timeSlot + " : ");
		for(Integer tableNo : tables.keySet()) {
			boolean booked = false;
			for(Reservation r : reservations) {
				if(r.tableNumber == tableNo && r.timeSlot.equals(timeSlot)) {
					booked = true;
					break;
				}
			}
			if(!booked) {
				System.out.println("Table " + tableNo);
			}
		}
	}
}
public class RestaurantTableReservationSystem {
	
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RestaurantReservation system = new RestaurantReservation();

        // Add some tables to the restaurant
        system.addTable(1, 4);
        system.addTable(2, 2);
        system.addTable(3, 6);
        system.addTable(4, 4);

        while (true) {
            System.out.println("\n=== Restaurant Reservation Menu ===");
            System.out.println("1. Reserve Table");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. Show Available Tables");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Table Number: ");
                    int tableNo = input.nextInt();
                    input.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = input.nextLine();
                    System.out.print("Enter Time Slot (e.g., 7PM-8PM): ");
                    String time = input.nextLine();

                    try {
                        system.reserveTable(tableNo, name, time);
                    } catch (TableAlreadyReservedException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Table Number to cancel: ");
                    int cancelTable = input.nextInt();
                    input.nextLine(); // consume newline
                    System.out.print("Enter Time Slot: ");
                    String cancelTime = input.nextLine();
                    system.cancelReservation(cancelTable, cancelTime);
                    break;

                case 3:
                    System.out.print("Enter Time Slot to check availability: ");
                    String availableTime = input.nextLine();
                    system.showAvailableTables(availableTime);
                    break;

                case 4:
                    System.out.println("Exiting... Thank you!");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
