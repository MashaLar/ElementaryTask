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
        return Stream.of(ticket.split(""))
                .mapToInt(Integer::parseInt).toArray();
    }

    public String addNumToTicket(String number){
        int oldLength = ticket.length();
        String newTicket = new BigInteger(ticket).add(new BigInteger(number)).toString();
        while(oldLength != newTicket.length() ){
            newTicket = "0"+newTicket;
        }
        return newTicket;
    }

    public BigInteger subNumToTicket(String number){
        return new BigInteger(ticket).subtract(new BigInteger(number));
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
