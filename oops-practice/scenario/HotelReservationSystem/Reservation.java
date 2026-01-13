package HotelReservationSystem;

public class Reservation {

    private int reservationId;
    private Guest guest;
    private Room room;
    private boolean active;

    public Reservation(int reservationId, Guest guest, Room room) {
        this.reservationId = reservationId;
        this.guest = guest;
        this.room = room;
        this.active = true;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Room getRoom() {
        return room;
    }

    public boolean isActive() {
        return active;
    }

    public void cancel() {
        active = false;
        room.checkOut();
    }

    public void displayInvoice(double amount) {
        System.out.println("\n----- INVOICE -----");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.getRoomNumber());
        System.out.println("Total Amount: ₹" + amount);
    }
}
