package baseball.domain;

import baseball.model.Comparator;
import baseball.model.Computer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class ComparatorTest {

    @ParameterizedTest
    @MethodSource("generateBallTestInputList")
    void calculateBallCountTest(List<Integer> guessNums, int expected) {
        // given
        Comparator comparator = new Comparator();
        List<Integer> answerNums = List.of(1, 2, 3);

        // when
        Integer ballCount = comparator.calculateBallCount(answerNums, guessNums);

        // then
        Assertions.assertThat(ballCount).isEqualTo(expected);
    }

    private static Stream<Arguments> generateBallTestInputList(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 0),
                Arguments.of(List.of(4, 3, 5), 1),
                Arguments.of(List.of(2, 1, 3), 2),
                Arguments.of(List.of(3, 1, 2), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("generateStrikeTestInputList")
    void calculateStrikeCountTest(List<Integer> guessNums, int expected) {
        // given
        Comparator comparator = new Comparator();
        List<Integer> answerNums = List.of(1, 2, 3);

        // when
        Integer ballCount = comparator.calculateStrikeCount(answerNums, guessNums);

        // then
        Assertions.assertThat(ballCount).isEqualTo(expected);
    }

    private static Stream<Arguments> generateStrikeTestInputList(){
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), 3),
                Arguments.of(List.of(1, 2, 4), 2),
                Arguments.of(List.of(1, 3, 2), 1),
                Arguments.of(List.of(3, 2, 1), 1),
                Arguments.of(List.of(2, 1, 3), 1)
        );
    }
}
