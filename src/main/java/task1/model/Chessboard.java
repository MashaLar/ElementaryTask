package task1.model;

import java.util.stream.Stream;

public class Chessboard {

    //symbols for squares
    final private char white= '\u25A0'; // symbol of white square
    final private char black= '\u25A1'; // symbol of black square

    private int rows; //count of rows for chessboard
    private int columns; //count of columns for chessboard

    //constructor for creating board
    public Chessboard(int rows, int columns) {
        if (checkNumber(rows, columns)) {
            this.rows = rows;
            this.columns = columns;
        }
        else Instruction();
    }

    //Instruction how to use this class
    public static void Instruction(){
        System.out.println("Please, input two natural integer numbers (from 1 to 1000). " +
                "The first one(m) is count of rows, the second one(n) is count of columns. " +
                "This program will print chessboard size m x n. ");
    }

    //method for print chessboard
    public void PrintDesk(){
        Stream.iterate(0, i -> i = ++i)
                .limit(rows)
                .forEach(i -> printRow(i));
    }

    //method for print one row
    private void printRow(int i){
        Stream.iterate(0, j -> j = ++j)
                .limit(columns)
                .forEach(j -> System.out.print(blackOrWhite(i, j)));
        System.out.print("\n");
    }

    //method for print one square
    private String blackOrWhite(int i, int j){
        if(i%2==0 && j%2==0){
            return ""+black;
        }
        else if(i%2==0 && j%2!=0){
            return ""+white;
        }
        else if(i%2!=0 && j%2==0){
            return ""+white;
        }
        else {
            return ""+black;
        }
    }

    //method to border size and to check correct input
    private boolean checkNumber(int rows, int columns){
        if(rows>=1 && rows<=100 && columns>=1 && columns<=100){
            return true;
        }
        else return false;
    }

}
