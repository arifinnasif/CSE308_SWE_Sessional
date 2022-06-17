import java.io.*;

public class TildeAdapterCalculateSum extends CalculateSum{

    private File file;

    public TildeAdapterCalculateSum() {

    }

    public TildeAdapterCalculateSum(File file) {
        setFile(file);
    }

    @Override
    public void setFile(File file) {
        File temp = new File("temp.txt");

        if(!temp.exists()) {
            try {
                temp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }

        BufferedReader br = null;
        try {
            br  = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        BufferedWriter bw = null;

        try {
            bw  = new BufferedWriter(new FileWriter(temp));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        String line;
        try {
            while ((line = br.readLine()) != null) {
                String mod_line = line.replaceAll("~", " ");
                bw.write(mod_line);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (IOException ioException) {
            System.out.println("Cannot read from file");
            ioException.printStackTrace();
        }


        this.file = file;
        super.setFile(temp);
    }



    @Override
    public int getResult() {
        return super.getResult();
    }
}
