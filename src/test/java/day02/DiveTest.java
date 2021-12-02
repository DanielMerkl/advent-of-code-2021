package day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiveTest {

    @Test
    void partOneTest() {
        String testInput = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2""";
        Dive dive = Dive.fromInput(testInput);

        long result = dive.partOne();

        assertThat(result).isEqualTo(150);
    }

    @Test
    void partOne() {
        Dive dive = Dive.fromInput(Input.input);

        long result = dive.partOne();

        assertThat(result).isEqualTo(1427868);
    }

    @Test
    void partTwoTest() {
        String testInput = """
                forward 5
                down 5
                forward 8
                up 3
                down 8
                forward 2""";
        Dive dive = Dive.fromInput(testInput);

        long result = dive.partTwo();

        assertThat(result).isEqualTo(900);
    }

    @Test
    void partTwo() {
        Dive dive = Dive.fromInput(Input.input);

        long result = dive.partTwo();

        assertThat(result).isEqualTo(1568138742);
    }
}
