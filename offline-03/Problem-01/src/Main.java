import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("in.txt");
        TildeAdapterCalculateSum calc = new TildeAdapterCalculateSum(file);

        System.out.print("Sum = ");
        System.out.println(calc.getResult());
    }
}
