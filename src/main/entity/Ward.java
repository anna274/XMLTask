package main.entity;

import java.util.ArrayList;

public class Ward {
    private Integer number;
    private String doctor;
    private Integer placesNumber;
    private ArrayList<Patient> patients = new ArrayList<>();

    public Ward() {
    }

    public Ward(Integer number, String doctor, Integer placesNumber, ArrayList<Patient> patients) {
        this.number = number;
        this.doctor = doctor;
        this.placesNumber = placesNumber;
        this.patients = patients;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getPlacesNumber() {
        return placesNumber;
    }

    public void setPlacesNumber(Integer placesNumber) {
        this.placesNumber = placesNumber;
    }

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public static void printWardInfo(Ward ward) {
        System.out.println("Ward № '" + ward.getNumber() + "', doctor = " + ward.getDoctor() + ", patients:");
        for(Patient patient: ward.getPatients()) {
            Patient.printPatientInfo(patient);
        }
    }
}
