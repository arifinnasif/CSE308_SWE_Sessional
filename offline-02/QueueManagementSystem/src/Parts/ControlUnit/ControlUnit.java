package Parts.ControlUnit;

import Parts.Parts;

public class ControlUnit extends Parts {
    public ControlUnit() {
        setPrice(250.0);
    }

    @Override
    public String toString() {
        return "Part Name : CONTROL UNIT\nPrice : "+getPrice()+"\n";
    }
}
