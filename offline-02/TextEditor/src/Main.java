import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] cmd;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            cmd = sc.nextLine().strip().split(" ");
            if("OPEN".equalsIgnoreCase(cmd[0])) {
                Editor editor = Editor.getInstance();
                editor.openFile(cmd[1]);
                System.out.println("Opened file : " + editor.getFilename());
            }
            else if("SHOW_PARSER".equalsIgnoreCase(cmd[0])) {
                Editor editor = Editor.getInstance();

                if (editor.getFilename() == null) {
                    System.out.println("No file open at this moment");
                    continue;
                }

                if (editor.getParser() == null) {
                    System.out.println("No Parser Found");
                    continue;
                }
                editor.getParser().parse();
            }
            else if("SHOW_FONT".equalsIgnoreCase(cmd[0])) {
                Editor editor = Editor.getInstance();

                if (editor.getFilename() == null) {
                    System.out.println("No file open at this moment");
                    continue;
                }

                if (editor.getFont() == null) {
                    System.out.println("No Font Found");
                    continue;
                }
                editor.getFont().writeFont();
            }
            else if("CLOSE".equalsIgnoreCase(cmd[0])) {
                Editor editor = Editor.getInstance();
                if(editor.getFilename() != null) System.out.println("Closing " + editor.getFilename());
                editor.openFile(null);
            }
            else if("QUIT".equalsIgnoreCase(cmd[0])) {
                break;
            }
            else {
                System.out.println("Unknown Command");
            }
        }
    }
}
