package day06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LanternfishTest {

    @ParameterizedTest
    @MethodSource
    void simulate(long days, long expected) {
        String testInput = "3,4,3,1,2";
        Lanternfish lanternfish = Lanternfish.fromInput(testInput);

        long result = lanternfish.simulate(days);

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> simulate() {
        return Stream.of(
                Arguments.of(18, 26),
                Arguments.of(80, 5934),
                Arguments.of(256, 26984457539L)
        );
    }

    @Test
    void partOne() {
        Lanternfish lanternfish = Lanternfish.fromInput(Input.input);

        long result = lanternfish.simulate(80);

        assertThat(result).isEqualTo(377263);
    }

    @Test
    void partTwo() {
        Lanternfish lanternfish = Lanternfish.fromInput(Input.input);

        long result = lanternfish.simulate(256);

        assertThat(result).isEqualTo(1695929023803L);
    }
}
