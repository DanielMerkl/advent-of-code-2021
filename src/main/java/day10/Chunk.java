package day10;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

record Chunk(String brackets) {
    private static final Map<Character, Character> openingBrackets;
    private static final Map<Character, Character> closingBrackets;

    static {
        openingBrackets = new HashMap<>();
        openingBrackets.put(')', '(');
        openingBrackets.put(']', '[');
        openingBrackets.put('}', '{');
        openingBrackets.put('>', '<');

        closingBrackets = openingBrackets.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    boolean isCorrupted() {
        var stack = new ArrayDeque<Character>();

        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(', '[', '{', '<' -> stack.add(bracket);
                default -> {
                    if (stack.pollLast() != openingBrackets.get(bracket)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    char firstCorruptedCharacter() {
        var stack = new ArrayDeque<Character>();

        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(', '[', '{', '<' -> stack.add(bracket);
                default -> {
                    if (stack.pollLast() != openingBrackets.get(bracket)) {
                        return bracket;
                    }
                }
            }
        }

        throw new RuntimeException("Chunk is not corrupted!");
    }

    String completeLine() {
        var stack = new ArrayDeque<Character>();

        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(', '[', '{', '<' -> stack.add(bracket);
                default -> stack.pollLast();
            }
        }

        String closingBrackets = stack.stream()
                .map(Chunk.closingBrackets::get)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return new StringBuilder(closingBrackets).reverse()
                .toString();
    }

    static long score(String closingBrackets) {
        long score = 0;

        for (char closingBracket : closingBrackets.toCharArray()) {
            score *= 5;
            score += SyntaxScoring.pointsPartTwo.get(closingBracket);
        }

        return score;
    }
}
