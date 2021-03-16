package task6.model;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

public class Ticket implements Comparable<Ticket>{

    private String ticket;

    public Ticket(String ticket){
        this.ticket = ticket;
    }

    public String getTicket(){
        return ticket;
    }

    public int[] getIntArrayFromString(){
        return Stream.of(ticket.split("")).mapToInt(Integer::parseInt).toArray();
    }

    public String addNumToTicket(int number){
        return new BigInteger(ticket).add(BigInteger.valueOf(number)).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ticket))
            return false;
        Ticket ticket1 = (Ticket) o;
        return ticket.equals(ticket1.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket);
    }

    @Override
    public int compareTo(Ticket o) {
        return new BigInteger(ticket).compareTo(new BigInteger(o.ticket));
    }



}