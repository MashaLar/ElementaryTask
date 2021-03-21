package task6.model;

import task6.exception.OutOfRangeOfSizeTicketList;
import task6.util.HardMethod;
import task6.util.OrdinaryMethod;
import task6.util.SimpleMethod;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TicketsList {

    private List<Ticket> tickets;

    public TicketsList(String start, String end){
        tickets = new ArrayList<>();
        Ticket endTicket = getEndTicket(start, end);
        while (tickets.get(tickets.size()-1).compareTo(endTicket)!=0){
            tickets.add(new Ticket(tickets.get(tickets.size()-1).addNumToTicket("1")));
        }
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public int countOfHappyTicketsHardMethod(){
        int count = 0;
        for (Ticket ticket : tickets) {
            if(HardMethod.sumOfEvenOddNums(ticket)){
                count++;
            }
        }
        return count;
    }

    public int countOfHappyTicketsOrdinaryMethod(){
        int count = 0;
        for (Ticket ticket : tickets) {
            if(OrdinaryMethod.sumOfPositionEvenOddNums(ticket)){
                count++;
            }
        }
        return count;
    }

    public int countOfHappyTicketsSimpleMethod(){
        int count = 0;
        for (Ticket ticket : tickets) {
            if(SimpleMethod.sumOfHalfNums(ticket)){
                count++;
            }
        }
        return count;
    }

    private Ticket getEndTicket(String start, String end){
        Ticket firstTicket = new Ticket(start);
        Ticket secondTicket = new Ticket(end);
        if(checkSizeOfInterval(firstTicket,secondTicket)) {
            if (firstTicket.compareTo(secondTicket) != -1) {
                tickets.add(secondTicket);
                return firstTicket;
            } else {
                tickets.add(firstTicket);
                return secondTicket;
            }
        }
        else throw new OutOfRangeOfSizeTicketList();
    }

    private boolean checkSizeOfInterval(Ticket first, Ticket second){
        return first.subNumToTicket(second.getTicket()).abs()
                .compareTo(BigInteger.valueOf(100000))!=1;
    }
}
