package task8.model;

import java.math.BigInteger;
import java.util.ArrayList;

public class FibonacciSequence {

    //list for sequence
    ArrayList<String> fibonacci = new ArrayList<>();

    //constructor
    public FibonacciSequence(){
        fibonacci.add("0");
        fibonacci.add("1");
    }

    //getter for list
    public ArrayList<String> getFibonacci() {
        return fibonacci;
    }

    //calculating one number fibonacci and add to array
    public String calculateFibonacciNumber(){
        BigInteger temp = new BigInteger(fibonacci.get(fibonacci.size()-1));
        return temp.add(new BigInteger(fibonacci.get(fibonacci.size()-2))).toString();
    }

    //method for adding num to list
    public void addFibonacciNumber(String S){
        fibonacci.add(S);
    }

    //Fibonacci sequence by length of numbers
    public void FibonacciNumberByLength(int lengthOfNumber) {
        while (fibonacci.get(fibonacci.size()-1).length()<lengthOfNumber
                || fibonacci.get(fibonacci.size()-1).length()==lengthOfNumber){
            addFibonacciNumber(calculateFibonacciNumber());
        }
    }

    //Fibonacci sequence to max value
    public void FibonacciNumberToMax(BigInteger max) {
        while (max.compareTo(new BigInteger(fibonacci.get(fibonacci.size()-1)))>=0){
            addFibonacciNumber(calculateFibonacciNumber());
        }
    }

}
