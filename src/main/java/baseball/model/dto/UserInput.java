package baseball.model.dto;

import java.util.ArrayList;
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
            if (inputNumbers.length() != 3) throw new IllegalArgumentException();
            for (int i = 0; i < 3; i++) {
                if (inputNumbers.charAt(i) > '9' || inputNumbers.charAt(i) < '0') {
                    throw new IllegalArgumentException();
                }
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
