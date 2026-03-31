package com.deepa.healthclinic.doctor;

import java.sql.SQLException;
import java.util.List;

import com.deepa.healthclinic.helper.DoctorNotAvailableException;

public class DoctorService {

    private DoctorRepository repo = new DoctorRepository();

    // UC-2.1 Add Doctor
    public int addDoctor(Doctor doctor) throws SQLException {
        return repo.insertDoctor(doctor);
    }

    // Get Doctor By ID
    public Doctor getDoctorById(int doctorId) throws SQLException, DoctorNotAvailableException {

        Doctor doctor = repo.findDoctorById(doctorId);

        if (doctor == null) {
            throw new DoctorNotAvailableException("Doctor not found with ID: " + doctorId);
        }

        return doctor;
    }

    // UC-2.2 Update Specialty
    public boolean assignDoctorSpecialty(int doctorId, int newSpecialtyId)
            throws SQLException, DoctorNotAvailableException {

        Doctor existing = repo.findDoctorById(doctorId);

        if (existing == null) {
            throw new DoctorNotAvailableException("Doctor not found with ID: " + doctorId);
        }

        return repo.updateDoctorSpecialty(doctorId, newSpecialtyId);
    }

    // UC-2.3 View doctors by specialty
    public List<Doctor> viewDoctorsBySpecialty(int specialtyId) throws SQLException {
        return repo.getDoctorsBySpecialty(specialtyId);
    }

    // UC-2.4 Deactivate doctor
    public boolean deactivateDoctor(int doctorId) throws SQLException, DoctorNotAvailableException {

        Doctor existing = repo.findDoctorById(doctorId);

        if (existing == null) {
            throw new DoctorNotAvailableException("Doctor not found with ID: " + doctorId);
        }

        return repo.deactivateDoctor(doctorId);
    }
}