package QMSPackages;



public interface PackageBuilder {
    void addCommunicationModule(String communication_module);

    void addApplication();

    void addControlUnit();

    void addDisplayUnit();

    Packages getPackage();
}
