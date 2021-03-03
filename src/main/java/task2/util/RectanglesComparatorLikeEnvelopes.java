package util;

import models.Rectangle;
import models.RightTriangle;

import java.util.Comparator;

public class RectanglesComparatorLikeEnvelopes implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {

        if((r1.getA()>r2.getA() && r1.getB()>r2.getB()) ||
                (r1.getA()>r2.getA() && r1.getB()==r2.getB()) ||
                (r1.getA()==r2.getA() && r1.getB()>r2.getB())){
            return 1;
        }
        else if((r1.getA()<r2.getA() && r1.getB()<r2.getB()) ||
                (r1.getA()<r2.getA() && r1.getB()==r2.getB()) ||
                (r1.getA()==r2.getA() && r1.getB()<r2.getB())){
            return -1;
        }
        else if(r1.getA()==r2.getA() && r1.getB()==r2.getB()){
            return 0;
        }
        else{
            return rectangleAtAngle(r1,r2);
        }
    }

    private int rectangleAtAngle(Rectangle r1, Rectangle r2){
        double OH = RightTriangle.findCathetus(r2.getDiagonal(),r1.getB());
        double HD = (r1.getA()-OH)/2;
        double GD = RightTriangle.findCathetus(r2.getB(),HD);
        double FB = RightTriangle.findCathetus(r2.getA(), r1.getB()-GD);
        if( FB + HD <= r1.getA() ){
            return 1;
        }
        else {return -1;}
    }
}
