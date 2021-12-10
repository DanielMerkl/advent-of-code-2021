package day08;

import java.util.*;
import java.util.stream.Collectors;

record SevenSegmentSearch(List<Entry> entries) {
    static SevenSegmentSearch fromInput(String input) {
        List<Entry> entries = input.lines()
                .map(Entry::fromInput)
                .toList();

        return new SevenSegmentSearch(entries);
    }

    long partOne() {
        return entries.stream()
                .map(Entry::output)
                .flatMap(Collection::stream)
                .map(String::length)
                .filter(length -> length == 2 || length == 4 || length == 3 || length == 7)
                .count();
    }

    long partTwo() {
        long result = 0;

        for (Entry entry : entries) {
            List<String> signalPatterns = entry.signalPatterns();

            var decodedValues = new HashMap<Integer, String>();

            decodedValues.put(1, findByLength(signalPatterns, 2));
            decodedValues.put(4, findByLength(signalPatterns, 4));
            decodedValues.put(7, findByLength(signalPatterns, 3));
            decodedValues.put(8, findByLength(signalPatterns, 7));

            decodedValues.put(6, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 6
                                       && !containsAll(pattern, decodedValues.get(1)))
                    .findFirst()
                    .orElseThrow());
            decodedValues.put(9, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 6
                                       && !pattern.equals(decodedValues.get(6))
                                       && containsAll(pattern, decodedValues.get(4)))
                    .findFirst()
                    .orElseThrow());
            decodedValues.put(0, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 6
                                       && !pattern.equals(decodedValues.get(6))
                                       && !pattern.equals(decodedValues.get(9)))
                    .findFirst()
                    .orElseThrow());

            decodedValues.put(3, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 5
                                       && containsAll(pattern, decodedValues.get(1)))
                    .findFirst()
                    .orElseThrow());
            decodedValues.put(5, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 5
                                       && !pattern.equals(decodedValues.get(3))
                                       && containsAll(decodedValues.get(6), pattern))
                    .findFirst()
                    .orElseThrow());
            decodedValues.put(2, signalPatterns.stream()
                    .filter(pattern -> pattern.length() == 5
                                       && !pattern.equals(decodedValues.get(3))
                                       && !pattern.equals(decodedValues.get(5)))
                    .findFirst()
                    .orElseThrow());

            Map<String, Integer> decodedStrings = decodedValues.entrySet()
                    .stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

            String outputValue = entry.output()
                    .stream()
                    .map(decodedStrings::get)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

            result += Long.parseLong(outputValue);
        }

        return result;
    }

    private boolean containsAll(String a, String b) {
        List<String> first = Arrays.stream(a.split(""))
                .toList();
        List<String> second = Arrays.stream(b.split(""))
                .toList();
        return first.containsAll(second);
    }

    private String findByLength(List<String> signalPatterns, int length) {
        return signalPatterns.stream()
                .filter(pattern -> pattern.length() == length)
                .findFirst()
                .orElseThrow();
    }
}
