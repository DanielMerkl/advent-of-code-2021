package day12;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaveTest {

    public static Stream<Arguments> isSmall() {
        return Stream.of(
                Arguments.of("a", true),
                Arguments.of("aa", true),
                Arguments.of("A", false),
                Arguments.of("AA", false),
                Arguments.of("start", true),
                Arguments.of("end", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isSmall(String input, boolean expected) {
        var cave = new Cave(input);
        assertEquals(expected, cave.isSmall());
    }

}
