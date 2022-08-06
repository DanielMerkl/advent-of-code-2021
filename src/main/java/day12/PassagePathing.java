package day12;

import java.util.*;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

class PassagePathing {
    private final Map<Cave, Set<Cave>> caveConnections;

    private PassagePathing(Map<Cave, Set<Cave>> caveConnections) {
        this.caveConnections = caveConnections;
    }

    static PassagePathing fromInput(String input) {
        var connections = new HashMap<Cave, Set<Cave>>();

        input.lines()
                .forEach(line -> {
                    String[] split = line.split("-");
                    Cave from = new Cave(split[0]);
                    Cave to = new Cave(split[1]);
                    connections.putIfAbsent(from, new HashSet<>());
                    connections.putIfAbsent(to, new HashSet<>());
                    connections.get(from)
                            .add(to);
                    connections.get(to)
                            .add(from);
                });

        return new PassagePathing(connections);
    }

    long partOne() {
        return findAllPossiblePaths(Path.fromStartCave()).size();
    }

    private List<Path> findAllPossiblePaths(Path path) {
        Cave currentCave = path.currentCave();

        List<Cave> possibleNextCaves = caveConnections.get(currentCave)
                .stream()
                .filter(path::canVisit)
                .toList();

        List<Path> allPossiblePaths = new ArrayList<>();

        for (Cave possibleNextCave : possibleNextCaves) {
            Path extendedPath = path.append(possibleNextCave);
            if (possibleNextCave.isEnd()) {
                allPossiblePaths.add(extendedPath);
            } else {
                allPossiblePaths.addAll(findAllPossiblePaths(extendedPath));
            }
        }

        return allPossiblePaths;
    }

    long partTwo() {
        Stream<Cave> cavesWithoutStartingCave = caveConnections.keySet()
                .stream()
                .filter(not(Cave::isStart));

        Stream<Path> pathsWithDifferentTwiceVisitableCaves = cavesWithoutStartingCave
                .map(cave -> Path.fromStartCave()
                        .withTwiceVisitableCave(cave));

        return pathsWithDifferentTwiceVisitableCaves
                .flatMap(path -> findAllPossiblePaths(path).stream())
                .distinct()
                .count();
    }

}
