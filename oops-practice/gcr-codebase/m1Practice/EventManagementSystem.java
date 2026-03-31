package m1Practice;

import java.util.*;

abstract class Festival {
    String name;
    String location;
    String date;

    Festival(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    abstract void displayDetails();
}

class MusicFestival extends Festival {
    String headliner;
    String musicGenre;
    int ticketPrice;

    MusicFestival(String name, String location, String date,
                  String headliner, String musicGenre, int ticketPrice) {
        super(name, location, date);
        this.headliner = headliner;
        this.musicGenre = musicGenre;
        this.ticketPrice = ticketPrice;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Headliner: " + headliner);
        System.out.println("Music Genre: " + musicGenre);
        System.out.println("Ticket Price: " + ticketPrice);
    }
}

class FoodFestival extends Festival {
    String cuisine;
    int numStalls;
    int entryFee;

    FoodFestival(String name, String location, String date,
                 String cuisine, int numStalls, int entryFee) {
        super(name, location, date);
        this.cuisine = cuisine;
        this.numStalls = numStalls;
        this.entryFee = entryFee;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Cuisine: " + cuisine);
        System.out.println("Number of Stalls: " + numStalls);
        System.out.println("Entry Fee: " + entryFee);
    }
}

class ArtFestival extends Festival {
    String artType;
    int numArtists;
    int exhibitionFee;

    ArtFestival(String name, String location, String date,
                String artType, int numArtists, int exhibitionFee) {
        super(name, location, date);
        this.artType = artType;
        this.numArtists = numArtists;
        this.exhibitionFee = exhibitionFee;
    }

    void displayDetails() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Date: " + date);
        System.out.println("Art Type: " + artType);
        System.out.println("Number of Artists: " + numArtists);
        System.out.println("Exhibition Fee: " + exhibitionFee);
    }
}

public class EventManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Festival> map = new HashMap<>();

        System.out.println("Enter input : ");
        while (true) {

            String command = sc.next();

            if (command.equals("ADD_FESTIVAL")) {

                String type = sc.next();
                String name = sc.next();
                String location = sc.next();
                String date = sc.next();

                if (type.equals("MUSIC")) {
                    String headliner = sc.next();
                    String genre = sc.next();
                    int price = sc.nextInt();

                    map.put(name, new MusicFestival(name, location, date, headliner, genre, price));
                }

                else if (type.equals("FOOD")) {
                    String cuisine = sc.next();
                    int stalls = sc.nextInt();
                    int fee = sc.nextInt();

                    map.put(name, new FoodFestival(name, location, date, cuisine, stalls, fee));
                }

                else if (type.equals("ART")) {
                    String artType = sc.next();
                    int artists = sc.nextInt();
                    int fee = sc.nextInt();

                    map.put(name, new ArtFestival(name, location, date, artType, artists, fee));
                }
            }

            else if (command.equals("DISPLAY_DETAILS")) {

                String name = sc.next();

                if (map.containsKey(name)) {
                    map.get(name).displayDetails();
                }
            }

            else if (command.equals("EXIT")) {
                break;
            }
        }
    }
}
