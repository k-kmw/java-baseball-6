package baseball.domain;

import baseball.model.Comparator;
import baseball.model.Computer;
import baseball.model.Referee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class RefereeTest {

    @ParameterizedTest
    @MethodSource("generateInputList")
    void judgeTest(List<Integer> inputNums, String expected) {
        // given
        List<Integer> answerNums = List.of(1, 2, 3);
        Referee referee = new Referee(new Comparator());

        // when
        String result = referee.judge(answerNums, inputNums);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> generateInputList(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), "3스트라이크"),
                Arguments.of(List.of(3, 1, 2), "3볼 0스트라이크"),
                Arguments.of(List.of(1, 3, 2), "2볼 1스트라이크"),
                Arguments.of(List.of(1, 2, 4), "0볼 2스트라이크"),
                Arguments.of(List.of(1, 3, 4), "1볼 1스트라이크")
        );
    }
}
