package Parts.DisplayUnit.Screen;

import Parts.Parts;

public class LCDPanel extends Screen {
    public LCDPanel() {
        setPrice(900);
    }

    @Override
    public String toString() {
        return "Part Name : LCD PANEL\nPrice : "+getPrice()+"\n";
    }
}
