package day05;

import java.util.ArrayList;
import java.util.List;

record Line(Point from, Point to) {
    static Line fromInput(String input) {
        String[] split = input.split(" -> ");
        Point from = Point.fromInput(split[0]);
        Point to = Point.fromInput(split[1]);
        return new Line(from, to);
    }

    boolean isHorizontal() {
        return from.y() == to.y();
    }

    boolean isVertical() {
        return from.x() == to.x();
    }

    List<Point> getAllPoints() {
        var result = new ArrayList<Point>();

        long distanceBetweenPoints = Math.max(Math.abs(from.x() - to.x()), Math.abs(from.y() - to.y()));

        long x = from.x();
        long y = from.y();

        for (long i = 0; i <= distanceBetweenPoints; i++) {
            result.add(new Point(x, y));
            if (x < to.x()) x++;
            if (x > to.x()) x--;
            if (y < to.y()) y++;
            if (y > to.y()) y--;
        }

        return result;
    }
}
