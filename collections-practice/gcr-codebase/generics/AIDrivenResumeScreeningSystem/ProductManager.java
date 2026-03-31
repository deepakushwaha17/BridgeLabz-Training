package generics.AIDrivenResumeScreeningSystem;

public class ProductManager extends JobRole {
    public ProductManager(String candidateName) {
        super(candidateName);
    }

    @Override
    public void displayRoleDetails() {
        System.out.println(candidateName + " applied for Product Manager role.");
    }
}