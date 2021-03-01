package models;

public class RightTriangle {

    public static double findHypotenuse(double a, double b){
        return Math.pow(a*a+b*b,0.5);
    }
    public static double findCathetus(double c, double b){
        return Math.pow(c*c-b*b,0.5);
    }

}
