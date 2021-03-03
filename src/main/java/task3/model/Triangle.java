package task2.model;

import java.util.Objects;

public class Triangle {

    private String name;
    private double a;
    private double b;
    private double c;

    private double perimeter;
    private double HalfP;
    private double square;

    public Triangle(String name, double a, double b, double c) {
        if(checkTriangle()) {
            this.name = name;
            this.a = a;
            this.b = b;
            this.c = c;
            this.perimeter = findPerimeter();
            this.HalfP = this.perimeter / 2;
            this.square = findSquare();
        }
        else {
            System.out.println("--Wrong sides!--");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public double getA() {
        return a;
    }
    public void setA(double a) {
        this.a = a;
        setPerimeter();
    }

    public double getB() {
        return b;
    }
    public void setB(double b) {
        this.b = b;
        setPerimeter();
    }

    public double getC() {
        return c;
    }
    public void setC(double c) {
        this.c = c;
        setPerimeter();
    }

    public double getPerimeter() {
        return perimeter;
    }
    public void setPerimeter() {
        this.perimeter = findPerimeter();
        setHalfP();
        setSquare();
    }

    public void setHalfP() {
        HalfP = this.perimeter/2;
    }

    public double getSquare() {
        return square;
    }
    public void setSquare() {
        this.square = findSquare();
    }

    @Override
    public String toString() {
        return  "[Triangle " + name + "]:"+
                " a= " + a +
                "cm, b= " + b +
                "cm, c= " + c +
                "cm, perimeter= " + perimeter +
                "cm, square= " + square +" cm^2";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.getA(), getA()) == 0 &&
                Double.compare(triangle.getB(), getB()) == 0 &&
                Double.compare(triangle.getC(), getC()) == 0 &&
                Objects.equals(getName(), triangle.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getA(), getB(), getC());
    }

    private double findPerimeter(){
        return a+b+c;
    }

    private double findSquare(){
        return Math.pow((HalfP*(HalfP-a)*(HalfP-b)*(HalfP-c)),0.5);
    }

    private boolean checkTriangle(){
        if (a + b > c && a + c > b && b + c > a) {
            return false;
        }
        return true;
    }

}
