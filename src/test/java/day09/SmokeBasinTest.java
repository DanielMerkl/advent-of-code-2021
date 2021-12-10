package day09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmokeBasinTest {
    private static final String testInput = """
            2199943210
            3987894921
            9856789892
            8767896789
            9899965678""";

    @Test
    void partOneTest() {
        SmokeBasin smokeBasin = SmokeBasin.fromInput(testInput);

        long result = smokeBasin.partOne();

        assertThat(result).isEqualTo(15);
    }

    @Test
    void partOne() {
        SmokeBasin smokeBasin = SmokeBasin.fromInput(Input.input);

        long result = smokeBasin.partOne();

        assertThat(result).isEqualTo(594);
    }

    @Test
    void partTwoTest() {
        SmokeBasin smokeBasin = SmokeBasin.fromInput(testInput);

        long result = smokeBasin.partTwo();

        assertThat(result).isEqualTo(1134);
    }

    @Test
    void partTwo() {
        SmokeBasin smokeBasin = SmokeBasin.fromInput(Input.input);

        long result = smokeBasin.partTwo();

        assertThat(result).isEqualTo(858494);
    }
}
