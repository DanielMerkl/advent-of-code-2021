package day05;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HydrothermalVentureTest {
    private static final String testInput = """
            0,9 -> 5,9
            8,0 -> 0,8
            9,4 -> 3,4
            2,2 -> 2,1
            7,0 -> 7,4
            6,4 -> 2,0
            0,9 -> 2,9
            3,4 -> 1,4
            0,0 -> 8,8
            5,5 -> 8,2""";

    @Test
    void partOneTest() {
        HydrothermalVenture hydrothermalVenture = HydrothermalVenture.fromInput(testInput);

        long result = hydrothermalVenture.partOne();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void partOne() {
        HydrothermalVenture hydrothermalVenture = HydrothermalVenture.fromInput(Input.input);

        long result = hydrothermalVenture.partOne();

        assertThat(result).isEqualTo(5294);
    }

    @Test
    void partTwoTest() {
        HydrothermalVenture hydrothermalVenture = HydrothermalVenture.fromInput(testInput);

        long result = hydrothermalVenture.partTwo();

        assertThat(result).isEqualTo(12);
    }

    @Test
    void partTwo() {
        HydrothermalVenture hydrothermalVenture = HydrothermalVenture.fromInput(Input.input);

        long result = hydrothermalVenture.partTwo();

        assertThat(result).isEqualTo(21698);
    }
}
