package task6.model;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

public class Ticket {

    private String ticket;

    public Ticket(String ticket){
        this.ticket = ticket;
    }

    public int[] getIntArrayFromString(){
        return Stream.of(ticket.split("")).mapToInt(Integer::parseInt).toArray();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ticket))
            return false;
        Ticket ticket1 = (Ticket) o;
        return new BigInteger(ticket).equals(new BigInteger(ticket1.ticket));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }
}
