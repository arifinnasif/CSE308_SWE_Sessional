package Parts.DisplayUnit.Processor;

public class ArduinoMega extends Processor {
    public ArduinoMega() {
        setPrice(800.0);
    }

    @Override
    public String toString() {
        return "Part Name : ARDUINO MEGA\nPrice : "+getPrice()+"\n";
    }
}
