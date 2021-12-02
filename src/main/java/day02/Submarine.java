package day02;

class Submarine {
    private long horizontalPosition;
    private long depth;
    private long aim;

    void processInstructionPartOne(Instruction instruction) {
        long amount = instruction.amount();
        switch (instruction.direction()) {
            case FORWARD -> horizontalPosition += amount;
            case DOWN -> depth += amount;
            case UP -> depth -= amount;
        }
    }

    void processInstructionPartTwo(Instruction instruction) {
        long amount = instruction.amount();
        switch (instruction.direction()) {
            case FORWARD -> {
                horizontalPosition += amount;
                depth += aim * amount;
            }
            case DOWN -> aim += amount;
            case UP -> aim -= amount;
        }
    }

    public long getHorizontalPosition() {
        return horizontalPosition;
    }

    public long getDepth() {
        return depth;
    }

    public long getAim() {
        return aim;
    }
}
