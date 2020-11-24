package main.entity;

public class Patient{
    private String name;
    private Integer age;
    private String diagnosis;
    private String insuranceNumber;
    private String covidStatus;
    private Integer covidStateCode;

    public Patient(){}

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public Integer getCovidStateCode() {
        return covidStateCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public void setCovidStateCode(Integer covidStateCode) {
        this.covidStateCode = covidStateCode;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
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

    public static class PatientBuilder{
        private Patient patient;

        public PatientBuilder(){
            patient = new Patient();
        }

        public PatientBuilder setName(String name) {
            patient.name = name;
            return this;
        }

        public PatientBuilder setCovidStatus(String covidStatus) {
            patient.covidStatus = covidStatus;
            return this;
        }

        public PatientBuilder setCovidStateCode(Integer covidStateCode) {
            patient.covidStateCode = covidStateCode;
            return this;
        }

        public PatientBuilder setAge(Integer age) {
            patient.age = age;
            return this;
        }

        public PatientBuilder setDiagnosis(String diagnosis) {
            patient.diagnosis = diagnosis;
            return this;
        }

        public PatientBuilder setInsuranceNumber(String insuranceNumber) {
            patient.insuranceNumber = insuranceNumber;
            return this;
        }

        public Patient build() {
            return patient;
        }
    }


}
