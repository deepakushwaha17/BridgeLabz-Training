package com.deepa.healthclinic.doctor;

public class Doctor {

    private int doctorId;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private int specialtyId;
    private double consultationFee;
    private boolean isActive;

    public Doctor() {}

    public Doctor(int doctorId, String firstName, String lastName, String phone, String email,
                  int specialtyId, double consultationFee, boolean isActive) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.specialtyId = specialtyId;
        this.consultationFee = consultationFee;
        this.isActive = isActive;
    }

    public Doctor(String firstName, String lastName, String phone, String email,
                  int specialtyId, double consultationFee) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.specialtyId = specialtyId;
        this.consultationFee = consultationFee;
        this.isActive = true;
    }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getSpecialtyId() { return specialtyId; }
    public void setSpecialtyId(int specialtyId) { this.specialtyId = specialtyId; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    @Override
    public String toString() {
        return "Doctor [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", phone=" + phone + ", email=" + email + ", specialtyId=" + specialtyId
                + ", consultationFee=" + consultationFee + ", isActive=" + isActive + "]";
    }
}