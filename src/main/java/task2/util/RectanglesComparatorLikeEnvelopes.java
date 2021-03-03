package task2.util;

import task2.models.Rectangle;

import java.util.Comparator;

public class RectanglesComparatorLikeEnvelopes implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle r1, Rectangle r2) {

        if((r1.getBiggerSide()>r2.getBiggerSide() && r1.getSmallerSide()>r2.getSmallerSide()) ||
                (r1.getBiggerSide()>r2.getBiggerSide() && r1.getSmallerSide()==r2.getSmallerSide()) ||
                (r1.getBiggerSide()==r2.getBiggerSide() && r1.getSmallerSide()>r2.getSmallerSide())){
            return 1;
        }
        else if((r1.getBiggerSide()<r2.getBiggerSide() && r1.getSmallerSide()<r2.getSmallerSide()) ||
                (r1.getBiggerSide()<r2.getBiggerSide() && r1.getSmallerSide()==r2.getSmallerSide()) ||
                (r1.getBiggerSide()==r2.getBiggerSide() && r1.getSmallerSide()<r2.getSmallerSide())){
            return -1;
        }
        else if(r1.getBiggerSide()==r2.getBiggerSide() && r1.getSmallerSide()==r2.getSmallerSide()){
            return 0;
        }
        else{
            return rectangleAtAngle(r1,r2);
        }
    }

    private int rectangleAtAngle(Rectangle r1, Rectangle r2){
        double OH = Rectangle.findCathetus(r2.calculateDiagonal(),r1.getSmallerSide());
        double HD = (r1.getBiggerSide()-OH)/2;
        double GD = Rectangle.findCathetus(r2.getSmallerSide(),HD);
        double FB = Rectangle.findCathetus(r2.getBiggerSide(), r1.getSmallerSide()-GD);
        if( FB + HD <= r1.getBiggerSide() ){
            return 1;
        }
        else {return -1;}
    }
}
