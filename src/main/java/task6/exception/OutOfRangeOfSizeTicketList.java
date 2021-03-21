package task6.exception;

public class OutOfRangeOfSizeTicketList extends ArrayStoreException{
    public OutOfRangeOfSizeTicketList() {
        super("Too big interval!");
    }
}
