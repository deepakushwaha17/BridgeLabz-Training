package generics.AIDrivenResumeScreeningSystem;

public class DataScientist extends JobRole {
    public DataScientist(String candidateName) {
        super(candidateName);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println(candidateName + " applied for Data Scientist role.");
    }
}