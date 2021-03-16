package task6.util;


import task6.model.Ticket;

public class HardMethod {

    public static boolean sumOfEvenOddNums(Ticket ticket){
        int[] sum = {0,0};
        int[] numbers = ticket.getIntArrayFromString();
        for (int number : numbers) {
            if (number % 2 ==0){
                sum[0] += number;
            }
            else sum[1]+=number;
        }
        return sum[0] == sum[1];
    }
}
