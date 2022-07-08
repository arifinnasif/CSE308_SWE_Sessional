import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GraderTest {
    private Grader grader;

    @Parameterized.Parameter(0)
    public String message;

    @Parameterized.Parameter(1)
    public String expectedGrade;

    @Parameterized.Parameter(2)
    public String testCredit;

    @Parameterized.Parameter(3)
    public String testMarks;

    @Parameterized.Parameter(4)
    public Class<? extends Exception> expectedException;

    @Parameterized.Parameter(5)
    public String expectedExceptionMessage;

    @Rule
    public ExpectedException thrown = ExpectedException.none();



//    public GraderTest(String arg_message, String arg_testCredit, String arg_testMarks, String arg_expected) {
//        this.message = arg_message;
//        this.testCredit = arg_testCredit;
//        this.testMarks = arg_testMarks;
//
//
//    }

    @Parameterized.Parameters(name = "Test #{index} {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Credit 3 Random A", "A", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeRandomA(), null, null },
                { "Credit 3 Random B", "B", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeRandomB(), null, null },
                { "Credit 3 Random C", "C", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeRandomC(), null, null },
                { "Credit 3 Random F", "F", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeRandomF(), null, null },

                { "Credit 3 LowerBound A", "A", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeLowerA(), null, null },
                { "Credit 3 LowerBound B", "B", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeLowerB(), null, null },
                { "Credit 3 LowerBound C", "C", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeLowerC(), null, null },
                { "Credit 3 LowerBound F", "F", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeLowerF(), null, null },

                { "Credit 3 UpperBound A", "A", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeUpperA(), null, null },
                { "Credit 3 UpperBound B", "B", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeUpperB(), null, null },
                { "Credit 3 UpperBound C", "C", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeUpperC(), null, null },
                { "Credit 3 UpperBound F", "F", GraderTestGenerator.getCreditThree(), GraderTestGenerator.getCreditThreeUpperF(), null, null },

                { "Credit 3 OutOfBound Lower 1", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getMarksOutOfBoundaryLower1(), IllegalArgumentException.class, "given marks is less than zero" },
                { "Credit 3 OutOfBound Lower 2", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getMarksOutOfBoundaryLower2(), IllegalArgumentException.class, "given marks is less than zero" },
                { "Credit 3 OutOfBound Upper 1", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getMarksOutOfBoundaryUpper1(), IllegalArgumentException.class, "given marks is greater than fullmarks" },
                { "Credit 3 OutOfBound Upper 2", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getMarksOutOfBoundaryUpper2(), IllegalArgumentException.class, "given marks is greater than fullmarks" },

                { "Credit 3 Non-Number", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getNonNumber(), IllegalArgumentException.class, "invalid marks" },

                { "Credit 4 Random A", "A", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourRandomA(), null, null },
                { "Credit 4 Random B", "B", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourRandomB(), null, null },
                { "Credit 4 Random C", "C", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourRandomC(), null, null },
                { "Credit 4 Random F", "F", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourRandomF(), null, null },

                { "Credit 4 LowerBound A", "A", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourLowerA(), null, null },
                { "Credit 4 LowerBound B", "B", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourLowerB(), null, null },
                { "Credit 4 LowerBound C", "C", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourLowerC(), null, null },
                { "Credit 4 LowerBound F", "F", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourLowerF(), null, null },

                { "Credit 4 UpperBound A", "A", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourUpperA(), null, null },
                { "Credit 4 UpperBound B", "B", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourUpperB(), null, null },
                { "Credit 4 UpperBound C", "C", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourUpperC(), null, null },
                { "Credit 4 UpperBound F", "F", GraderTestGenerator.getCreditFour(), GraderTestGenerator.getCreditFourUpperF(), null, null },

                { "Credit 4 OutOfBound Lower 1", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getMarksOutOfBoundaryLower1(), IllegalArgumentException.class, "given marks is less than zero" },
                { "Credit 4 OutOfBound Lower 2", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getMarksOutOfBoundaryLower2(), IllegalArgumentException.class, "given marks is less than zero" },
                { "Credit 4 OutOfBound Upper 1", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getMarksOutOfBoundaryUpper1(), IllegalArgumentException.class, "given marks is greater than fullmarks" },
                { "Credit 4 OutOfBound Upper 2", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getMarksOutOfBoundaryUpper2(), IllegalArgumentException.class, "given marks is greater than fullmarks" },

                { "Credit 4 Non-Number", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getNonNumber(), IllegalArgumentException.class, "invalid marks" },

                /* ADDITIONAL TESTS */
                { "Invalid Credit 1", null, GraderTestGenerator.getCreditInvalid1(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "invalid credit" },
                { "Invalid Credit 2", null, GraderTestGenerator.getCreditInvalid2(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "invalid credit" },
                { "Invalid Credit 3", null, GraderTestGenerator.getCreditInvalid3(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "invalid credit" },
                { "Invalid Credit 4", null, GraderTestGenerator.getCreditInvalid4(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "invalid credit" },
                { "Non-Number Credit", null, GraderTestGenerator.getNonNumber(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "invalid credit" },
                { "NULL Credit", null, GraderTestGenerator.getNULL(), GraderTestGenerator.getValidMarks(), IllegalArgumentException.class, "credit is null" },
                { "Credit 3 NULL Marks", null, GraderTestGenerator.getCreditThree(), GraderTestGenerator.getNULL(), IllegalArgumentException.class, "marks is null" },
                { "Credit 4 NULL Marks", null, GraderTestGenerator.getCreditFour(), GraderTestGenerator.getNULL(), IllegalArgumentException.class, "marks is null" },

                { "Fractional Valid Credit 3", "C", "3.0", GraderTestGenerator.getCreditThreeRandomC(), null, null },
                { "Fractional Valid Credit 4", "C", "4.0", GraderTestGenerator.getCreditFourRandomC(), null, null },
        });
    }

    @Before
    public void setUp() {
        grader = new Grader();
    }

    @Test
    public void test() {
        if(expectedException != null) {
            IllegalArgumentException e = assertThrows("Failed "+message,IllegalArgumentException.class, () -> grader.getGrade(testCredit, testMarks));
            assertEquals("Failed "+message, expectedExceptionMessage, e.getMessage());
        } else {
            assertEquals("Failed "+message, expectedGrade, grader.getGrade(testCredit, testMarks));
        }
    }


    @After
    public void tearDown() {
        grader = null;
    }

}