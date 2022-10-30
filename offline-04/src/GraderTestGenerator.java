import java.util.Random;

public class GraderTestGenerator {
    static double leastDoubleVal = 0.0001;
    public static String getCreditThreeRandomA() {
        Random r = new Random();
        double min = 240;
        double max = 400;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditThreeRandomB() {
        Random r = new Random();
        double min = 210;
        double max = 239;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditThreeRandomC() {
        Random r = new Random();
        double min = 180;
        double max = 209;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditThreeRandomF() {
        Random r = new Random();
        double min = 0;
        double max = 179;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditFourRandomA() {
        Random r = new Random();
        double min = 320;
        double max = 400;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditFourRandomB() {
        Random r = new Random();
        double min = 280;
        double max = 319;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditFourRandomC() {
        Random r = new Random();
        double min = 240;
        double max = 279;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditFourRandomF() {
        Random r = new Random();
        double min = 0;
        double max = 239;
        return Double.toString(min + (max - min) * r.nextDouble());
    }

    public static String getCreditThreeLowerA() {
        return Double.toString(239.0 + leastDoubleVal);
    }

    public static String getCreditThreeUpperA() {
        return Double.toString(400.0);
    }

    public static String getCreditThreeLowerB() {
        return Double.toString(209.0 + leastDoubleVal);
    }

    public static String getCreditThreeUpperB() {
        return Double.toString(239.0);
    }

    public static String getCreditThreeLowerC() {
        return Double.toString(179.0 + leastDoubleVal);
    }

    public static String getCreditThreeUpperC() {
        return Double.toString(209.0);
    }

    public static String getCreditThreeLowerF() {
        return Double.toString(0.0);
    }

    public static String getCreditThreeUpperF() {
        return Double.toString(179.0);
    }

    //--------------------
    public static String getCreditFourLowerA() {
        return Double.toString(319.0 + leastDoubleVal);
    }

    public static String getCreditFourUpperA() {
        return Double.toString(400.0);
    }

    public static String getCreditFourLowerB() {
        return Double.toString(279.0 + leastDoubleVal);
    }

    public static String getCreditFourUpperB() {
        return Double.toString(319.0);
    }

    public static String getCreditFourLowerC() {
        return Double.toString(239.0 + leastDoubleVal);
    }

    public static String getCreditFourUpperC() {
        return Double.toString(279.0);
    }

    public static String getCreditFourLowerF() {
        return Double.toString(0.0);
    }

    public static String getCreditFourUpperF() {
        return Double.toString(239.0);
    }

    // -----
    public static String getMarksOutOfBoundaryLower1() {
        return Double.toString(0.0 - leastDoubleVal);
    }

    public static String getMarksOutOfBoundaryLower2() {
        return Double.toString(- 400);
    }

    public static String getMarksOutOfBoundaryUpper1() {
        return Double.toString(400.0 + leastDoubleVal);
    }

    public static String getMarksOutOfBoundaryUpper2() {
        return Double.toString(800.0);
    }

    public static String getTooLargeDouble() {
        return Double.toString(Double.MAX_VALUE);
    }

    public static String getNonNumber() {
        return "abc";
    }

    public static String getNULL() {
        return null;
    }

    public static String getCreditThree() {
        return "3";
    }

    public static String getCreditFour() {
        return "4";
    }

    public static String getCreditInvalid1() {
        return "0";
    }

    public static String getCreditInvalid2() {
        return "1.5";
    }

    public static String getCreditInvalid3() {
        return "-1.5";
    }

    public static String getCreditInvalid4() {
        return "5";
    }

    public static String getValidMarks() {
        Random r = new Random();
        double min = 0;
        double max = 400;
        return Double.toString(min + (max - min) * r.nextDouble());
    }
}
