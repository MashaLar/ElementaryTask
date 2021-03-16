package task7.presentation;

public class RootRowConsoleProgram {

    private static final String NAME_PROGRAM = "RootRow program";
    private static final String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program need two numbers. First one is count of numbers in row,\n" +
            "second one is square of number that less than first element of row.\n" +
            "EXAMPLE. Input: 4 9. Output: [3, 4, 5, 6].\n";
    private static final String WARNING_COUNT = "\n--!Please, don`t input count of numbers greater than 1000!--\n";
    private static final String WARNING_SQUARE = "\n--!Please, don`t input square number greater than 1 000 000!--\n";
    private static final String[] MENU = {"get natural row of elements which square greater than some number", "exit"};

    public void run(){

    }

    private String menu(){
        return "=========Welcome to "+NAME_PROGRAM+"========" +
                "Chose what you want to do:" +
                "\n1)"+ MENU[0] +";" +
                // "\n2)go to menu of tasks;"+
                "\n2)"+ MENU[1] + ".";
    }

//    private int getIntNumberFromUser(String message, String warning){
//        do{
//            System.out.println(message);
//            StringBuilder s =in.nextline();
//            if(isNumber(s)){
//                return convertToNumber(s);}
//            else{
//                System.out.println(warning);
//            }
//        }
//        while(true);
//    }

}
