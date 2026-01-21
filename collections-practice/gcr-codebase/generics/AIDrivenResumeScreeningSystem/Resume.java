package generics.AIDrivenResumeScreeningSystem;

public class Resume<T extends JobRole>{
	private T jobRole;
	
	public Resume(T jobRole) {
		this.jobRole = jobRole;
	}
	
	public void processResume() {
        System.out.println("Processing resume...");
        jobRole.displayRoleDetails();
        System.out.println("Resume processed successfully!\n");
    }

}
