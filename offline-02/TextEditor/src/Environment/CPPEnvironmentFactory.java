package Environment;

import Environment.AbstractEnvironmentFactory;
import Environment.Font.Font;
import Environment.Font.Monaco;
import Environment.Parser.CPPParser;
import Environment.Parser.Parser;

public class CPPEnvironmentFactory implements AbstractEnvironmentFactory {
    CPPEnvironmentFactory() {

    }
    @Override
    public Parser createParser() {
        return new CPPParser();
    }

    @Override
    public Font createFont() {
        return new Monaco();
    }
}
