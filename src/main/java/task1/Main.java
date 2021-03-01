package task1;

import task1.model.Chessboard;

public class Main {
    public static void main(String... args){

        try{
            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            Chessboard chessboard = new Chessboard(m,n);
            chessboard.PrintDesk();
        }catch (Exception e){
            Chessboard.Instruction();
        }

    }
}
