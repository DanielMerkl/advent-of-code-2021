package day13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class TransparentOrigami {

    private final Set<Dot> dots;
    private final List<Fold> folds;
    private int maxX;
    private int maxY;

    private TransparentOrigami(Set<Dot> dots, List<Fold> folds, int maxX, int maxY) {
        this.dots = dots;
        this.folds = folds;
        this.maxX = maxX;
        this.maxY = maxY;
    }

    static TransparentOrigami fromInput(String input) {
        String[] split = input.split("\n\n");
        String initialDots = split[0];
        String folds = split[1];

        Set<Dot> dots = initialDots.lines()
                .map(Dot::fromInput)
                .collect(Collectors.toSet());

        List<Fold> fold = folds.lines()
                .map(Fold::fromInput)
                .toList();

        int maxX = dots.stream()
                .mapToInt(Dot::x)
                .max()
                .orElse(0);

        int maxY = dots.stream()
                .mapToInt(Dot::y)
                .max()
                .orElse(0);

        return new TransparentOrigami(dots, fold, maxX, maxY);
    }

    String currentFold() {
        var sb = new StringBuilder();

        for (int y = 0; y <= maxY; y++) {
            for (int x = 0; x <= maxX; x++) {
                if (dots.contains(new Dot(x, y))) {
                    sb.append("#");
                } else {
                    sb.append(".");
                }
            }
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    void partOne() {
        fold(folds.get(0));
    }

    private void fold(Fold fold) {
        var dotsToBeAdded = new HashSet<Dot>();
        var dotsToBeRemoved = new HashSet<Dot>();

        for (Dot dot : dots) {
            int dotPosition = dot.position(fold.axis());
            boolean isBehindFoldingAxis = dotPosition > fold.position();
            if (!isBehindFoldingAxis) {
                continue;
            }
            int axisDotDistance = Math.abs(dotPosition - fold.position());
            int updatedDotPosition = fold.position() - axisDotDistance;
            Dot updatedDot = dot.changePosition(fold.axis(), updatedDotPosition);
            dotsToBeAdded.add(updatedDot);
            dotsToBeRemoved.add(dot);
        }

        dots.addAll(dotsToBeAdded);
        dots.removeAll(dotsToBeRemoved);

        if (fold.axis() == Axis.X) {
            maxX = fold.position() - 1;
        } else {
            maxY = fold.position() - 1;
        }
    }

    int dotCount() {
        return dots.size();
    }

    String partTwo() {
        folds.forEach(this::fold);

        return currentFold();
    }

}
