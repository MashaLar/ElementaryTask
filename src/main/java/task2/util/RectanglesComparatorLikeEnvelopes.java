package task2.util;

import task2.models.Rectangle;

public class RectanglesComparatorLikeEnvelopes  {

    private RectanglesComparatorLikeEnvelopes(){}

    public static int compare(Rectangle r1, Rectangle r2) {

        if((r1.getBiggerSide()>r2.getBiggerSide() && r1.getSmallerSide()>r2.getSmallerSide()) ||
                (r1.getBiggerSide()>r2.getBiggerSide() && r1.getSmallerSide()==r2.getSmallerSide()) ||
                (r1.getBiggerSide()==r2.getBiggerSide() && r1.getSmallerSide()>r2.getSmallerSide())||
                (r1.calculateDiagonal()>= r2.getSmallerSide()+r2.getBiggerSide())){
            return 1;
        }
        else if(r1.getBiggerSide()==r2.getBiggerSide() && r1.getSmallerSide()==r2.getSmallerSide()){
            return 0;
        }
        else {
            return -1;
        }
    }


}
