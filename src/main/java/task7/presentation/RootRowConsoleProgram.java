package task7.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task7.util.RootRow;

public class RootRowConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "RootRow program";
    private static final String INSTRUCTION =  "------?Instruction?------\n" +
            "This program need two integer numbers. First one is count of numbers in row (from 1 to 999),\n" +
            "second one is square of number that less than first element of row (from 1 to 999 999).\n" +
            "EXAMPLE. Input: 4 9. Output: [3, 4, 5, 6].\n";
    private static final String[] COMMON_MENU = {
            "get natural row of elements which square greater than some number",
            "go to task menu"
    };
    private static final String[] MENU = {
            "get natural row of elements which square greater than some number",
            "exit"
    };
    private static final String INPUT_COUNT_OF_NUMBERS = "\nInput count of numbers in row:";
    private static final String INPUT_SQUARE_NUMBER = "\nInput square number:";

    public RootRowConsoleProgram(boolean commonFlag, String... args) {
        if (args.length == 2) {
            startRootRowConsoleProgram(args);
        } else run(commonFlag);
    }

    public void startRootRowConsoleProgram() {
        int count = getCount();
        int square = getSquare();
        showResult("\nSequence: "+RootRow.findElements(count, square).toString());
    }

    public void startRootRowConsoleProgram(String... args) {
        int count = convertToIntCount(StringConverter.stringIgnoreTabsSpacesPlus(args[0]));
        int square = convertToIntSquare(StringConverter.stringIgnoreTabsSpacesPlus(args[1]));
        showResult(RootRow.findElements(count, square).toString());
    }

    private int getCount() {
        int num = 0;
        do {
            num = convertToIntCount(inputDataFiltered(INPUT_COUNT_OF_NUMBERS));
            if (checkNumber(num)) {
                return num;
            } else {
                showStandartWarning();
                showInstruction(INSTRUCTION);
            }
        } while (true);
    }

    private int getSquare() {
        int num = 0;
        do {
            num = convertToIntSquare(inputDataFiltered(INPUT_SQUARE_NUMBER));
            if (checkNumber(num)) {
                return num;
            } else {
                showStandartWarning();
                showInstruction(INSTRUCTION);
            }
        } while (true);
    }

    //method to check correct input
    private boolean checkNumber(int num) {
        return num != 0;
    }

    //method to border size and to check correct input of string
    private int convertToIntCount(String S) {
        if (S.matches("[1-9]\\d{0,2}")) {
            return StringConverter.stringToInt(S);
        }
        return 0;
    }

    private int convertToIntSquare(String S) {
        if (S.matches("[1-9]\\d{0,5}")) {
            return StringConverter.stringToInt(S);
        }
        return 0;
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startRootRowConsoleProgram();
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
