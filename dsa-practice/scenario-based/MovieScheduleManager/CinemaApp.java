package MovieScheduleManager;
import java.util.Scanner;

public class CinemaApp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("\n----CinemaTime App----");
			System.out.println("1. Add Movie");
			System.out.println("2. Search Movie");
			System.out.println("3. Display All Movies");
			System.out.println("4. Printable Movie Reports");
			System.out.println("5. Exit");
			System.out.print("Enter the choice : ");
			int choice = input.nextInt();
			input.nextLine();
			
			switch(choice) {
				case 1:
					System.out.print("Enter the title : ");
					String title = input.nextLine();
					System.out.print("Enter the time : ");
					String time = input.next();
					try{
						if(isValidTime(time)) {
							CinemaManager.addMovie(title,time);
						}
					}catch (InvalidTimeFormatException e) {
				        System.out.println("Error: " + e.getMessage());
				    }
					break;
				case 2:
					System.out.print("Enter the keyword : ");
					String keyword = input.next();
					CinemaManager.searchMovie(keyword);
					break;
				case 3:
					CinemaManager.displayAllMovies();
					break;
				case 4:
					CinemaManager.printableReports();
					break;
				case 5:
					System.out.println("Existing..");
					input.close();
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	
	public static boolean isValidTime(String time)throws InvalidTimeFormatException {
		String[] parts = time.split(":");
		if(parts.length != 2) {
			throw new InvalidTimeFormatException("Time must be in HH:MM format!");
		}
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);
		
		if(hour < 0 || hour > 24 || minute < 0 || minute > 60) {
			throw new InvalidTimeFormatException("Invalid time format!");
		}
		return true;
 	}
}
