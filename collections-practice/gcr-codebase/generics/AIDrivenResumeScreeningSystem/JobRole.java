package generics.AIDrivenResumeScreeningSystem;

public abstract class JobRole {

	String candidateName;

    public JobRole(String candidateName) {
        this.candidateName = candidateName;
    }

    public abstract void displayRoleDetails();
}
