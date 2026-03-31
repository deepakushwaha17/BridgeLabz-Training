package HospitalManagementSystem;

public class Patient extends Person {

    private String disease;
    private String medicalHistory;

    public Patient(int id, String name, int age, String disease) {
        super(id, name, age);
        this.disease = disease;
        this.medicalHistory = disease;
    }

    public int getId() {
        return id;
    }

    public void updateDisease(String disease) {
        this.disease = disease;
        this.medicalHistory += " | " + disease;
    }

    public void display() {
        System.out.println(id + " | " + name + " | Age: " + age + " | Disease: " + disease);
    }

    public void viewMedicalHistory() {
        System.out.println("Medical History: " + medicalHistory);
    }
}
