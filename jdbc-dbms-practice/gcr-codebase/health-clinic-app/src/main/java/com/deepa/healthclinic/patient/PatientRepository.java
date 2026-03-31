package com.deepa.healthclinic.patient;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.deepa.healthclinic.helper.DBConnectionPool;

public class PatientRepository {

    // 1) Check if patient exists by phone OR email
    public boolean isPatientExists(String phone, String email) throws SQLException {
        String sql = "SELECT patient_id FROM patients WHERE phone = ? OR email = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setString(2, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // 2) Insert new patient
    public int insertPatient(Patient patient) throws SQLException {
        String sql = " INSERT INTO patients (patient_name, dob, phone, email, address, blood_group) VALUES (?, ?, ?, ?, ?, ?) ";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, patient.getPatientName());
            ps.setDate(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // generated patient_id
                }
            }
        }
        return -1;
    }

    // 3) Find patient by ID
    public Patient findPatientById(int patientId) throws SQLException {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRowToPatient(rs);
                }
            }
        }
        return null;
    }

    // 4) Update patient
    public boolean updatePatient(Patient patient) throws SQLException {
        String sql = "UPDATE patients SET patient_name = ?, dob = ?, phone = ?, email = ?, address = ?, blood_group = ? WHERE patient_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getPatientName());
            ps.setDate(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());
            ps.setInt(7, patient.getPatientId());

            return ps.executeUpdate() > 0;
        }
    }

    // Helper method
    private Patient mapRowToPatient(ResultSet rs) throws SQLException {
        int id = rs.getInt("patient_id");
        String name = rs.getString("patient_name");
        Date dob = rs.getDate("dob");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String address = rs.getString("address");
        String blood = rs.getString("blood_group");

        return new Patient(id, name, dob, phone, email, address, blood);
    }
}