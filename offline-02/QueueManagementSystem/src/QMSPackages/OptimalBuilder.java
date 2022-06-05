package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModule;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class OptimalBuilder implements PackageBuilder {
    private String communicationModule;
    private int numberOfDisplayUnit;
    private Optimal optimal;
    public OptimalBuilder(String communicationModule, int numberOfDisplayUnit) {
        this.optimal = new Optimal();
        this.communicationModule = communicationModule;
        this.numberOfDisplayUnit = numberOfDisplayUnit;
    }
    @Override
    public void addCommunicationModule() {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        optimal.add(communicationModuleFactory.getCommunicationModule(communicationModule));
    }

    @Override
    public void addApplication() {
        optimal.add(new Application());
    }

    @Override
    public void addControlUnit() {
        optimal.add(new ControlUnit());
    }

    @Override
    public void addDisplayUnit() {
        ProcessorFactory processorFactory = new ProcessorFactory();
        ScreenFactory screenFactory = new ScreenFactory();
        for (int i = 0; i < numberOfDisplayUnit; i++) {
            optimal.add(processorFactory.getProcessor("ArduinoMega"));
            optimal.add(screenFactory.getScreen("LEDMatrix"));
        }
    }

    @Override
    public Packages getPackage() {
        return optimal;
    }
}
