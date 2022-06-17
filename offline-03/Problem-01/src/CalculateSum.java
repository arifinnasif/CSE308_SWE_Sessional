import java.io.*;

public class CalculateSum {
    private File file;

    public CalculateSum() {

    }

    public CalculateSum(File file) {
        this.file = file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public int getResult() {
        int sum = 0;

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("No such file found");
            e.printStackTrace();
        }

        String line;

        try {
            while ((line = br.readLine()) != null) {

                String[] args = line.strip().split(" ");
                for (String arg : args) {
                    if(arg == null || arg.length() == 0) continue;
                    sum += Integer.parseInt(arg);
                }
            }
            br.close();
        } catch (IOException ioException) {
            System.out.println("Cannot read from file");
            ioException.printStackTrace();
        }

        return sum;
    }
}
