package main.entity.patientFilters;

import main.entity.Patient;

import java.util.ArrayList;

public class AgeFilter extends Filter {

    private final int minAge;
    private final int maxAge;

    public AgeFilter(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public ArrayList<Patient> filter(ArrayList<Patient> items) {
        ArrayList<Patient> result = new ArrayList<>();
        for(Patient item: items){
            if(item.getAge() >= minAge && item.getAge() <= maxAge){
                result.add(item);
            }
        }
        return super.filter(result);
    }
}
