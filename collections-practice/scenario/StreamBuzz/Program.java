package scenario.StreamBuzz;
import java.util.*; 

public class Program {
	
	
	public void registerCreator(CreatorStats record) {
		CreatorStats.engagementBoard.add(record);
		System.out.println("Creator registered successfully.");
	}
	
	public Map<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold){
		Map<String, Integer> result = new LinkedHashMap<>();
		
		for(CreatorStats creator : records) {
			int count = 0;
			for(double likes : creator.weeklyLikes) {
				if(likes >= likeThreshold) {
					count++;
				}
			}
			if(count > 0) {
				result.put(creator.creatorName, count);
			}
		}
		return result;
	}
	
	public double calculateAverageLikes() {
		double totalLikes = 0;
		int totalWeeks = 0;
		
		for(CreatorStats creator : CreatorStats.engagementBoard) {
			for(double likes : creator.weeklyLikes) {
				totalLikes += likes;
				totalWeeks++;
			}
		}
		
		if(totalWeeks == 0) {
			return 0;
		}
		return totalLikes / totalWeeks;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        Program program = new Program();
        boolean running = true;
        
        while (running) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline
            
            switch (choice) {
            	case 1:
	                // Register Creator
	                CreatorStats creator = new CreatorStats();
	                System.out.print("Enter Creator Name: ");
	                creator.creatorName = input.nextLine();
	                System.out.println("Enter weekly likes (Week 1 to 4):");
	                for (int i = 0; i < 4; i++) {
	                    creator.weeklyLikes[i] = input.nextDouble();
	                }
	                input.nextLine(); // consume newline
	                program.registerCreator(creator);
	                break;
	                
            	case 2:
	                // Show Top Posts
	                System.out.print("Enter like threshold: ");
	                double threshold = input.nextDouble();
	                input.nextLine(); // consume newline
	                Map<String, Integer> topPosts = program.getTopPostCounts(CreatorStats.engagementBoard, threshold);
	                if (topPosts.isEmpty()) {
	                    System.out.println("No top-performing posts this week");
	                } else {
	                    for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
	                        System.out.println(entry.getKey() + " - " + entry.getValue());
	                    }
	                }
	                break;
	                
            	case 3:
	                // Calculate Average Likes
	                double average = program.calculateAverageLikes();
	                System.out.println("Overall average weekly likes: " + (int)average);
	                break;

            	case 4:
	                // Exit
	                System.out.println("Logging off - Keep Creating with StreamBuzz!");
	                running = false;
	                break;

            	default:
	                System.out.println("Invalid choice! Please enter 1-4.");
	                break;
            }
        }
        input.close();
        
	}
}
