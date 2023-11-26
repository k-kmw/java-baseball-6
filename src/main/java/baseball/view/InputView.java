package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public List<Integer> get3Numbers() {
        String input3Numbers = Console.readLine();

        List<Integer> inputNumbers = new ArrayList<>();
        for (int i = 0; i < input3Numbers.length(); i++) {
            inputNumbers.add(input3Numbers.charAt(i) - '0');
        }
        return inputNumbers;
    }

    public String getIsRestart() {
        return Console.readLine();
    }
}
