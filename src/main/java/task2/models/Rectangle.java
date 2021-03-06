package task2.models;

import task2.exception.NoSuchRectangleException;

import java.util.Objects;

public class Rectangle {

    private final double biggerSide; //bigger side of rectangle
    private final double smallerSide; //smaller side of rectangle

    //constructor for rectangle
    public Rectangle(double biggerSide, double smallerSide) {
        if(checkRectangle(biggerSide, smallerSide)) {
            if (biggerSide >= smallerSide) {
                this.biggerSide = biggerSide;
                this.smallerSide = smallerSide;
            } else {
                this.biggerSide = smallerSide;
                this.smallerSide = biggerSide;
            }
        }
        else throw new NoSuchRectangleException();
    }
    //constructor for special case of rectangle - square
    public Rectangle(double biggerSide) {
        this(biggerSide,biggerSide);
    }

    //methods for getting value of sides
    public double getBiggerSide() {
        return biggerSide;
    }
    public double getSmallerSide() {
        return smallerSide;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side a = " + biggerSide +
                ", side b=" + smallerSide +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getBiggerSide(), getBiggerSide()) == 0 &&
                Double.compare(rectangle.getSmallerSide(), getSmallerSide()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBiggerSide(), getSmallerSide());
    }

    //method for finding value of diagonal
    public double calculateDiagonal (){
        return Math.pow(biggerSide*biggerSide+smallerSide*smallerSide, 0.5);
    }

    private boolean checkRectangle(double biggerSide, double smallerSide){
        return biggerSide>0 && smallerSide>0;
    }

}
