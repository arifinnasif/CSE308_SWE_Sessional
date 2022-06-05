import Parts.Parts;
import QMSPackages.*;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] cmd;
        Scanner sc = new Scanner(System.in);
        PackageDirector packageDirector;
        while (true) {
            System.out.print("> ");
            cmd = sc.nextLine().strip().toUpperCase(Locale.ROOT).split(" ");

            if("BUY_PACKAGE".equalsIgnoreCase(cmd[0])) {
                PackageBuilder packageBuilder;
                if("DELUXE".equalsIgnoreCase(cmd[1])) {
                    packageBuilder = new DeluxeBuilder(cmd[2], Integer.parseInt(cmd[3]));
                } else if ("OPTIMAL".equalsIgnoreCase(cmd[1])) {
                    packageBuilder = new OptimalBuilder(cmd[2], Integer.parseInt(cmd[3]));
                } else if("POOR".equalsIgnoreCase(cmd[1])) {
                    packageBuilder = new PoorBuilder(cmd[2], Integer.parseInt(cmd[3]));
                } else continue;
                packageDirector = new PackageDirector();
                packageDirector.createPackage(packageBuilder);
                System.out.println("Bought package "+packageBuilder.getPackage().getName().toUpperCase(Locale.ROOT));
                System.out.println("Total cost : "+packageBuilder.getPackage().getTotalCost());
                System.out.println("Yearly comm cost : "+packageBuilder.getPackage().getYearlyCommCost());
                System.out.println("Parts List");
                System.out.println("----------");
                Parts[] parts = packageBuilder.getPackage().getPartsList();
                for (Parts p :
                        parts) {
                    System.out.println(p);
                }

            }
            else if("QUIT".equalsIgnoreCase(cmd[0])) {
                break;
            }
            else {
                System.out.println("UNKNOWN COMMAND");
            }
        }
    }
}
