package HospitalManagementSystem;

import java.util.Scanner;

public class HospitalManagement {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        HospitalServiceImplementation service = new HospitalServiceImplementation();

        boolean exit = false;

        while (!exit) {
            System.out.println("\n---- HOSPITAL MANAGEMENT SYSTEM ----");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Add Doctor");
            System.out.println("5. Book Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. View Medical History");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Patient ID: ");
                    int pid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String pname = input.nextLine();

                    System.out.print("Enter Age: ");
                    int page = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = input.nextLine();

                    service.addPatient(new Patient(pid, pname, page, disease));
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    int upid = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter New Disease: ");
                    String nd = input.nextLine();

                    service.updatePatient(upid, nd);
                    break;

                case 3:
                    System.out.print("Enter Patient ID: ");
                    service.deletePatient(input.nextInt());
                    break;

                case 4:
                    System.out.print("Enter Doctor ID: ");
                    int did = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String dname = input.nextLine();

                    System.out.print("Enter Age: ");
                    int dage = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Specialization: ");
                    String spec = input.nextLine();

                    service.addDoctor(new Doctor(did, dname, dage, spec));
                    break;

                case 5:
                    System.out.print("Enter Appointment ID: ");
                    int aid = input.nextInt();

                    System.out.print("Enter Patient ID: ");
                    int ppid = input.nextInt();

                    Patient p = service.getPatient(ppid);
                    Doctor d = service.getDoctor(0); // first doctor

                    if (p != null && d != null) {
                        service.bookAppointment(new Appointment(aid, p, d));
                    } else {
                        System.out.println("Patient or Doctor not available!");
                    }
                    break;

                case 6:
                    System.out.print("Enter Appointment ID: ");
                    service.cancelAppointment(input.nextInt());
                    break;

                case 7:
                    System.out.print("Enter Patient ID: ");
                    Patient patient = service.getPatient(input.nextInt());
                    if (patient != null)
                        patient.viewMedicalHistory();
                    else
                        System.out.println("Patient not found!");
                    break;

                case 8:
                    exit = true;
                    System.out.println("Exiting Hospital System...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        input.close();
    }
}
