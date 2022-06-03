package QMSPackages;

import Parts.Application.Application;
import Parts.CommunicationModule.CommunicationModuleFactory;
import Parts.ControlUnit.ControlUnit;
import Parts.DisplayUnit.Processor.Processor;
import Parts.DisplayUnit.Processor.ProcessorFactory;
import Parts.DisplayUnit.Screen.ScreenFactory;

public class DeluxeBuilder implements PackageBuilder {
    Deluxe deluxe;
    DeluxeBuilder() {
        deluxe = new Deluxe();
    }
    @Override
    public void addCommunicationModule(String communication_module) {
        CommunicationModuleFactory communicationModuleFactory = new CommunicationModuleFactory();
        deluxe.add(communicationModuleFactory.getCommunicationModule(communication_module));
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
        deluxe.add(processorFactory.getProcessor("RaspberryPI"));
        deluxe.add(screenFactory.getScreen("LCDPanel"));
    }

    @Override
    public Packages getPackage() {
        return deluxe;
    }
}
