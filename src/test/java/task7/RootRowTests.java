package task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import task7.util.RootRow;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RootRowTests {

    @ParameterizedTest
    @CsvSource({"0,0", "0x7fffffff,46341", "57,8", "400,20"})
    public void testGetRoundRootValid_IntegerValue(int numberSquare, int numberRoot) {
        //given
        int square = numberSquare;
        //expected
        int expected = numberRoot;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource({"-1,0", "-0x7fffffff,0", "-57,0", "-400,0"})
    public void testGetRoundRootNoneValid_IntegerValue(int numberSquare, int numberRoot){
        //given
        int square = numberSquare;
        //expected
        int expected = numberRoot;
        //actual
        int actual = RootRow.getRoundRoot(square);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"erwqre", "-ew", "vfe", "-423uierf", "3nui23j8", "7896r4", "2.3"})
    public void testGetRoundRootNoneValid_StringValue(String string) {
        //given
        String square = string;

        //actual
        assertThrows(NumberFormatException.class,
                () -> RootRow.getRoundRoot((Integer.parseInt(square))));

    }

    @ParameterizedTest
    @MethodSource("validParametersForFindElements")
    public void testFindElementsValid_IntegerValue(int numberSquare,
                                                   int numberRoot,
                                                   List<Integer> numbers) {
        //given
        int square = numberSquare;
        int count = numberRoot;
        //expected
        List<Integer> expected = numbers;
        //actual
        List<Integer> actual = RootRow.findElements(count, square);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -89, -500, -90000, Integer.MIN_VALUE, Integer.MAX_VALUE+Integer.MAX_VALUE})
    public void testFindElementsNoneValid_GreaterMaxValueCount(int number) {
        //given
        int square = 1;
        int count = number;
        //actual
        assertThrows(IllegalArgumentException.class,
                () -> RootRow.findElements(count, square));
    }

    @ParameterizedTest
    @ValueSource(strings = {"erwqre", "-ew", "vfe", "-423uierf", "3nui23j8", "7896r4", "2.3"})
    public void testFindElementsNoneValid_StringValueCount(String string) {
        //given
        int square = 1;
        String count = string;
        //actual
        assertThrows(NumberFormatException.class,
                () -> RootRow.findElements(Integer.parseInt(count), square));
    }

    private static Stream<Arguments> validParametersForFindElements() {
        return Stream.of(
                Arguments.of(7, 5, Arrays.asList(3, 4, 5, 6, 7)),
                Arguments.of(0, 0, Collections.emptyList()),
                Arguments.of(Integer.MAX_VALUE, 3, Arrays.asList(46341, 46342, 46343)),
                Arguments.of(-Integer.MAX_VALUE,  5, Arrays.asList(0, 1, 2, 3, 4)),
                Arguments.of(-9, 5, Arrays.asList(0, 1, 2, 3, 4))
        );
    }
}
