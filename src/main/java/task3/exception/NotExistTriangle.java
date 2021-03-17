package task3.exception;

public class NotExistTriangle extends IllegalArgumentException{
    public NotExistTriangle() {
        super("Wrong sides for triangle. This is not triangle!");
    }
}
