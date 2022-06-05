package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.Processor;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class DeluxeBuilder implements PackageBuilder {
    private int numberOfDisplayUnit;
    private String communicationModule;
    private Deluxe deluxe;
    public DeluxeBuilder(String communicationModule, int numberOfDisplayUnit) {
        this.deluxe = new Deluxe();
        this.communicationModule = communicationModule;
        this.numberOfDisplayUnit = numberOfDisplayUnit;
    }
    @Override
    public void addCommunicationModule() {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        deluxe.add(communicationModuleFactory.getCommunicationModule(communicationModule));
    }

    @Override
    public void addApplication() {
        deluxe.add(new Application());
    }

    @Override
    public void addControlUnit() {
        deluxe.add(new ControlUnit());
    }

    @Override
    public void addDisplayUnit() {
        ProcessorFactory processorFactory = new ProcessorFactory();
        ScreenFactory screenFactory = new ScreenFactory();
        for (int i = 0; i < numberOfDisplayUnit; i++) {
            deluxe.add(processorFactory.getProcessor("RaspberryPI"));
            deluxe.add(screenFactory.getScreen("LCDPanel"));
        }
    }

    @Override
    public Packages getPackage() {
        return deluxe;
    }
}
