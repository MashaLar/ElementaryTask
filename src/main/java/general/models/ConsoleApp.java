package general.models;

import general.converter.StringConverter;

import java.util.Scanner;

public abstract class ConsoleApp implements Application {

    protected static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "Input number according to chosen action.\n" +
            "EXAMPLE. Input: 1. Output: started one of actions";

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String inputDataFiltered(String someMessage) {
        System.out.println(someMessage);
        return scanner.nextLine().replaceAll("[,;\\s]", "");
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
        System.err.println(someMessage);
    }

    public boolean hasNext(String pattern){
        return scanner.hasNext(pattern);
    }

    public String menu(String nameOfProgram, String... menuPoints){
        StringBuilder menu = new StringBuilder();
        menu.append("\n=========This is "+nameOfProgram+"========\n" +
                "Chose what you want to do:");
        for (int i =0; i< menuPoints.length;i++) {
            menu.append("\n"+(i+1)+")"+menuPoints[i]);
        }
        return menu.toString();
    }

    public boolean close(){
        return StringConverter.StringIgnoreRegisterLow(
                inputDataFiltered("\nDo you want to exit? (press 'y')"))
                        .matches("y");
    }

    public abstract ConsoleApp run(boolean commonFlag);
}
