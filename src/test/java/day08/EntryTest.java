package day08;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EntryTest {

    @Test
    void parsesCorrectly() {
        String testInput = "acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf";

        Entry entry = Entry.fromInput(testInput);

        assertThat(entry.signalPatterns()).containsAll(List.of("acedgfb", "cdfbe", "gcdfa", "fbcad", "dab", "cefabd",
                "cdfgeb", "eafb", "cagedb", "ab"));
        assertThat(entry.output()).containsAll(List.of("cdfeb", "fcadb", "cdfeb", "cdbaf"));
    }
}
