package main;

import main.entity.Hospital;
import main.entity.Patient;
import main.entity.covidStats.CovidStats;
import main.entity.covidStats.StatItem;
import main.entity.covidStats.PatientAdapter;
import main.entity.patientFilters.AgeFilter;
import main.entity.patientFilters.StatusFilter;
import main.parsers.DOMParser;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // get info from xml file

        Hospital hospital = DOMParser.parseHospitalXml("src/resources/hospital.xml");
        ArrayList<Patient> patients = hospital.getHospitalPatients();

        // usage of filters

        // create filter chain with 2 filters
        StatusFilter statusFilter = new StatusFilter("sick");
        AgeFilter ageFilter = new AgeFilter(30, 40);
        statusFilter.setNextFilter(ageFilter);

        // apply filter chain
        ArrayList<Patient> filteredPatients = statusFilter.filter(patients);
        for(Patient patient: filteredPatients) {
            Patient.printPatientInfo(patient);
        }

        // usage of CovidStats with Patients through PatientAdapter

        ArrayList<StatItem> adapted = PatientAdapter.adapt(patients);
        CovidStats stats = new CovidStats(adapted);
        stats.displayStats();

    }
}
