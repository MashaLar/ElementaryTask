package task1.presentation;

import task1.model.Chessboard;
import task1.controller.PrintChessboard;

public class ChessboardProgram {

    //constructor for integer type params
    public ChessboardProgram(int m, int n){
        if (checkNumber(m, n)) {
            PrintChessboard printChessboard = new PrintChessboard(new Chessboard(m,n));
            printChessboard.PrintDesk();
        }
        else chessboardInstruction();
    }

    //constructor for string type params
    public ChessboardProgram(String row, String column){
        this(convertToInt(row),convertToInt(column));
    }

    //instruction for program
    public static void chessboardInstruction(){
        System.out.println("Please, input two natural integer numbers (from 1 to 99).\n" +
                "For example:4 5\n" +
                "The first one(m) is count of rows, the second one(n) is count of columns.\n" +
                "This program will print chessboard size m x n. ");
    }

    //method to border size and to check correct input
    private boolean checkNumber(int rows, int columns){
        if(rows>=1 && rows<=100 && columns>=1 && columns<=100){
            return true;
        }
        return false;
    }

    //method to border size and to check correct input of string
    private static int convertToInt(String S){
        if(S.matches("\\d{1,2}")){
            return Integer.parseInt(S);
        }
        return 0;
    }

}
