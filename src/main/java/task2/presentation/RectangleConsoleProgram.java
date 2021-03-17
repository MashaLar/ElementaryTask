package task2.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task2.models.Rectangle;
import task2.util.RectanglesComparatorLikeEnvelopes;

import java.util.Scanner;

public class RectangleConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "Fibonacci sequence program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
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

    public RectangleConsoleProgram(boolean commonFlag){
        run(commonFlag);
    }

    public void startRectangleConsoleProgram(){
        showData(FIRST_RECTANGLE);
        double[] rectangle = getSides();
        Rectangle rectangle1 = new Rectangle(rectangle[0],rectangle[1]);

        showData(SECOND_RECTANGLE);
        rectangle = getSides();
        Rectangle rectangle2 = new Rectangle(rectangle[0],rectangle[1]);

        compareResult(RectanglesComparatorLikeEnvelopes.compare(rectangle1, rectangle2),
                        RectanglesComparatorLikeEnvelopes.compare(rectangle2, rectangle1));
    }

    private boolean checkNumber(double number){ return number != 0.0 && number<=1000; }

    private double[] getSides() {
        double[] rectanglesSides = {0, 0};
        do {
            rectanglesSides[0] = StringConverter.StringToDouble(inputDataFiltered(FIRST_SIDE));
            if (checkNumber(rectanglesSides[0])) {
                rectanglesSides[1] = StringConverter.StringToDouble(inputDataFiltered(SECOND_SIDE));
                if (checkNumber(rectanglesSides[1])) {
                    return rectanglesSides;
                }
                showData(INSTRUCTION);
            }
            showData(INSTRUCTION);
        } while (true);
    }

    private void compareResult(int result1, int result2){
        if(result1 == 1){
            showData(SECOND_IN_FIRST);
        }
        if(result2 == 1){
            showData(FIRST_IN_SECOND);
        }
        if(result1 == 0 && result2 ==0){
            showData("They equals!");
        }
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do{
            showData(menu(commonFlag));
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startRectangleConsoleProgram();
                    continue;
                case 2:
                    closeFlag = close();
                    break;
                default:
                    showData(ConsoleApp.INSTRUCTION);
            }
        }while(!closeFlag);
        if(commonFlag) return new ConsoleProgram();
        else return null;
    }

    private String menu(boolean commonFlag){
        if(commonFlag) return menu(NAME_PROGRAM,COMMON_MENU);
        return menu(NAME_PROGRAM,MENU);
    }
}
