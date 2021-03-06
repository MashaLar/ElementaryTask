package task2.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task2.models.Rectangle;
import task2.util.RectanglesComparatorLikeEnvelopes;

public class RectangleConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "Fibonacci sequence program";
    private static final String INSTRUCTION = "------?Instruction?------\n" +
            "This program need two rectangles-envelopes(2 number for one).\n" +
            "After it gets 2 rectangles program will compare them and tell which one can put in other.\n" +
            "Sides shouldn`t be greater than 1000mm(because we can`t imagine envelope greater)\n" +
            "and less or equal 0.\n" +
            "EXAMPLE. Input first: 9 9. Input second: 10 1.\n" +
            "Output: The second envelope is inserted into the first.\n";
    private static final String[] COMMON_MENU = {
            "compare two rectangles-envelopers",
            "back to task menu"
    };
    private static final String[] MENU = {
            "compare two rectangles-envelopers",
            "exit"
    };
    private static final String FIRST_RECTANGLE = "Input first rectangle sides:";
    private static final String SECOND_RECTANGLE = "Input second rectangle sides:";
    private static final String FIRST_SIDE = "Input first side:";
    private static final String SECOND_SIDE = "Input second side:";
    private static final String FIRST_IN_SECOND = "The first envelope is inserted into the second.";
    private static final String SECOND_IN_FIRST = "The second envelope is inserted into the first.";

    public RectangleConsoleProgram(boolean commonFlag) {
        run(commonFlag);
    }

    public void startRectangleConsoleProgram() {
        double[] rectangle = getSides(FIRST_RECTANGLE);
        Rectangle rectangle1 = new Rectangle(rectangle[0], rectangle[1]);

        rectangle = getSides(SECOND_RECTANGLE);
        Rectangle rectangle2 = new Rectangle(rectangle[0], rectangle[1]);

        compareResult(RectanglesComparatorLikeEnvelopes.compare(rectangle1, rectangle2),
                RectanglesComparatorLikeEnvelopes.compare(rectangle2, rectangle1));
    }

    private boolean checkNumber(double number) {
        return number != 0.0 && number <= 1000;
    }

    private double[] getSides(String message) {
        showData(message);
        double[] rectanglesSides = {0, 0};
        do {
            rectanglesSides[0] = StringConverter.stringToDouble(inputDataFiltered(FIRST_SIDE));
            if (checkNumber(rectanglesSides[0])) {
                rectanglesSides[1] = StringConverter.stringToDouble(inputDataFiltered(SECOND_SIDE));
                if (checkNumber(rectanglesSides[1])) {
                    return rectanglesSides;
                }
                showStandartWarning();
                showInstruction(INSTRUCTION);
            }
            showStandartWarning();
            showInstruction(INSTRUCTION);
        } while (true);
    }

    private void compareResult(int result1, int result2) {
        if (result1 == 1) {
            showResult(SECOND_IN_FIRST);
        } else if (result2 == 1) {
            showResult(FIRST_IN_SECOND);
        } else if (result1 == 0 && result2 == 0) {
            showResult("They are equal!");
        } else {
            showResult("They are incompatible!");
        }
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startRectangleConsoleProgram();
                    continue;
                case 2:
                    closeFlag = close();
                    break;
                default:
                    showStandartWarning();
                    showInstruction(ConsoleApp.INSTRUCTION);
            }
        } while (!closeFlag);
        if (commonFlag) return new ConsoleProgram();
        else return null;
    }

    private String menu(boolean commonFlag) {
        if (commonFlag) return menu(NAME_PROGRAM, COMMON_MENU);
        return menu(NAME_PROGRAM, MENU);
    }
}
