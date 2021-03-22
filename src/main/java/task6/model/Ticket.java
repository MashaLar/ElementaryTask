package task6.model;

import java.math.BigInteger;
import java.util.Objects;
import java.util.stream.Stream;

public class Ticket implements Comparable<Ticket>{

    private String valueTicket;

    public Ticket(String valueTicket){
        this.valueTicket = valueTicket;
    }

    public String getValueTicket(){
        return valueTicket;
    }

    public int[] getIntArrayFromString(){
        return Stream.of(valueTicket.split(""))
                .mapToInt(Integer::parseInt).toArray();
    }

    public String addNumToTicket(String number){
        int oldLength = valueTicket.length();
        String newTicket = new BigInteger(valueTicket).add(new BigInteger(number)).toString();
        while(oldLength != newTicket.length() ){
            newTicket = "0"+newTicket;
        }
        return newTicket;
    }

    public BigInteger subNumToTicket(String number){
        return new BigInteger(valueTicket).subtract(new BigInteger(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Ticket))
            return false;
        Ticket ticket1 = (Ticket) o;
        return valueTicket.equals(ticket1.valueTicket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valueTicket);
    }

    @Override
    public int compareTo(Ticket o) {
        return new BigInteger(valueTicket).compareTo(new BigInteger(o.valueTicket));
    }



}
