package day11;

class DumboOctopus {
    private final long[][] octopuses;
    private final boolean[][] hasFlashed;
    private long flashCount = 0;

    private DumboOctopus(long[][] octopuses, boolean[][] hasFlashed) {
        this.octopuses = octopuses;
        this.hasFlashed = hasFlashed;
    }

    static DumboOctopus fromInput(String input) {
        String[] lines = input.split("\n");
        long[][] octopuses = new long[lines.length][];
        boolean[][] hasFlashed = new boolean[octopuses.length][];
        for (int i = 0; i < lines.length; i++) {
            octopuses[i] = lines[i].chars()
                    .mapToLong(c -> c - '0')
                    .toArray();
            hasFlashed[i] = new boolean[octopuses[i].length];
        }
        return new DumboOctopus(octopuses, hasFlashed);
    }


    String currentState() {
        StringBuilder sb = new StringBuilder();
        for (long[] octopus : octopuses) {
            for (long octopusValue : octopus) {
                sb.append(octopusValue);
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    void makeSteps(int steps) {
        for (int i = 0; i < steps; i++) {
            incrementAllEnergyLevels();
            triggerFlashes();
            resetEnergyLevelsOfFlashedOctopuses();
        }
    }

    private void resetEnergyLevelsOfFlashedOctopuses() {
        for (int i = 0; i < octopuses.length; i++) {
            for (int j = 0; j < octopuses[i].length; j++) {
                if (hasFlashed[i][j]) {
                    octopuses[i][j] = 0;
                    hasFlashed[i][j] = false;
                }
            }
        }
    }

    private void incrementAllEnergyLevels() {
        for (int i = 0; i < octopuses.length; i++) {
            for (int j = 0; j < octopuses[i].length; j++) {
                octopuses[i][j]++;
            }
        }
    }

    private void triggerFlashes() {
        var hasChanged = false;

        for (int row = 0; row < octopuses.length; row++) {
            for (int col = 0; col < octopuses[row].length; col++) {
                long energyLevel = octopuses[row][col];
                if (energyLevel > 9 && !hasFlashed[row][col]) {
                    hasFlashed[row][col] = true;
                    flash(row, col);
                    hasChanged = true;
                    flashCount++;
                }
            }
        }

        if (hasChanged) {
            triggerFlashes();
        }
    }

    private void flash(int row, int col) {
        incrementAt(row - 1, col - 1);
        incrementAt(row - 1, col);
        incrementAt(row - 1, col + 1);
        incrementAt(row, col - 1);
        incrementAt(row, col + 1);
        incrementAt(row + 1, col - 1);
        incrementAt(row + 1, col);
        incrementAt(row + 1, col + 1);
    }

    private void incrementAt(int row, int col) {
        if (row >= 0 && col >= 0
            && row < octopuses.length && col < octopuses[row].length) {
            octopuses[row][col]++;
        }
    }

    public long flashCount() {
        return flashCount;
    }

    public long firstStepDuringWhichAllOctopusesFlash() {
        long step = 1;
        while (!allOctopusesHaveFlashed()) {
            incrementAllEnergyLevels();
            triggerFlashes();
            if (allOctopusesHaveFlashed()) {
                return step;
            }
            resetEnergyLevelsOfFlashedOctopuses();
            step++;
        }
        return 0;
    }

    private boolean allOctopusesHaveFlashed() {
        for (boolean[] hasFlashedRow : hasFlashed) {
            for (boolean hasFlashedField : hasFlashedRow) {
                if (!hasFlashedField) {
                    return false;
                }
            }
        }
        return true;
    }
}
