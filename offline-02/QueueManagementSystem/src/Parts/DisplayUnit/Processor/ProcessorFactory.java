package Parts.DisplayUnit.Processor;

public class ProcessorFactory {
    public Processor getProcessor(String processor_name) {
        if("ARDUINOMEGA".equalsIgnoreCase(processor_name)) {
            return new ArduinoMega();
        } else if ("ATMEGA32".equalsIgnoreCase(processor_name)) {
            return new ATMega32();
        } else if ("RASPBERRYPI".equalsIgnoreCase(processor_name)) {
            return new RaspberryPI();
        }
        return null;
    }
}
