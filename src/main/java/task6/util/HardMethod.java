package task6.util;

import task6.model.Ticket;

//enum realisation of singleton
public enum HardMethod implements HappyMethods {

    INSTANCE;

    //sum of odd numbers equals sum of even numbers
    public boolean isHappy(Ticket ticket){
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
