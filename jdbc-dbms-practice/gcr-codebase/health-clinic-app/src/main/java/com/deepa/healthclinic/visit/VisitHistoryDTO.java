package com.deepa.healthclinic.visit;

import java.sql.Timestamp;

public class VisitHistoryDTO {

    private int visitId;
    private Timestamp visitDate;
    private String doctorName;
    private String diagnosis;
    private String notes;

    public VisitHistoryDTO(int visitId, Timestamp visitDate, String doctorName,
                           String diagnosis, String notes) {
        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.notes = notes;
    }

    public int getVisitId() { return visitId; }
    public Timestamp getVisitDate() { return visitDate; }
    public String getDoctorName() { return doctorName; }
    public String getDiagnosis() { return diagnosis; }
    public String getNotes() { return notes; }

    @Override
    public String toString() {
        return "VisitHistoryDTO [visitId=" + visitId + ", visitDate=" + visitDate
                + ", doctorName=" + doctorName + ", diagnosis=" + diagnosis
                + ", notes=" + notes + "]";
    }
}