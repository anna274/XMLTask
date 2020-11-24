package main.entity.covidStats;

import main.entity.Patient;

import java.util.ArrayList;

public class PatientAdapter implements IStatItem {
    private Patient patient;

    public PatientAdapter(Patient patient) {
       this.patient = patient;
    }

    @Override
    public int getAge() {
        return patient.getAge();
    }

    @Override
    public String getStatus() {
        String patientStatus = patient.getCovidStatus();
        if(patientStatus.equals("first level contact")) {
            return "healthy";
        }
        return patientStatus;
    }

    @Override
    public Boolean isCritical() {
        return patient.getCovidStateCode() != null && patient.getCovidStateCode() == 5;
    }

    public static ArrayList<IStatItem> adapt(ArrayList<Patient> patients) {
        ArrayList<IStatItem> adaptedPatients = new ArrayList<>();
        for(Patient patient: patients) {
            adaptedPatients.add(new PatientAdapter(patient));
        }
        return adaptedPatients;
    }
}
