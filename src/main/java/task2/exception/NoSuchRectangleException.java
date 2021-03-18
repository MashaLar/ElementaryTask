package task2.exception;

public class NoSuchRectangleException extends IllegalArgumentException{
    public NoSuchRectangleException() {
        super("No such Rectangle!");
    }
}
