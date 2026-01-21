package generics.AIDrivenResumeScreeningSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AIResumeScreening {

	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<JobRole> applicants = new ArrayList<>();

        System.out.println("\n===== AI Driven Resume Screening System =====\n");
        System.out.print("Enter number of candidates: ");
        int n = input.nextInt();
        input.nextLine(); // consume leftover newline

        for (int i = 0; i < n; i++) {
            System.out.print("Enter candidate name: ");
            String name = input.nextLine();

            System.out.println("Select job role for " + name + ":");
            System.out.println("1. Software Engineer");
            System.out.println("2. Data Scientist");
            System.out.println("3. Product Manager");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine(); // consume newline

            JobRole role = null;
            switch (choice) {
                case 1 :
                	role = new SoftwareEngineer(name);
                	break;
                case 2 :
                	role = new DataScientist(name);
                	break;
                case 3 :
                	role = new ProductManager(name);
                	break;
                default : 
                    System.out.println("Invalid choice, skipping candidate.\n");
                    continue;
            }

            // Process individual resume
            Resume<JobRole> resume = new Resume<>(role);
            resume.processResume();

            // Add to list for batch screening
            applicants.add(role);
        }

        // Screen all resumes together
        ResumeScreening.screenResumes(applicants);
        input.close();
    }
}
