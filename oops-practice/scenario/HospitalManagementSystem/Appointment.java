package HospitalManagementSystem;

public class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private boolean available;

    public Appointment(int appointmentId, Patient patient, Doctor doctor) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.available = true;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book() throws AppointmentNotAvailableException {
        if (!available) {
            throw new AppointmentNotAvailableException("Appointment already booked!");
        }
        available = false;
    }

    public void cancel() {
        available = true;
    }

    public void display() {
        System.out.println(
            "Appointment ID: " + appointmentId +
            " | Patient: " + patient.name +
            " | Doctor: Dr. " + doctor.name
        );
    }
}