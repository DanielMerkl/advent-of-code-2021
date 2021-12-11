package day10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SyntaxScoringTest {

    private static final String testInput = """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]""";

    @Test
    void partOneTest() {
        SyntaxScoring syntaxScoring = SyntaxScoring.fromInput(testInput);

        long result = syntaxScoring.partOne();

        assertThat(result).isEqualTo(26397);
    }

    @Test
    void partOne() {
        SyntaxScoring syntaxScoring = SyntaxScoring.fromInput(Input.input);

        long result = syntaxScoring.partOne();

        assertThat(result).isEqualTo(366027);
    }

    @Test
    void partTwoTest() {
        SyntaxScoring syntaxScoring = SyntaxScoring.fromInput(testInput);

        long result = syntaxScoring.partTwo();

        assertThat(result).isEqualTo(288957);
    }

    @Test
    void partTwo() {
        SyntaxScoring syntaxScoring = SyntaxScoring.fromInput(Input.input);

        long result = syntaxScoring.partTwo();

        assertThat(result).isEqualTo(1118645287);
    }
}
