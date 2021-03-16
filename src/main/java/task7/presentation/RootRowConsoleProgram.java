package task7.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task7.util.RootRow;

public class RootRowConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "RootRow program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program need two numbers. First one is count of numbers in row (from 1 to 999),\n" +
            "second one is square of number that less than first element of row (from 1 to 999 999).\n" +
            "EXAMPLE. Input: 4 9. Output: [3, 4, 5, 6].\n";
    private static final String[] COMMON_MENU = {
            "get natural row of elements which square greater than some number",
            "go to task menu"
    };
    private static final String[] MENU = {
            "get natural row of elements which square greater than some number",
            "exit"
    }; //TODO: make interface with commonMenu and make dependency for run method
    private static final String INPUT_COUNT_OF_NUMBERS = "\nInput count of numbers in row:";
    private static final String INPUT_SQUARE_NUMBER = "\nInput square number:";

    public RootRowConsoleProgram(){
        run();
    }
    public RootRowConsoleProgram(boolean commonFlag){
        if(commonFlag) run();
        run();
    }

    public void startRootRowConsoleProgram(){
        int count = convertToIntCount(inputDataFiltered(INPUT_COUNT_OF_NUMBERS));
        int square = convertToIntSquare(inputDataFiltered(INPUT_SQUARE_NUMBER));
        if (checkNumber(count, square)) {
            showData(RootRow.findElements(count,square).toString());
        }
        else showData(INSTRUCTION);
    }

    //method to check correct input
    private boolean checkNumber(int rows, int columns){
        return rows == 0 || columns == 0;
    }

    //method to border size and to check correct input of string
    private static int convertToIntCount(String S){
        if(S.matches("[1-9]\\d{0,2}")){
            return StringConverter.StringToInt(S);
        }
        return 0;
    }
    private static int convertToIntSquare(String S){
        if(S.matches("[1-9]\\d{0,5}")){
            return StringConverter.StringToInt(S);
        }
        return 0;
    }

    @Override
    public ConsoleApp run(){
        anchor:
        do{
            showData(menu());
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:\n"));
            switch (i) {
                case 1:
                    startRootRowConsoleProgram();
                    continue anchor;
                case 2:
                    break;
                default:
                    showData(ConsoleApp.INSTRUCTION);
            }
        }while(!close());
        return new ConsoleProgram();
    }

    private String menu(){
        return menu(NAME_PROGRAM,MENU);
    }


}
