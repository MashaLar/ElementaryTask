package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import task7.util.RootRow;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RootRowTests {

    @Test
    public void testGetRoundRootValid_MinValue() {
        //given
        int square = 0;
        //expected
        int expected = 0;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRoundRootValid_MaxValue() {
        //given
        int square = Integer.MAX_VALUE;
        //expected
        int expected = 46341;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRoundRootNoneValid_NegativeValue() {
        //given
        int square = -9;
        //expected
        int expected = 0;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRoundRootNoneValid_GreaterMaxValue() {
        //given
        int square = Integer.MAX_VALUE + Integer.MAX_VALUE;
        //expected
        int expected = 0;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRoundRootNoneValid_TripleGreaterMaxValue() {
        //given
        int square = Integer.MAX_VALUE + Integer.MAX_VALUE + Integer.MAX_VALUE;
        //expected
        int expected = 46341;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testGetRoundRootNoneValid_StringValue() {
        //given
        String square = "rugtirg";
        //expected
        String expected = "java.lang.NumberFormatException: For input string: \"" + square + "\"";
        //actual
        Throwable actual = assertThrows(NumberFormatException.class,
                () -> RootRow.getRoundRoot((Integer.parseInt(square))));

        Assertions.assertEquals(expected, actual.toString());
//        try {
//            RootRow.getRoundRoot((Integer.parseInt(square)));
//        }catch (Exception actual){
//            Assertions.assertEquals(expected,actual.getMessage());
//        }
    }


    @Test
    public void testFindElementsValid_RandomValue() {
        //given
        int square = 7;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(3, 4, 5, 6, 7);
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindElementsValid_MinValue() {
        //given
        int square = 0;
        int count = 0;
        //expected
        List<Integer> expected = Collections.emptyList();
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindElementsValid_MaxValueSquare() {
        //given
        int square = Integer.MAX_VALUE;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(46341, 46342, 46343, 46344, 46345);
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindElementsNoneValid_NegativeSquare() {
        //given
        int square = -9;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindElementsNoneValid_GreaterMaxValueSquare() {
        //given
        int square = Integer.MAX_VALUE + 1;
        int count = 5;
        //expected
        List<Integer> expected = Arrays.asList(0, 1, 2, 3, 4);
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testFindElementsNoneValid_GreaterMaxValueCount() {
        //given
        int square = 1;
        int count = Integer.MAX_VALUE + Integer.MAX_VALUE;
        //expected
        String expected = "java.lang.IllegalArgumentException: " + count;
        //actual
        Throwable actual = assertThrows(IllegalArgumentException.class,
                () -> RootRow.findElements(count, square));

        Assertions.assertEquals(expected, actual.toString());

    }

    @Test
    public void testFindElementsNoneValid_NegativeCount() {
        //given
        int square = 1;
        int count = -5;
        //expected
        String expected = "java.lang.IllegalArgumentException: " + count;
        //actual
        Throwable actual = assertThrows(IllegalArgumentException.class,
                () -> RootRow.findElements(count, square));

        Assertions.assertEquals(expected, actual.toString());

    }

    @Test
    public void testFindElementsNoneValid_StringValueCount() {
        //given
        int square = 1;
        String count = "rugtirg";
        //expected
        String expected = "java.lang.NumberFormatException: For input string: \"" + count + "\"";
        //actual
        Throwable actual = assertThrows(NumberFormatException.class,
                () -> RootRow.findElements(Integer.parseInt(count), square));
        Assertions.assertEquals(expected, actual.toString());

    }


}
