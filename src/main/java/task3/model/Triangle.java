package task3.model;

import task3.exception.NotExistTriangle;

import java.util.Objects;

public class Triangle {

    //user variables
    private String name;
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    //calculated variables
    private double perimeter;
    private double square;

    //constructor of triangle
    public Triangle(String name, double firstSide, double secondSide, double thirdSide) {
        if(checkTriangle(firstSide, secondSide, thirdSide)) {
            this.name = name;
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
            this.perimeter = findPerimeter();
            this.square = findSquare();
        }
        else throw new NotExistTriangle();
    }

    //getters for variables
    public String getName() {
        return name;
    }
    public double getFirstSide() {
        return firstSide;
    }
    public double getSecondSide() {
        return secondSide;
    }
    public double getThirdSide() {
        return thirdSide;
    }
    public double getPerimeter() {
        return perimeter;
    }
    public double getSquare() {
        return square;
    }

    //calculate perimeter of triangle
    private double findPerimeter(){
        return firstSide + secondSide + thirdSide;
    }

    //calculate square of triangle
    private double findSquare(){
        double halfP = perimeter/2;
        return Math.pow((halfP*(halfP- firstSide)*(halfP- secondSide)*(halfP- thirdSide)),0.5);
    }

    //check sides (is it triangle?)
    private boolean checkTriangle(double firstSide, double secondSide, double thirdSide){
        return firstSide + secondSide >= thirdSide &&
                firstSide + thirdSide >= secondSide &&
                secondSide + thirdSide >= firstSide &&
                firstSide>0 && secondSide>0 && thirdSide>0;
    }

    @Override
    public String toString() {
        return  "[Triangle " + name +"]:"+
                "square= " + square + "c.u.^2";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getFirstSide(), getFirstSide()) == 0 &&
                Double.compare(triangle.getSecondSide(), getSecondSide()) == 0 &&
                Double.compare(triangle.getThirdSide(), getThirdSide()) == 0 &&
                Objects.equals(getName(), triangle.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getFirstSide(), getSecondSide(), getThirdSide());
    }



}
