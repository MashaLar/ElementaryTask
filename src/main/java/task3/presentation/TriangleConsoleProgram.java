package task3.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task3.exception.NotExistTriangle;
import task3.model.Triangle;
import task3.controller.TriangleList;

import java.util.logging.Logger;

public class TriangleConsoleProgram extends ConsoleApp implements TriangleConsoleProgramStringConstants {

    private final TriangleList triangleList = new TriangleList();

    public TriangleConsoleProgram(boolean commonFlag){
        createStandardTriangleList();
        run(commonFlag);
    }

    private void createNewTriangleAndAddToList(){
        String name = inputDataFiltered(INPUT_NAME_OF_TRIANGLE);
        double triangleFirstSide = getSide(INPUT_FIRST_SIDE_OF_TRIANGLE);
        double triangleSecondSide = getSide(INPUT_SECOND_SIDE_OF_TRIANGLE);
        double triangleThirdSide = getSide(INPUT_THIRD_SIDE_OF_TRIANGLE);
        try {
            Triangle triangle = new Triangle(
                    name,triangleFirstSide,triangleSecondSide,triangleThirdSide);
            showSuccessOrFail(triangleList.addTriangle(triangle), ALREADY_EXIST_TRIANGLE);
        }catch (NotExistTriangle e){
            showWarning(e.getMessage());
        }
    }

    private void deleteTriangleFromList(){
        String name = inputDataFiltered(INPUT_NAME_OF_TRIANGLE);
        showSuccessOrFail(triangleList.removeTriangle(name),NOT_FOUND_TRIANGLE);
    }

    private void showSuccessOrFail(boolean result, String failMessage){
        if(result){
            showResult(SUCCESS);
        }
        else showWarning(failMessage);
    }

    private void printSortedList(){
       showResult(triangleList.toString());
    }

    private double getSide(String message) {
        double result = 0;
        do {
            result = StringConverter
                    .stringToDouble(inputDataFiltered(message));
            if (checkNumber(result)) {
                return result;
            }
            showStandartWarning();
            showInstruction(ConsoleApp.INSTRUCTION);
        } while (true);
    }

    private boolean checkNumber(double number){
        return number != 0.0;
    }

    private void createStandardTriangleList(){
        triangleList.addTriangle(new Triangle("triangle1", 6,6,3));
        triangleList.addTriangle(new Triangle("triangle2", 7,8,4));
        triangleList.addTriangle(new Triangle("triangle3", 2,2,2));
    }

    @Override
    public ConsoleApp run(boolean commonFlag) {
        boolean closeFlag = false;
        do{
            showData(menu(commonFlag));
            int i = StringConverter.stringToInt(inputDataFiltered("Your choice:"));
            switch (i) {
                case 1:
                    createNewTriangleAndAddToList();
                    continue;
                case 2:
                    deleteTriangleFromList();
                    continue;
                case 3:
                    printSortedList();
                    continue;
                case 4:
                    closeFlag = close();
                    break;
                default:
                    showStandartWarning();
                    showInstruction(ConsoleApp.INSTRUCTION);
            }
        }while(!closeFlag);
        if(commonFlag) return new ConsoleProgram();
        else return null;
    }

    private String menu(boolean commonFlag){
        if(commonFlag) return menu(NAME_PROGRAM,COMMON_MENU);
        return menu(NAME_PROGRAM,MENU);
    }
}
