package com.deepa.healthclinic.specialty;

public class Specialty {
    private int specialtyId;
    private String name;

    public Specialty() {}

    public Specialty(String name) {
        this.name = name;
    }

    public int getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getName() {
        return name;
    }
}
