package Parts.CommunicationModule;

import Parts.Parts;

public abstract class CommunicationModule extends Parts{
    private double yearlyCost;
    protected CommunicationModule() {
        yearlyCost = 0;
    }

    protected void setYearlyCost(double yearlyCost) {
        this.yearlyCost = yearlyCost;
    }
    public abstract void communicate();
    public double getYearlyCost() {
        return this.yearlyCost;
    }
}
