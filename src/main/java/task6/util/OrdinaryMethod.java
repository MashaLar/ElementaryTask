package task6.util;
import task6.model.Ticket;

public class OrdinaryMethod {

    public boolean sumOfPositionEvenOddNums(Ticket ticket) {
        int[] numbers = ticket.getIntArrayFromString();
        int[] sum = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                sum[0] += numbers[i];
            } else sum[1] += numbers[i];
        }
        return sum[0] == sum[1];
    }
}
