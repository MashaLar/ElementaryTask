package models;

import java.util.Objects;

public class Rectangle {

    private double a; //bigger side of rectangle
    private double b; //smaller side of rectangle

    private double diagonal; //diagonal of rectangle

    //constructor for rectangle
    public Rectangle(double a, double b) {
        if(a>=b) {
            this.a = a;
            this.b = b;
            this.diagonal = getTriangleDiagonal();
        }
        if(a<b){
            this.a = b;
            this.b = a;
            this.diagonal = getTriangleDiagonal();
        }
    }
    //constructor for special case of rectangle - square
    public Rectangle(double a) {
        this(a,a);
    }

    //methods for getting value of sides
    public double getA() {
        return a;
    }
    public double getB() {
        return b;
    }

    //method for changing value of sides
    public void setNewSides(double a, double b) {
        if(a>=b) {
            this.a = a;
            this.b = b;
            this.diagonal = getTriangleDiagonal();
        }
        if(a<b){
            this.a = b;
            this.b = a;
            this.diagonal = getTriangleDiagonal();
        }
        setDiagonal();
    }

    //getter and setter of diagonal
    public double getDiagonal() {
        return diagonal;
    }
    public void setDiagonal() {
        this.diagonal = getTriangleDiagonal();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "side a = " + a +
                ", side b=" + b +
                ", diagonal=" + diagonal +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.getA(), getA()) == 0 &&
                Double.compare(rectangle.getB(), getB()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getA(), getB());
    }

    //method for finding value of diagonal
    private double getTriangleDiagonal (){
        return RightTriangle.findHypotenuse(a,b);
    }

}
