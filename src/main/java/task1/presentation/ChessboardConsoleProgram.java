package task1.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task1.model.Chessboard;
import task1.controller.ConsoleChessboard;

public class ChessboardConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "Chessboard program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program need two numbers(from 1 to 99). First one is count of rows,\n" +
            "second one is count of columns.\n" +
            "EXAMPLE. Input: 2 2. Output:\n \u25A0 \u25A1 \n \u25A0 \u25A1.\n";
    private static final String[] MENU = {
            "print new chessboard",
            "back to task menu"
    };
    private static final String ROWS = "\nInput count of rows:";
    private static final String COLUMNS = "\nInput count of columns:";

    //constructor
    public ChessboardConsoleProgram(){
        run();
    }

    private void startChessboardConsoleProgram(){
        int m = convertToInt(inputDataFiltered(ROWS));
        int n = convertToInt(inputDataFiltered(COLUMNS));
        if (checkNumber(m, n)) {
            ConsoleChessboard consoleChessboard = new ConsoleChessboard(new Chessboard(m,n));
            showData(consoleChessboard.CreateDesk());
        }
        else showData(INSTRUCTION);
    }

    //method to check correct input
    private boolean checkNumber(int rows, int columns){
        return rows == 0 || columns == 0;
    }

    //method to border size and to check correct input of string
    private static int convertToInt(String S){
        if(S.matches("\\d{1,2}")){
            return StringConverter.StringToInt(S);
        }
        return 0;
    }

    @Override
    public ConsoleApp run() {
        anchor:
        do{
            showData(menu());
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:\n"));
            switch (i) {
                case 1:
                    startChessboardConsoleProgram();
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
