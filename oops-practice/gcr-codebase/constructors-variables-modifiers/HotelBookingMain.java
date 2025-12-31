package classandobject;

public class HotelBookingMain {

	public static void main(String[] args) {
		 HotelBooking booking1 = new HotelBooking();
		 booking1.displayBooking();
		 
	     HotelBooking booking2 = new HotelBooking("Deepa", "Deluxe", 3);
	     booking2.displayBooking();
	     
	     HotelBooking booking3 = new HotelBooking(booking2);  
	     booking3.displayBooking();

	}
}

class HotelBooking {

    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking hb) {
        this.guestName = hb.guestName;
        this.roomType = hb.roomType;
        this.nights = hb.nights;
    }

    public void displayBooking() {
        System.out.println("Guest Name: " + guestName +", Room Type: " + roomType +
            ", Nights: " + nights);
    }
}
