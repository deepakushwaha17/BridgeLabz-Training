package oopsPillars;

public class HospitalPatientManagement {
	
	public static void processPatients(Patient[] patients) {

        for (Patient p : patients) {
            p.getPatientDetails();

            double bill = p.calculateBill();
            System.out.println("Total Bill: ₹" + bill);

            if (p instanceof MedicalRecord) {
                MedicalRecord m = (MedicalRecord) p;
                m.viewRecords();
            }

            System.out.println("---------------------------");
        }
	}
	
	public static void main(String[] args) {

        Patient[] patients = new Patient[2];

        InPatient p1 = new InPatient(101, "Amit Sharma", 45, "Pneumonia", "Diabetes", 5, 3000);
        p1.addRecord("Admitted to ICU, oxygen support");

        OutPatient p2 = new OutPatient(102, "Saloni Verma", 30, "Fever", "None",800);
        p2.addRecord("Prescribed antibiotics");

        patients[0] = p1;
        patients[1] = p2;

        processPatients(patients);
    }

}

abstract class Patient {

    private int patientId;
    private String name;
    private int age;

    private String diagnosis;
    private String medicalHistory;

    public Patient(int patientId, String name, int age,
                   String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }

    //public getters
    public int getPatientId() { 
    	return patientId; 
    }
    public String getName() { 
    	return name; 
    }
    public int getAge() { 
    	return age; 
    }
    protected String getDiagnosis() {
    	return diagnosis; 
    }
    protected String getMedicalHistory() {
    	return medicalHistory; 
    }
    
    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    
}

//interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {

    int daysAdmitted;
    double dailyCharge;
    String record;

    public InPatient(int id, String name, int age, String diagnosis,
                     String history, int daysAdmitted, double dailyCharge) {
        super(id, name, age, diagnosis, history);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}

class OutPatient extends Patient implements MedicalRecord {

    private double consultationFee;
    private String record;

    public OutPatient(int id, String name, int age, String diagnosis,
                      String history, double consultationFee) {
        super(id, name, age, diagnosis, history);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Record: " + record);
    }
}
