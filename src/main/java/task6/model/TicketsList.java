package task6.model;

import task6.util.HardMethod;
import task6.util.OrdinaryMethod;
import task6.util.SimpleMethod;

import java.util.ArrayList;
import java.util.List;

public class TicketsList {

    private List<Ticket> tickets;

    public TicketsList(String start, String end){
        tickets = new ArrayList<>();
        tickets.add(new Ticket(start));
        Ticket endTicket = new Ticket(end);
        while (tickets.get(tickets.size()-1).compareTo(endTicket)!=0){
            tickets.add(new Ticket(tickets.get(tickets.size()-1).addNumToTicket(1)));
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

}
