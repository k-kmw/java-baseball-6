package baseball.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserInput {

    public static class GuessNumbersDTO {
        private final String guessNumbers;

        public GuessNumbersDTO(String inputNumbers) {
            validate(inputNumbers);
            this.guessNumbers = inputNumbers;
        }

        public List<Integer> toList() {
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < guessNumbers.length(); i++) {
                numbers.add(guessNumbers.charAt(i) - '0');
            }
            return numbers;
        }

        private void validate(String inputNumbers) {
            checkNumberCount(inputNumbers);
            checkNumberRange(inputNumbers);
            checkDuplicateNumber(inputNumbers);
        }

        private static void checkNumberCount(String inputNumbers) {
            if (inputNumbers.length() != 3) throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
        }

        private static void checkNumberRange(String inputNumbers) {
            for (int i = 0; i < 3; i++) {
                if (inputNumbers.charAt(i) > '9' || inputNumbers.charAt(i) < '1') {
                    throw new IllegalArgumentException("1에서 9까지 숫자만 입력이 가능합니다.");
                }
            }
        }

        private static void checkDuplicateNumber(String inputNumbers) {
            char[] charArray = inputNumbers.toCharArray();
            HashSet<Character> charSet = new HashSet<>();
            for (char c : charArray) {
                charSet.add(c);
            }
            if (charSet.size() != inputNumbers.length()) {
                throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
            }
        }
    }

    public static class restartNumberDTO {
        private final String restartNum;

        public restartNumberDTO(String num) {
            validate(num);
            this.restartNum = num;
        }

        public String getRestartNum() {
            return restartNum;
        }

        private void validate(String num) {
            if (num.length() != 1)  throw new IllegalArgumentException();
            if (!num.equals("1") && !num.equals("2")) {
                throw new IllegalArgumentException();
            }
        }
    }
}
