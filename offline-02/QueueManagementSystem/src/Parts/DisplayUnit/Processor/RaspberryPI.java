package Parts.DisplayUnit.Processor;

public class RaspberryPI extends Processor {
    public RaspberryPI() {
        setPrice(4000.0);
    }

    @Override
    public String toString() {
        return "Part Name : RASPBERRY PI\nPrice : "+getPrice()+"\n";
    }
}
