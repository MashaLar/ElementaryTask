package task3.presentation;

import task3.model.Triangle;
import task3.util.TriangleList;

import java.util.Scanner;

public class TriangleProgram {

    private final Scanner in = new Scanner(System.in);
    private final TriangleList triangleList = new TriangleList();

    public TriangleProgram(){
        boolean flag;
        do {
            printMenu();
            int choose = in.nextInt();
            flag = chooseFromMenu(choose);
        }while(!flag);
    }

    private void printMenu(){
        System.out.println("______Menu______" +
                "\n1)create new triangle;" +
                "\n2)delete triangle;" +
                "\n3)show list of triangles;" +
                "\n4)exit");
    }

    private boolean chooseFromMenu(int choose){
        switch (choose){
            case 1:
                createNewTriangleAndAddToList();
                return false;
            case 2:
                return false;
            case 3:
                printSortedList();
                return false;
            case 4:
                System.out.println("Good luck!");
                return true;
            default:
                System.out.println("---Wrong choose!---");
                return false;
        }
    }

    private void createNewTriangleAndAddToList(){
        String name = getUsersString("Input name of triangle");
        System.out.println("Input three sides of triangle (side x should be inside interval (0;100]).");
        double a = getUsersDouble("First side:");
        double b = getUsersDouble("Second side:");
        double c = getUsersDouble("Third side:");
        triangleList.addTriangle(new Triangle(name,a,b,c));
    }

    private double getUsersDouble(String text){
        System.out.println(text);
        return in.nextDouble();
    }

    private String getUsersString(String text){
        System.out.println(text);
        return in.nextLine();
    }

    private void deleteTriangleFromList(){
        String name = getUsersString("Input name");
    }

    //method to print list
    private void printSortedList(){
        triangleList.sortBySquare();
        System.out.println("============= Triangles list: ===============");
        int i = 1;
        for (Triangle triangle : triangleList.getTriangleList()) {
            System.out.println( ""+(i++)+"."+triangle.toString());
        }
    }


}
