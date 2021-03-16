package task7;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task7.util.RootRow;

import java.util.Arrays;
import java.util.List;

public class RootRowTests {

    @Test
    public void testGetRoundRootValid_MinValue(){

        int square = 7;
        //expected
        int expected = 3;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testGetRoundRootValid_MaxValue(){

        int square = Integer.MAX_VALUE;
        //expected
        int expected = 46341;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testGetRoundRootNoneValid_MinValue(){

    }

    @Test
    public void testGetRoundRootNoneValid_MaxValue(){

    }

    @Test
    public void testFindElementsValid(){

        int square = 7;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(3, 4, 5, 6, 7);
        //actual
        List<Integer> actual = RootRow.findElements(count,square);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testFindElementsValid_MaxValueSquare(){

        int square = Integer.MAX_VALUE;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(46341, 46342, 46343, 46344, 46345);
        //actual
        List<Integer> actual = RootRow.findElements(count,square);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void testFindElementsNoneValidSquare(){

    }

    @Test
    public void testFindElementsNoneValidCount(){

    }

}
