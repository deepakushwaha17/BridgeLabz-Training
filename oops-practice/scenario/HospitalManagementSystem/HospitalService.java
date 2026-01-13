package HospitalManagementSystem;

public interface HospitalService {

    void addPatient(Patient patient);
    void updatePatient(int patientId, String newDisease);
    void deletePatient(int patientId);

    void addDoctor(Doctor doctor);

    void bookAppointment(Appointment appointment);
    void cancelAppointment(int appointmentId);
}
