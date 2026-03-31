package generics.AIDrivenResumeScreeningSystem;

public class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName) {
        super(candidateName);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println(candidateName + " applied for Software Engineer role.");
    }
}
