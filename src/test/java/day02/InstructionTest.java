package day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InstructionTest {

    @ParameterizedTest
    @MethodSource
    void parsesCorrectly(String input, Direction expectedDirection, long expectedAmount) {
        Instruction instruction = Instruction.fromInput(input);

        assertThat(instruction.direction()).isEqualTo(expectedDirection);
        assertThat(instruction.amount()).isEqualTo(expectedAmount);
    }

    public static Stream<Arguments> parsesCorrectly() {
        return Stream.of(
                Arguments.of("forward 5", Direction.FORWARD, 5),
                Arguments.of("down 3", Direction.DOWN, 3),
                Arguments.of("up 1", Direction.UP, 1)
        );
    }
}
