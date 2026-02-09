package com.deepa.healthclinic.doctor;

import java.util.List;

import com.deepa.healthclinic.helper.DoctorNotAvailableException;
import com.deepa.healthclinic.specialty.Specialty;
import com.deepa.healthclinic.specialty.SpecialtyRepository;

public class DoctorApp {

    public static void main(String[] args) {

        DoctorService doctorService = new DoctorService();
        SpecialtyRepository specialtyRepo = new SpecialtyRepository();

        try {
            // Ensure specialty exists
            int specialtyId;
            try {
                specialtyId = specialtyRepo.getSpecialtyIdByName("Cardiology");
            } catch (Exception e) {
                specialtyId = specialtyRepo.addSpecialty(new Specialty("Cardiology"));
            }

            // Add doctor
            Doctor d1 = new Doctor(
                    "Amit",
                    "Sharma",
                    "9998887776",
                    "amit@gmail.com",
                    specialtyId,
                    500.00
            );

            int doctorId = doctorService.addDoctor(d1);
            System.out.println("Doctor Added Successfully! ID = " + doctorId);

            // Fetch doctor
            Doctor doctor = doctorService.getDoctorById(doctorId);
            System.out.println("Doctor Found: " + doctor);

            // Doctors by specialty
            List<Doctor> doctors = doctorService.viewDoctorsBySpecialty(specialtyId);
            doctors.forEach(System.out::println);

            // Deactivate doctor
            System.out.println("Doctor Deactivated: " +
                    doctorService.deactivateDoctor(doctorId));

        } catch (DoctorNotAvailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
