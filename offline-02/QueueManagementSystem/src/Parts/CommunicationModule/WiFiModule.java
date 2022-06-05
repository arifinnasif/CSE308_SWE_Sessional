package Parts.CommunicationModule;


public class WiFiModule extends CommunicationModule {
    public WiFiModule() {
        super();
        setYearlyCost(5999);
        setPrice(1500.0);
    }

    @Override
    public void communicate() {
        System.out.println("WiFi module communicating...");
    }

    @Override
    public String toString() {
        return "Part Name : WIFI MODULE\nPrice : "+getPrice()+"\n";
    }
}
