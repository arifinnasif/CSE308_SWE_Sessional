package QMSPackages;

public class PackageDirector {
    private PackageBuilder myPackageBuilder;
    public void createPackage(PackageBuilder packageBuilder) {
        myPackageBuilder = packageBuilder;
        myPackageBuilder.addDisplayUnit();
        myPackageBuilder.addApplication();
        myPackageBuilder.addControlUnit();
        myPackageBuilder.addCommunicationModule();
//        return packageBuilder.getPackage();
    }

    public PackageBuilder getMyPackageBuilder() {
        return myPackageBuilder;
    }
}
