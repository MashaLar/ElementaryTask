package general.models;

import general.converter.StringConverter;
import task1.presentation.ChessboardConsoleProgram;
import task2.presentation.RectangleConsoleProgram;
import task3.presentation.TriangleConsoleProgram;
import task7.presentation.RootRowConsoleProgram;
import task8.presentation.FibonacciSequenceConsoleProgram;

public class ConsoleProgram extends ConsoleApp{

    private static final String NAME_PROGRAM = "common program";
    private static final String[] MENU = {
            "Chessboard task",
            "Envelopers task",
            "Triangle list task",
            "File parser task",
            "Number transfer to word task",
            "Happy tickets task",
            "Number row task",
            "Fibonacci task",
            "Palindrome task",
            "exit"
    };

    public ConsoleProgram(){
        run(true);
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do{
            showData(menu());
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    return new ChessboardConsoleProgram(commonFlag);
                case 2:
                    return new RectangleConsoleProgram(commonFlag);
                case 3:
                    return new TriangleConsoleProgram(commonFlag);
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return new RootRowConsoleProgram(commonFlag);
                case 8:
                    return new FibonacciSequenceConsoleProgram(commonFlag);
                case 9:
                    break;
                case 10:
                    closeFlag = close();
                    break;
                default:
                    showData(ConsoleApp.INSTRUCTION);
            }
        }while(!closeFlag);
        return null;
    }

    private String menu(){
        return menu(NAME_PROGRAM,MENU);
    }

}
