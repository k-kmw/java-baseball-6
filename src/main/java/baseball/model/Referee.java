package baseball.model;

import baseball.Result;

import java.util.List;

public class Referee {
    public String judge(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        Integer ballCount = calculateBallCount(answerNumbers, inputNumbers);
        Integer strikeCount = calculateStrikeCount(answerNumbers, inputNumbers);

        if (ballCount == 0 && strikeCount == 0) {
            return Result.ZERO.getString();
        }
        if (strikeCount == 3) {
            return Result.STRIKE3.getString();
        }
        return ballCount + "볼" + " " + strikeCount + "스트라이크";
    }

    private Integer calculateBallCount(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        int ballCount = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            for (int j = 0; j < answerNumbers.size(); j++) {
                if (i == j) continue;
                if(inputNumbers.get(i).equals(answerNumbers.get(j))) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }


    private Integer calculateStrikeCount(List<Integer> answerNumbers, List<Integer> inputNumbers) {
        int strikeCount = 0;
        int idx = 0;
        while (idx < answerNumbers.size()) {
            if(answerNumbers.get(idx).equals(inputNumbers.get(idx))) {
                strikeCount++;
            }
            idx++;
        }
        return strikeCount;
    }
}
