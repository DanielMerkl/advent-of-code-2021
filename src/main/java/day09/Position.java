package day09;

import java.util.List;

record Position(int x, int y) {
    List<Position> neighbors() {
        return List.of(
                new Position(x + 1, y),
                new Position(x, y + 1),
                new Position(x - 1, y),
                new Position(x, y - 1)
        );
    }
}
