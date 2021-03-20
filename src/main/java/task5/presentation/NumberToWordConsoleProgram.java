package task5.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import general.validation.StringValidator;
import task5.model.NumberToWord;

public class NumberToWordConsoleProgram extends ConsoleApp {
    private static final String NAME_PROGRAM = "Translator Number To Word program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program need integer number (from -10^33 to 10^33).\n" +
            "Translator will translate numbers in words.\n" +
            "EXAMPLE. Input: 234.\n" +
            "Output: 234 - двести тридцать четыре.\n";
    private static final String[] COMMON_MENU = {
            "translate number in words",
            "back to task menu"
    };
    private static final String[] MENU = {
            "translate number in words",
            "exit"
    };
    private static final String INPUT_NUMBER = "\nInput number to translate:";

    public NumberToWordConsoleProgram(boolean commonFlag) {
        run(commonFlag);
    }

    public void startNumberToWordConsoleProgram(){
        String number = StringConverter.stringIgnorePlus(inputDataFiltered(INPUT_NUMBER));
        if(StringValidator.isIntegerNumber(number)){
            NumberToWord numberToWord = new NumberToWord(number);
            showData(numberToWord.toString());
        }
        else showData(INSTRUCTION);
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startNumberToWordConsoleProgram();
                    continue;
                case 2:
                    closeFlag = close();
                    break;
                default:
                    showData(ConsoleApp.INSTRUCTION);
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
