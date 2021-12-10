package day09;

import java.util.*;

record SmokeBasin(int[][] heightmap) {
    static SmokeBasin fromInput(String input) {
        String[] lines = input.split("\n");

        var heightmap = new int[lines.length + 2][lines[0].length() + 2];

        Arrays.stream(heightmap)
                .forEach(row -> Arrays.fill(row, 9));

        for (int y = 0; y < lines.length; y++) {
            String line = lines[y];
            char[] charArray = line.toCharArray();
            for (int x = 0; x < charArray.length; x++) {
                int height = Integer.parseInt(String.valueOf(charArray[x]));
                heightmap[y + 1][x + 1] = height;
            }
        }

        return new SmokeBasin(heightmap);
    }

    long partOne() {
        return getLowPoints().stream()
                .mapToLong(position -> heightmap[position.y()][position.x()] + 1)
                .sum();
    }

    private List<Position> getLowPoints() {
        var lowPoints = new ArrayList<Position>();

        for (int y = 1; y < heightmap.length - 1; y++) {
            int[] row = heightmap[y];
            for (int x = 1; x < row.length - 1; x++) {
                int height = row[x];
                if (height < heightmap[y - 1][x] &&
                    height < heightmap[y][x - 1] &&
                    height < heightmap[y + 1][x] &&
                    height < heightmap[y][x + 1]) {
                    lowPoints.add(new Position(x, y));
                }
            }
        }

        return lowPoints;
    }

    long partTwo() {
        return getLowPoints().stream()
                .map(this::basinSize)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .mapToLong(Long::longValue)
                .reduce(1, (left, right) -> left * right);
    }

    private long basinSize(Position startPosition) {
        var queue = new ArrayDeque<Position>();
        var visited = new HashSet<Position>();

        queue.add(startPosition);

        while (!queue.isEmpty()) {
            Position currentNode = queue.remove();
            visited.add(currentNode);

            List<Position> neighbors = currentNode.neighbors()
                    .stream()
                    .filter(position -> heightmap[position.y()][position.x()] != 9)
                    .toList();

            queue.addAll(neighbors);
            queue.removeAll(visited);
        }

        return visited.size();
    }
}
