package day05;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;

record HydrothermalVenture(List<Line> lines) {
    static HydrothermalVenture fromInput(String input) {
        List<Line> lines = input.lines()
                .map(Line::fromInput)
                .toList();
        return new HydrothermalVenture(lines);
    }

    long partOne() {
        List<Line> horizontalAndVerticalLines = lines.stream()
                .filter(line -> line.isHorizontal() || line.isVertical())
                .toList();

        return overlapCount(horizontalAndVerticalLines);
    }

    long partTwo() {
        return overlapCount(lines);
    }

    long overlapCount(List<Line> lines) {
        return lines.stream()
                .map(Line::getAllPoints)
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(identity(), counting()))
                .values()
                .stream()
                .filter(occurrence -> occurrence > 1)
                .count();
    }
}
