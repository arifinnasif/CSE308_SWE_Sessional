package Parts.DisplayUnit.Processor;

public class ATMega32 extends Processor {
    public ATMega32() {
        setPrice(200.0);
    }

    @Override
    public String toString() {
        return "Part Name : ATMEGA 32\nPrice : "+getPrice()+"\n";
    }
}
