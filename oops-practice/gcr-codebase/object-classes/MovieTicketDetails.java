package classandobject;

public class MovieTicketDetails {

	public static void main(String[] args) {
		MovieTicket movieTicket1 = new MovieTicket("Dragon" , "A10" ,120.0);
		movieTicket1.displayTicket();
		movieTicket1.bookTicket();
		movieTicket1.displayTicket();
		movieTicket1.bookTicket();
		movieTicket1.bookTicket();
		
		MovieTicket movieTicket2 = new MovieTicket("Dragon" , "A10" ,120.0);
		movieTicket2.bookTicket();
		movieTicket2.displayTicket();
	}

}

class MovieTicket{
	private String movieName;
	private String seatNumber;
	private double price;
	boolean isBooked = false;
	
	public MovieTicket(String movieName , String seatNumber , double price) {
		this.movieName = movieName;
		this.seatNumber = seatNumber;
		this.price = price;	
	}
	
	public void bookTicket() {
		if(!isBooked) {
			isBooked  = true;
		}else {
			System.out.println("House full!!! Sorry...... Ticket already booked");
		}
		
	}
	
	public void displayTicket() {
		if(!isBooked) {
			System.out.println("Ticket have not booked yet ...");
		}
		else {
			System.out.println("Ticket booked for movie : " +movieName);
			System.out.println("SeatNumber : " + seatNumber);
			System.out.println("Price : $" +price);
		}
	}
}
