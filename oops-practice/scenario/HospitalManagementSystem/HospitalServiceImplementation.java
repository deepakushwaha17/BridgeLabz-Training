package HospitalManagementSystem;

public class HospitalServiceImplementation implements HospitalService {

    private Patient[] patients = new Patient[5];
    private Doctor[] doctors = new Doctor[5];
    private Appointment[] appointments = new Appointment[5];

    private int patientCount = 0;
    private int doctorCount = 0;
    private int appointmentCount = 0;

    @Override
    public void addPatient(Patient patient) {
        patients[patientCount++] = patient;
        System.out.println("Patient added successfully!");
    }

    @Override
    public void updatePatient(int patientId, String newDisease) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == patientId) {
                patients[i].updateDisease(newDisease);
                System.out.println("Patient updated!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    @Override
    public void deletePatient(int patientId) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == patientId) {
                for (int j = i; j < patientCount - 1; j++) {
                    patients[j] = patients[j + 1];
                }
                patients[--patientCount] = null;
                System.out.println("Patient deleted!");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors[doctorCount++] = doctor;
        System.out.println("Doctor added successfully!");
    }

    @Override
    public void bookAppointment(Appointment appointment) {
        try {
            appointment.book();
            appointments[appointmentCount++] = appointment;
            System.out.println("Appointment booked!");
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void cancelAppointment(int appointmentId) {
        for (int i = 0; i < appointmentCount; i++) {
            if (appointments[i].getAppointmentId() == appointmentId) {
                appointments[i].cancel();
                System.out.println("Appointment cancelled!");
                return;
            }
        }
        System.out.println("Appointment not found!");
    }

    public Patient getPatient(int id) {
        for (int i = 0; i < patientCount; i++) {
            if (patients[i].getId() == id)
                return patients[i];
        }
        return null;
    }

    public Doctor getDoctor(int index) {
        if (index < doctorCount)
            return doctors[index];
        return null;
    }
}
