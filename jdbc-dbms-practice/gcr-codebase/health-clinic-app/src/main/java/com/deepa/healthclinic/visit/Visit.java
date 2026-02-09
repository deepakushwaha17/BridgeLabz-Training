package com.deepa.healthclinic.visit;

import java.sql.Timestamp;

public class Visit {

    private int visitId;
    private int appointmentId;
    private int doctorId;
    private int patientId;
    private String diagnosis;
    private String notes;
    private Timestamp visitDate;

    public Visit() {}

    public Visit(int visitId, int appointmentId, int doctorId, int patientId,
                 String diagnosis, String notes, Timestamp visitDate) {
        this.visitId = visitId;
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.notes = notes;
        this.visitDate = visitDate;
    }

    public Visit(int appointmentId, int doctorId, int patientId, String diagnosis, String notes) {
        this.appointmentId = appointmentId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public int getVisitId() { return visitId; }
    public void setVisitId(int visitId) { this.visitId = visitId; }

    public int getAppointmentId() { return appointmentId; }
    public void setAppointmentId(int appointmentId) { this.appointmentId = appointmentId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Timestamp getVisitDate() { return visitDate; }
    public void setVisitDate(Timestamp visitDate) { this.visitDate = visitDate; }

    @Override
    public String toString() {
        return "Visit [visitId=" + visitId + ", appointmentId=" + appointmentId + ", doctorId=" + doctorId
                + ", patientId=" + patientId + ", diagnosis=" + diagnosis + ", notes=" + notes
                + ", visitDate=" + visitDate + "]";
    }
}