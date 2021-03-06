package day08;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SevenSegmentSearchTest {

    private static final String testInput = """
            be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe
            edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc
            fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg
            fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb
            aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea
            fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb
            dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe
            bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef
            egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb
            gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce""";

    @Test
    void partOneTest() {
        SevenSegmentSearch sevenSegmentSearch = SevenSegmentSearch.fromInput(testInput);

        long result = sevenSegmentSearch.partOne();

        assertThat(result).isEqualTo(26);
    }

    @Test
    void partOne() {
        SevenSegmentSearch sevenSegmentSearch = SevenSegmentSearch.fromInput(Input.input);

        long result = sevenSegmentSearch.partOne();

        assertThat(result).isEqualTo(303);
    }

    @Test
    void partTwoTest() {
        SevenSegmentSearch sevenSegmentSearch = SevenSegmentSearch.fromInput(testInput);

        long result = sevenSegmentSearch.partTwo();

        assertThat(result).isEqualTo(61229);
    }

    @Test
    void partTwo() {
        SevenSegmentSearch sevenSegmentSearch = SevenSegmentSearch.fromInput(Input.input);

        long result = sevenSegmentSearch.partTwo();

        assertThat(result).isEqualTo(961734);
    }
}
