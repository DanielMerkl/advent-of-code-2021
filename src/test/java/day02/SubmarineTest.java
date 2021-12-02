package day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SubmarineTest {

    @Test
    void processInstructionPartOne() {
        Submarine submarine = new Submarine();

        submarine.processInstructionPartOne(new Instruction(Direction.FORWARD, 5));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(5);
        submarine.processInstructionPartOne(new Instruction(Direction.DOWN, 5));
        assertThat(submarine.getDepth()).isEqualTo(5);
        submarine.processInstructionPartOne(new Instruction(Direction.FORWARD, 8));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(13);
        submarine.processInstructionPartOne(new Instruction(Direction.UP, 3));
        assertThat(submarine.getDepth()).isEqualTo(2);
        submarine.processInstructionPartOne(new Instruction(Direction.DOWN, 8));
        assertThat(submarine.getDepth()).isEqualTo(10);
        submarine.processInstructionPartOne(new Instruction(Direction.FORWARD, 2));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(15);
    }

    @Test
    void processInstructionPartTwo() {
        Submarine submarine = new Submarine();

        submarine.processInstructionPartTwo(new Instruction(Direction.FORWARD, 5));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(5);
        assertThat(submarine.getDepth()).isEqualTo(0);
        submarine.processInstructionPartTwo(new Instruction(Direction.DOWN, 5));
        assertThat(submarine.getAim()).isEqualTo(5);
        submarine.processInstructionPartTwo(new Instruction(Direction.FORWARD, 8));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(13);
        assertThat(submarine.getDepth()).isEqualTo(40);
        submarine.processInstructionPartTwo(new Instruction(Direction.UP, 3));
        assertThat(submarine.getAim()).isEqualTo(2);
        submarine.processInstructionPartTwo(new Instruction(Direction.DOWN, 8));
        assertThat(submarine.getAim()).isEqualTo(10);
        submarine.processInstructionPartTwo(new Instruction(Direction.FORWARD, 2));
        assertThat(submarine.getHorizontalPosition()).isEqualTo(15);
        assertThat(submarine.getDepth()).isEqualTo(60);
    }
}
