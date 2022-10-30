public class Grader {
    public String getGrade(String arg_credit, String arg_marks) {
        // handle non number
        double credit;
        double marks;

        if(arg_credit == null) {
            throw new IllegalArgumentException("credit is null");
        }

        if(arg_marks == null) {
            throw new IllegalArgumentException("marks is null");
        }

        try {
            credit = Double.parseDouble(arg_credit);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid credit");
        }

        try {
            marks = Double.parseDouble(arg_marks);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid marks");
        }

        if (credit == 3.0) return getThreeCreditGrader(marks);
        else if(credit == 4.0) return getFourCreditGrader(marks);
        else {
            throw new IllegalArgumentException("invalid credit");
        }
    }


    private String getThreeCreditGrader(double arg_marks) {
        if(arg_marks < 0.0d) throw new IllegalArgumentException("given marks is less than zero");
        if(arg_marks > 400.0d) throw new IllegalArgumentException("given marks is greater than fullmarks");

        int marks = (int) Math.ceil(arg_marks);
        if(marks >= 240) {
            return "A";

        } else if(marks >= 210) {
            return "B";

        } else if(marks >= 180) {
            return "C";

        } else {
            return "F";

        }
    }

    private String getFourCreditGrader(double arg_marks) {
        if(arg_marks < 0.0d) throw new IllegalArgumentException("given marks is less than zero");
        if(arg_marks > 400.0d) throw new IllegalArgumentException("given marks is greater than fullmarks");

        int marks = (int) Math.ceil(arg_marks);
        if(marks >= 320) {
            return "A";

        } else if(marks >= 280) {
            return "B";

        } else if(marks >= 240) {
            return "C";

        } else {
            return "F";

        }
    }
}
