package day04;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

record Board(Field[][] board) {

    static Board fromInput(String input) {
        String[] lines = input.split("\n");
        int size = lines.length;
        Field[][] board = new Field[size][size];

        for (int row = 0; row < lines.length; row++) {
            String line = lines[row];
            String[] numbers = line.trim()
                    .replace("  ", " ")
                    .split(" ");
            for (int column = 0; column < numbers.length; column++) {
                long number = Long.parseLong(numbers[column]);
                board[row][column] = new Field(number);
            }
        }

        return new Board(board);
    }

    void markNumber(long number) {
        allFields()
                .filter(field -> field.getNumber() == number)
                .forEach(Field::mark);
    }

    boolean isWinner() {
        return rows().anyMatch(this::allFieldsMarked) || columns().anyMatch(this::allFieldsMarked);
    }

    private Stream<Field[]> rows() {
        return Arrays.stream(board);
    }

    private Stream<Field[]> columns() {
        Field[][] rotatedBoard = new Field[board.length][board.length];

        for (int column = 0; column < board[0].length; column++) {
            for (int row = 0; row < board[column].length; row++) {
                rotatedBoard[column][row] = board[row][column];
            }
        }

        return Arrays.stream(rotatedBoard);
    }

    private boolean allFieldsMarked(Field[] fields) {
        return Arrays.stream(fields)
                .allMatch(Field::isMarked);
    }

    public long sumOfAllUnmarkedFields() {
        return allFields()
                .filter(not(Field::isMarked))
                .mapToLong(Field::getNumber)
                .sum();
    }

    private Stream<Field> allFields() {
        return Arrays.stream(board)
                .flatMap(Arrays::stream);
    }
}
