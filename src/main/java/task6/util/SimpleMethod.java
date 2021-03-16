package task6.util;

import task6.model.Ticket;

public class SimpleMethod {

    public static boolean sumOfHalfNums(Ticket ticket) {
        if ((ticket.getTicket().length() + 1) % 2 == 0) {
            int[] sum = {0, 0};
            int[] numbers = ticket.getIntArrayFromString();
            int length = numbers.length;
            for (int i = 0; i < length - 1; i++) {
                if (i < length / 2) {
                    sum[0] += numbers[i];
                } else {
                    sum[1] += numbers[i];
                }
            }
            return sum[0] == sum[1];
        }
        return false;
    }
}
