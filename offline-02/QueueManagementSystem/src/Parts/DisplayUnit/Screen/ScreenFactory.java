package Parts.DisplayUnit.Screen;

public class ScreenFactory {
    public Screen getScreen(String screen) {
        if("LCDPANEL".equalsIgnoreCase(screen)) {
            return new LCDPanel();
        } else if("LEDMATRIX".equalsIgnoreCase(screen)) {
            return new LEDMatrix();
        }
        return null;
    }
}
