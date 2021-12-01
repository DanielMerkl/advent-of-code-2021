package day01;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SonarSweepTest {

    @Test
    void partOneTest() {
        String testInput = """
                199
                200
                208
                210
                200
                207
                240
                269
                260
                263""";

        SonarSweep sonarSweep = SonarSweep.fromInput(testInput);

        long result = sonarSweep.partOne();

        assertThat(result).isEqualTo(7);
    }

    @Test
    void partOne() {
        SonarSweep sonarSweep = SonarSweep.fromInput(Input.input);

        long result = sonarSweep.partOne();

        assertThat(result).isEqualTo(1292);
    }

    @Test
    void partTwoTest() {
        String testInput = """
                607
                618
                618
                617
                647
                716
                769
                792""";

        SonarSweep sonarSweep = SonarSweep.fromInput(testInput);

        long result = sonarSweep.partTwo();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void partTwo() {
        SonarSweep sonarSweep = SonarSweep.fromInput(Input.input);

        long result = sonarSweep.partTwo();

        assertThat(result).isEqualTo(1262);
    }
}
