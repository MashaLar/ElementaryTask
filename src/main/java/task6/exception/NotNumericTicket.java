package task6.exception;

public class NotNumericTicket extends IllegalArgumentException{

    public NotNumericTicket() {
        super("This is not numeric ticket!");
    }
}
