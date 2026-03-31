package com.deepa.healthclinic.patient;
import java.sql.SQLException;

import com.deepa.healthclinic.helper.DuplicatePatientException;
import com.deepa.healthclinic.helper.PatientNotFoundException;

public class PatientService {

    private PatientRepository repo = new PatientRepository();

    // UC-1.1 Register New Patient
    public int registerNewPatient(Patient patient) throws SQLException, DuplicatePatientException {

        boolean exists = repo.isPatientExists(patient.getPhone(), patient.getEmail());

        if (exists) {
            throw new DuplicatePatientException("Patient already exists with same phone/email!");
        }

        return repo.insertPatient(patient);
    }

    // UC-1.2 Update Patient Information
    public boolean updatePatientInfo(Patient patient)
            throws SQLException, PatientNotFoundException {

        Patient existing = repo.findPatientById(patient.getPatientId());

        if (existing == null) {
            throw new PatientNotFoundException("Patient not found with ID: " + patient.getPatientId());
        }

        return repo.updatePatient(patient);
    }

    // UC-1.3 Search Patient by ID
    public Patient getPatientById(int patientId)
            throws SQLException, PatientNotFoundException {

        Patient patient = repo.findPatientById(patientId);

        if (patient == null) {
            throw new PatientNotFoundException("Patient not found with ID: " + patientId);
        }

        return patient;
    }
}