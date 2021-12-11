package day10;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.function.Predicate.not;

record SyntaxScoring(List<Chunk> chunks) {
    static final Map<Character, Integer> pointsPartOne;
    static final Map<Character, Integer> pointsPartTwo;

    static {
        pointsPartOne = new HashMap<>();
        pointsPartOne.put(')', 3);
        pointsPartOne.put(']', 57);
        pointsPartOne.put('}', 1197);
        pointsPartOne.put('>', 25137);

        pointsPartTwo = new HashMap<>();
        pointsPartTwo.put(')', 1);
        pointsPartTwo.put(']', 2);
        pointsPartTwo.put('}', 3);
        pointsPartTwo.put('>', 4);
    }

    static SyntaxScoring fromInput(String input) {
        List<Chunk> chunks = input.lines()
                .map(Chunk::new)
                .toList();

        return new SyntaxScoring(chunks);
    }

    long partOne() {
        return chunks.stream()
                .filter(Chunk::isCorrupted)
                .map(Chunk::firstCorruptedCharacter)
                .mapToLong(pointsPartOne::get)
                .sum();
    }

    public long partTwo() {
        List<Long> scores = chunks.stream()
                .filter(not(Chunk::isCorrupted))
                .map(Chunk::completeLine)
                .map(Chunk::score)
                .sorted(Comparator.naturalOrder())
                .toList();

        return scores.get(scores.size() / 2);
    }
}
