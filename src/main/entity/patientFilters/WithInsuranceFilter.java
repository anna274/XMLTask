package main.entity.patientFilters;

import main.entity.Patient;

import java.util.ArrayList;

public class WithInsuranceFilter extends Filter{

    private final Boolean withInsurance;

    public WithInsuranceFilter(Boolean hasInsurance) {
        this.withInsurance = hasInsurance;
    }

    @Override
    public ArrayList<Patient> filter(ArrayList<Patient> items) {
        ArrayList<Patient> result = new ArrayList<>();
        if(withInsurance) {
            for(Patient item: items){
                if(item.getInsuranceNumber() != null){
                    result.add(item);
                }
            }
        } else {
            for(Patient item: items){
                if(item.getInsuranceNumber() == null){
                    result.add(item);
                }
            }
        }
        return super.filter(result);
    }
}
