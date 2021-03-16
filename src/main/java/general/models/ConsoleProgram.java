package general.models;

import general.converter.StringConverter;
import task1.presentation.ChessboardConsoleProgram;
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
        run();
    }

    @Override
    public ConsoleApp run() {
        anchor:
        do{
            showData(menu());
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:\n"));
            switch (i) {
                case 1:
                    return new ChessboardConsoleProgram();
                case 2:
                    return new RootRowConsoleProgram();
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    return new FibonacciSequenceConsoleProgram();
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    showData(ConsoleApp.INSTRUCTION);
                    continue anchor;
            }
        }while(!close());
        return null;
    }

    private String menu(){
        return menu(NAME_PROGRAM,MENU);
    }

}
