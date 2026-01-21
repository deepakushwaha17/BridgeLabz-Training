package generics.AIDrivenResumeScreeningSystem;
import java.util.List;

public class ResumeScreening {

	// Using wildcard ? extends JobRole
    public static void screenResumes(List<? extends JobRole> resumes) {
        System.out.println("Screening multiple resumes...");
        for (JobRole role : resumes) {
            role.displayRoleDetails();
        }
        System.out.println("All resumes screened.\n");
    }
}
