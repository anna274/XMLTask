package main.entity;

public class Patient{
    private String name;
    private Integer age;
    private String diagnosis;
    private String insuranceNumber = "not specified";
    private String covidStatus;

    public Patient(){}

    public Patient(String name, Integer age, String diagnosis, String insuranceNumber, String covidStatus) {
        this.name= name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.covidStatus = covidStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public static void printPatientInfo(Patient patient) {
        System.out.println(
                "Patient: " +
                "name='" + patient.getName() + '\'' +
                ", age=" + patient.getAge() +
                ", diagnosis='" + patient.getDiagnosis() + '\'' +
                ", insuranceNumber=" + patient.getInsuranceNumber() +
                ", covidStatus='" + patient.getCovidStatus());
    }
}
