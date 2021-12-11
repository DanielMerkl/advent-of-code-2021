package day10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ChunkTest {

    public static Stream<Arguments> isCorrupted() {
        return Stream.of(
                Arguments.of("()", false),
                Arguments.of("([])", false),
                Arguments.of("[<>({}){}[([])<>]]", false),
                Arguments.of("(]", true),
                Arguments.of("{()()()>", true),
                Arguments.of("(((()))}", true),
                Arguments.of("<([]){()}[{}])", true)
        );
    }

    @ParameterizedTest
    @MethodSource
    void isCorrupted(String brackets, boolean expected) {
        var chunk = new Chunk(brackets);

        boolean corrupted = chunk.isCorrupted();

        assertThat(corrupted).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource
    void firstCorruptedCharacter(String brackets, char expected) {
        var chunk = new Chunk(brackets);

        char result = chunk.firstCorruptedCharacter();

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> firstCorruptedCharacter() {
        return Stream.of(
                Arguments.of("{([(<{}[<>[]}>{[]{[(<()>", '}'),
                Arguments.of("[[<[([]))<([[{}[[()]]]", ')'),
                Arguments.of("[{[{({}]{}}([{[{{{}}([]", ']'),
                Arguments.of("<{([([[(<>()){}]>(<<{{", '>')
        );
    }

    @ParameterizedTest
    @MethodSource
    void completeLine(String brackets, String expected) {
        var chunk = new Chunk(brackets);

        String result = chunk.completeLine();

        assertThat(result).isEqualTo(expected);
    }

    public static Stream<Arguments> completeLine() {
        return Stream.of(
                Arguments.of("[({(<(())[]>[[{[]{<()<>>", "}}]])})]"),
                Arguments.of("[(()[<>])]({[<{<<[]>>(", ")}>]})"),
                Arguments.of("(((({<>}<{<{<>}{[]{[]{}", "}}>}>))))"),
                Arguments.of("{<[[]]>}<{[{[{[]{()[[[]", "]]}}]}]}>"),
                Arguments.of("{<[[]]>}<{[{[{[]{()[[[]", "]]}}]}]}>"),
                Arguments.of("<{([{{}}[<[[[<>{}]]]>[]]", "])}>")
        );
    }

    @ParameterizedTest
    @MethodSource
    void score(String closingBrackets, long expectedScore) {
        long result = Chunk.score(closingBrackets);

        assertThat(result).isEqualTo(expectedScore);
    }

    public static Stream<Arguments> score() {
        return Stream.of(
                Arguments.of("}}]])})]", 288957),
                Arguments.of(")}>]})", 5566),
                Arguments.of("}}>}>))))", 1480781),
                Arguments.of("}}>}>))))", 1480781),
                Arguments.of("]]}}]}]}>", 995444),
                Arguments.of("])}>", 294)
        );
    }
}
