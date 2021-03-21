package general.models;

import general.converter.StringConverter;

import java.util.Scanner;


public abstract class ConsoleApp implements Application, StringColorConsts{

    protected static final String INSTRUCTION = "------?Instruction?------\n" +
            "Input number according to chosen action.\n" +
            "EXAMPLE. Input: 1. Output: started one of actions";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputDataFiltered(String someMessage) {
        System.out.println(someMessage);
        return StringConverter.stringIgnoreTabsSpaces(scanner.nextLine());
    }

    @Override
    public void showData(String someData) {
        System.out.println(someData);
    }

    @Override
    public String inputData(String someMessage) {
        System.out.println(someMessage);
        return scanner.nextLine();
    }

    @Override
    public void showWarning(String someMessage) {
        showData(ANSI_RED_BOLD +
                someMessage + ANSI_RESET);
    }

    public void showStandartWarning() {
        showData(ANSI_RED_BOLD +
                "=Wrong input! Please try again!=" + ANSI_RESET);
    }

    public void showInstruction(String instruction) {
        showData(ANSI_CYAN_CURSIVE +
                instruction + ANSI_RESET);
    }

    public void showResult(String result) {
        showData(ANSI_WHITE_BOLD +
                result + ANSI_RESET);
    }

    public String menu(String nameOfProgram, String... menuPoints){
        StringBuilder menu = new StringBuilder();
        menu.append(ANSI_BLUE + "\n=========This is "+nameOfProgram+"========\n" + ANSI_RESET+
                "Chose what you want to do:");
        for (int i =0; i< menuPoints.length;i++) {
            menu.append("\n"+(i+1)+")"+menuPoints[i]);
        }
        return menu.toString();
    }

    public boolean close(){
        return StringConverter.stringIgnoreRegisterLow(
                inputDataFiltered(ANSI_YELLOW +
                        "\nDo you want to exit? (input 'y' or 'yes')" +
                        ANSI_RESET))
                        .matches("y|yes");
    }

    public abstract ConsoleApp run(boolean commonFlag);
}
