package day13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DotTest {

    public static Stream<Arguments> parsesInputCorrectly() {
        return Stream.of(
                Arguments.of("0,14", new Dot(0, 14)),
                Arguments.of("9,10", new Dot(9, 10)),
                Arguments.of("0,3", new Dot(0, 3))
        );
    }

    @ParameterizedTest
    @DisplayName("parses input correctly")
    @MethodSource
    void parsesInputCorrectly(String input, Dot expectedDot) {
        Dot dot = Dot.fromInput(input);

        assertEquals(expectedDot, dot);
    }

}
