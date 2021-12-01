package day01;

import java.util.List;

record SonarSweep(List<Long> depthMeasurements) {

    static SonarSweep fromInput(String input) {
        List<Long> depthMeasurements = input.lines()
                .map(Long::parseLong)
                .toList();

        return new SonarSweep(depthMeasurements);
    }

    long partOne() {
        int result = 0;

        for (int i = 0; i < depthMeasurements.size() - 1; i++) {
            long current = depthMeasurements.get(i);
            long next = depthMeasurements.get(i + 1);

            if (next > current) {
                result++;
            }
        }

        return result;
    }

    long partTwo() {
        int result = 0;

        for (int i = 1; i < depthMeasurements.size() - 2; i++) {
            long current = slidingWindow(i);
            long next = slidingWindow(i + 1);

            if (next > current) {
                result++;
            }
        }

        return result;
    }

    private long slidingWindow(int index) {
        long previous = depthMeasurements.get(index - 1);
        long current = depthMeasurements.get(index);
        long next = depthMeasurements.get(index + 1);

        return previous + current + next;
    }
}
