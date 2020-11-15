package main.entity;

public class Patient extends Human{
    private Integer age;
    private String diagnosis;
    private Long insuranceNumber;
    private CovidStatus covidStatus;

    public Patient(Integer age, String diagnosis, Long insuranceNumber, CovidStatus covidStatus) {
        this.age = age;
        this.diagnosis = diagnosis;
        this.insuranceNumber = insuranceNumber;
        this.covidStatus = covidStatus;
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

    public Long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public CovidStatus getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(CovidStatus covidStatus) {
        this.covidStatus = covidStatus;
    }
}
