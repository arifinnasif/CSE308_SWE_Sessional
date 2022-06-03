package Environment;

import Environment.AbstractEnvironmentFactory;
import Environment.Font.Consolas;
import Environment.Font.Font;
import Environment.Parser.Parser;
import Environment.Parser.PythonParser;

public class PythonEnvironmentFactory implements AbstractEnvironmentFactory {
    @Override
    public Font createFont() {
        return new Consolas();
    }

    @Override
    public Parser createParser() {
        return new PythonParser();
    }
}
