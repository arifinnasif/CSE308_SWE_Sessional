package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class PoorBuilder implements PackageBuilder {
    private int numberOfDisplayUnit;
    private String communicationModule;
    private Poor poor;
    public PoorBuilder(String communicationModule, int numberOfDisplayUnit) {
        this.poor = new Poor();
        this.communicationModule = communicationModule;
        this.numberOfDisplayUnit = numberOfDisplayUnit;
    }

    @Override
    public void addCommunicationModule() {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        poor.add(communicationModuleFactory.getCommunicationModule(communicationModule));
    }

    @Override
    public void addApplication() {
        poor.add(new Application());
    }

    @Override
    public void addControlUnit() {
        poor.add(new ControlUnit());
    }

    @Override
    public void addDisplayUnit() {
        ProcessorFactory processorFactory = new ProcessorFactory();
        ScreenFactory screenFactory = new ScreenFactory();
        for (int i = 0; i < numberOfDisplayUnit; i++) {
            poor.add(processorFactory.getProcessor("ATMega32"));
            poor.add(screenFactory.getScreen("LEDMatrix"));
        }
    }

    @Override
    public Packages getPackage() {
        return poor;
    }
}
