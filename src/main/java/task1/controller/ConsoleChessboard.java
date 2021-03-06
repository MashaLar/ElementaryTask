package task1.controller;

import task1.model.Chessboard;

public class ConsoleChessboard {

    //symbols for squares
    final private char white= ' '; // symbol of white square ■ - '\u25A0'
    final private char black= '*'; // symbol of black square □ - '\u25A1'

    private Chessboard chessboard;

    public ConsoleChessboard(Chessboard chessboard){
        this.chessboard = chessboard;
    }

    //method for print chessboard
    public String CreateDesk(){
        StringBuilder result = new StringBuilder("\n-----Chessboard-----\n");
        for (int i = 0; i < chessboard.getRows(); i++) {
            for (int j = 0; j < chessboard.getColumns(); j++) {
               result.append(blackOrWhite(i,j));
            }
            result.append("\n");
        }
        return result.toString();
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
