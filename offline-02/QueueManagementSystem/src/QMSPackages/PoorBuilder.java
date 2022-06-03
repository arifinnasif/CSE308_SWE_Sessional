package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class PoorBuilder implements PackageBuilder {
    Poor poor;
    PoorBuilder() {
        poor = new Poor();
    }
    @Override
    public void addCommunicationModule(String communication_module) {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        poor.add(communicationModuleFactory.getCommunicationModule(communication_module));
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
        poor.add(processorFactory.getProcessor("ATMega32"));
        poor.add(screenFactory.getScreen("LEDMatrix"));
    }

    @Override
    public Packages getPackage() {
        return poor;
    }
}
