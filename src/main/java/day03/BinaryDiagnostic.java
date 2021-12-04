package day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record BinaryDiagnostic(List<String> binaryNumbers) {

    static BinaryDiagnostic fromInput(String input) {
        List<String> binaryNumbers = input.lines()
                .toList();

        return new BinaryDiagnostic(binaryNumbers);
    }

    long partOne() {
        return gammaRate() * epsilonRate();
    }

    long gammaRate() {
        return Long.parseLong(String.join("", mostOccurringDigits(binaryNumbers)), 2);
    }

    long epsilonRate() {
        return Long.parseLong(String.join("", leastOccurringDigits(binaryNumbers)), 2);
    }

    private List<String> mostOccurringDigits(List<String> binaryNumbers) {
        var occurrences = new int[binaryNumbers.get(0)
                .length()];

        for (String binaryNumber : binaryNumbers) {
            char[] digits = binaryNumber.toCharArray();
            for (int i = 0; i < digits.length; i++) {
                char digit = digits[i];
                occurrences[i] += digit == '1' ? 1 : -1;
            }
        }

        return Arrays.stream(occurrences)
                .mapToObj(count -> count >= 0 ? "1" : "0")
                .toList();
    }

    private List<String> leastOccurringDigits(List<String> binaryNumbers) {
        return mostOccurringDigits(binaryNumbers).stream()
                .map(digit -> digit.equals("1") ? "0" : "1")
                .toList();
    }

    long partTwo() {
        return oxygenGeneratorRating() * co2ScrubberRating();
    }

    long oxygenGeneratorRating() {
        return Long.parseLong(filter(new ArrayList<>(binaryNumbers), false), 2);
    }

    long co2ScrubberRating() {
        return Long.parseLong(filter(new ArrayList<>(binaryNumbers), true), 2);
    }

    private String filter(ArrayList<String> binaryNumbers, boolean mostCommon) {
        var result = new ArrayList<>(binaryNumbers);

        int index = 0;
        while (result.size() > 1) {
            char mostOccurringDigit = mostOccurringDigitAtIndex(result, index);
            int finalIndex = index;
            if (mostCommon) {
                result.removeIf(binaryNumber -> binaryNumber.charAt(finalIndex) == mostOccurringDigit);
            } else {
                result.removeIf(binaryNumber -> binaryNumber.charAt(finalIndex) != mostOccurringDigit);
            }
            index++;
        }

        return result.get(0);
    }

    private char mostOccurringDigitAtIndex(List<String> binaryNumbers, int index) {
        return mostOccurringDigits(binaryNumbers).get(index)
                .charAt(0);
    }
}
