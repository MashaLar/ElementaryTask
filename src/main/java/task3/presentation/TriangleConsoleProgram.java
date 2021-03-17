package task3.presentation;

import general.converter.StringConverter;
import general.models.ConsoleApp;
import general.models.ConsoleProgram;
import task3.exception.NotExistTriangle;
import task3.model.Triangle;
import task3.controller.TriangleList;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TriangleConsoleProgram extends ConsoleApp implements TriangleConsoleProgramStringConstants {

    private static final TriangleList triangleList = new TriangleList();
    private static Logger log = Logger.getLogger(TriangleConsoleProgram.class.getName());

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
            if(triangleList.addTriangle(triangle)){
                showData(SUCCESS);
            }
            else showWarning(FAIL);
        }catch (NotExistTriangle e){
            log.warning( "Exception: "+ e);
            //showWarning(SIDE_WARNING_OF_TRIANGLE);
        }
    }

    private void deleteTriangleFromList(){
        String name = inputDataFiltered(INPUT_NAME_OF_TRIANGLE);
        if(triangleList.removeTriangle(name)){
            showData(SUCCESS);
        }
        else showWarning(FAIL);
    }

    private void printSortedList(){
       showData(triangleList.toString());
    }

    private double getSide(String message) {
        double result = 0;
        do {
            result = StringConverter
                    .StringToDouble(inputDataFiltered(message));
            if (checkNumber(result)) {
                return result;
            }
            showData(TriangleConsoleProgramStringConstants.INSTRUCTION);
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
            int i = StringConverter.StringToInt(inputDataFiltered("Your choice:"));
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
                    showData(ConsoleApp.INSTRUCTION);
            }
        }while(!closeFlag); //race between threads warning and close
        if(commonFlag) return new ConsoleProgram();
        else return null;
    }

    private String menu(boolean commonFlag){
        if(commonFlag) return menu(NAME_PROGRAM,COMMON_MENU);
        return menu(NAME_PROGRAM,MENU);
    }
}
