package com.deepa.healthclinic.specialty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.deepa.healthclinic.helper.DBConnectionPool;

public class SpecialtyRepository {

    public int getSpecialtyIdByName(String name) throws Exception {
        Connection con = DBConnectionPool.getConnection();

        String sql = "SELECT specialty_id FROM specialties WHERE name = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return rs.getInt("specialty_id");
        }

        throw new Exception("Specialty not found: " + name);
    }

    public int addSpecialty(Specialty specialty) throws Exception {
        Connection con = DBConnectionPool.getConnection();

        String sql = "INSERT INTO specialties(name) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, specialty.getName());
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
}
