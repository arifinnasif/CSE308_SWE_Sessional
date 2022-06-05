package QMSPackages;


import Parts.CommunicationModule.CommunicationModule;

public interface PackageBuilder {
    void addCommunicationModule();

    void addApplication();

    void addControlUnit();

    void addDisplayUnit();

    Packages getPackage();
}
