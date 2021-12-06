package day06;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

record Lanternfish(Map<Integer, Long> population) {

    static Lanternfish fromInput(String input) {
        // remaining days -> number of fishes with that amount of remaining days
        Map<Integer, Long> population = Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return new Lanternfish(population);
    }

    long simulate(long days) {
        for (int day = 0; day < days; day++) {
            long numberOfNewFishes = numberOfFishesWithRemainingDays(0);
            population.put(0, numberOfFishesWithRemainingDays(1));
            population.put(1, numberOfFishesWithRemainingDays(2));
            population.put(2, numberOfFishesWithRemainingDays(3));
            population.put(3, numberOfFishesWithRemainingDays(4));
            population.put(4, numberOfFishesWithRemainingDays(5));
            population.put(5, numberOfFishesWithRemainingDays(6));
            population.put(6, numberOfFishesWithRemainingDays(7) + numberOfNewFishes);
            population.put(7, numberOfFishesWithRemainingDays(8));
            population.put(8, numberOfNewFishes);
        }

        return population.values()
                .stream()
                .mapToLong(l -> l)
                .sum();
    }

    private long numberOfFishesWithRemainingDays(int remainingDays) {
        return population.getOrDefault(remainingDays, 0L);
    }
}
