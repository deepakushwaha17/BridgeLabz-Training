package com.deepa.healthclinic.doctor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deepa.healthclinic.helper.DBConnectionPool;

public class DoctorRepository {

    // UC-2.1 Add Doctor Profile
    public int insertDoctor(Doctor doctor) throws SQLException {

        String sql = "INSERT INTO doctors (first_name, last_name, phone, email, specialty_id, consultation_fee, is_active) VALUES (?, ?, ?, ?, ?, ?, TRUE)";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, doctor.getFirstName());
            ps.setString(2, doctor.getLastName());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setInt(5, doctor.getSpecialtyId());
            ps.setDouble(6, doctor.getConsultationFee());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }

        return -1;
    }

    // Find doctor by ID
    public Doctor findDoctorById(int doctorId) throws SQLException {

        String sql = "SELECT * FROM doctors WHERE doctor_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRowToDoctor(rs);
            }
        }

        return null;
    }

    // UC-2.2 Assign/Update Doctor Specialty
    public boolean updateDoctorSpecialty(int doctorId, int newSpecialtyId) throws SQLException {

        String sql = "UPDATE doctors SET specialty_id = ? WHERE doctor_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, newSpecialtyId);
            ps.setInt(2, doctorId);

            return ps.executeUpdate() > 0;
        }
    }

    // UC-2.3 View Doctors by Specialty
    public List<Doctor> getDoctorsBySpecialty(int specialtyId) throws SQLException {

        String sql = "SELECT * FROM doctors WHERE specialty_id = ? AND is_active = TRUE ORDER BY first_name";

        List<Doctor> doctors = new ArrayList<>();

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, specialtyId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    doctors.add(mapRowToDoctor(rs));
                }
            }
        }

        return doctors;
    }

    // UC-2.4 Deactivate Doctor Profile (Soft delete)
    public boolean deactivateDoctor(int doctorId) throws SQLException {

        String sql = "UPDATE doctors SET is_active = FALSE WHERE doctor_id = ?";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, doctorId);

            return ps.executeUpdate() > 0;
        }
    }

    // Helper
    private Doctor mapRowToDoctor(ResultSet rs) throws SQLException {

        int id = rs.getInt("doctor_id");
        String first = rs.getString("first_name");
        String last = rs.getString("last_name");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        int specialtyId = rs.getInt("specialty_id");
        double fee = rs.getDouble("consultation_fee");
        boolean active = rs.getBoolean("is_active");

        return new Doctor(id, first, last, phone, email, specialtyId, fee, active);
    }
}