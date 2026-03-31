package com.deepa.healthclinic.patient;

import java.sql.Date;

public class Patient {

    private int patientId;
    private String patientName;
    private Date dob;
    private String phone;
    private String email;
    private String address;
    private String bloodGroup;

    public Patient() {}

    public Patient(int patientId, String patientName, Date dob, String phone, String email,
                   String address, String bloodGroup) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public Patient(String patientName, Date dob, String phone, String email,
                   String address, String bloodGroup) {
        this.patientName = patientName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.bloodGroup = bloodGroup;
    }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    @Override
    public String toString() {
        return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", dob=" + dob
                + ", phone=" + phone + ", email=" + email + ", address=" + address
                + ", bloodGroup=" + bloodGroup + "]";
    }
}