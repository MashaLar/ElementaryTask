package task7.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RootRow {

    private RootRow(){}

    //method for calculate and add numbers to list
    public static List<Integer> findElements(int count, int square) {
        return Stream.iterate(getRoundRoot(square), k -> ++k) // stream for find and add numbers
                .limit(count)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //method for finding rounded root. If square less than 0, than back -1
    public static int getRoundRoot(int square){
            return (int) Math.round(Math.pow(square, 0.5));
    }

}
