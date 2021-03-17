package task1.model;

import task1.exception.NoSuchChessboardException;

public class Chessboard {

    private int rows; //count of rows for chessboard
    private int columns; //count of columns for chessboard

    //constructor for creating board
    public Chessboard(int rows, int columns) {
        if(checkChessboard(rows,columns)) {
            this.rows = rows;
            this.columns = columns;
        }
        else throw new NoSuchChessboardException();
    }

    //getter for rows
    public int getRows() {
        return rows;
    }

    //getter for columns
    public int getColumns() {
        return columns;
    }

    private boolean checkChessboard(int rows, int columns){
        return rows>=2 && columns>=2;
    }

}
