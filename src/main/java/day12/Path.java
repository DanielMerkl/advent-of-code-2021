package day12;

import java.util.ArrayList;
import java.util.List;

final class Path {
    private final List<Cave> visitedCaves;
    private final Cave twiceVisitableCave;

    private Path(List<Cave> visitedCaves, Cave twiceVisitableCave) {
        this.visitedCaves = visitedCaves;
        this.twiceVisitableCave = twiceVisitableCave;
    }

    static Path from(Cave startCave) {
        return new Path(List.of(startCave), null);
    }

    static Path fromStartCave() {
        return new Path(List.of(Cave.START_CAVE), null);
    }

    Path withTwiceVisitableCave(Cave twiceVisitableCave) {
        return new Path(visitedCaves, twiceVisitableCave);
    }

    Cave currentCave() {
        return visitedCaves.get(visitedCaves.size() - 1);
    }

    public Path append(Cave cave) {
        List<Cave> caves = new ArrayList<>(visitedCaves);
        caves.add(cave);
        return new Path(caves, twiceVisitableCave);
    }

    boolean canVisit(Cave caveToBeVisited) {
        if (caveToBeVisited.isLarge()) {
            return true;
        }

        if (caveToBeVisited.equals(twiceVisitableCave)) {
            return hasVisitedTwice(caveToBeVisited);
        }

        return !visitedCaves.contains(caveToBeVisited);
    }

    private boolean hasVisitedTwice(Cave cave) {
        return visitedCaves.stream()
                       .filter(c -> c.equals(cave))
                       .count() < 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Path path = (Path) o;

        return visitedCaves.equals(path.visitedCaves);
    }

    @Override
    public int hashCode() {
        return visitedCaves.hashCode();
    }

}
