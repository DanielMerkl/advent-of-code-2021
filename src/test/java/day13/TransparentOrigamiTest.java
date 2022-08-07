package day13;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransparentOrigamiTest {

    private static final String TEST_INPUT = """
            6,10
            0,14
            9,10
            0,3
            10,4
            4,11
            6,0
            6,12
            4,1
            0,13
            10,12
            3,4
            3,0
            8,4
            1,10
            2,14
            8,10
            9,0
                        
            fold along y=7
            fold along x=5""";

    @Test
    @DisplayName("parses input correctly")
    void parsesInputCorrectly() {
        final String expectedUnfoldedPaper = """
                ...#..#..#.
                ....#......
                ...........
                #..........
                ...#....#.#
                ...........
                ...........
                ...........
                ...........
                ...........
                .#....#.##.
                ....#......
                ......#...#
                #..........
                #.#........""";

        TransparentOrigami transparentOrigami = TransparentOrigami.fromInput(TEST_INPUT);

        assertEquals(expectedUnfoldedPaper, transparentOrigami.currentFold());
    }

    @Test
    @DisplayName("part one test")
    void partOneTest() {
        TransparentOrigami transparentOrigami = TransparentOrigami.fromInput(TEST_INPUT);

        transparentOrigami.partOne();

        assertEquals(17, transparentOrigami.dotCount());
    }

    @Test
    @DisplayName("part one")
    void partOne() {
        TransparentOrigami transparentOrigami = TransparentOrigami.fromInput(Input.VALUE);

        transparentOrigami.partOne();

        assertEquals(781, transparentOrigami.dotCount());
    }

    @Test
    @DisplayName("part two test")
    void partTwoTest() {
        var expectedResult = """
                #####
                #...#
                #...#
                #...#
                #####
                .....
                .....""";

        TransparentOrigami transparentOrigami = TransparentOrigami.fromInput(TEST_INPUT);

        String result = transparentOrigami.partTwo();

        assertEquals(expectedResult, result);
    }

    @Test
    @DisplayName("part two")
    void partTwo() {
        var expectedResult = """
                ###..####.###...##...##....##.###..###..
                #..#.#....#..#.#..#.#..#....#.#..#.#..#.
                #..#.###..#..#.#....#.......#.#..#.###..
                ###..#....###..#....#.##....#.###..#..#.
                #....#....#.#..#..#.#..#.#..#.#....#..#.
                #....####.#..#..##...###..##..#....###..""";

        TransparentOrigami transparentOrigami = TransparentOrigami.fromInput(Input.VALUE);

        String result = transparentOrigami.partTwo();

        assertEquals(expectedResult, result);
    }

}
