/*Movie Ticket Booking App 🎬
Ask users for movie type, seat type (gold/silver), and snacks.
● Use switch and if together.
● Loop through multiple customers.
● Clean structure and helpful variable names. */

import java.util.Scanner;

public class MovieTicketBookingApp {

    public static int getMovieTypePrice(String movieType){
        int moviePrice = 0;
        switch (movieType) {
            case "action":
                moviePrice = 250;
                break;
            case "comedy":
                moviePrice = 300;
                break;
            case "horror":
                moviePrice = 270;
                break;
            case "thriller":
                moviePrice = 200;
                break;
            default:
                moviePrice = 0;
        }
        return moviePrice;
    }

    public static int getSeatTypePrice(String seatType){
        int seatPrice = 0;
        if(seatType.equals("gold")){
            seatPrice = 150;
        }else if (seatType.equals("silver")){
            seatPrice = 100;
        }
        return seatPrice;
    }

    public static int getSnacksPrice(String snacks){
        int snacksPrice = 0;
        if(snacks.equals("yes")){
            snacksPrice = 500;
        }else if(snacks.equals("no")){
            snacksPrice = 0;
        }
        return snacksPrice;
    }

    public static int getTicketPrice(int moviePrice , int seatPrice , int snacksPrice){
        int totalTicketPrice = moviePrice + seatPrice + snacksPrice;
        return totalTicketPrice;
    }
        
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, to Movie Ticket Booking App! ");
        String movieType = "" , seatType = "" , snacks = "";  

        while (true) {
            System.out.print("Enter the movie type (Action/Comedy/Horror/Thriller) or exit  : ");
            movieType = input.next().toLowerCase();

             //to exit the while loop
            if(movieType.equals("exit")){
                System.out.println("Thank you . Visit Again !");
                System.exit(0);
            }

            // to check invalid movie type
            if(getMovieTypePrice(movieType) == 0){
                System.err.println("Invalid Input . This movie is not available!");
                continue;
            }

            System.out.print("Enter the seatType (Gold/Silver) : "); 
            seatType = input.next().toLowerCase();

            // to check invalid seat type
            if(getSeatTypePrice(seatType) == 0){
                System.err.println("Invalid Seat Type.");
                continue;
            }

            System.out.print("Enter the snacks you want to include (yes/no) : ");
            snacks = input.next().toLowerCase();
   
            // to check invalid snacks
            if(getSnacksPrice(snacks )== 0){
                System.err.println("Invalid Snacks Input.");
                continue;
            }

            int moviePrice = getMovieTypePrice(movieType);
            int seatPrice = getSeatTypePrice(seatType);
            int snacksPrice = getSnacksPrice(snacks);
            int totalTicketPrice = getTicketPrice(moviePrice, seatPrice, snacksPrice);

            System.out.println("\n Total Ticket Price is " + totalTicketPrice);
        }     
    }  
}