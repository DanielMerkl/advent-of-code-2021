package day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

record GiantSquid(List<Long> randomNumbers, ArrayList<Board> boards) {

    static GiantSquid fromInput(String input) {
        String[] split = input.split("\n\n");

        String numbersString = split[0];
        List<Long> randomNumbers = Arrays.stream(numbersString.split(","))
                .map(Long::parseLong)
                .toList();

        List<Board> boards = Arrays.stream(split)
                .skip(1)
                .map(Board::fromInput)
                .toList();

        return new GiantSquid(randomNumbers, new ArrayList<>(boards));
    }

    public long partOne() {
        for (Long randomNumber : randomNumbers) {
            boards.forEach(board -> board.markNumber(randomNumber));

            Optional<Board> optionalWinningBoard = boards.stream()
                    .filter(Board::isWinner)
                    .findAny();

            if (optionalWinningBoard.isPresent()) {
                Board winningBoard = optionalWinningBoard.get();
                return randomNumber * winningBoard.sumOfAllUnmarkedFields();
            }
        }

        throw new RuntimeException("No Bingo!");
    }

    public long partTwo() {
        for (Long randomNumber : randomNumbers) {
            boards.forEach(board -> board.markNumber(randomNumber));

            Optional<Board> optionalWinningBoard = boards.stream()
                    .filter(Board::isWinner)
                    .findAny();

            if (optionalWinningBoard.isEmpty()) {
                continue;
            }

            Board winningBoard = optionalWinningBoard.get();
            if (boards.size() == 1) {
                return randomNumber * winningBoard.sumOfAllUnmarkedFields();
            }
            boards.removeIf(Board::isWinner);
        }

        throw new RuntimeException("No Bingo!");
    }
}
