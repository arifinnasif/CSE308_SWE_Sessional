import Environment.AbstractEnvironmentFactory;
import Environment.CEvinormentFactory;
import Environment.CPPEnvironmentFactory;
import Environment.Font.Font;
import Environment.Parser.Parser;
import Environment.PythonEnvironmentFactory;

public class Editor {
    private Editor editor;
    private Font font;
    private Parser parser;
    private Editor() {

    }

    public synchronized Editor getInstance() {
        if(editor == null) {
            editor = new Editor();
        }

        return editor;
    }

    public void openFile(String filename) {
        String[] temp = filename.split(".");
        String ext = temp[temp.length-1];
        AbstractEnvironmentFactory environmentFactory = null;
        if("c".equalsIgnoreCase(ext)) {
            environmentFactory = new CEvinormentFactory();
        } else if("cpp".equalsIgnoreCase(ext)) {
            environmentFactory = new CPPEnvironmentFactory();
        } else if("py".equalsIgnoreCase(ext)) {
            environmentFactory = new PythonEnvironmentFactory();
        }
        if (environmentFactory == null) {
            font = null;
            parser = null;
            return;
        }
        font = environmentFactory.createFont();
        parser = environmentFactory.createParser();

    }
}
