package Parts.CommunicationModule;

public class CommunicationModuleFactory {
    public CommunicationModule getCommunicationModule(String communication_module) {
        if("SIMCARD".equalsIgnoreCase(communication_module)) {
            return new SIMCard();
        } else if("WIFIMODULE".equalsIgnoreCase(communication_module)) {
            return new WiFiModule();
        }
        return null;
    }
}
