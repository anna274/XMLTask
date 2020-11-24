package main.entity.patientFilters;

import main.entity.Patient;

import java.util.ArrayList;

public class StatusFilter extends Filter {
    private final String status;

    public StatusFilter(String status) {
        this.status = status;
    }

    @Override
    public ArrayList<Patient> filter(ArrayList<Patient> items) {
        ArrayList<Patient> result = new ArrayList<>();
        for(Patient item: items){
            if(item.getCovidStatus().equals(status)){
                result.add(item);
            }
        }
        return super.filter(result);
    }
}
