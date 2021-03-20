package task1.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task1.exception.NoSuchChessboardException;
import task1.model.Chessboard;
import task1.controller.ConsoleChessboard;

public class ChessboardConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "Chessboard program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program need two integer numbers(from 1 to 99). First one is count of rows,\n" +
            "second one is count of columns.\n" +
            "EXAMPLE. Input: 2 2. Output:\n \u25A0 \u25A1 \n \u25A0 \u25A1.\n";
    private static final String[] COMMON_MENU = {
            "print new chessboard",
            "back to task menu"
    };
    private static final String[] MENU = {
            "print new chessboard",
            "exit"
    };
    private static final String ROWS = "\nInput count of rows:";
    private static final String COLUMNS = "\nInput count of columns:";

    //constructor
    public ChessboardConsoleProgram(boolean commonFlag){
        run(commonFlag);
    }

    private void startChessboardConsoleProgram(){
        int m = convertToInt(inputDataFiltered(ROWS));
        if (checkNumber(m)) {
            int n = convertToInt(inputDataFiltered(COLUMNS));
            if (checkNumber(n)) {
                try {
                    ConsoleChessboard consoleChessboard = new ConsoleChessboard(new Chessboard(m, n));
                    showData(consoleChessboard.CreateDesk());
                }catch (NoSuchChessboardException ex){
                    showData(INSTRUCTION);
                }
            }
        }
        else showData(INSTRUCTION);
    }

    //method to check correct input
    private boolean checkNumber(int number){ return number != 0; }

    //method to border size and to check correct input of string
    private static int convertToInt(String S){
        if(S.matches("[2-9]\\d{0,1}|\\d{2}")){
            return StringConverter.stringToInt(S);
        }
        return 0;
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do{
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startChessboardConsoleProgram();
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
