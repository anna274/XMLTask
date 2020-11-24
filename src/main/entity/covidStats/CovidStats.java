package main.entity.covidStats;

import java.util.ArrayList;

public class CovidStats {
    ArrayList<IStatItem> items = new ArrayList<>();

    public CovidStats(){}

    public CovidStats(ArrayList<IStatItem> items) {
        this.items = items;
    }

    public ArrayList<IStatItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<IStatItem> items) {
        this.items = items;
    }

    public double inCriticalState(){
        double inCriticalStateNumber = 0;
        for(IStatItem item: items) {
            if(item.isCritical()) {
                inCriticalStateNumber += 1;
            }
        }
        return convertToPercentages(inCriticalStateNumber / items.size());
    }

    public int getAverageAgeOfRecovered() {
        int recoveredNumber = 0;
        int summarizedAge = 0;
        for(IStatItem item: items) {
            if(item.getStatus().equals("recovered")) {
                recoveredNumber += 1;
                summarizedAge += item.getAge();
            }
        }
        return summarizedAge / recoveredNumber;
    }

    private static int convertToPercentages(double value) {
        return (int) Math.round(value * 100);
    }

    public void displayStats() {
        double inCritical = inCriticalState();
        int recoveredAverageAge = getAverageAgeOfRecovered();
        System.out.println("In critical state(%) : " + inCritical);
        System.out.println("Average age of recovered: " + recoveredAverageAge);

    }
}
