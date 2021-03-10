package task7.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RootRow {

    private static List<Integer> rowOfNumbers = new ArrayList<>();

    //TODO catch exceptions/validations -> to another class
    // leave it static methods or make it oop?

    //method for print row
    static public void calculateAndPrintRow(int count, int square){
        try {
            if(isNumber(count) && isSquare(square)) { //check variables
                System.out.print("Natural row: ");
                findElements(count, square); //call method for find and add numbers to list
                System.out.println(rowOfNumbers);
            } else System.out.println("--Wrong param!--");
        }catch (Exception e){
            System.out.println("--Something get wrong!--");
        }
    }

    //method for calculate and add numbers to list
    static private void findElements(int count, int square) {
        rowOfNumbers = Stream.iterate(getRoundRoot(square), k -> ++k) // stream for find and add numbers
                .limit(count)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //method for finding rounded root from minimal border for sequence of natural numbers
    static private int getRoundRoot(int square){
        return (int) Math.round(Math.pow(square, 0.5));
    }

    //check variable for length of row
    static private boolean isNumber(int number){
        if(number>0)return true;
        else return false;
    }

    //check variable for minimal border for sequence of natural numbers
    static private boolean isSquare(int square){
        if(square>=0)return true;
        else return false;
    }



}
