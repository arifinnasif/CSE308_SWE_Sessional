package Environment;

import Environment.Font.Font;
import Environment.Parser.Parser;

public interface AbstractEnvironmentFactory {
    public Font createFont();
    public Parser createParser();
}
