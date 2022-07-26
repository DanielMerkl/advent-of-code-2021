package day11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DumboOctopusTest {

    @Test
    void partOneTest() {
        final String testInput = """
                11111
                19991
                19191
                19991
                11111""";
        DumboOctopus dumboOctopus = DumboOctopus.fromInput(testInput);

        dumboOctopus.makeSteps(1);

        var expectedOutput = """
                34543
                40004
                50005
                40004
                34543""";
        assertThat(dumboOctopus.currentState()).isEqualTo(expectedOutput);

        dumboOctopus.makeSteps(1);

        expectedOutput = """
                45654
                51115
                61116
                51115
                45654""";
        assertThat(dumboOctopus.currentState()).isEqualTo(expectedOutput);
    }

    @Test
    void partOne() {
        DumboOctopus dumboOctopus = DumboOctopus.fromInput(Input.VALUE);

        dumboOctopus.makeSteps(100);
        assertThat(dumboOctopus.flashCount()).isEqualTo(1625);
    }

    @Test
    void partTwoTest() {
        var testInput = """
                5483143223
                2745854711
                5264556173
                6141336146
                6357385478
                4167524645
                2176841721
                6882881134
                4846848554
                5283751526""";

        DumboOctopus dumboOctopus = DumboOctopus.fromInput(testInput);

        long step = dumboOctopus.firstStepDuringWhichAllOctopusesFlash();

        assertThat(step).isEqualTo(195);
    }

    @Test
    void partTwo() {
        DumboOctopus dumboOctopus = DumboOctopus.fromInput(Input.VALUE);

        long step = dumboOctopus.firstStepDuringWhichAllOctopusesFlash();

        assertThat(step).isEqualTo(244);
    }
}
