package QMSPackages;

public class PackageDirector {
    static Packages createPackage(PackageBuilder packageBuilder, String comm_channel, int number_of_display_units) {
        for(int i = 0; i<number_of_display_units; i++) packageBuilder.addDisplayUnit();
        packageBuilder.addApplication();
        packageBuilder.addControlUnit();
        packageBuilder.addCommunicationModule(comm_channel);
        return packageBuilder.getPackage();
    }
}
