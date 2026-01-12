package classandobject;

import java.util.Scanner;
import java.util.ArrayList;

public class HospitalManagementSystem {
	static ArrayList<Patient> patients = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Doctor d1 = new Doctor(101,"Dr.Sharma" ,"Cardiologist");
		Doctor d2 = new Doctor(102,"Dr.Verma" ,"Physiotherapist");
		
		while(true) {
			System.out.println("\n----Hospital Management System----");
			System.out.println("1. Add Patient");
			System.out.println("2. View Patients");
			System.out.println("3. Remove Patient");
			System.out.println("4. Exit.");
			
			System.out.print("Enter the choice : ");
			int choice = input.nextInt();
			input.nextLine();
			switch(choice) {
				case 1 : 
					System.out.print("Enter (1-InPatient / 2- OutPatient) : ");
					int type = input.nextInt();
					input.nextLine();
					System.out.print("Enter Patient Id : ");
					int patientId = input.nextInt();
					input.nextLine();
					System.out.print("Enter Patient Name : ");
					String patientName = input.nextLine();
					System.out.print("Enter Patient Age : ");
					int age = input.nextInt();
					input.nextLine();
					
					if(type == 1) {
						System.out.print("Enter Days Admitted : ");
						int daysAdmitted = input.nextInt();
						input.nextLine();
						System.out.print("Enter Daily Charges : ");
						double dailyCharges = input.nextDouble();
						input.nextLine();
						
						patients.add(new InPatient(patientId,patientName,age,d1,daysAdmitted,dailyCharges));
					}
					else if(type == 2) {
						System.out.print("Enter Consultation Fees : ");
						double consultationFees = input.nextDouble();
						input.nextLine();
						
						patients.add(new OutPatient(patientId,patientName,age,d2,consultationFees));
					}
					else {
						System.out.println("Invaild Type.");
					}
					System.out.println("Patient Added.");
					break;
					
				case 2 :
					for(Patient p : patients) {
						p.displayInfo();
						System.out.println("------------------------");
					}
					break;
					
				case 3 :
					System.out.print("Enter Patient Id to remove : ");
					int removeId = input.nextInt();
					patients.removeIf(p ->p.getPatientId() == removeId);
					System.out.println("Patient removed.");
					break;
					
				case 4 :
					System.out.println("Exiting... ");
					System.exit(0);
				default:
					System.out.println("Invalid Choice.");
			}

		}

	}

}

interface IPayable {
	double calculateBill();
}

class Doctor {
	private int doctorId;
	private String doctorName;
	private String specialization;
	
	//Constructor
	Doctor(int doctorId , String doctorName , String specialization) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
	}
	
	//Public getter for doctor name
	public String getDoctorName() {
		return doctorName;
	}
	
	//Public getter for specialization
	public String getSpecialization() {
		return specialization;
	}
}

abstract class Patient implements IPayable {
	protected int patientId;
	protected String patientName;
	protected int age;
	protected Doctor doctor;
	
	//Constructor
	Patient(int patientId , String patientName , int age  , Doctor doctor){
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.doctor = doctor;
	}
	
	//Public getter for patient id
	public int getPatientId() {
		return patientId;
	}
	
	//Abstract method to display info
	public abstract void displayInfo();
}


class InPatient extends Patient {
	int daysAdmitted;
	double dailyCharge;
	
	//Constructor
	InPatient(int patientId , String patientName , int age , Doctor doctor , int daysAdmitted , double dailyCharge){
		super(patientId , patientName , age , doctor);
		this.daysAdmitted = daysAdmitted;
		this.dailyCharge = dailyCharge;
	}
	
	public double calculateBill() {
		return dailyCharge * daysAdmitted;
	}
	
	public void displayInfo() {
		System.out.println("In-Patient Id : "+patientId);
		System.out.println("Patient Name : "+patientName);
		System.out.println("Patient Age : "+age);
		System.out.println("Doctor Name : " +doctor.getDoctorName());
		System.out.println("Total Bill : $"+calculateBill());
		
	}
}

class OutPatient extends Patient {
	double consultationFees;
	
	//Constructor
	OutPatient(int patientId , String patientName , int age , Doctor doctor , double consultationFees){
		super(patientId , patientName , age , doctor);
		this.consultationFees = consultationFees;
	}
	
	public double calculateBill() {
		return consultationFees;
	}
	
	public void displayInfo() {
		System.out.println("In-Patient Id : "+patientId);
		System.out.println("Patient Name : "+patientName);
		System.out.println("Patient Age : "+age);
		System.out.println("Doctor Name : " +doctor.getDoctorName());
		System.out.println("Total Bill : $"+calculateBill());
		
	}
}
