package task3.presentation;

public interface TriangleConsoleProgramStringConstants {

    String NAME_PROGRAM = "Triangle program";
    String INSTRUCTION = "------?Instruction?------\n" +
            "This program collects triangles and sort list by their square.\n" +
            "Name of each triangle should be unique!\n" +
            "For one triangle you need to input three numbers - sides (greater than 0 and less than 1000).\n" +
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
    String ALREADY_EXIST_TRIANGLE = "Triangle with such name already exist!";
    String NOT_FOUND_TRIANGLE = "Not found such triangle in list";
    String SUCCESS = "Successful!";

    String INPUT_NAME_OF_TRIANGLE = "Input name of triangle:";
    String INPUT_FIRST_SIDE_OF_TRIANGLE = "First side:";
    String INPUT_SECOND_SIDE_OF_TRIANGLE = "Second side:";
    String INPUT_THIRD_SIDE_OF_TRIANGLE = "Third side:";

}
