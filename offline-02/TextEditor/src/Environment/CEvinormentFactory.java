package Environment;

import Environment.Font.CourierNew;
import Environment.Font.Font;
import Environment.Parser.CParser;
import Environment.Parser.Parser;

public class CEvinormentFactory implements AbstractEnvironmentFactory{
    @Override
    public Font createFont() {
        return new CourierNew();
    }

    @Override
    public Parser createParser() {
        return new CParser();
    }
}
