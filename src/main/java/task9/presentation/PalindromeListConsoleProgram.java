package task9.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import general.validation.StringValidator;
import task9.model.PalindromeList;

public class PalindromeListConsoleProgram extends ConsoleApp {
    private static final String NAME_PROGRAM = "Palindrome Number program";
    private static final String INSTRUCTION = "------?Instruction?------\n" +
            "This program need positive integer number. It will show all sub-palindromes\n" +
            "in this number.\n" +
            "EXAMPLE. Input: 123321. Output: All palindromes: 33, 2332, 123321.";
    private static final String[] COMMON_MENU = {
            "get all palindromes from number",
            "go to task menu"
    };
    private static final String[] MENU = {
            "get all palindromes from number",
            "exit"
    };
    private static final String INPUT_NUMBER = "\nInput number:";
    private static final String NO_PALINDROMES = "\nThis number don`t have any palindrome";

    public PalindromeListConsoleProgram(boolean commonFlag, String... args) {
        if (args.length == 1) {
            startPalindromeListConsoleProgram(args);
        } else run(commonFlag);
    }

    public void startPalindromeListConsoleProgram() {
        String stringNumber = getBigNumber();
        PalindromeList palindromeList = new PalindromeList();
        palindromeList.findAndAddPalindromeToSet(stringNumber);
        if (!palindromeList.getPalindromesSet().isEmpty()) {
            showResult(palindromeList.toString());
        } else showResult(NO_PALINDROMES);
    }

    public void startPalindromeListConsoleProgram(String... args) {
        String stringNumber = args[0];
        if (StringValidator.isPositiveIntegerNumber(stringNumber)) {
            PalindromeList palindromeList = new PalindromeList();
            palindromeList.findAndAddPalindromeToSet(stringNumber);
            if (!palindromeList.getPalindromesSet().isEmpty()) {
                showResult(palindromeList.toString());
            } else showResult(NO_PALINDROMES);
        }
        else showInstruction(INSTRUCTION);
    }

    private String getBigNumber() {
        String num = "";
        do {
            num = inputDataFiltered(INPUT_NUMBER);
            if (StringValidator.isPositiveIntegerNumber(num)) {
                return num;
            } else {
                showStandartWarning();
                showInstruction(INSTRUCTION);
            }
        } while (true);
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startPalindromeListConsoleProgram();
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
