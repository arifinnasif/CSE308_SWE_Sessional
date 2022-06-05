package Parts.CommunicationModule;

public class SIMCard extends CommunicationModule {
    public SIMCard() {
        super();
        setYearlyCost(3999);
        setPrice(200.0);
    }

    @Override
    public void communicate() {
        System.out.println("Sim card communicating...");
    }

    @Override
    public String toString() {
        return "Part Name : SIM CARD\nPrice : "+getPrice()+"\n";
    }
}
