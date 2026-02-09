package com.deepa.healthclinic.patient;

import java.sql.Date;

import com.deepa.healthclinic.helper.DuplicatePatientException;
import com.deepa.healthclinic.helper.PatientNotFoundException;

public class PatientApp {

    public static void main(String[] args) {

        PatientService service = new PatientService();

        try {
            // Register new patient
            Patient p1 = new Patient(
                    "Deepa Kushwaha",
                    Date.valueOf("2003-04-17"),
                    "9835675854",
                    "deepa@gmail.com",
                    "Deoria",
                    "A+"
            );

            int newId = service.registerNewPatient(p1);
            System.out.println("Patient registered successfully! ID = " + newId);

            // Fetch patient
            Patient fetched = service.getPatientById(newId);
            System.out.println("Patient Found: " + fetched);

        } catch (DuplicatePatientException e) {
            System.out.println("Duplicate Error: " + e.getMessage());

        } catch (PatientNotFoundException e) {
            System.out.println("Not Found: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}