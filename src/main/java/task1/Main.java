package task1;

import task1.presentation.ChessboardConsoleProgram;

public class Main {
    public static void main(String... args){

        try{
            ChessboardConsoleProgram chessboardConsoleProgram = new ChessboardConsoleProgram(args[0],args[1]);
        }catch (Exception e){
            ChessboardConsoleProgram.chessboardInstruction();
        }

    }
}
