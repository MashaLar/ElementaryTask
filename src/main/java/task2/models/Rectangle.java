package task2.models;

import java.util.Objects;

public class Rectangle {

    private double biggerSide; //bigger side of rectangle
    private double smallerSide; //smaller side of rectangle

    private double diagonal; //diagonal of rectangle

    //constructor for rectangle
    public Rectangle(double biggerSide, double smallerSide) {
        if(biggerSide>= smallerSide) {
            this.biggerSide = biggerSide;
            this.smallerSide = smallerSide;
            this.diagonal = getTriangleDiagonal();
        }
        else{
            this.biggerSide = smallerSide;
            this.smallerSide = biggerSide;
            this.diagonal = getTriangleDiagonal();
        }
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

    //getter for diagonal
    public double getDiagonal() {
        return diagonal;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side a = " + biggerSide +
                ", side b=" + smallerSide +
                ", diagonal=" + diagonal +
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
    private double getTriangleDiagonal (){
        return findHypotenuse(biggerSide, smallerSide);
    }

    public static double findHypotenuse(double a, double b){
        return Math.pow(a*a+b*b,0.5);
    }

    public static double findCathetus(double c, double b){
        return Math.pow(c*c-b*b,0.5);
    }
}
