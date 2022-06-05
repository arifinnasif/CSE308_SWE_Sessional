package QMSPackages;

import Parts.CommunicationModule.CommunicationModule;
import Parts.Parts;

import java.util.ArrayList;

public abstract class Packages {
    private double totalCost;
    private double yearlyCommCost;
    private ArrayList<Parts> partsList;
    public abstract String getName();

    protected Packages() {
        partsList = new ArrayList<Parts>();
        totalCost = 0;
        yearlyCommCost = 0;
    }


    void add(Parts parts) {
        partsList.add(parts);
        this.totalCost += parts.getPrice();
        if(parts instanceof CommunicationModule) {
            yearlyCommCost += ((CommunicationModule)parts).getYearlyCost();
        }
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getYearlyCommCost() {
        return yearlyCommCost;
    }

    public Parts[] getPartsList() {
        return partsList.toArray(new Parts[1]);
    }
}
