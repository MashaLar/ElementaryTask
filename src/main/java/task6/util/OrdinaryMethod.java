package task6.util;
import task6.model.Ticket;

//enum realisation of singleton
public enum OrdinaryMethod implements HappyMethods{

    INSTANCE;

    @Override
    public boolean isHappy(Ticket ticket) {
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
