package com.deepa.healthclinic.visit;

import java.sql.SQLException;
import java.util.List;

import com.deepa.healthclinic.helper.PatientNotFoundException;

public class VisitService {

    private VisitRepository repo = new VisitRepository();

    // UC-4.1 Record Patient Visit
    public int recordVisit(Visit visit) throws SQLException {
        return repo.insertVisit(visit);
    }

    // UC-1.4 View Patient Visit History
    public List<VisitHistoryDTO> viewPatientHistory(int patientId)
            throws SQLException, PatientNotFoundException {

        List<VisitHistoryDTO> history = repo.getPatientVisitHistory(patientId);

        if (history.isEmpty()) {
            throw new PatientNotFoundException("No visit history found for patient ID: " + patientId);
        }

        return history;
    }
}