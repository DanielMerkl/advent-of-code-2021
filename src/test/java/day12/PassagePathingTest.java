package day12;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassagePathingTest {

    private static final String TEST_INPUT_1 = """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end""";

    private static final String TEST_INPUT_2 = """
            dc-end
            HN-start
            start-kj
            dc-start
            dc-HN
            LN-dc
            HN-end
            kj-sa
            kj-HN
            kj-dc""";

    private static final String TEST_INPUT_3 = """
            fs-end
            he-DX
            fs-he
            start-DX
            pj-DX
            end-zg
            zg-sl
            zg-pj
            pj-he
            RW-he
            fs-DX
            pj-RW
            zg-RW
            start-pj
            he-WI
            zg-he
            pj-fs
            start-RW""";

    public static Stream<Arguments> partOneTest() {
        return Stream.of(
                Arguments.of(TEST_INPUT_1, 10),
                Arguments.of(TEST_INPUT_2, 19),
                Arguments.of(TEST_INPUT_3, 226)
        );
    }

    public static Stream<Arguments> partTwoTest() {
        return Stream.of(
                Arguments.of(TEST_INPUT_2, 103),
                Arguments.of(TEST_INPUT_3, 3509)
        );
    }

    @ParameterizedTest
    @MethodSource
    void partOneTest(String input, long expected) {
        PassagePathing testPathing = PassagePathing.fromInput(input);

        long result = testPathing.partOne();

        assertEquals(expected, result);
    }

    @Test
    void partOne() {
        PassagePathing pathing = PassagePathing.fromInput(Input.VALUE);

        long result = pathing.partOne();

        assertEquals(4167, result);
    }

    @ParameterizedTest
    @MethodSource
    void partTwoTest(String input, long expected) {
        PassagePathing testPathing = PassagePathing.fromInput(input);

        long result = testPathing.partTwo();

        assertEquals(expected, result);
    }

    @Test
    void partTwo() {
        PassagePathing pathing = PassagePathing.fromInput(Input.VALUE);

        long result = pathing.partTwo();

        assertEquals(98441, result);
    }

}
