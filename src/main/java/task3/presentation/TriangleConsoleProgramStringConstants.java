package task3.presentation;

public interface TriangleConsoleProgramStringConstants {

    String NAME_PROGRAM = "Triangle program";
    String INSTRUCTION = "\n--------?Instruction?-------\n" +
            "This program collects Triangles and sort list by their square.\n" +
            "For one Triangle you need to input three numbers (greater than 0 and less than 1000).\n" +
            "Remember that sum of any two sides of triangle should be less than third side.\n" +
            "EXAMPLE. Input first: 3.3 3 5. Input second: 1 3 3.\n" +
            "Output: list of triangles in descending order by their square.\n";
    String[] COMMON_MENU = {
            "create new triangle",
            "delete triangle",
            "show list of triangles",
            "back to task menu"
    };
    String[] MENU = {
            "create new triangle",
            "delete triangle",
            "show list of triangles",
            "exit"
    };
    String SIDE_WARNING_OF_TRIANGLE = "Wrong sides value. Try again!";
    String SUCCESS = "Successful!";
    String FAIL = "Failed!";

    String INPUT_NAME_OF_TRIANGLE = "Input name of triangle:";
    String INPUT_FIRST_SIDE_OF_TRIANGLE = "First side:";
    String INPUT_SECOND_SIDE_OF_TRIANGLE = "Second side:";
    String INPUT_THIRD_SIDE_OF_TRIANGLE = "Third side:";

}
