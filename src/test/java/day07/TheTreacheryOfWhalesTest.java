package day07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheTreacheryOfWhalesTest {
    private static final String testInput = "16,1,2,0,4,2,7,1,2,14";

    @Test
    void partOneTest() {
        TheTreacheryOfWhales theTreacheryOfWhales = TheTreacheryOfWhales.fromInput(testInput);

        long result = theTreacheryOfWhales.partOne();

        assertThat(result).isEqualTo(37);
    }

    @Test
    void partOne() {
        TheTreacheryOfWhales theTreacheryOfWhales = TheTreacheryOfWhales.fromInput(Input.input);

        long result = theTreacheryOfWhales.partOne();

        assertThat(result).isEqualTo(347449);
    }

    @Test
    void partTwoTest() {
        TheTreacheryOfWhales theTreacheryOfWhales = TheTreacheryOfWhales.fromInput(testInput);

        long result = theTreacheryOfWhales.partTwo();

        assertThat(result).isEqualTo(168);
    }

    @Test
    void partTwo() {
        TheTreacheryOfWhales theTreacheryOfWhales = TheTreacheryOfWhales.fromInput(Input.input);

        long result = theTreacheryOfWhales.partTwo();

        assertThat(result).isEqualTo(98039527);
    }
}
