package QMSPackages;

import Parts.Parts;

import java.util.ArrayList;

public abstract class Packages {
    private ArrayList<Parts> partsList;
    public abstract String getName();
    void add(Parts parts) {
        partsList.add(parts);
    }

    public Parts[] getPartsList() {
        return partsList.toArray(new Parts[1]);
    }
}
