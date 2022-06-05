package Parts.DisplayUnit.Screen;

import Parts.Parts;

public class LEDMatrix extends Screen {
    public LEDMatrix() {
        setPrice(300);
    }

    @Override
    public String toString() {
        return "Part Name : LED MATRIX\nPrice : "+getPrice()+"\n";
    }
}
