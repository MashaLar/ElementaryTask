package task2.presentation;

import task2.models.Rectangle;

import java.util.Scanner;

public class RectangleProgram {

    private static final String FIRST_SIDE = "Input first side";
    private static final String SECOND_SIDE = "Input second side";

    private final Scanner in = new Scanner(System.in);

    private Rectangle firstRectangle;
    private Rectangle secondRectangle;

    public RectangleProgram(){

    }

    public static void Instruction(){
        System.out.println("Some Instructions");
    }

    private void createRectangle(){

    }



    private void compareResult(int result){
        if(result == 1){
            System.out.println("second in first");
        }
        if(result == -1){
            System.out.println("second cant fit in first");
        }
        else {
            System.out.println("equal");
        }
    }

}
