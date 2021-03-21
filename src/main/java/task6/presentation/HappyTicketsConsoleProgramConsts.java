package task6.presentation;

public interface HappyTicketsConsoleProgramConsts {
    String NAME_PROGRAM = "Happy Tickets program";
    String INSTRUCTION =  "------?Instruction?------\n" +
            "This program need two integer numbers (interval shouldn`t be greater 100000).\n" +
            "First one is minimum ticket, second one is maximum.\n" +
            "Size of ticket will be count of numerals in maximum ticket.\n" +
            "Program will count happy tickets by 3 methods.\n" +
            "First one hard method - sum odd numerals = sum even numerals.\n" +
            "Second one ordinary method - sum of numerals on odd positions = \n" +
            "= sum of numerals on even position.\n" +
            "Third one simple method - sum halves are equal.\n" +
            "EXAMPLE. Input: 34567 234568.\n" +
            "Output: The biggest count of happy tickets get by Simple method\n" +
            "Count of tickets by hard method: 6141\n" +
            "Count of tickets by ordinary method: 10190\n" +
            "Count of tickets by simple method: 10581.\n";
    String[] COMMON_MENU = {
            "get count of happy tickets",
            "back to task menu"
    };
    String[] MENU = {
            "get count of happy tickets",
            "exit"
    };
    String INPUT_MAX = "\nInput max ticket:";
    String INPUT_MIN = "\nInput min ticket:";

    String OUTPUT_WINNER = "\nThe biggest count of happy tickets get by";
    String OUTPUT_DRAW = "\nAll methods equals!";

    String HARD_METHOD_COUNT = "Count of tickets by hard method: ";
    String ORDINARY_METHOD_COUNT = "Count of tickets by ordinary method: ";
    String SIMPLE_METHOD_COUNT = "Count of tickets by simple method: ";

    String HARD_METHOD_NAME = "Hard method";
    String ORDINARY_METHOD_NAME = "Ordinary method";
    String SIMPLE_METHOD_NAME = "Simple method";

    default String getResultOFCompareOfHappyTicketsCount(int hardMethod, int ordinaryMethod, int simpleMethod){
        if(hardMethod>ordinaryMethod && hardMethod>simpleMethod){
            return OUTPUT_WINNER +" "+ HARD_METHOD_NAME;
        }
        else if(ordinaryMethod>hardMethod && ordinaryMethod>simpleMethod){
            return OUTPUT_WINNER +" "+ ORDINARY_METHOD_NAME;
        }
        else if(simpleMethod>hardMethod && simpleMethod>ordinaryMethod){
            return OUTPUT_WINNER +" "+ SIMPLE_METHOD_NAME;
        }
        else if(hardMethod==ordinaryMethod && hardMethod==simpleMethod){
            return OUTPUT_DRAW;
        }
        else if(hardMethod==ordinaryMethod){
            return OUTPUT_WINNER +" "+ HARD_METHOD_NAME+ " and "+ORDINARY_METHOD_NAME;
        }
        else if(hardMethod==simpleMethod){
            return OUTPUT_WINNER +" "+ HARD_METHOD_NAME+ " and "+SIMPLE_METHOD_NAME;
        }
        else {
            return OUTPUT_WINNER +" "+ SIMPLE_METHOD_NAME+ " and "+ORDINARY_METHOD_NAME;
        }
    }

}
