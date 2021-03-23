package task8.model;

import general.converter.StringConverter;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciSequence {

    //list for sequence
    private static List<String> fibonacci;

    //constructor
    private FibonacciSequence(){ }

    //getter for list
    public static List<String> getFibonacci() {
        return fibonacci;
    }

    //calculating one number fibonacci and add to array
    private static String calculateFibonacciNumber(){
        BigInteger temp = new BigInteger(fibonacci.get(fibonacci.size()-1));
        return temp.add(new BigInteger(fibonacci.get(fibonacci.size()-2))).toString();
    }

    //method for adding num to list
    private static void addFibonacciNumber(String S){
        fibonacci.add(S);
    }

    //Fibonacci sequence by length of numbers
    public static void calculateFibonacciNumberByLength(int lengthOfNumber) {
        fibonacci = new ArrayList<>(Arrays.asList("0", "1"));
        while (fibonacci.get(fibonacci.size()-1).length()<=lengthOfNumber){
            addFibonacciNumber(calculateFibonacciNumber());
        }
    }

    //Fibonacci sequence to max value
    public static void calculateFibonacciNumberToMax(BigInteger max) {
        fibonacci =  new ArrayList<>(Arrays.asList("0", "1"));
        while (max.compareTo(new BigInteger(fibonacci.get(fibonacci.size()-1)))>=0){
            addFibonacciNumber(calculateFibonacciNumber());
        }
    }

}
