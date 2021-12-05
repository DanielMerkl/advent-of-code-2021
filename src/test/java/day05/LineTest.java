package day05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void parsesCorrectly() {
        Line line = Line.fromInput("0,9 -> 5,9");

        assertThat(line).isEqualTo(new Line(new Point(0, 9), new Point(5, 9)));
    }

    @ParameterizedTest
    @MethodSource
    void isHorizontal(String input, boolean expected) {
        Line line = Line.fromInput(input);

        assertThat(line.isHorizontal()).isEqualTo(expected);
    }

    public static Stream<Arguments> isHorizontal() {
        return Stream.of(
                Arguments.of("0,9 -> 5,9", true),
                Arguments.of("8,0 -> 0,8", false),
                Arguments.of("9,4 -> 3,4", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isVertical(String input, boolean expected) {
        Line line = Line.fromInput(input);

        assertThat(line.isVertical()).isEqualTo(expected);
    }

    public static Stream<Arguments> isVertical() {
        return Stream.of(
                Arguments.of("0,9 -> 5,9", false),
                Arguments.of("8,0 -> 0,8", false),
                Arguments.of("9,4 -> 3,4", false),
                Arguments.of("2,2 -> 2,1", true)
        );
    }

    @Test
    void getAllPoints() {
        Line line = Line.fromInput("0,9 -> 5,9");

        List<Point> result = line.getAllPoints();

        assertThat(result).containsAll(List.of(
                new Point(0, 9),
                new Point(1, 9),
                new Point(2, 9),
                new Point(3, 9),
                new Point(4, 9),
                new Point(5, 9)
        ));
    }

    @Test
    void getAllPoints2() {
        Line line = Line.fromInput("9,7 -> 7,9");

        List<Point> result = line.getAllPoints();

        assertThat(result).containsAll(List.of(
                new Point(9, 7),
                new Point(8, 8),
                new Point(7, 9)
        ));
    }
}
