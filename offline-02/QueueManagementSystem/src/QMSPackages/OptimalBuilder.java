package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class OptimalBuilder implements PackageBuilder {
    Optimal optimal;
    OptimalBuilder() {
        optimal = new Optimal();
    }
    @Override
    public void addCommunicationModule(String communication_module) {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        optimal.add(communicationModuleFactory.getCommunicationModule(communication_module));
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
        optimal.add(processorFactory.getProcessor("ArduinoMega"));
        optimal.add(screenFactory.getScreen("LEDMatrix"));
    }

    @Override
    public Packages getPackage() {
        return optimal;
    }
}
