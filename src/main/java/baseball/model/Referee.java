package baseball.model;

import baseball.Result;

import java.util.List;

// 예측 결과를 결정하는 책임
public class Referee {

    private final Comparator comparator;

    public Referee(Comparator comparator) {
        this.comparator = comparator;
    }

    public String judge(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        Integer ballCount = comparator.calculateBallCount(answerNumbers, inputNumbers);
        Integer strikeCount = comparator.calculateStrikeCount(answerNumbers, inputNumbers);

        if (ballCount == 0 && strikeCount == 0) {
            return Result.ZERO.getString();
        }
        if (strikeCount == 3) {
            return Result.STRIKE3.getString();
        }
        return ballCount + "볼" + " " + strikeCount + "스트라이크";
    }
}
