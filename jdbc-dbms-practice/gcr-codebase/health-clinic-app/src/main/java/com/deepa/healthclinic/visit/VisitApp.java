package com.deepa.healthclinic.visit;

import java.util.List;

import com.deepa.healthclinic.helper.PatientNotFoundException;

public class VisitApp {

    public static void main(String[] args) {

        VisitService service = new VisitService();

        try {
            int patientId = 1;

            List<VisitHistoryDTO> history = service.viewPatientHistory(patientId);

            System.out.println("Visit History for Patient ID: " + patientId);
            System.out.println("-----------------------------------------");

            for (VisitHistoryDTO v : history) {
                System.out.println(v);
            }

        } catch (PatientNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}