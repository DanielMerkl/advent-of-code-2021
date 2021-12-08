package day07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

record TheTreacheryOfWhales(List<Integer> horizontalCrabPositions) {

    static TheTreacheryOfWhales fromInput(String input) {
        List<Integer> horizontalCrabPositions = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();

        return new TheTreacheryOfWhales(horizontalCrabPositions);
    }

    long partOne() {
        int min = minPosition();
        int max = maxPosition();

        long result = Long.MAX_VALUE;

        for (int i = min; i < max; i++) {
            final int targetPosition = i;
            long requiredFuel = horizontalCrabPositions.stream()
                    .mapToLong(position -> Math.abs(targetPosition - position))
                    .sum();
            result = Math.min(result, requiredFuel);
        }

        return result;
    }

    private int minPosition() {
        return horizontalCrabPositions.stream()
                .min(Comparator.comparing(Function.identity()))
                .orElseThrow();
    }

    private int maxPosition() {
        return horizontalCrabPositions.stream()
                .max(Comparator.comparing(Function.identity()))
                .orElseThrow();
    }

    public long partTwo() {
        int min = minPosition();
        int max = maxPosition();

        long result = Long.MAX_VALUE;

        for (int i = min; i < max; i++) {
            final int targetPosition = i;
            long requiredFuel = horizontalCrabPositions.stream()
                    .mapToLong(position -> {
                        long diff = Math.abs(targetPosition - position);
                        return diff * (diff + 1) / 2;
                    })
                    .sum();
            result = Math.min(result, requiredFuel);
        }

        return result;
    }
}
