public class Grader {
    public String getGrade(String arg_credit, String arg_marks) {
        // handle non number
        double credit;
        int marks;

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
            double temp = Double.parseDouble(arg_marks);
            if(temp < 0.0d) throw new IllegalArgumentException("given marks is less than zero");
            if(temp > 400.0d) throw new IllegalArgumentException("given marks is greater than fullmarks");

            marks = (int) Math.ceil(Double.parseDouble(arg_marks));

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid marks");
        }

        if (credit == 3.0) return getThreeCreditGrader(marks);
        else if(credit == 4.0) return getFourCreditGrader(marks);
        else {
            throw new IllegalArgumentException("invalid credit");
        }
    }


    private String getThreeCreditGrader(int arg_marks) {
        if(arg_marks > 400) { // redundant. but kept for the sake of modularity
            throw new IllegalArgumentException("given marks is greater than fullmarks");

        } else if(arg_marks >= 240) {
            return "A";

        } else if(arg_marks >= 210) {
            return "B";

        } else if(arg_marks >= 180) {
            return "C";

        } else if(arg_marks >= 0) {
            return "F";

        } else { // redundant. but kept for the sake of modularity
            throw new IllegalArgumentException("given marks is less than zero");
        }
    }

    private String getFourCreditGrader(int arg_marks) {
        if(arg_marks > 400) { // redundant. but kept for the sake of modularity
            throw new IllegalArgumentException("given marks is greater than fullmarks");

        } else if(arg_marks >= 320) {
            return "A";

        } else if(arg_marks >= 280) {
            return "B";

        } else if(arg_marks >= 240) {
            return "C";

        } else if(arg_marks >= 0) {
            return "F";

        } else { // redundant. but kept for the sake of modularity
            throw new IllegalArgumentException("given marks is less than zero");
        }
    }
}
