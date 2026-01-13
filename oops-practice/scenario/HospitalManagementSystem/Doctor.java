package HospitalManagementSystem;

public class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, int age, String specialization) {
        super(id, name, age);
        this.specialization = specialization;
    }

    // Polymorphism
    public double calculateConsultationFee() {
        return 500; // default fee
    }

    public void display() {
        System.out.println(id + " | Dr. " + name + " | " + specialization);
    }
}