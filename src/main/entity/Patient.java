package main.entity;

public class Patient{
    private String name;
    private Integer age;
    private String diagnosis;
    private Long insuranceNumber;
    private String covidStatus;

    public Patient(){}

    public Patient(String name, Integer age, String diagnosis, Long insuranceNumber, String covidStatus) {
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

    public Long getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(Long insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    @Override
    public String toString() {
        return "Patient: " +
                "name='" + name + '\'' +
                ", age=" + age +
                ", diagnosis='" + diagnosis + '\'' +
                ", insuranceNumber=" + insuranceNumber +
                ", covidStatus='" + covidStatus;
    }
}
