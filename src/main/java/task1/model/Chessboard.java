package task1.model;

public class Chessboard {

    private int rows; //count of rows for chessboard
    private int columns; //count of columns for chessboard

    //constructor for creating board
    public Chessboard(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
    }

    //getter for rows
    public int getRows() {
        return rows;
    }

    //getter for columns
    public int getColumns() {
        return columns;
    }

}
