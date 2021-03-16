package task1.controller;

import task1.model.Chessboard;

public class PrintChessboard {

    //symbols for squares
    final private char white= '\u25A0'; // symbol of white square
    final private char black= '\u25A1'; // symbol of black square

    private Chessboard chessboard;

    public PrintChessboard(Chessboard chessboard){
        this.chessboard = chessboard;
    }

    //method for print chessboard
    public void PrintDesk(){
        for (int i = 0; i < chessboard.getRows(); i++) {
            for (int j = 0; j < chessboard.getColumns(); j++) {
                System.out.print(blackOrWhite(i,j));
            }
            System.out.print("\n");
        }
    }

    //method for get one square
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


}
