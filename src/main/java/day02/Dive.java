package day02;

import java.util.List;

final class Dive {
    private final Submarine submarine = new Submarine();
    private final List<Instruction> instructions;

    private Dive(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    static Dive fromInput(String input) {
        List<Instruction> instructions = input.lines()
                .map(Instruction::fromInput)
                .toList();

        return new Dive(instructions);
    }

    long partOne() {
        instructions.forEach(submarine::processInstructionPartOne);

        return submarine.getHorizontalPosition() * submarine.getDepth();
    }

    long partTwo() {
        instructions.forEach(submarine::processInstructionPartTwo);

        return submarine.getHorizontalPosition() * submarine.getDepth();
    }

}
