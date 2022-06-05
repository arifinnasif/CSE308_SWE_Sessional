package Parts.Application;

import Parts.Parts;

public class Application extends Parts {
    public Application() {
        setPrice(400.0);
    }

    @Override
    public String toString() {
        return "Part Name : APPLICATION\nPrice : "+getPrice()+"\n";
    }
}
