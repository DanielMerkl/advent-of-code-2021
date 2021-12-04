package day03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryDiagnosticTest {

    private final String testInput = """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010""";

    @Test
    void gammaRate() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.gammaRate();

        assertThat(result).isEqualTo(22);
    }

    @Test
    void epsilonRate() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.epsilonRate();

        assertThat(result).isEqualTo(9);
    }

    @Test
    void partOneTest() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.partOne();

        assertThat(result).isEqualTo(198);
    }

    @Test
    void partOne() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(Input.input);

        long result = binaryDiagnostic.partOne();

        assertThat(result).isEqualTo(3882564);
    }

    @Test
    void oxygenGeneratorRating() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.oxygenGeneratorRating();

        assertThat(result).isEqualTo(23);
    }

    @Test
    void co2ScrubberRating() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.co2ScrubberRating();

        assertThat(result).isEqualTo(10);
    }

    @Test
    void partTwoTest() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(testInput);

        long result = binaryDiagnostic.partTwo();

        assertThat(result).isEqualTo(230);
    }

    @Test
    void partTwo() {
        BinaryDiagnostic binaryDiagnostic = BinaryDiagnostic.fromInput(Input.input);

        long result = binaryDiagnostic.partTwo();

        assertThat(result).isEqualTo(3385170);
    }

}
