package MovieScheduleManager;
import java.util.ArrayList;

public class CinemaManager {
	
	static ArrayList<String> movieTitles = new ArrayList<>();
	static ArrayList<String> showTimes = new ArrayList<>();
	
	private String title;
	private String time;

	public CinemaManager(String title, String time) {
		this.title = title;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	public static void addMovie(String title , String time) {
		if(movieTitles.contains(title)) {
			System.out.println("Movie already exist.");
			return;
		}
		movieTitles.add(title);
		showTimes.add(time);
		System.out.println("Movie added successfully.");
	}
	
	public static void searchMovie(String keyword) {
		try {
			boolean found = false;
			for(int i = 0; i < movieTitles.size(); i++) {
				if(movieTitles.get(i).contains(keyword)) {
					String result = String.format("Movie : %s | Showtime : %s", movieTitles.get(i), showTimes.get(i));
					System.out.println(result);
					found = true;
				}
			}
			if(!found) {
				System.out.println("No movie found with keyword : "+keyword);
			}
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println("Error : "+e.getMessage());
		}
	}
	
	public static void displayAllMovies() {
		if(movieTitles.isEmpty()) {
			System.out.println("No movie record exists..");
			return;
		}
		System.out.println("\n----All Movies with Showtimes----");
		for(int i = 0; i < movieTitles.size(); i++) {
			String result = String.format("%d. Movie : %s | Showtime : %s", (i+1),movieTitles.get(i), showTimes.get(i));
			System.out.println(result);
		}
		System.out.println("-------------------------------------");
	}

	public static void printableReports() {
		if(movieTitles.isEmpty()) {
			System.out.println("No movie record exists..");
			return;
		}
		String[] titleArray = movieTitles.toArray(new String[movieTitles.size()]);
		String[] timeArray = showTimes.toArray(new String[showTimes.size()]);
		System.out.println("\n----Printable Reports----");
		for(int i = 0; i < titleArray.length; i++) {
			System.out.println(titleArray[i] + " - " +timeArray[i]);
			System.out.println("---------------------------------");
		}
	}
}
