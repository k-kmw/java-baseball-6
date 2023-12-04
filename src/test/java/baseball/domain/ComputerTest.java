package baseball.domain;

import baseball.model.Computer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerTest {

    // 라이브러리를 테스트 할 필요는 없음..
    @Test
    void generate3NumbersTest() {
        Computer computer = new Computer();
        List<Integer> numbers = computer.generate3Numbers();

        boolean isLegalNumber = true;
        if (numbers.size() != 3) {
            isLegalNumber = false;
        }
        for (Integer number : numbers) {
            if (number > 9 || number < 1) {
                isLegalNumber = false;
                break;
            }
        }

        Assertions.assertTrue(isLegalNumber);
    }
}
