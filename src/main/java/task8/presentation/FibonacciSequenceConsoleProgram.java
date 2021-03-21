package task8.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import general.validation.StringValidator;
import task8.model.FibonacciSequence;

import java.math.BigInteger;

public class FibonacciSequenceConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "Fibonacci sequence program";
    private static final String INSTRUCTION = "------?Instruction?------\n" +
            "This program need one or two integer numbers. If you input one number (from 1 to 99),\n" +
            "than program will print numbers which lengths equals it.\n" +
            "If you input two numbers (from 0 to number which contains 99 numerals).\n" +
            "EXAMPLE. Input: 1. Output: [0, 1, 1, 2, 3, 5, 8].\n" +
            "Input: 1 100. Output: [1, 1, 2, 3, 5, 8, 13, 21, 33, 54, 87].";
    private static final String[] COMMON_MENU = {
            "print numbers of sequence which lengths equals yours",
            "print numbers of sequence in given interval",
            "back to task menu"
    };
    private static final String[] MENU = {
            "print numbers of sequence which lengths equals yours",
            "print numbers of sequence in given interval",
            "exit"
    };
    private static final String LENGTH_NUM = "\nInput length of number in sequence:";
    private static final String MIN_VALUE = "\nInput minimal number of sequence:";
    private static final String MAX_VALUE = "\nInput maximal number of sequence:";

    //constructor
    public FibonacciSequenceConsoleProgram(boolean commonFlag) {
        run(commonFlag);
    }

    private void startFibonacciSequenceLength() {
        int length = StringConverter.stringToInt(inputDataFiltered(LENGTH_NUM));
        if (checkNumbersLength(length)) {
            FibonacciSequence fibonacciSequence = new FibonacciSequence();
            fibonacciSequence.calculateFibonacciNumberByLength(length);
            fibonacciSequence.getFibonacci().removeIf(s -> s.length() != length);
            showResult(fibonacciSequence.getFibonacci().toString());
        } else{
            showStandartWarning();
            showInstruction(INSTRUCTION);
        }
    }

    private void startFibonacciSequenceInterval() {
        String min = getBigInteger(MIN_VALUE);
        String max = getBigInteger(MAX_VALUE);
        if (checkNumbersIntervalNumber(min) && checkNumbersIntervalNumber(max)) {
            FibonacciSequence fibonacciSequence = new FibonacciSequence();
            fibonacciSequence.calculateFibonacciNumberToMax(new BigInteger(max));
            fibonacciSequence.getFibonacci()
                    .removeIf(s -> new BigInteger(s).compareTo(new BigInteger(min)) == -1);
            showData(fibonacciSequence.getFibonacci().toString());
        }
        else {
            showStandartWarning();
            showInstruction(INSTRUCTION);
        }
    }

    private String getBigInteger(String message) {
        String string = "";
        do {
            string = inputDataFiltered(message);
            if (StringValidator.isIntegerNumber(string)) {
                return string;
            } else {
                showStandartWarning();
                showInstruction(INSTRUCTION);
            }
        } while (true);
    }

    private boolean checkNumbersLength(int lengthNumber) {
        return lengthNumber > 1 && lengthNumber <= 99;
    }

    private boolean checkNumbersIntervalNumber(String numbers) {
        return numbers.matches("[1-9]\\d{0,98}");
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startFibonacciSequenceLength();
                    continue;
                case 2:
                    startFibonacciSequenceInterval();
                    continue;
                case 3:
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
