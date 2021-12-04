package day04;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    String testInput = """
            1 2 3
            4 5 6
            7 8 9""";

    @Test
    void mark() {
        Board board = Board.fromInput(testInput);

        board.markNumber(5);

        assertThat(board.board()[1][1].isMarked()).isTrue();
    }

    @Test
    void isWinnerHorizontal() {
        Board board = Board.fromInput(testInput);

        assertThat(board.isWinner()).isFalse();

        board.markNumber(1);
        board.markNumber(2);
        board.markNumber(3);

        assertThat(board.isWinner()).isTrue();
    }

    @Test
    void isWinnerVertical() {
        Board board = Board.fromInput(testInput);

        assertThat(board.isWinner()).isFalse();

        board.markNumber(3);
        board.markNumber(6);
        board.markNumber(9);

        assertThat(board.isWinner()).isTrue();
    }

    @Test
    void sumOfAllUnmarkedFields() {
        Board board = Board.fromInput(testInput);

        assertThat(board.sumOfAllUnmarkedFields()).isEqualTo(45);

        board.markNumber(5);

        assertThat(board.sumOfAllUnmarkedFields()).isEqualTo(40);
    }
}
