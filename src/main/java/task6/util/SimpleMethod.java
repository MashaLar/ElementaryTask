package task6.util;

import task6.model.Ticket;

public class SimpleMethod {

    public static boolean sumOfHalfNums(Ticket ticket) {
        if (ticket.getTicket().length() % 2 == 0) {
            return sumOfHalfNumForEvenLength(ticket);
        }
        else {
            return sumOfHalfNumForOddLength(ticket);
        }
    }

    private static boolean sumOfHalfNumForOddLength(Ticket ticket) {
        int[] sum = {0, 0};
        int[] numbers = ticket.getIntArrayFromString();
        int length = numbers.length;
        for (int i = 0; i < length ; i++) {
            if (i < length / 2) {
                sum[0] += numbers[i];
            }
            else if(i>length / 2 ) {
                sum[1] += numbers[i];
            }
        }
        return sum[0] == sum[1];
    }

    private static boolean sumOfHalfNumForEvenLength(Ticket ticket) {
        int[] sum = {0, 0};
        int[] numbers = ticket.getIntArrayFromString();
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            if (i < length / 2) {
                sum[0] += numbers[i];
            } else {
                sum[1] += numbers[i];
            }
        }
        return sum[0] == sum[1];
    }
}
