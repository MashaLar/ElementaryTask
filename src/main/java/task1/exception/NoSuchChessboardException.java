package task1.exception;

public class NoSuchChessboardException extends IllegalArgumentException{
    public NoSuchChessboardException() {
        super("This is not a chessboard!");
    }
}
