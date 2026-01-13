package HotelReservationSystem;

import java.util.Scanner;

public class HotelReservation {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Room[] rooms = new Room[4];
        rooms[0] = new StandardRoom(101);
        rooms[1] = new StandardRoom(102);
        rooms[2] = new DeluxeRoom(201);
        rooms[3] = new DeluxeRoom(202);

        Reservation[] reservations = new Reservation[5];
        int reservationCount = 0;

        PricingStrategy normalSeason = new SeasonalPricing(1.0);
        PricingStrategy peakSeason = new SeasonalPricing(1.5);

        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- HOTEL RESERVATION SYSTEM ----");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Check-In");
            System.out.println("4. Check-Out & Generate Invoice");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nRoom No | Type | Status");
                    for (int i = 0; i < rooms.length; i++) {
                        String type = (rooms[i] instanceof DeluxeRoom) ? "Deluxe" : "Standard";
                        String status = rooms[i].isAvailable() ? "Available" : "Booked";
                        System.out.println(rooms[i].getRoomNumber() + " | " + type + " | " + status);
                    }
                    break;

                case 2:
                    System.out.print("Enter Guest ID: ");
                    int gid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Guest Name: ");
                    String gname = input.nextLine();

                    Guest guest = new Guest(gid, gname);

                    System.out.print("Enter Room Number: ");
                    int rno = input.nextInt();

                    try {
                        Room selectedRoom = null;
                        for (int i = 0; i < rooms.length; i++) {
                            if (rooms[i].getRoomNumber() == rno) {
                                selectedRoom = rooms[i];
                                break;
                            }
                        }

                        if (selectedRoom == null || !selectedRoom.isAvailable()) {
                            throw new RoomNotAvailableException("Room not available!");
                        }

                        selectedRoom.checkIn();
                        reservations[reservationCount++] =
                                new Reservation(reservationCount, guest, selectedRoom);

                        System.out.println("Room booked successfully!");

                    } catch (RoomNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Check-in completed during booking.");
                    break;

                case 4:
                    System.out.print("Enter Reservation ID: ");
                    int rid = input.nextInt();

                    for (int i = 0; i < reservationCount; i++) {
                        if (reservations[i].getReservationId() == rid
                                && reservations[i].isActive()) {

                            Room room = reservations[i].getRoom();

                            System.out.print("Season (1-Normal / 2-Peak): ");
                            int s = input.nextInt();

                            PricingStrategy strategy =
                                    (s == 2) ? peakSeason : normalSeason;

                            double bill = room.calculatePrice(strategy);
                            reservations[i].displayInvoice(bill);
                            reservations[i].cancel();
                            break;
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting from Hotel Reservation System");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}
