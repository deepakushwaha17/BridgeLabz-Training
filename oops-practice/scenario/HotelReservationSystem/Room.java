package HotelReservationSystem;

public abstract class Room {

    protected int roomNumber;
    protected boolean available;
    protected double basePrice;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.available = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void checkIn() {
        available = false;
    }

    public void checkOut() {
        available = true;
    }

    public abstract double calculatePrice(PricingStrategy strategy);
}
