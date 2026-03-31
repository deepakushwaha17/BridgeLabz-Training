package streamAPI;

import java.util.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;

    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }

    public String getSpecialty() {
        return specialty;
    }
}

public class HospitalDoctorAvailability {
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sameer", "Cardiology", true),
            new Doctor("Dr. Amit", "Neurology", false),
            new Doctor("Dr. Shila", "Dermatology", true)
        );

        doctors.stream()
               .filter(d -> d.availableOnWeekend)
               .sorted(Comparator.comparing(Doctor::getSpecialty))
               .forEach(d -> System.out.println(d.name + " - " + d.specialty));
    }
}