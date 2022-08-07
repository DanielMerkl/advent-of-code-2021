package day13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FoldTest {

    public static Stream<Arguments> parsesInputCorrectly() {
        return Stream.of(
                Arguments.of("fold along y=7", new Fold(Axis.Y, 7)),
                Arguments.of("fold along x=5", new Fold(Axis.X, 5))
        );
    }

    @ParameterizedTest
    @DisplayName("parses input correctly")
    @MethodSource
    void parsesInputCorrectly(String input, Fold expectedFold) {
        Fold fold = Fold.fromInput(input);

        assertEquals(expectedFold, fold);
    }
}
