package task1;

import task1.presentation.ChessboardProgram;

public class Main {
    public static void main(String... args){

        try{
            ChessboardProgram chessboardProgram = new ChessboardProgram(args[0],args[1]);
        }catch (Exception e){
            ChessboardProgram.chessboardInstruction();
        }

    }
}
