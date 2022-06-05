import Environment.*;
import Environment.Font.Font;
import Environment.Parser.Parser;

public class Editor {
    private static Editor editor;
    private Font font;
    private Parser parser;
    private String filename;
    private Editor() {

    }

    public synchronized static Editor getInstance() {
        if(editor == null) {
            editor = new Editor();
        }

        return editor;
    }

    public void openFile(String filename) {
        this.filename = filename;
        if (filename == null) {
            font = null;
            parser = null;
            return;

        }
        String[] temp = filename.split("\\.");
        String ext = temp[temp.length-1];
        AbstractEnvironmentFactory environmentFactory = null;
//        System.out.println("ext "+ext);
        if("c".equalsIgnoreCase(ext)) {
            environmentFactory = EnvironmentFactoryCreator.getFactory("C");
        } else if("cpp".equalsIgnoreCase(ext)) {
            environmentFactory = EnvironmentFactoryCreator.getFactory("CPP");
        } else if("py".equalsIgnoreCase(ext)) {
            environmentFactory = EnvironmentFactoryCreator.getFactory("PYTHON");
        }
        if (environmentFactory == null) {
            font = null;
            parser = null;
            return;
        }
        font = environmentFactory.createFont();
        parser = environmentFactory.createParser();

    }

    public Font getFont() {
        return font;
    }

    public Parser getParser() {
        return parser;
    }

    public String getFilename() {
        return filename;
    }
}
