package main.entity.patientFilters;

import main.entity.Patient;

import java.util.ArrayList;

public class Filter {
    private Filter nextFilter = null;
    public ArrayList<Patient> filter(ArrayList<Patient> items){
        if(nextFilter != null) {
            return nextFilter.filter(items);
        }
        return items;
    }

    public void setNextFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }
}
