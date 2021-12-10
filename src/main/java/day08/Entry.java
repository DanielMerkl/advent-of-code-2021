package day08;

import java.util.Arrays;
import java.util.List;

record Entry(List<String> signalPatterns, List<String> output) {
    static Entry fromInput(String input) {
        String[] split = input.split(" \\| ");
        List<String> signalPatterns = Arrays.stream(split[0].split(" "))
                .map(Entry::sortAlphabetically)
                .toList();
        List<String> output = Arrays.stream(split[1].split(" "))
                .map(Entry::sortAlphabetically)
                .toList();

        return new Entry(signalPatterns, output);
    }

    private static String sortAlphabetically(String input) {
        return input.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
