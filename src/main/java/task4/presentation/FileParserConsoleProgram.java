package task4.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import general.validation.StringValidator;
import task4.model.FileParser;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileParserConsoleProgram extends ConsoleApp {

    private static final String NAME_PROGRAM = "File Parser program";
    private static final String INSTRUCTION = "------?Instruction?------\n" +
            "This program need path to file and phrase/word.\n" +
            "File Parser will show count of occurrence this pattern in file\n" +
            "or change pattern to another.\n" +
            "Path should be absolute or your file should be in one folder.\n" +
            "EXAMPLE. Input: G:\\3 курс\\2 семестр\\TAQC\\test.txt Hello world.\n" +
            "Output: Count of \"Hello world\": 9.\n";
    private static final String[] COMMON_MENU = {
            "count phrase/word occurrence",
            "replace phrase/word",
            "back to task menu"
    };
    private static final String[] MENU = {
            "count phrase/word occurrence",
            "replace phrase/word",
            "exit"
    };
    private static final String INPUT_PATH = "\nInput path (recommended absolute path):";
    private static final String INPUT_PATTERN = "\nInput word or phrase:";
    private static final String OUTPUT_RESULT = "\nCount of";

    //constructor
    public FileParserConsoleProgram(boolean commonFlag) {
        run(commonFlag);
    }

    private void startCountFileParserConsoleProgram() {
        String filePath = inputData(INPUT_PATH);
        if (StringValidator.isPath(filePath)) {
            String pattern = inputData(INPUT_PATTERN);
            try {
                showResult(OUTPUT_RESULT + " \"" + pattern + "\": " +
                        FileParser.countOfRegex(filePath,pattern));
            } catch (FileNotFoundException e) {
                showWarning(e.getMessage());
            }
            catch (IOException e) {
                showWarning(e.getMessage());
            }
        } else {
            showStandartWarning();
            showInstruction(INSTRUCTION);
        }
    }

    private void startReplaceFileParserConsoleProgram() {
        String filePath = inputData(INPUT_PATH);
        if (StringValidator.isPath(filePath)) {
            String pattern = inputData(INPUT_PATTERN);
            String newPattern = inputData(INPUT_PATTERN);
            try {
                if(FileParser.replaceOfRegex(filePath,pattern,newPattern)){
                    showResult("Successful!");
                }
            } catch (FileNotFoundException e) {
                showWarning(e.getMessage());
            }
            catch (IOException e) {
                showWarning(e.getMessage());
            }
        } else {
            showStandartWarning();
            showInstruction(INSTRUCTION);
        }
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do {
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    startCountFileParserConsoleProgram();
                    continue;
                case 2:
                    startReplaceFileParserConsoleProgram();
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
