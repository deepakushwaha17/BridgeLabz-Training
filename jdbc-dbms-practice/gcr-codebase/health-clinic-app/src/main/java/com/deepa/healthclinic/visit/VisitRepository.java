package com.deepa.healthclinic.visit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.deepa.healthclinic.helper.DBConnectionPool;

public class VisitRepository {

    // Insert visit record
    public int insertVisit(Visit visit) throws SQLException {

        String sql = "INSERT INTO visits (appointment_id, doctor_id, patient_id, diagnosis, notes) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setInt(2, visit.getDoctorId());
            ps.setInt(3, visit.getPatientId());
            ps.setString(4, visit.getDiagnosis());
            ps.setString(5, visit.getNotes());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }

        return -1;
    }

    // Patient Visit History (JOIN)
    public List<VisitHistoryDTO> getPatientVisitHistory(int patientId) throws SQLException {

        String sql = "SELECT v.visit_id, v.visit_date, CONCAT(d.first_name, ' ', d.last_name) AS doctor_name, "
        		+ "v.diagnosis, v.notes FROM visits v JOIN doctors d ON v.doctor_id = d.doctor_id WHERE v.patient_id = ? ORDER BY v.visit_date DESC ";

        List<VisitHistoryDTO> history = new ArrayList<>();

        try (Connection con = DBConnectionPool.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, patientId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {

                    int visitId = rs.getInt("visit_id");
                    java.sql.Timestamp visitDate = rs.getTimestamp("visit_date");
                    String doctorName = rs.getString("doctor_name");
                    String diagnosis = rs.getString("diagnosis");
                    String notes = rs.getString("notes");

                    history.add(new VisitHistoryDTO(
                            visitId, visitDate, doctorName, diagnosis, notes
                    ));
                }
            }
        }

        return history;
    }
}